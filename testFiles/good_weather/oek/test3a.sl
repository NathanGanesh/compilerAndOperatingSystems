// Program with a basic scope. Should not compile, unless you comment out the last print
INT a;
a = 1;
BEGIN
   INT b;
   b = 2;
   PRINT a;
   PRINT b;
END
PRINT a;
PRINT b;
