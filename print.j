.class public print
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;
.field private static i I

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
	putstatic        print/_runTimer LRunTimer;
	new PascalTextIn
	dup
	invokenonvirtual PascalTextIn/<init>()V
	putstatic        print/_standardIn LPascalTextIn;

; print(1>2);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	1
	ldc	2
	if_icmpgt L0
	iconst_0
	goto L1
L0:
	iconst_1
L1:
	invokevirtual java/io/PrintStream.println(I)V

; print(2>1);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	2
	ldc	1
	if_icmpgt L2
	iconst_0
	goto L3
L2:
	iconst_1
L3:
	invokevirtual java/io/PrintStream.println(I)V

; print((1<2));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	1
	ldc	2
	if_icmplt L4
	iconst_0
	goto L5
L4:
	iconst_1
L5:
	invokevirtual java/io/PrintStream.println(I)V

; print(2<1);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	2
	ldc	1
	if_icmplt L6
	iconst_0
	goto L7
L6:
	iconst_1
L7:
	invokevirtual java/io/PrintStream.println(I)V

; print(1<=2);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	1
	ldc	2
	if_icmple L8
	iconst_0
	goto L9
L8:
	iconst_1
L9:
	invokevirtual java/io/PrintStream.println(I)V

; print(2<=1);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	2
	ldc	1
	if_icmple L10
	iconst_0
	goto L11
L10:
	iconst_1
L11:
	invokevirtual java/io/PrintStream.println(I)V

; print(2<=2);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	2
	ldc	2
	if_icmple L12
	iconst_0
	goto L13
L12:
	iconst_1
L13:
	invokevirtual java/io/PrintStream.println(I)V

; print(1>=2);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	1
	ldc	2
	if_icmpge L14
	iconst_0
	goto L15
L14:
	iconst_1
L15:
	invokevirtual java/io/PrintStream.println(I)V

; print(2>=1);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	2
	ldc	1
	if_icmpge L16
	iconst_0
	goto L17
L16:
	iconst_1
L17:
	invokevirtual java/io/PrintStream.println(I)V

; print(2>=2);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	2
	ldc	2
	if_icmpge L18
	iconst_0
	goto L19
L18:
	iconst_1
L19:
	invokevirtual java/io/PrintStream.println(I)V

; print(1==2);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	1
	ldc	2
	if_icmpeq L20
	iconst_0
	goto L21
L20:
	iconst_1
L21:
	invokevirtual java/io/PrintStream.println(I)V

; print(2==2);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	2
	ldc	2
	if_icmpeq L22
	iconst_0
	goto L23
L22:
	iconst_1
L23:
	invokevirtual java/io/PrintStream.println(I)V

; print(2+2);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	2
	ldc	2
	iadd
	invokevirtual java/io/PrintStream.println(I)V

; print(i=2);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	2
	dup
	putstatic	print/i I
	invokevirtual java/io/PrintStream.println(I)V

; print(2+4/2);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	2
	ldc	4
	ldc	2
	idiv
	iadd
	invokevirtual java/io/PrintStream.println(I)V

; print((2+4)/2);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	2
	ldc	4
	iadd
	ldc	2
	idiv
	invokevirtual java/io/PrintStream.println(I)V

; print(2.0+1.2);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	2.0
	ldc	1.2
	fadd
	invokevirtual java/io/PrintStream.println(F)V

; print(-3.0*2.0);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	3.0
	fneg
	ldc	2.0
	fmul
	invokevirtual java/io/PrintStream.println(F)V

; print(-4.0/-3.0);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	4.0
	fneg
	ldc	3.0
	fneg
	fdiv
	invokevirtual java/io/PrintStream.println(F)V

; print(random());

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	invokestatic JFlatMath/random()F
	invokevirtual java/io/PrintStream.println(F)V

; print(toInt(random()));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	invokestatic JFlatMath/random()F
	invokestatic JFlatMath/toInt(F)I
	invokevirtual java/io/PrintStream.println(I)V

	getstatic     print/_runTimer LRunTimer;
	invokevirtual RunTimer.printElapsedTime()V

	return

.limit locals 16
.limit stack 16
.end method
