import static wci.intermediate.symtabimpl.DefinitionImpl.VARIABLE;

import java.io.PrintWriter;

import wci.intermediate.SymTabEntry;
import wci.intermediate.SymTabStack;
import wci.intermediate.TypeSpec;
import wci.intermediate.symtabimpl.Predefined;
import wci.intermediate.symtabimpl.SymTabKeyImpl;

public class Pass2Visitor extends JFlatBaseVisitor<Integer> {
	private String programName;
	private PrintWriter jFile;
	private int assignLv;
	private SymTabStack symTabStack;

	public Pass2Visitor(PrintWriter jFile, String progName, SymTabStack symTab) {
		this.jFile = jFile;
		programName = progName;
		assignLv = 0;
		symTabStack = symTab;
	}

	public Integer visitProg(JFlatParser.ProgContext ctx) {
		// Emit the main program header.
		jFile.println();
		jFile.println(".method public static main([Ljava/lang/String;)V");
		jFile.println();
		jFile.println("\tnew RunTimer");
		jFile.println("\tdup");
		jFile.println("\tinvokenonvirtual RunTimer/<init>()V");
		jFile.println("\tputstatic        " + programName + "/_runTimer LRunTimer;");
		jFile.println("\tnew PascalTextIn");
		jFile.println("\tdup");
		jFile.println("\tinvokenonvirtual PascalTextIn/<init>()V");
		jFile.println("\tputstatic        " + programName + "/_standardIn LPascalTextIn;");

		Integer value = visitChildren(ctx);

		// Emit the main program epilogue.
		jFile.println();
		jFile.println("\tgetstatic     " + programName + "/_runTimer LRunTimer;");
		jFile.println("\tinvokevirtual RunTimer.printElapsedTime()V");
		jFile.println();
		jFile.println("\treturn");
		jFile.println();
		jFile.println(".limit locals 16");
		jFile.println(".limit stack 16");
		jFile.println(".end method");

		jFile.close();
		return value;
	}

	public Integer visitBareExpr(JFlatParser.BareExprContext ctx) {
		jFile.println("\n; " + ctx.getText() + "\n");
		return visitChildren(ctx);
	}

	public Integer visitIfThenElse(JFlatParser.IfThenElseContext ctx) {
		jFile.println("\n; " + ctx.getText() + "\n");
		String[] label = LabelGenerator.nextLabel(2);

		// If
		visit(ctx.expr());
		jFile.println("\tifeq " + label[0]);
		// Then
		visit(ctx.block(0));
		jFile.println("\tgoto " + label[1]);
		// Else
		jFile.println(label[0] + ":");
		visit(ctx.block(1));
		// Next
		jFile.println(label[1] + ":");
		return null;
	}

	public Integer visitIfThen(JFlatParser.IfThenContext ctx) {
		jFile.println("\n; " + ctx.getText() + "\n");
		String label = LabelGenerator.nextLabel();

		// If
		visit(ctx.expr());
		jFile.println("\tifeq " + label);
		// Then
		visit(ctx.block());
		jFile.println(label + ":");
		return null;
	}

	public Integer visitWhile(JFlatParser.WhileContext ctx) {
		jFile.println("\n; " + ctx.getText() + "\n");
		String[] label = LabelGenerator.nextLabel(2);

		// While
		jFile.println(label[1] + ":");
		visit(ctx.expr());
		jFile.println("\tifeq " + label[0]);
		visit(ctx.block());
		jFile.println("\tgoto " + label[1]);
		jFile.println(label[0] + ":");
		return null;
	}
	
	public Integer visitFunctApply(JFlatParser.FunctApplyContext ctx) {

		SymTabEntry currentEntry = symTabStack.lookup(ctx.IDENTIFIER().getText());
		ctx.type = currentEntry.getTypeSpec();
		
		// TODO: Predefined
		
		visitChildren(ctx);
		
		String program = getParentProgram(currentEntry);

		jFile.println("\tinvokestatic " + program + "/" + ctx.IDENTIFIER().getText() + '('
				+ currentEntry.getAttribute(SymTabKeyImpl.ROUTINE_PARMS) + ')'
				+ currentEntry.getAttribute(SymTabKeyImpl.DATA_VALUE));
		return 0;
	}
	
	public String getParentProgram(SymTabEntry entry) {
		DefaultRoutineCode routineCode = (DefaultRoutineCode) entry.getAttribute(SymTabKeyImpl.ROUTINE_CODE);
		if (routineCode == null)
			return programName;
		
		switch (routineCode) {
		case ADDCOLOR:
			return "JFlatGraphics";
		case ADDPOINT:
			return "JFlatGraphics";
		case ADDTOLIST:
			return "JFlatList";
		case CREATELINE:
			return "JFlatGraphics";
		case CREATENEWLIST:
			return "JFlatList";
		case CREATEPAINTGUI:
			return "JFlatGraphics";
		case ENDLINE:
			return "JFlatGraphics";
		case GETCOLORSIZE:
			return "JFlatGraphics";
		case GETFROMLIST:
			return "JFlatList";
		case GETMOUSEX:
			return "JFlatGraphics";
		case GETMOUSEY:
			return "JFlatGraphics";
		case ISDRAG:
			return "JFlatGraphics";
		case ISLEFTCLICK:
			return "JFlatGraphics";
		case ISRIGHTCLICK:
			return "JFlatGraphics";
		case LISTSIZE:
			return "JFlatList";
		case PAINTGUIEXITED:
			return "JFlatGraphics";
		case REFRESH:
			return "JFlatGraphics";
		case SETTOLIST:
			return "JFlatList";
		case SQRTI:
			return "JFlatMath";
		case SQRTR:
			return "JFlatMath";
		case TOINT:
			return "JFlatMath";
		case TOREAL:
			return "JFlatMath";
		case RANDOM:
			return "JFlatMath";
		default:
			return programName;
		}
	}

	public Integer visitFunctDeclare(JFlatParser.FunctDeclareContext ctx) {
		return 0;
	}

	public Integer visitVarDeclareAssign(JFlatParser.VarDeclareAssignContext ctx) {
		assignLv++;
		Integer value = visit(ctx.expr());

		String typeIndicator = (ctx.expr().type == Predefined.integerType) ? "I"
				: (ctx.expr().type == Predefined.realType) ? "F" : "?";

		// Dup if part of another assignement statement
		assignLv--;

		if (assignLv > 0)
			jFile.println("\tdup");

		// Emit a field put instruction.
		jFile.println("\tputstatic\t" + programName + "/" + ctx.IDENTIFIER().toString() + " " + typeIndicator);

		return value;
	}

	public Integer visitVarAssign(JFlatParser.VarAssignContext ctx) {
		assignLv++;
		Integer value = visit(ctx.expr());

		String typeIndicator = (ctx.expr().type == Predefined.integerType) ? "I"
				: (ctx.expr().type == Predefined.realType) ? "F" : "?";

		// Dup if part of another assignement statement
		assignLv--;

		if (assignLv > 0)
			jFile.println("\tdup");

		// Emit a field put instruction.
		jFile.println("\tputstatic\t" + programName + "/" + ctx.IDENTIFIER().toString() + " " + typeIndicator);

		return value;
	}

	public Integer visitMulDivMod(JFlatParser.MulDivModContext ctx) {
		Integer value = visitChildren(ctx);

		TypeSpec type1 = ctx.expr(0).type;
		TypeSpec type2 = ctx.expr(1).type;

		boolean integerMode = (type1 == Predefined.integerType) && (type2 == Predefined.integerType);
		boolean realMode = ((type1 == Predefined.realType) && (type2 == Predefined.realType)) || ((type1 == Predefined.realType) && (type2 == Predefined.integerType)) || ((type1 == Predefined.integerType) && (type2 == Predefined.realType));

		if (realMode && type1 == Predefined.integerType) {
			jFile.println("\tpop");
			jFile.println("\tpop");
			visit(ctx.expr(0));
			jFile.println("\ti2f");
			visit(ctx.expr(1));
		} else if (realMode && type2 == Predefined.integerType) {
			jFile.println("\tpop");
			visit(ctx.expr(1));
			jFile.println("\ti2f");
		}
		
		String op = ctx.op.getText();
		String opcode;

		if (op.equals("*")) {
			opcode = integerMode ? "imul" : realMode ? "fmul" : "f???";
		} else {
			opcode = integerMode ? "idiv" : realMode ? "fdiv" : "????";
		}

		// Emit a multiply or divide instruction.
		jFile.println("\t" + opcode);

		return value;
	}

	public Integer visitAddSub(JFlatParser.AddSubContext ctx) {
		Integer value = visitChildren(ctx);

		TypeSpec type1 = ctx.expr(0).type;
		TypeSpec type2 = ctx.expr(1).type;

		boolean integerMode = (type1 == Predefined.integerType) && (type2 == Predefined.integerType);
		boolean realMode = ((type1 == Predefined.realType) && (type2 == Predefined.realType)) || ((type1 == Predefined.realType) && (type2 == Predefined.integerType)) || ((type1 == Predefined.integerType) && (type2 == Predefined.realType));
		
		if (realMode && type1 == Predefined.integerType) {
			jFile.println("\tpop");
			jFile.println("\tpop");
			visit(ctx.expr(0));
			jFile.println("\ti2f");
			visit(ctx.expr(1));
		} else if (realMode && type2 == Predefined.integerType) {
			jFile.println("\tpop");
			visit(ctx.expr(1));
			jFile.println("\ti2f");
		}
		
		String op = ctx.op.getText();
		String opcode;

		if (op.equals("+")) {
			opcode = integerMode ? "iadd" : realMode ? "fadd" : "????";
		} else {
			opcode = integerMode ? "isub" : realMode ? "fsub" : "????";
		}

		// Emit an add or subtract instruction.
		jFile.println("\t" + opcode);

		return value;
	}

	public Integer visitComparison(JFlatParser.ComparisonContext ctx) {
		Integer value = visitChildren(ctx);

		TypeSpec type1 = ctx.expr(0).type;
		TypeSpec type2 = ctx.expr(1).type;

		boolean integerMode = (type1 == Predefined.integerType) && (type2 == Predefined.integerType);

		String op = ctx.op.getText();
		String opcode;

		if (op.equals("<")) {
			opcode = integerMode ? "if_icmplt " : "????";
		} else if (op.equals("<=")) {
			opcode = integerMode ? "if_icmple " : "????";
		} else if (op.equals(">")) {
			opcode = integerMode ? "if_icmpgt " : "????";
		} else if (op.equals(">=")) {
			opcode = integerMode ? "if_icmpge " : "????";
		} else {
			opcode = integerMode ? "if_icmpeq " : "????";
		}

		String[] labels = LabelGenerator.nextLabel(2);

		jFile.println("\t" + opcode + labels[0]);
		jFile.println("\t" + "iconst_0");
		jFile.println("\t" + "goto " + labels[1]);
		jFile.println(labels[0] + ":");
		jFile.println("\t" + "iconst_1");
		jFile.println(labels[1] + ":");

		return value;
	}

	public Integer visitVarRef(JFlatParser.VarRefContext ctx) {
		String variableName = ctx.IDENTIFIER().toString();
		TypeSpec type = ctx.type;
		String typeIndicator = (type == Predefined.integerType) ? "I" : (type == Predefined.realType) ? "F" : "?";

		// Emit a field get instruction.
		jFile.println("\tgetstatic\t" + programName + "/" + variableName + " " + typeIndicator);

		return visitChildren(ctx);
	}

	public Integer visitSignedNumber(JFlatParser.SignedNumberContext ctx) {
		Integer value = visitChildren(ctx);
		TypeSpec type = ctx.number().type;

		if (ctx.sign().getChild(0) == ctx.sign().SUB()) {
			String opcode = (type == Predefined.integerType) ? "ineg" : (type == Predefined.realType) ? "fneg" : "?neg";

			// Emit a negate instruction.
			jFile.println("\t" + opcode);
		}

		return value;
	}

	public Integer visitIntConst(JFlatParser.IntConstContext ctx) {
		// Emit a load constant instruction.
		jFile.println("\tldc\t" + ctx.getText());

		return visitChildren(ctx);
	}

	public Integer visitRealConst(JFlatParser.RealConstContext ctx) {
		// Emit a load constant instruction.
		jFile.println("\tldc\t" + ctx.getText());

		return visitChildren(ctx);
	}

	public Integer visitBoolean(JFlatParser.BooleanContext ctx) {
		if ("false".equals(ctx.getText())) {
			jFile.println("\tldc\t" + "0");
		} else {
			jFile.println("\tldc\t" + "1");
		}

		return visitChildren(ctx);
	}

	public Integer visitPrint(JFlatParser.PrintContext ctx) {
		jFile.println("\n; " + ctx.getText() + "\n");

		// Print
		jFile.println("\tgetstatic\t java/lang/System/out Ljava/io/PrintStream;");
		
		assignLv++;
		Integer value = visit(ctx.expr());
		assignLv--;
		
		String typeIndicator = (ctx.expr().type == Predefined.integerType) ? "I"
				: (ctx.expr().type == Predefined.realType) ? "F" : "?";


		jFile.println("\tinvokevirtual java/io/PrintStream.println(" + typeIndicator + ")V");
		return null;
	}
}
