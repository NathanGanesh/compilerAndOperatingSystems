.class public test2b
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 99
.limit locals 99

ldc "empty"
astore 2
ldc "Hello World"
astore 2
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 2
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
return
.end method
