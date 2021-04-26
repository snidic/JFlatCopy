.class public stats
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;
.field private static i I
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
	invokestatic stats/calcMean(I)F
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
	invokestatic stats/calcSampleVar(I)F
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
	invokestatic stats/getSmallestIndexFrom(III)I
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
	invokestatic stats/getSmallestIndexFrom(III)I
	istore 4

; swap(i,j,index);

	iload 0
	iload 1
	iload 4
	invokestatic stats/swap(III)V

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
	putstatic        stats/_runTimer LRunTimer;
	new PascalTextIn
	dup
	invokenonvirtual PascalTextIn/<init>()V
	putstatic        stats/_standardIn LPascalTextIn;
	invokestatic JFlatList/createNewList()I
	putstatic	stats/i I

; print(i);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	stats/i I
	invokevirtual java/io/PrintStream.println(I)V

; addToList(i,2);

	getstatic	stats/i I
	ldc	2
	invokestatic JFlatList/addToList(II)V

; addToList(i,3);

	getstatic	stats/i I
	ldc	3
	invokestatic JFlatList/addToList(II)V

; addToList(i,1);

	getstatic	stats/i I
	ldc	1
	invokestatic JFlatList/addToList(II)V

; addToList(i,4);

	getstatic	stats/i I
	ldc	4
	invokestatic JFlatList/addToList(II)V

; addToList(i,8);

	getstatic	stats/i I
	ldc	8
	invokestatic JFlatList/addToList(II)V

; addToList(i,9);

	getstatic	stats/i I
	ldc	9
	invokestatic JFlatList/addToList(II)V

; addToList(i,7);

	getstatic	stats/i I
	ldc	7
	invokestatic JFlatList/addToList(II)V

; addToList(i,10);

	getstatic	stats/i I
	ldc	10
	invokestatic JFlatList/addToList(II)V

; addToList(i,5);

	getstatic	stats/i I
	ldc	5
	invokestatic JFlatList/addToList(II)V

; addToList(i,6);

	getstatic	stats/i I
	ldc	6
	invokestatic JFlatList/addToList(II)V

; print(getFromList(i,0));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	stats/i I
	ldc	0
	invokestatic JFlatList/getFromList(II)I
	invokevirtual java/io/PrintStream.println(I)V

; print(listSize(i));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	stats/i I
	invokestatic JFlatList/listSize(I)I
	invokevirtual java/io/PrintStream.println(I)V

; print(-11111111);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	11111111
	ineg
	invokevirtual java/io/PrintStream.println(I)V
	getstatic	stats/i I
	invokestatic stats/calcMean(I)F
	putstatic	stats/iMean F
	getstatic	stats/i I
	invokestatic stats/calcSampleVar(I)F
	putstatic	stats/iVar F
	getstatic	stats/i I
	invokestatic stats/calcStandardSampleVar(I)F
	putstatic	stats/iSVar F

; print(iMean);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	stats/iMean F
	invokevirtual java/io/PrintStream.println(F)V

; print(iVar);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	stats/iVar F
	invokevirtual java/io/PrintStream.println(F)V

; print(iSVar);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	stats/iSVar F
	invokevirtual java/io/PrintStream.println(F)V

; print(-22222222);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	22222222
	ineg
	invokevirtual java/io/PrintStream.println(I)V

; addToList(i,11);

	getstatic	stats/i I
	ldc	11
	invokestatic JFlatList/addToList(II)V

; print(listSize(i));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	stats/i I
	invokestatic JFlatList/listSize(I)I
	invokevirtual java/io/PrintStream.println(I)V

; iMean=calcMean(i);

	getstatic	stats/i I
	invokestatic stats/calcMean(I)F
	putstatic	stats/iMean F

; iVar=calcSampleVar(i);

	getstatic	stats/i I
	invokestatic stats/calcSampleVar(I)F
	putstatic	stats/iVar F

; iSVar=calcStandardSampleVar(i);

	getstatic	stats/i I
	invokestatic stats/calcStandardSampleVar(I)F
	putstatic	stats/iSVar F

; print(iMean);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	stats/iMean F
	invokevirtual java/io/PrintStream.println(F)V

; print(iVar);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	stats/iVar F
	invokevirtual java/io/PrintStream.println(F)V

; print(iSVar);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	stats/iSVar F
	invokevirtual java/io/PrintStream.println(F)V

; print(-33333333);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	33333333
	ineg
	invokevirtual java/io/PrintStream.println(I)V

; print(getSmallestValue(i,1000));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	stats/i I
	ldc	1000
	invokestatic stats/getSmallestValue(II)I
	invokevirtual java/io/PrintStream.println(I)V

; print(getSmallestIndex(i,1000));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	stats/i I
	ldc	1000
	invokestatic stats/getSmallestIndex(II)I
	invokevirtual java/io/PrintStream.println(I)V

; addToList(i,-1);

	getstatic	stats/i I
	ldc	1
	ineg
	invokestatic JFlatList/addToList(II)V

; addToList(i,0);

	getstatic	stats/i I
	ldc	0
	invokestatic JFlatList/addToList(II)V

; print(getSmallestValue(i,1000));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	stats/i I
	ldc	1000
	invokestatic stats/getSmallestValue(II)I
	invokevirtual java/io/PrintStream.println(I)V

; print(getSmallestIndex(i,1000));

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	getstatic	stats/i I
	ldc	1000
	invokestatic stats/getSmallestIndex(II)I
	invokevirtual java/io/PrintStream.println(I)V

; print(-444444);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	444444
	ineg
	invokevirtual java/io/PrintStream.println(I)V

; printList(i);

	getstatic	stats/i I
	invokestatic stats/printList(I)V

; sortList(i);

	getstatic	stats/i I
	invokestatic stats/sortList(I)V

; print(-555555);

	getstatic	 java/lang/System/out Ljava/io/PrintStream;
	ldc	555555
	ineg
	invokevirtual java/io/PrintStream.println(I)V

; printList(i);

	getstatic	stats/i I
	invokestatic stats/printList(I)V

	getstatic     stats/_runTimer LRunTimer;
	invokevirtual RunTimer.printElapsedTime()V

	return

.limit locals 16
.limit stack 16
.end method
