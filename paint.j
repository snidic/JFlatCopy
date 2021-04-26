.class public paint
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;
.field private static width I
.field private static height I
.field private static r I
.field private static g I
.field private static b I
.field private static black I
.field private static white I
.field private static red I
.field private static green I
.field private static blue I
.field private static active I
.field private static leftClick I
.field private static rightClick I
.field private static leftTrigger I
.field private static rightTrigger I
.field private static dragged I
.field private static mouseX I
.field private static mouseY I
.field private static colorIndex I

.method public <init>()V

	aload_0
	invokenonvirtual    java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

; functionvoidnextColorIndex(){varn=getColorSize();colorIndex=colorIndex+1;if(colorIndex>=n)colorIndex=0;}

.method private static nextColorIndex()V
	invokestatic JFlatGraphics/getColorSize()I
	istore 0

; colorIndex=colorIndex+1;

	getstatic	paint/colorIndex I
	ldc	1
	iadd
	putstatic	paint/colorIndex I

; if(colorIndex>=n)colorIndex=0;

	getstatic	paint/colorIndex I
	iload 0
	if_icmpge L1
	iconst_0
	goto L2
L1:
	iconst_1
L2:
	ifeq L0

; colorIndex=0;

	ldc	0
	putstatic	paint/colorIndex I
L0:
	return

.limit locals 16
.limit stack 16
.end method

.method public static main([Ljava/lang/String;)V

	new RunTimer
	dup
	invokenonvirtual RunTimer/<init>()V
	putstatic        paint/_runTimer LRunTimer;
	new PascalTextIn
	dup
	invokenonvirtual PascalTextIn/<init>()V
	putstatic        paint/_standardIn LPascalTextIn;
	ldc	1000
	putstatic	paint/width I
	ldc	500
	putstatic	paint/height I
	ldc	0
	putstatic	paint/r I
	ldc	0
	putstatic	paint/g I
	ldc	0
	putstatic	paint/b I
	getstatic	paint/r I
	getstatic	paint/g I
	getstatic	paint/b I
	invokestatic JFlatGraphics/addColor(III)I
	putstatic	paint/black I
	ldc	255
	ldc	255
	ldc	255
	invokestatic JFlatGraphics/addColor(III)I
	putstatic	paint/white I
	ldc	255
	ldc	0
	ldc	0
	invokestatic JFlatGraphics/addColor(III)I
	putstatic	paint/red I
	ldc	0
	ldc	255
	ldc	0
	invokestatic JFlatGraphics/addColor(III)I
	putstatic	paint/green I
	ldc	0
	ldc	0
	ldc	255
	invokestatic JFlatGraphics/addColor(III)I
	putstatic	paint/blue I

; createPaintGUI(width,height);

	getstatic	paint/width I
	getstatic	paint/height I
	invokestatic JFlatGraphics/createPaintGUI(II)V
	ldc	1
	putstatic	paint/active I
	ldc	0
	putstatic	paint/leftClick I
	ldc	0
	putstatic	paint/rightClick I
	ldc	0
	putstatic	paint/leftTrigger I
	ldc	0
	putstatic	paint/rightTrigger I
	ldc	0
	putstatic	paint/dragged I
	ldc	0
	putstatic	paint/mouseX I
	ldc	0
	putstatic	paint/mouseY I
	ldc	0
	putstatic	paint/colorIndex I

; while(active){leftClick=isLeftClick();rightClick=isRightClick();dragged=isDrag();mouseX=getMouseX();mouseY=getMouseY();if(leftClick){if(leftTrigger==false){createLine(mouseX,mouseY,colorIndex);leftTrigger=true;}else{if(dragged)addPoint(mouseX,mouseY);}}else{if(leftTrigger){endLine(mouseX,mouseY);leftTrigger=false;}}if(rightClick){if(rightTrigger==false){nextColorIndex();rightTrigger=true;}}else{if(rightTrigger){rightTrigger=false;}}refresh();active=paintGUIExited();}

L4:
	getstatic	paint/active I
	ifeq L3

; leftClick=isLeftClick();

	invokestatic JFlatGraphics/isLeftClick()I
	putstatic	paint/leftClick I

; rightClick=isRightClick();

	invokestatic JFlatGraphics/isRightClick()I
	putstatic	paint/rightClick I

; dragged=isDrag();

	invokestatic JFlatGraphics/isDrag()I
	putstatic	paint/dragged I

; mouseX=getMouseX();

	invokestatic JFlatGraphics/getMouseX()I
	putstatic	paint/mouseX I

; mouseY=getMouseY();

	invokestatic JFlatGraphics/getMouseY()I
	putstatic	paint/mouseY I

; if(leftClick){if(leftTrigger==false){createLine(mouseX,mouseY,colorIndex);leftTrigger=true;}else{if(dragged)addPoint(mouseX,mouseY);}}else{if(leftTrigger){endLine(mouseX,mouseY);leftTrigger=false;}}

	getstatic	paint/leftClick I
	ifeq L5

; if(leftTrigger==false){createLine(mouseX,mouseY,colorIndex);leftTrigger=true;}else{if(dragged)addPoint(mouseX,mouseY);}

	getstatic	paint/leftTrigger I
	ldc	0
	if_icmpeq L9
	iconst_0
	goto L10
L9:
	iconst_1
L10:
	ifeq L7

; createLine(mouseX,mouseY,colorIndex);

	getstatic	paint/mouseX I
	getstatic	paint/mouseY I
	getstatic	paint/colorIndex I
	invokestatic JFlatGraphics/createLine(III)V

; leftTrigger=true;

	ldc	1
	putstatic	paint/leftTrigger I
	goto L8
L7:

; if(dragged)addPoint(mouseX,mouseY);

	getstatic	paint/dragged I
	ifeq L11

; addPoint(mouseX,mouseY);

	getstatic	paint/mouseX I
	getstatic	paint/mouseY I
	invokestatic JFlatGraphics/addPoint(II)V
L11:
L8:
	goto L6
L5:

; if(leftTrigger){endLine(mouseX,mouseY);leftTrigger=false;}

	getstatic	paint/leftTrigger I
	ifeq L12

; endLine(mouseX,mouseY);

	getstatic	paint/mouseX I
	getstatic	paint/mouseY I
	invokestatic JFlatGraphics/endLine(II)V

; leftTrigger=false;

	ldc	0
	putstatic	paint/leftTrigger I
L12:
L6:

; if(rightClick){if(rightTrigger==false){nextColorIndex();rightTrigger=true;}}else{if(rightTrigger){rightTrigger=false;}}

	getstatic	paint/rightClick I
	ifeq L13

; if(rightTrigger==false){nextColorIndex();rightTrigger=true;}

	getstatic	paint/rightTrigger I
	ldc	0
	if_icmpeq L16
	iconst_0
	goto L17
L16:
	iconst_1
L17:
	ifeq L15

; nextColorIndex();

	invokestatic paint/nextColorIndex()V

; rightTrigger=true;

	ldc	1
	putstatic	paint/rightTrigger I
L15:
	goto L14
L13:

; if(rightTrigger){rightTrigger=false;}

	getstatic	paint/rightTrigger I
	ifeq L18

; rightTrigger=false;

	ldc	0
	putstatic	paint/rightTrigger I
L18:
L14:

; refresh();

	invokestatic JFlatGraphics/refresh()V

; active=paintGUIExited();

	invokestatic JFlatGraphics/paintGUIExited()I
	putstatic	paint/active I
	goto L4
L3:

	getstatic     paint/_runTimer LRunTimer;
	invokevirtual RunTimer.printElapsedTime()V

	return

.limit locals 16
.limit stack 16
.end method
