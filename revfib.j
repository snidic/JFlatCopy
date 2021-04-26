.class public revfib
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;

.method public <init>()V

	aload_0
	invokenonvirtual    java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

; functionvoidfib(intn){revFib(n,-1,1,0);}

.method private static fib(I)V

; revFib(n,-1,1,0);

	iload 0
	ldc	1
	ineg
	ldc	1
	ldc	0
	invokestatic revfib/revFib(IIII)V
	return

.limit locals 16
.limit stack 16
.end method

; functionvoidrevFib(intn,inta,intb,intsum){if(sum<n){revFib(n,b,a+b,sum+1);print(a+b);}}

.method private static revFib(IIII)V

; if(sum<n){revFib(n,b,a+b,sum+1);print(a+b);}

	iload 3
	iload 0
	if_icmplt L1
	iconst_0
	goto L2
L1:
	iconst_1
L2:
	ifeq L0

; revFib(n,b,a+b,sum+1);

	iload 0
	iload 2
	iload 1
	iload 2
	iadd
	iload 3
	ldc	1
	iadd
	invokestatic revfib/revFib(IIII)V

; print(a+b);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	iload 1
	iload 2
	iadd
	invokevirtual java/io/PrintStream.println(I)V
L0:
	return

.limit locals 16
.limit stack 16
.end method

.method public static main([Ljava/lang/String;)V

	new RunTimer
	dup
	invokenonvirtual RunTimer/<init>()V
	putstatic        revfib/_runTimer LRunTimer;
	new PascalTextIn
	dup
	invokenonvirtual PascalTextIn/<init>()V
	putstatic        revfib/_standardIn LPascalTextIn;

; fib(10);

	ldc	10
	invokestatic revfib/fib(I)V

	getstatic     revfib/_runTimer LRunTimer;
	invokevirtual RunTimer.printElapsedTime()V

	return

.limit locals 16
.limit stack 16
.end method
