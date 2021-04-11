# Compilers and Operating systems

This is the base project for the assignment of *Compilers and Operating Systems*.

The project has support for reading your files, assembling Jasmin bytecode into classes and even 
running them automatically in JUnit-tests. The actual code generation is of course missing still 
(since that is the whole point of the assignment) and you should replace the grammar (and associated
lexer and parser) with one of your own.

You can change this code in any way you see fit.

## Compiler phases

During the course, you will build your own compiler. The compiler we discuss in the lectures
consists of a few phases:

![Diagram showing compiler has lexer, parser, checker and generation phase](doc/readme/compiler-phases.png)

* ***Lexer***\
  The lexer takes the source file of your user and groups the characters in the file
  into meaningful *tokens*. So a string of characters like

   `i` `n` `t` `<space>` `m` `a` `i` `n` `(` `)` `{` `<CRLF>` `i` `n` `t` `<space>` `a` `=` `3` `4` `;`
   `<CRLF>` `}`
   
   is grouped into:
   
   `int` `main` `(` `)` `{` `int` `a` `=` `34` `;` `}`

* ***Parser***\
  The parser then takes those tokens and tries to build a tree structure from them, 
  called a *parse tree*, like: 
  
  ![Example parse tree](doc/readme/parsetree.png)
  
* ***Checker***\
  The checker then walks through that parse tree and checks if the code the user gave
  to the compiler is actually correct. For example, it will check if the user uses the right type
  of arguments when calling a function.

* ***Code generator***\
  After making sure the user's code is correct, the code generator will walk
  the parse tree and generate Jasmin byte code. The end result will look something like:
  
  ```
  .class public Example
  .super java/lang/Object
  .method public static main([Ljava/lang/String;)V
  ldc 34
  istore 1
  return
  .end method
  ```

If this seems daunting, do not worry: for the first two phases we will use a tool call ANTLR. When
we supply that tool with a description of our programming language, it will generate the *lexer* and
*parser* for us.

## Planning

During the course, we will design our own programming language and create a compiler for it. In the
first weeks, you will build your knowledge and can expand your project week-by-week.

* ***Week 1***\
  You will design you own language and make example programs in your language. These
  examples can then also be used as input for your unit tests.
* ***Week 2***\
  Your compiler will generate [Jasmin](http://jasmin.sourceforge.net)-compatible byte
  code. We will learn to create programs in byte code and then translate our example programs to
  byte code. This will be the expected output of your unit tests.
* ***Week 3***\
  ANTLR needs a grammar that describes the rules of your language. We will create that
  grammar during this week. You can now use the ANTLR plugin to show parse trees of your example
  programs.
* ***Week 4***\
  This week we will do our first code generation. After this week, you can expand your
  compiler so that it can compile code in your language with hardcoded values.
* ***Week 5***\
  We will now add support for variables to our compiler. Most code in your language
  can now compile. Also, we will make sure that if a user makes errors, they are found by the
  compiler.
* ***Week 6-8***\
  You can use this time to make sure all the features in your language have been
  implemented and tested.

## Running the compiler

### How to run

If you run the compiler framework just after you cloned it from GitLab, it will probably give you
an error message like:

> ``Usage: java Compiler <name of Source>``
 
This is because the compiler expects the path to the input program as a program argument. To supply
this program argument, expand the combo box next to the Build- and Play-buttons.

![Screenshots showing run configuration combobox](doc/readme/runconfig1.png)

This will open the *Run/Debug Configurations* screen. You can supply the program argument (i.e. the
file you want to compile) in the third input field. This path is relative to the *working directory*
that you can find in the text field below.

![Screenshots showing run configuration combobox](doc/readme/runconfig2.png)

### So what will it do?

When you run the compiler, it will take your input file and try to compile it into byte code and
assemble that into a Java VM-compatible class.

It will output 2 files:

* The Jasmin byte code. Whatever the compiler generated will be stored in a file with the
  `.j`-extension.
* A `.class` file that is created by running Jasmin over the byte code from the previous step.

If your code is correct, you should be able to run the class file by starting the Java virtual
machine and giving it the name of the class you want to run (without the `.class` extension):

> `java MyProgram`

## Testing

Of course, you can test your compiler manually as shown above. However, it is probably more practical
to use the unit tests. Check the `CompilerTest` for some examples how to do this. You could consider
tests like:

* Taking the example programs you created in week 1, compiling them and comparing them to the
  byte code equivalents you wrote in week 2.
* Making smaller programs (testing just a single feature) and comparing the generated byte code.
* Running the compiled programs and comparing the output.
* Checking that certain errors will be found by the checker.

## Getting started

So, how do you get started?

* Design your programming language and create the grammar for it. Also generate the classes for the
  lexer, parser and base visitor using ANTLR.
* In `Compiler.runLexer()` and `Compiler.runParser()` refer to your own lexer and parser, instead of
  the example language.
* Create a visitor to generate code and generate Jasmin code for programs in your language. Hook
  that up to the compiler by calling `visit(parseTree)` on your code generator in
  `Compiler.generateCode()`.\
  *Start small!* Make sure you can compile the equivalent of `print("Hello World!");` and then
  expand from there. Use automated tests to track your success.
* Expand your project with a checker and code generator for all features needed.

## Classes

A quick explanation of some of the classes we gave you: 

### Compiler

The compiler reads in the source file and the runs the four phases described above:
* `runLexer()`\
  Runs the lexer generated by ANTLR. By default, it will run `ExampleLangLexer`. Replace it with
  your own. 
* `runParser()`\
  Runs the parser generated by ANTLR. By default, it will run `ExampleLangParser`. Replace it with
  your own.
* `runChecker()` \
  Does nothing by default. This will be the method where you check if the user's source code is
  correct. If you return false here, compilation stops.
* `generateCode()`\
  Generates a `JasminBytecode` instance from a given `ParseTree`. The byte code is then written to a
  file and given to Jasmin to assemble into a runnable `.class` file.\
  By default, this function just generates the byte code for printing *Hello, world*.

### JasminBytecode

Basically a wrapper around `ArrayList<String>`. You can add lines of bytecode to this object just as
you would to an `ArrayList`. The class also contains functionality to write all lines to a file, 
which is used by the `Compiler` class.

### AssembledClass

After successfully generating the `JasminCode` it is passed to `AssembledClass.assemble()` to run
Jasmin and create a JVM-compatible class.

### SandBox

The testing framework uses `SandBox` to run the assembled class in a safe environment.
You can check the output after execution finished.