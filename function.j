.class public function
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;
.field private static a I
.field private static b I
.field private static c I
.field private static five I

.method public <init>()V

	aload_0
	invokenonvirtual    java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

; functionintadd(inta,intb){returna+b;}

.method private static add(II)I
	iload 0
	iload 1
	iadd
	ireturn
	ireturn

.limit locals 16
.limit stack 16
.end method

; functionvoidprintInt(inta){print(a);}

.method private static printInt(I)V

; print(a);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	iload 0
	invokevirtual java/io/PrintStream.println(I)V
	return

.limit locals 16
.limit stack 16
.end method

; functionintmult(intx1,intx2){vari=0,sum;sum=0;while(i<abs(x2)){sum=sum+x1;i=i+1;}returnsum;}

.method private static mult(II)I
	ldc	0
	istore 2

; sum=0;

	ldc	0
	istore 3

; while(i<abs(x2)){sum=sum+x1;i=i+1;}

L1:
	iload 2
	iload 1
	invokestatic function/abs(I)I
	if_icmplt L2
	iconst_0
	goto L3
L2:
	iconst_1
L3:
	ifeq L0

; sum=sum+x1;

	iload 3
	iload 0
	iadd
	istore 3

; i=i+1;

	iload 2
	ldc	1
	iadd
	istore 2
	goto L1
L0:
	iload 3
	ireturn
	ireturn

.limit locals 16
.limit stack 16
.end method

; functionintabs(intx){if(x<0)returnx*-1;returnx;}

.method private static abs(I)I

; if(x<0)returnx*-1;

	iload 0
	ldc	0
	if_icmplt L5
	iconst_0
	goto L6
L5:
	iconst_1
L6:
	ifeq L4
	iload 0
	ldc	1
	ineg
	imul
	ireturn
L4:
	iload 0
	ireturn
	ireturn

.limit locals 16
.limit stack 16
.end method

; functionrealaddR(reala,realb){returna+b;}

.method private static addR(FF)F
	fload 0
	fload 1
	fadd
	freturn
	freturn

.limit locals 16
.limit stack 16
.end method

; functionintincByFive(intd){returnd+5;}

.method private static incByFive(I)I
	iload 0
	ldc	5
	iadd
	ireturn
	ireturn

.limit locals 16
.limit stack 16
.end method

; functionbooleanisNeg(inta){if(a<0)returntrue;returnfalse;}

.method private static isNeg(I)I

; if(a<0)returntrue;

	iload 0
	ldc	0
	if_icmplt L8
	iconst_0
	goto L9
L8:
	iconst_1
L9:
	ifeq L7
	ldc	1
	ireturn
L7:
	ldc	0
	ireturn
	ireturn

.limit locals 16
.limit stack 16
.end method

; functionbooleantest(inta){varb=isNeg(a);returnb;}

.method private static test(I)I
	iload 0
	invokestatic function/isNeg(I)I
	istore 1
	iload 1
	ireturn
	ireturn

.limit locals 16
.limit stack 16
.end method

; functionvoidinner(){varj=0;varsum=0;while(j<5){vark=0;while(k<5){print(k);print(j);k=k+1;}print(-100);j=j+1;}}

.method private static inner()V
	ldc	0
	istore 0
	ldc	0
	istore 1

; while(j<5){vark=0;while(k<5){print(k);print(j);k=k+1;}print(-100);j=j+1;}

L11:
	iload 0
	ldc	5
	if_icmplt L12
	iconst_0
	goto L13
L12:
	iconst_1
L13:
	ifeq L10
	ldc	0
	istore 2

; while(k<5){print(k);print(j);k=k+1;}

L15:
	iload 2
	ldc	5
	if_icmplt L16
	iconst_0
	goto L17
L16:
	iconst_1
L17:
	ifeq L14

; print(k);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	iload 2
	invokevirtual java/io/PrintStream.println(I)V

; print(j);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	iload 0
	invokevirtual java/io/PrintStream.println(I)V

; k=k+1;

	iload 2
	ldc	1
	iadd
	istore 2
	goto L15
L14:

; print(-100);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	100
	ineg
	invokevirtual java/io/PrintStream.println(I)V

; j=j+1;

	iload 0
	ldc	1
	iadd
	istore 0
	goto L11
L10:
	return

.limit locals 16
.limit stack 16
.end method

.method public static main([Ljava/lang/String;)V

	new RunTimer
	dup
	invokenonvirtual RunTimer/<init>()V
	putstatic        function/_runTimer LRunTimer;
	new PascalTextIn
	dup
	invokenonvirtual PascalTextIn/<init>()V
	putstatic        function/_standardIn LPascalTextIn;
	ldc	1
	putstatic	function/a I
	ldc	1
	ldc	1
	iadd
	putstatic	function/b I

; a=add(2,3);

	ldc	2
	ldc	3
	invokestatic function/add(II)I
	putstatic	function/a I

; printInt(a);

	getstatic	function/a I
	invokestatic function/printInt(I)V
	ldc	3
	ldc	3
	invokestatic function/mult(II)I
	putstatic	function/c I

; print(c);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	function/c I
	invokevirtual java/io/PrintStream.println(I)V

; print(mult(5,2));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	5
	ldc	2
	invokestatic function/mult(II)I
	invokevirtual java/io/PrintStream.println(I)V

; print(addR(2.1,1.2));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	2.1
	ldc	1.2
	invokestatic function/addR(FF)F
	invokevirtual java/io/PrintStream.println(F)V

; print(add(4,4));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	4
	ldc	4
	invokestatic function/add(II)I
	invokevirtual java/io/PrintStream.println(I)V

; print(add(-4,-4));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	4
	ineg
	ldc	4
	ineg
	invokestatic function/add(II)I
	invokevirtual java/io/PrintStream.println(I)V

; print(abs(-3));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	3
	ineg
	invokestatic function/abs(I)I
	invokevirtual java/io/PrintStream.println(I)V

; print(abs(4));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	4
	invokestatic function/abs(I)I
	invokevirtual java/io/PrintStream.println(I)V
	ldc	5
	putstatic	function/five I

; print(incByFive(0));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	0
	invokestatic function/incByFive(I)I
	invokevirtual java/io/PrintStream.println(I)V

; print(incByFive(1));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	1
	invokestatic function/incByFive(I)I
	invokevirtual java/io/PrintStream.println(I)V

; print(isNeg(-10));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	10
	ineg
	invokestatic function/isNeg(I)I
	invokevirtual java/io/PrintStream.println(I)V

; print(isNeg(99));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	99
	invokestatic function/isNeg(I)I
	invokevirtual java/io/PrintStream.println(I)V

; print(test(-3));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	3
	ineg
	invokestatic function/test(I)I
	invokevirtual java/io/PrintStream.println(I)V

; print(test(1));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	1
	invokestatic function/test(I)I
	invokevirtual java/io/PrintStream.println(I)V

; inner();

	invokestatic function/inner()V

	getstatic     function/_runTimer LRunTimer;
	invokevirtual RunTimer.printElapsedTime()V

	return

.limit locals 16
.limit stack 16
.end method
