// Program with a basic scope. Should not compile, unless you comment out the last print
int a;
a = 1;
{
int b;
b = 2;
print(a);
print(b);
}
print(a);
//print(b);
