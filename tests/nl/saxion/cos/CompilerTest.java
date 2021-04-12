package nl.saxion.cos;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;


/**
 * This file shows a few different ways you can do automated tests:
 * <p>
 * - checkByteCode():        Shows how to compile a file and check that the bytecode that was
 * generated matches your expectations.
 * - checkByteCode2():       Same as above, but now the output is stored in a file.
 * - syntaxErrorsAreFound(): Checks that a file with syntax errors stops compilation.
 * - checkOutputFile():      This test shows how to compile a file, run it and check if the output
 * matches your expectations.
 * - checkOutputString():    Same as above, but now the source code is coming from a string within
 * the test.
 * <p>
 * Not shown is a  test where the file contains no syntax errors, but the checker should find some
 * error. You can of course add that yourself.
 */
public class CompilerTest {

    @Rule // Used for mocking the scanner input
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void test0() throws Exception {
        JasminBytecode bytecode = compile("testFiles/good_weather/oek/test0.sl", "test0");
        List<String> result = runCode(bytecode);
        assertEquals("1337", result.get(0));
    }


    @Test
    public void test2a() throws Exception {
        Compiler c = new Compiler();
        JasminBytecode code = c.compileFile("testFiles/good_weather/oek/test2a.sl", "Test2");

        assertArrayEquals(new String[]{
                ".class public Test2",
                ".super java/lang/Object",
                "",
                ".method public static main([Ljava/lang/String;)V",
                ".limit stack 99",
                ".limit locals 99",
                "",
                "ldc 0",
                "istore 1",
                "ldc 123",
                "istore 1",
                "getstatic java/lang/System/out Ljava/io/PrintStream;",
                "iload 1",
                "invokevirtual java/io/PrintStream/println(I)V",
                "return",
                ".end method"
        }, code.getLines().toArray());

        AssembledClass aClass = AssembledClass.assemble(code);
        SandBox s = new SandBox();
        s.runClass(aClass);
        List<String> output = s.getOutput();

        assertArrayEquals(new String[]{
                "123"
        }, output.toArray());
    }

    //
    @Test
    public void test2b() throws Exception {
        Compiler c = new Compiler();
        JasminBytecode code = c.compileFile("testFiles/good_weather/oek/test2b.sl", "Test2");

        assertArrayEquals(new String[]{
                ".class public Test2",
                ".super java/lang/Object",
                "",
                ".method public static main([Ljava/lang/String;)V",
                ".limit stack 99",
                ".limit locals 99",
                "",
                "ldc \"empty\"",
                "astore 1",
                "ldc \"Hello World\"",
                "astore 1",
                "getstatic java/lang/System/out Ljava/io/PrintStream;",
                "aload 1",
                "invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V",
                "return",
                ".end method"
        }, code.getLines().toArray());

        AssembledClass aClass = AssembledClass.assemble(code);
        SandBox s = new SandBox();
        s.runClass(aClass);
        List<String> output = s.getOutput();

        assertArrayEquals(new String[]{
                "Hello World"
        }, output.toArray());
    }

    @Test
    public void test3a() throws Exception {
        Compiler c = new Compiler();
        JasminBytecode code = c.compileFile("testFiles/good_weather/oek/test3a.sl", "Test3");
        assertArrayEquals(new String[]{
                ".class public Test3",
                ".super java/lang/Object",
                "",
                ".method public static main([Ljava/lang/String;)V",
                ".limit stack 99",
                ".limit locals 99",
                "",
                "ldc 0",
                "istore 1",
                "ldc 1",
                "istore 1",
                "ldc 0",
                "istore 2",
                "ldc 2",
                "istore 2",
                "getstatic java/lang/System/out Ljava/io/PrintStream;",
                "iload 1",
                "invokevirtual java/io/PrintStream/println(I)V",
                "getstatic java/lang/System/out Ljava/io/PrintStream;",
                "iload 2",
                "invokevirtual java/io/PrintStream/println(I)V",
                "getstatic java/lang/System/out Ljava/io/PrintStream;",
                "iload 1",
                "invokevirtual java/io/PrintStream/println(I)V",
                "return",
                ".end method"
        }, code.getLines().toArray());

        AssembledClass aClass = AssembledClass.assemble(code);
        SandBox s = new SandBox();
        s.runClass(aClass);
        List<String> output = s.getOutput();

        assertArrayEquals(new String[]{
                "1",
                "2",
                "1"
        }, output.toArray());


    }

    @Test
    public void test3b() throws Exception {
        Compiler c = new Compiler();
        JasminBytecode code = c.compileFile("testFiles/good_weather/oek/test3a.sl", "Test3");

        assertArrayEquals(new String[]{
                ".class public Test3",
                ".super java/lang/Object",
                "",
                ".method public static main([Ljava/lang/String;)V",
                ".limit stack 99",
                ".limit locals 99",
                "",
                "ldc 0",
                "istore 1",
                "ldc 1",
                "istore 1",
                "ldc 0",
                "istore 2",
                "ldc 2",
                "istore 2",
                "getstatic java/lang/System/out Ljava/io/PrintStream;",
                "iload 1",
                "invokevirtual java/io/PrintStream/println(I)V",
                "getstatic java/lang/System/out Ljava/io/PrintStream;",
                "iload 2",
                "invokevirtual java/io/PrintStream/println(I)V",
                "getstatic java/lang/System/out Ljava/io/PrintStream;",
                "iload 1",
                "invokevirtual java/io/PrintStream/println(I)V",
                "return",
                ".end method"
        }, code.getLines().toArray());

        AssembledClass aClass = AssembledClass.assemble(code);
        SandBox s = new SandBox();
        s.runClass(aClass);
        List<String> output = s.getOutput();

        assertArrayEquals(new String[]{
                "1",
                "2",
                "1"
        }, output.toArray());
    }

    @Test
    public void mustOne() throws AssembleException, IOException {
        JasminBytecode bytecode = compile("testFiles/good_weather/mustWeatherCases/MustOne", "MustOne");
        List<String> result = runCode(bytecode);
        assertEquals("10", result.get(0));
    }

    @Test
    public void mustTwo() throws IOException, AssembleException {
        JasminBytecode bytecode = compile("testFiles/good_weather/mustWeatherCases/MustTwo", "MustTwo");

        // Mocking an int scanner by setting the input stream to 10
        systemInMock.provideLines("10000000");

        List<String> result = runCode(bytecode);

        assertEquals("true", result.get(0));
    }

    @Test
    public void mustThree() throws IOException, AssembleException {
        JasminBytecode bytecode = compile("testFiles/good_weather/mustWeatherCases/MustThree", "MustThree");

        systemInMock.provideLines("2000", "-1000");
        List<String> resultOne = runCode(bytecode);

        systemInMock.provideLines("20000", "100100");
        List<String> resultTwo = runCode(bytecode);

        assertArrayEquals(new String[]{"You mad a mistake", "true"}, resultOne.toArray());
        assertArrayEquals(new String[]{"false", "false"}, resultTwo.toArray());
    }

    @Test
    public void mustFour() throws AssembleException, IOException {
        JasminBytecode bytecode = compile("testFiles/good_weather/mustWeatherCases/MustFour", "MustFour");

        systemInMock.provideLines("999", "666", "22", "4", "34");
        List<String> result = runCode(bytecode);

        assertArrayEquals(new String[]{"Wrong answer", "Wrong answer",
                "Wrong answer", "Correct"}, result.toArray());
    }

    @Test
    public void mustFive() throws IOException, AssembleException {
        JasminBytecode bytecode = compile("testFiles/good_weather/mustWeatherCases/MustFive.txt", "test");
        List<String> result = runCode(bytecode);
        assertEquals("Correct", result.get(0));
    }




    //	shouldnt compile


    @Test
    public void scope() throws IOException, AssembleException {
        assertThrows(NullPointerException.class, () -> {
            compile("testFiles/bad_weather/oekbad/test3b.sl", "Scope");
        });

    }

    @Test
    public void test4a() throws Exception {
        Compiler c = new Compiler();
        JasminBytecode code = c.compileFile("testFiles/bad_weather/oekbad/test4a.sl", "4a");

        assertNull(code); // Should not compile
    }

    @Test
    public void test4b() throws Exception {
        Compiler c = new Compiler();
        JasminBytecode code = c.compileFile("testFiles/bad_weather/oekbad/test4b.sl", "Test4");
        assertNull(code); // Should not compile
    }

    @Test
    public void test4c() throws Exception {
        Compiler c = new Compiler();
        JasminBytecode code = c.compileFile("testFiles/bad_weather/oekbad/test4c.sl", "Test4");
        assertNull(code); // Should not compile
    }

    @Test
    public void test4d() throws Exception {
        Compiler c = new Compiler();
        JasminBytecode code = c.compileFile("testFiles/bad_weather/oekbad/test4d.sl", "Test4");
        assertNull(code); // Should not compile
    }

    @Test
    public void test4e() throws Exception {
        Compiler c = new Compiler();
        JasminBytecode code = c.compileFile("testFiles/bad_weather/oekbad/test4e.sl", "Test4");
        assertNull(code); // Should not compile
    }

    @Test
    public void test4f() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            compile("testFiles/bad_weather/oekbad/test4f.sl", "Test4");
        });
    }

    @Test
    public void mustBadOne() throws Exception {
//        assertThrows(NullPointerException.class, () -> {
//            compile("testFiles/bad_weather/MustBadCases/if.txt", "Test4");
//        });
        Compiler c = new Compiler();
        JasminBytecode code = c.compileFile("testFiles/bad_weather/MustBadCases/if.txt", "Test4");
        assertNull(code); // Should not compile
    }

    @Test
    public void mustBadTwo() throws Exception {
        Compiler c = new Compiler();
        JasminBytecode code = c.compileFile("testFiles/bad_weather/MustBadCases/while.txt", "Test4");
        assertNull(code);
    }
    @Test
    public void mustBadThree() throws Exception {
        Compiler c = new Compiler();
        JasminBytecode code = c.compileFile("testFiles/bad_weather/MustBadCases/functioninpu.txt", "Test4");
        assertNull(code);
    }


    @Test
    public void mustBadFour() throws Exception {
        Compiler c = new Compiler();
        JasminBytecode code = c.compileFile("testFiles/bad_weather/MustBadCases/dupFunction", "Test4");
        assertNull(code);

         }


    @Test
    public void mustBadFive() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            compile("testFiles/bad_weather/oekbad/test4f.sl", "Test4");
        });
    }





    //	@Test
//	void checkOutputFile() throws Exception {
//		// Compile and assemble testFiles/hello.exlang
//		Compiler c = new Compiler();
//		JasminBytecode code = c.compileFile("testFiles/hello.exlang", "HelloWorld");
//		assertNotNull(code);
//
//		// Check that output matches what we expect
//		List<String> output = runCode(code);
//		assertArrayEquals(new String[] {
//				"Hello from ExampleLang!"
//		}, output.toArray());
//	}
    @Test
    public void variableNotFound() throws Exception {
        JasminBytecode bytecode = compile("testFiles/prog.txt", "prog");

        List<String> result = runCode(bytecode);
        System.out.println(result.get(0));
        assertEquals("123", result.get(0));
    }


    /**
     * Helper method that takes some compiled Jasmin byte code, assembles it and
     * runs the class. It returns the output of the execution, which you can use
     * to check in an assert.
     */
    private List<String> runCode(JasminBytecode code) throws AssembleException {
        // Turn the Jasmin code into a (hopefully) working class file
        if (code == null) {
            throw new AssembleException("No valid Jasmin code to assemble");
        }
        AssembledClass aClass = AssembledClass.assemble(code);
        // Run the class and return the output
        SandBox s = new SandBox();
        s.runClass(aClass);
        return s.getOutput();
    }

    private String[] getOutput(AssembledClass assembledClass) {
        SandBox s = new SandBox();
        s.runClass(assembledClass);
        return s.getOutput().toArray(new String[0]);
    }

    public JasminBytecode compile(String inputPath, String className) throws IOException, AssembleException {
        Compiler compiler = new Compiler();
        return compiler.compileFile(inputPath, className);
    }
}
