package nl.saxion.cos;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Compiles source code in a custom language into Jasmin and then assembles a
 * JVM-compatible .class file.
 */
public class Compiler {
    /**
     * The number of errors detected by the lexer and parser.
     */
    private int errorCount = 0;
    private ParseTreeProperty<DataType> types = new ParseTreeProperty<>();
    private SymbolTable symbolTable;
    private ParseTreeProperty<SymbolTable> scope = new ParseTreeProperty<>();

    /**
     * Main method.
     *
     * @param args Array of command line arguments. You can use this to supply the file name to
     *             compile.
     */
    public static void main(String[] args) {
        try {
            Compiler compiler = new Compiler();

            // Check that the user supplied a name of the source file
            if (args.length == 0) {
                System.err.println("Usage: java Compiler <name of source>");
                return;
            }

            // Split the file name
            // It first strips the extension, so that: tests/myFile.exlang becomes tests/myFile.
            // Then, it removes everything that seems a path, so we end up with just 'myFile' as
            // the class name.
            Path sourceCodePath = Paths.get(args[0]);

            String sourceFileName = sourceCodePath.getFileName().toString();
            int dotIndex = sourceFileName.lastIndexOf('.');
            String className = sourceFileName.substring(0, dotIndex == -1 ? sourceFileName.length() : dotIndex);

            // Read the file and compile it.
            JasminBytecode jasminBytecode = compiler.compileFile(sourceCodePath.toString(), className);
            if (jasminBytecode == null) {
                System.err.println("No Jasmin output");
                return;
            }

            // Write Jasmin-code to a file
            String jasminFilename = sourceCodePath.getParent().resolve(className + ".j").toString();
            jasminBytecode.writeJasminToFile(jasminFilename);

            // Try to assemble the Jasmin byte code and write that to a file
            AssembledClass assembledClass = AssembledClass.assemble(jasminBytecode);
            String classFilename = sourceCodePath.getParent().resolve(className + ".class").toString();
            assembledClass.writeClassToFile(classFilename);
        } catch (IOException | AssembleException e) {
            System.err.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Compiles a complete source code file.
     *
     * @param inputPath Path to the source code to compile.
     * @param className Name of the class to create.
     * @throws IOException       if files could not be read or written
     * @throws AssembleException if Jasmin code was not valid
     */
    public JasminBytecode compileFile(String inputPath, String className)
            throws IOException, AssembleException {
        return compile(CharStreams.fromFileName(inputPath), className);
    }

    /**
     * Compiles a string.
     *
     * @param sourceCode The source code to compile.
     * @param className  Name of the class to create.
     * @throws IOException       if files could not be read or written
     * @throws AssembleException if Jasmin code was not valid
     */
    public JasminBytecode compileString(String sourceCode, String className)
            throws IOException, AssembleException {
        return compile(CharStreams.fromString(sourceCode), className);
    }

    /**
     * Compiles a file. The source code is lexed (turned into tokens), parsed (a parse tree
     * created) then Jasmin code is generated and assembled into a class.
     *
     * @param input     Stream to the source code input.
     * @param className Name of the class to create.
     */
    private JasminBytecode compile(CharStream input, String className) {
        // Phase 1: Run the lexer
        symbolTable = new SymbolTable(1);
        types = new ParseTreeProperty<>();
        scope = new ParseTreeProperty<>();
        CommonTokenStream tokens = runLexer(input);

        // Phase 2: Run the parser
        ParseTree parseTree = runParser(tokens);

        // ANTLR tries to do its best in creating a parse tree, even if the source code contains
        // errors. So, check if that is the case and bail out if so.
        if (errorCount > 0)
            return null;

        // Phase 3: Check the source code for semantic errors
        if (!runChecker(parseTree))
            return null;

        // Phase 4: Generate code
        return generateCode(parseTree, className);
    }

    /**
     * Take the charater input and turn it into tokens according to the grammar.
     *
     * @param input The input.
     * @return A steam of tokens.
     */
    private CommonTokenStream runLexer(CharStream input) {
        TheRealDealLangLexer lexer = new TheRealDealLangLexer(input);
        lexer.addErrorListener(getErrorListener());
        return new CommonTokenStream(lexer);
    }

    /**
     * Tries to form a parse tree from the given tokens. In case of errors, the error listener is
     * called, but the parser still tries to create a parse tree.
     *
     * @param tokens The tokens returned from the lexer.
     * @return A Parse Tree.
     */
    private ParseTree runParser(CommonTokenStream tokens) {
        TheRealDealLangParser parser = new TheRealDealLangParser(tokens);
        parser.addErrorListener(getErrorListener());
        return parser.compileUnit();
    }

    /**
     * Called to check if the source code was semantically correct. This method is only called when
     * there were no syntax errors.
     *
     * @param parseTree The parse tree generated by the parser
     * @return True if all code is semantically correct
     */
    private boolean runChecker(ParseTree parseTree) {
        try {
            RealDealChecker checker = new RealDealChecker(types, symbolTable, scope);
            checker.visit(parseTree);
            return !checker.isFailed();
        } catch (CompilerException ce) {
            System.err.println(ce.getMessage());
            return false;
        }
    }

    /**
     * Generate the Jasmin code for the source code. This method is only called after checking that
     * the code is syntactically and semantically correct, so you need not check for any errors.
     *
     * @param parseTree The parseTree to generate code for
     * @return All Jasmin code that is generated
     */
    private JasminBytecode generateCode(ParseTree parseTree, String className) {
        JasminBytecode jasminBytecode = new JasminBytecode(className);

        jasminBytecode.add(".class public " + className);
        jasminBytecode.add(".super java/lang/Object");
        jasminBytecode.add("");

        // This visitor is meant for generating the function definitions before generating the code for the main method
        FunctionVisitor functionVisitor = new FunctionVisitor(jasminBytecode);
        functionVisitor.visit(parseTree);

        // Main method
        jasminBytecode.add(".method public static main([Ljava/lang/String;)V");
        jasminBytecode.add(".limit stack 99");
        jasminBytecode.add(".limit locals 99");
        jasminBytecode.add("");

        CodeGenerator codeGenerator = new CodeGenerator(jasminBytecode, scope, types);
        codeGenerator.visit(parseTree);

        jasminBytecode.add("return");
        jasminBytecode.add(".end method");

        return jasminBytecode;
    }

    /**
     * Creates and returns an error listener for use in the lexer and parser that just increases
     * the errorCount-attribute in this class so we can find out if the source code had a syntax
     * error.
     *
     * @return An error listener for use with lexer.addErrorListener() and parser.addErrorListener()
     */
    private ANTLRErrorListener getErrorListener() {
        return new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                    int line, int charPositionInLine,
                                    String msg, RecognitionException e) {
                errorCount++;
            }
        };
    }
}
