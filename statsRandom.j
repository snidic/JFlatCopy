.class public statsRandom
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;
.field private static i I
.field private static n I
.field private static j I
.field private static iMean F
.field private static iVar F
.field private static iSVar F

.method public <init>()V

	aload_0
	invokenonvirtual    java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

; functionintrandomInt(intrange,intstart){returntoInt(toReal(range)*random())+start;}

.method private static randomInt(II)I
	iload 0
	invokestatic JFlatMath/toReal(I)F
	invokestatic JFlatMath/random()F
	fmul
	invokestatic JFlatMath/toInt(F)I
	iload 1
	iadd
	ireturn
	ireturn

.limit locals 16
.limit stack 16
.end method

; functionrealcalcMean(inti){varj=0;varsum=0;varn=listSize(i);while(j<n){sum=sum+getFromList(i,j);j=j+1;}returntoReal(sum)/toReal(n);}

.method private static calcMean(I)F
	ldc	0
	istore 1
	ldc	0
	istore 2
	iload 0
	invokestatic JFlatList/listSize(I)I
	istore 3

; while(j<n){sum=sum+getFromList(i,j);j=j+1;}

L1:
	iload 1
	iload 3
	if_icmplt L2
	iconst_0
	goto L3
L2:
	iconst_1
L3:
	ifeq L0

; sum=sum+getFromList(i,j);

	iload 2
	iload 0
	iload 1
	invokestatic JFlatList/getFromList(II)I
	iadd
	istore 2

; j=j+1;

	iload 1
	ldc	1
	iadd
	istore 1
	goto L1
L0:
	iload 2
	invokestatic JFlatMath/toReal(I)F
	iload 3
	invokestatic JFlatMath/toReal(I)F
	fdiv
	freturn
	freturn

.limit locals 16
.limit stack 16
.end method

; functionrealcalcSampleVar(inti){varn=listSize(i);vartotal=0.0;varmean=calcMean(i);varj=0;while(j<n){vartemp=toReal(getFromList(i,j))-mean;total=total+temp*temp;j=j+1;}returntotal/toReal(n-1);}

.method private static calcSampleVar(I)F
	iload 0
	invokestatic JFlatList/listSize(I)I
	istore 1
	ldc	0.0
	fstore 2
	iload 0
	invokestatic statsRandom/calcMean(I)F
	fstore 3
	ldc	0
	istore 4

; while(j<n){vartemp=toReal(getFromList(i,j))-mean;total=total+temp*temp;j=j+1;}

L5:
	iload 4
	iload 1
	if_icmplt L6
	iconst_0
	goto L7
L6:
	iconst_1
L7:
	ifeq L4
	iload 0
	iload 4
	invokestatic JFlatList/getFromList(II)I
	invokestatic JFlatMath/toReal(I)F
	fload 3
	fsub
	fstore 5

; total=total+temp*temp;

	fload 2
	fload 5
	fload 5
	fmul
	fadd
	fstore 2

; j=j+1;

	iload 4
	ldc	1
	iadd
	istore 4
	goto L5
L4:
	fload 2
	iload 1
	ldc	1
	isub
	invokestatic JFlatMath/toReal(I)F
	fdiv
	freturn
	freturn

.limit locals 16
.limit stack 16
.end method

; functionrealcalcStandardSampleVar(inti){returnsqrtr(calcSampleVar(i));}

.method private static calcStandardSampleVar(I)F
	iload 0
	invokestatic statsRandom/calcSampleVar(I)F
	invokestatic JFlatMath/sqrtr(F)F
	freturn
	freturn

.limit locals 16
.limit stack 16
.end method

; functionintgetSmallestValue(inti,intmax){varn=listSize(i);varsmallest=max;varj=0;while(j<n){if(getFromList(i,j)<smallest)smallest=getFromList(i,j);j=j+1;}returnsmallest;}

.method private static getSmallestValue(II)I
	iload 0
	invokestatic JFlatList/listSize(I)I
	istore 2
	iload 1
	istore 3
	ldc	0
	istore 4

; while(j<n){if(getFromList(i,j)<smallest)smallest=getFromList(i,j);j=j+1;}

L9:
	iload 4
	iload 2
	if_icmplt L10
	iconst_0
	goto L11
L10:
	iconst_1
L11:
	ifeq L8

; if(getFromList(i,j)<smallest)smallest=getFromList(i,j);

	iload 0
	iload 4
	invokestatic JFlatList/getFromList(II)I
	iload 3
	if_icmplt L13
	iconst_0
	goto L14
L13:
	iconst_1
L14:
	ifeq L12

; smallest=getFromList(i,j);

	iload 0
	iload 4
	invokestatic JFlatList/getFromList(II)I
	istore 3
L12:

; j=j+1;

	iload 4
	ldc	1
	iadd
	istore 4
	goto L9
L8:
	iload 3
	ireturn
	ireturn

.limit locals 16
.limit stack 16
.end method

; functionintgetSmallestIndex(inti,intmax){returngetSmallestIndexFrom(i,max,0);;}

.method private static getSmallestIndex(II)I
	iload 0
	iload 1
	ldc	0
	invokestatic statsRandom/getSmallestIndexFrom(III)I
	ireturn
	ireturn

.limit locals 16
.limit stack 16
.end method

; functionintgetSmallestIndexFrom(inti,intmax,intstart){varn=listSize(i);varsmallest=max;varindex=0;varj=start;while(j<n){if(getFromList(i,j)<smallest){smallest=getFromList(i,j);index=j;}j=j+1;}returnindex;}

.method private static getSmallestIndexFrom(III)I
	iload 0
	invokestatic JFlatList/listSize(I)I
	istore 3
	iload 1
	istore 4
	ldc	0
	istore 5
	iload 2
	istore 6

; while(j<n){if(getFromList(i,j)<smallest){smallest=getFromList(i,j);index=j;}j=j+1;}

L16:
	iload 6
	iload 3
	if_icmplt L17
	iconst_0
	goto L18
L17:
	iconst_1
L18:
	ifeq L15

; if(getFromList(i,j)<smallest){smallest=getFromList(i,j);index=j;}

	iload 0
	iload 6
	invokestatic JFlatList/getFromList(II)I
	iload 4
	if_icmplt L20
	iconst_0
	goto L21
L20:
	iconst_1
L21:
	ifeq L19

; smallest=getFromList(i,j);

	iload 0
	iload 6
	invokestatic JFlatList/getFromList(II)I
	istore 4

; index=j;

	iload 6
	istore 5
L19:

; j=j+1;

	iload 6
	ldc	1
	iadd
	istore 6
	goto L16
L15:
	iload 5
	ireturn
	ireturn

.limit locals 16
.limit stack 16
.end method

; functionvoidprintList(inti){varj=0;varn=listSize(i);while(j<n){print(getFromList(i,j));j=j+1;}}

.method private static printList(I)V
	ldc	0
	istore 1
	iload 0
	invokestatic JFlatList/listSize(I)I
	istore 2

; while(j<n){print(getFromList(i,j));j=j+1;}

L23:
	iload 1
	iload 2
	if_icmplt L24
	iconst_0
	goto L25
L24:
	iconst_1
L25:
	ifeq L22

; print(getFromList(i,j));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	iload 0
	iload 1
	invokestatic JFlatList/getFromList(II)I
	invokevirtual java/io/PrintStream.println(I)V

; j=j+1;

	iload 1
	ldc	1
	iadd
	istore 1
	goto L23
L22:
	return

.limit locals 16
.limit stack 16
.end method

; functionvoidswap(inti,intj,intk){vartemp=getFromList(i,j);setToList(i,j,getFromList(i,k));setToList(i,k,temp);}

.method private static swap(III)V
	iload 0
	iload 1
	invokestatic JFlatList/getFromList(II)I
	istore 3

; setToList(i,j,getFromList(i,k));

	iload 0
	iload 1
	iload 0
	iload 2
	invokestatic JFlatList/getFromList(II)I
	invokestatic JFlatList/setToList(III)V

; setToList(i,k,temp);

	iload 0
	iload 2
	iload 3
	invokestatic JFlatList/setToList(III)V
	return

.limit locals 16
.limit stack 16
.end method

; functionvoidsortList(inti){varj=0;varn=listSize(i);varmax=1000;while(j<n-1){varindex=getSmallestIndexFrom(i,1000,j);swap(i,j,index);j=j+1;}}

.method private static sortList(I)V
	ldc	0
	istore 1
	iload 0
	invokestatic JFlatList/listSize(I)I
	istore 2
	ldc	1000
	istore 3

; while(j<n-1){varindex=getSmallestIndexFrom(i,1000,j);swap(i,j,index);j=j+1;}

L27:
	iload 1
	iload 2
	ldc	1
	isub
	if_icmplt L28
	iconst_0
	goto L29
L28:
	iconst_1
L29:
	ifeq L26
	iload 0
	ldc	1000
	iload 1
	invokestatic statsRandom/getSmallestIndexFrom(III)I
	istore 4

; swap(i,j,index);

	iload 0
	iload 1
	iload 4
	invokestatic statsRandom/swap(III)V

; j=j+1;

	iload 1
	ldc	1
	iadd
	istore 1
	goto L27
L26:
	return

.limit locals 16
.limit stack 16
.end method

.method public static main([Ljava/lang/String;)V

	new RunTimer
	dup
	invokenonvirtual RunTimer/<init>()V
	putstatic        statsRandom/_runTimer LRunTimer;
	new PascalTextIn
	dup
	invokenonvirtual PascalTextIn/<init>()V
	putstatic        statsRandom/_standardIn LPascalTextIn;
	invokestatic JFlatList/createNewList()I
	putstatic	statsRandom/i I
	ldc	10
	putstatic	statsRandom/n I
	ldc	0
	putstatic	statsRandom/j I

; while(j<n){addToList(i,randomInt(100,-50));j=j+1;}

L31:
	getstatic	statsRandom/j I
	getstatic	statsRandom/n I
	if_icmplt L32
	iconst_0
	goto L33
L32:
	iconst_1
L33:
	ifeq L30

; addToList(i,randomInt(100,-50));

	getstatic	statsRandom/i I
	ldc	100
	ldc	50
	ineg
	invokestatic statsRandom/randomInt(II)I
	invokestatic JFlatList/addToList(II)V

; j=j+1;

	getstatic	statsRandom/j I
	ldc	1
	iadd
	putstatic	statsRandom/j I
	goto L31
L30:

; printList(i);

	getstatic	statsRandom/i I
	invokestatic statsRandom/printList(I)V

; print(-11111111);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	11111111
	ineg
	invokevirtual java/io/PrintStream.println(I)V
	getstatic	statsRandom/i I
	invokestatic statsRandom/calcMean(I)F
	putstatic	statsRandom/iMean F
	getstatic	statsRandom/i I
	invokestatic statsRandom/calcSampleVar(I)F
	putstatic	statsRandom/iVar F
	getstatic	statsRandom/i I
	invokestatic statsRandom/calcStandardSampleVar(I)F
	putstatic	statsRandom/iSVar F

; print(iMean);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	statsRandom/iMean F
	invokevirtual java/io/PrintStream.println(F)V

; print(iVar);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	statsRandom/iVar F
	invokevirtual java/io/PrintStream.println(F)V

; print(iSVar);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	statsRandom/iSVar F
	invokevirtual java/io/PrintStream.println(F)V

; print(-22222222);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	22222222
	ineg
	invokevirtual java/io/PrintStream.println(I)V

; sortList(i);

	getstatic	statsRandom/i I
	invokestatic statsRandom/sortList(I)V

; printList(i);

	getstatic	statsRandom/i I
	invokestatic statsRandom/printList(I)V

	getstatic     statsRandom/_runTimer LRunTimer;
	invokevirtual RunTimer.printElapsedTime()V

	return

.limit locals 16
.limit stack 16
.end method
