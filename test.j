.class public test
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;
.field private static i I
.field private static sum I
.field private static max I
.field private static float F
.field private static bool I
.field private static b F
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
	putstatic        test/_runTimer LRunTimer;
	new PascalTextIn
	dup
	invokenonvirtual PascalTextIn/<init>()V
	putstatic        test/_standardIn LPascalTextIn;
	ldc	5
	putstatic	test/max I
	ldc	1.1
	fneg
	putstatic	test/float F

; i=0;

	ldc	0
	putstatic	test/i I

; sum=0;

	ldc	0
	putstatic	test/sum I

; bool=false;

	ldc	0
	putstatic	test/bool I

; print(false);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	0
	invokevirtual java/io/PrintStream.println(I)V

; print(true);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	1
	invokevirtual java/io/PrintStream.println(I)V

; print(-1);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	1
	ineg
	invokevirtual java/io/PrintStream.println(I)V

; while(i<max){sum=sum+i;i=i+1;print(sum);}

L1:
	getstatic	test/i I
	getstatic	test/max I
	if_icmplt L2
	iconst_0
	goto L3
L2:
	iconst_1
L3:
	ifeq L0

; sum=sum+i;

	getstatic	test/sum I
	getstatic	test/i I
	iadd
	putstatic	test/sum I

; i=i+1;

	getstatic	test/i I
	ldc	1
	iadd
	putstatic	test/i I

; print(sum);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test/sum I
	invokevirtual java/io/PrintStream.println(I)V
	goto L1
L0:

; print(-2);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	2
	ineg
	invokevirtual java/io/PrintStream.println(I)V

; if(i>max){i=i-max;}

	getstatic	test/i I
	getstatic	test/max I
	if_icmpgt L5
	iconst_0
	goto L6
L5:
	iconst_1
L6:
	ifeq L4

; i=i-max;

	getstatic	test/i I
	getstatic	test/max I
	isub
	putstatic	test/i I
L4:

; if(sum<max*2){print(bool);}else{bool=true;print(bool);}

	getstatic	test/sum I
	getstatic	test/max I
	ldc	2
	imul
	if_icmplt L9
	iconst_0
	goto L10
L9:
	iconst_1
L10:
	ifeq L7

; print(bool);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test/bool I
	invokevirtual java/io/PrintStream.println(I)V
	goto L8
L7:

; bool=true;

	ldc	1
	putstatic	test/bool I

; print(bool);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test/bool I
	invokevirtual java/io/PrintStream.println(I)V
L8:

; print(i);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test/i I
	invokevirtual java/io/PrintStream.println(I)V

; print(sum);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test/sum I
	invokevirtual java/io/PrintStream.println(I)V

; print(max);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test/max I
	invokevirtual java/io/PrintStream.println(I)V

; print(float);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test/float F
	invokevirtual java/io/PrintStream.println(F)V

; print(bool);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test/bool I
	invokevirtual java/io/PrintStream.println(I)V

; print(-2);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	2
	ineg
	invokevirtual java/io/PrintStream.println(I)V

; if(0<0)print(0);

	ldc	0
	ldc	0
	if_icmplt L12
	iconst_0
	goto L13
L12:
	iconst_1
L13:
	ifeq L11

; print(0);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	0
	invokevirtual java/io/PrintStream.println(I)V
L11:

; if(0<1)print(0);

	ldc	0
	ldc	1
	if_icmplt L15
	iconst_0
	goto L16
L15:
	iconst_1
L16:
	ifeq L14

; print(0);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	0
	invokevirtual java/io/PrintStream.println(I)V
L14:

; if(0<=0)print(1);

	ldc	0
	ldc	0
	if_icmple L18
	iconst_0
	goto L19
L18:
	iconst_1
L19:
	ifeq L17

; print(1);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	1
	invokevirtual java/io/PrintStream.println(I)V
L17:

; if(1<=0)print(1);

	ldc	1
	ldc	0
	if_icmple L21
	iconst_0
	goto L22
L21:
	iconst_1
L22:
	ifeq L20

; print(1);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	1
	invokevirtual java/io/PrintStream.println(I)V
L20:

; if(1>1)print(2);

	ldc	1
	ldc	1
	if_icmpgt L24
	iconst_0
	goto L25
L24:
	iconst_1
L25:
	ifeq L23

; print(2);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	2
	invokevirtual java/io/PrintStream.println(I)V
L23:

; if(1>0)print(2);

	ldc	1
	ldc	0
	if_icmpgt L27
	iconst_0
	goto L28
L27:
	iconst_1
L28:
	ifeq L26

; print(2);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	2
	invokevirtual java/io/PrintStream.println(I)V
L26:

; if(1>=1)print(3);

	ldc	1
	ldc	1
	if_icmpge L30
	iconst_0
	goto L31
L30:
	iconst_1
L31:
	ifeq L29

; print(3);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	3
	invokevirtual java/io/PrintStream.println(I)V
L29:

; if(0>=1)print(3);

	ldc	0
	ldc	1
	if_icmpge L33
	iconst_0
	goto L34
L33:
	iconst_1
L34:
	ifeq L32

; print(3);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	3
	invokevirtual java/io/PrintStream.println(I)V
L32:

; if(1==0)print(4);

	ldc	1
	ldc	0
	if_icmpeq L36
	iconst_0
	goto L37
L36:
	iconst_1
L37:
	ifeq L35

; print(4);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	4
	invokevirtual java/io/PrintStream.println(I)V
L35:

; if(0==0)print(4);

	ldc	0
	ldc	0
	if_icmpeq L39
	iconst_0
	goto L40
L39:
	iconst_1
L40:
	ifeq L38

; print(4);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	4
	invokevirtual java/io/PrintStream.println(I)V
L38:

; if(true)print(5);

	ldc	1
	ifeq L41

; print(5);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	5
	invokevirtual java/io/PrintStream.println(I)V
L41:

; if(false)print(5);

	ldc	0
	ifeq L42

; print(5);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	5
	invokevirtual java/io/PrintStream.println(I)V
L42:

; print(-3);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	3
	ineg
	invokevirtual java/io/PrintStream.println(I)V

; print(i);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test/i I
	invokevirtual java/io/PrintStream.println(I)V

; print(sum);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test/sum I
	invokevirtual java/io/PrintStream.println(I)V

; i=sum=-1;

	ldc	1
	ineg
	dup
	putstatic	test/sum I
	putstatic	test/i I

; print(i);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test/i I
	invokevirtual java/io/PrintStream.println(I)V

; print(sum);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test/sum I
	invokevirtual java/io/PrintStream.println(I)V

; print(-4);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	4
	ineg
	invokevirtual java/io/PrintStream.println(I)V
	ldc	2.1
	fneg
	putstatic	test/b F

; print(b);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test/b F
	invokevirtual java/io/PrintStream.println(F)V

; b=float=-2.2;

	ldc	2.2
	fneg
	dup
	putstatic	test/float F
	putstatic	test/b F

; print(b);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test/b F
	invokevirtual java/io/PrintStream.println(F)V

; print(float);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test/float F
	invokevirtual java/io/PrintStream.println(F)V
	ldc	2.1
	dup
	putstatic	test/b F
	putstatic	test/c F

; print(c);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test/c F
	invokevirtual java/io/PrintStream.println(F)V

; print(b);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	test/b F
	invokevirtual java/io/PrintStream.println(F)V

; print(1+1);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	1
	ldc	1
	iadd
	invokevirtual java/io/PrintStream.println(I)V

	getstatic     test/_runTimer LRunTimer;
	invokevirtual RunTimer.printElapsedTime()V

	return

.limit locals 16
.limit stack 16
.end method
