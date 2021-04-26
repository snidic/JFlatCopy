.class public test2
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;
.field private static a F
.field private static b I
.field private static c F

.method public <init>()V

	aload_0
	invokenonvirtual    java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static main([Ljava/lang/String;)V

	new RunTimer
	dup
	invokenonvirtual RunTimer/<init>()V
	putstatic        test2/_runTimer LRunTimer;
	new PascalTextIn
	dup
	invokenonvirtual PascalTextIn/<init>()V
	putstatic        test2/_standardIn LPascalTextIn;
	ldc	14.5
	fneg
	putstatic	test2/a F
	ldc	3
	putstatic	test2/b I
	getstatic	test2/a F
	getstatic	test2/b I
	pop
	getstatic	test2/b I
	i2f
	fmul
	putstatic	test2/c F

; print(c);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test2/c F
	invokevirtual java/io/PrintStream.println(F)V

	getstatic     test2/_runTimer LRunTimer;
	invokevirtual RunTimer.printElapsedTime()V

	return

.limit locals 16
.limit stack 16
.end method
