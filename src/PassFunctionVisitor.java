import static wci.intermediate.symtabimpl.DefinitionImpl.VARIABLE;

import java.io.PrintWriter;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import wci.intermediate.SymTab;
import wci.intermediate.SymTabEntry;
import wci.intermediate.SymTabStack;
import wci.intermediate.TypeSpec;
import wci.intermediate.symtabimpl.Predefined;
import wci.intermediate.symtabimpl.SymTabKeyImpl;

public class PassFunctionVisitor extends JFlatBaseVisitor<Integer> {
	private String programName;
	private PrintWriter jFile;
	private SymTabStack symTabStack;
	private boolean inFunction;
	private String paramString;
	private SymTab functStack;
	private SymTabEntry functEntry;
	private int assignLv;
	private int localVarNum;
	private String returnType;

	public PassFunctionVisitor(PrintWriter jFile, String progName, SymTabStack symTab) {
		this.jFile = jFile;
		programName = progName;
		symTabStack = symTab;
		assignLv = 0;
		inFunction = false;
	}

	public String getProgramName() {
		return programName;
	}

	public PrintWriter getAssemblyFile() {
		return jFile;
	}

	public SymTabStack getSymTabStack() {
		return symTabStack;
	}

	public Integer visitFunctDeclare(JFlatParser.FunctDeclareContext ctx) {
		jFile.println("\n; " + ctx.getText() + "\n");

		inFunction = true;
		localVarNum = 0;
		// Add a new symbol table entry with function name
		functEntry = symTabStack.lookup(ctx.IDENTIFIER().getText());

		// Push local stack and assign it to the entry
		functStack = symTabStack.push();
		functEntry.setAttribute(SymTabKeyImpl.ROUTINE_SYMTAB, functStack);

		// Visit function return type and set it as an attribute to the entry
		visit(ctx.primType());
		TypeSpec type = ctx.primType().type;
		returnType = (type == Predefined.integerType) ? "I" : (type == Predefined.realType) ? "F" : "V";
		functEntry.setAttribute(SymTabKeyImpl.DATA_VALUE, returnType);

		visit(ctx.params());

		jFile.println(".method private static " + ctx.IDENTIFIER().getText() + '(' + paramString + ')' + returnType);

		// Visit body of the function
		for (JFlatParser.StatContext s : ctx.stat()) {
			visit(s);
		}

		// TODO: return statement
		if (returnType.equals("I"))
			jFile.println("\tireturn");
		else if (returnType.equals("F"))
			jFile.println("\tfreturn");
		else
			jFile.println("\treturn");

		jFile.println();
		jFile.println(".limit locals 16");
		jFile.println(".limit stack 16");
		jFile.println(".end method");

		symTabStack.pop();
		inFunction = false;

		return 0;
	}

	/**
	 * Gather the parameter types and enter the parameters to the local function
	 * stack
	 */
	public Integer visitParams(JFlatParser.ParamsContext ctx) {
		paramString = "";

		List<JFlatParser.PrimTypeContext> typeList = ctx.primType();
		List<TerminalNode> idList = ctx.IDENTIFIER();

		// Loop over the parameters and their type
		for (int i = 0; i < typeList.size(); i++) {
			visit(typeList.get(i));
			visit(idList.get(i));
			// append the parameter type to the paramString
			paramString += (typeList.get(i).type == Predefined.integerType) ? "I"
					: (typeList.get(i).type == Predefined.realType) ? "F" : "?";
			// Add the parameter variable ID to the local stack and set its local variable
			// number
			SymTabEntry entry = functStack.enter(idList.get(i).getText());
			entry.setAttribute(SymTabKeyImpl.DATA_VALUE, localVarNum++);
			entry.setTypeSpec(typeList.get(i).type);
		}

		// Add paramString to the parent entry as a parameter
		functEntry.setAttribute(SymTabKeyImpl.ROUTINE_PARMS, paramString);

		return visitChildren(ctx);
	}

	public Integer visitExprReturn(JFlatParser.ExprReturnContext ctx) {
		assignLv++;
		visit(ctx.expr());
		assignLv--;

		if (returnType.equals("I"))
			jFile.println("\tireturn");
		else if (returnType.equals("F"))
			jFile.println("\tfreturn");
		else
			jFile.println("\treturn");

		return 0;
	}

	public Integer visitEmptyReturn(JFlatParser.EmptyReturnContext ctx) {
		jFile.println("\treturn");
		return visitChildren(ctx);
	}

	public Integer visitTypeBool(JFlatParser.TypeBoolContext ctx) {
		ctx.type = Predefined.integerType;
		return visitChildren(ctx);
	}

	public Integer visitTypeInt(JFlatParser.TypeIntContext ctx) {
		ctx.type = Predefined.integerType;
		return visitChildren(ctx);
	}

	public Integer visitTypeReal(JFlatParser.TypeRealContext ctx) {
		ctx.type = Predefined.realType;
		return visitChildren(ctx);
	}

	public Integer visitFunctApply(JFlatParser.FunctApplyContext ctx) {
		if (!inFunction)
			return 0;

		SymTabEntry currentEntry = symTabStack.lookup(ctx.IDENTIFIER().getText());
		ctx.type = currentEntry.getTypeSpec();
		
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

	public Integer visitBareExpr(JFlatParser.BareExprContext ctx) {
		if (!inFunction)
			return 0;

		jFile.println("\n; " + ctx.getText() + "\n");
		return visitChildren(ctx);
	}

	public Integer visitIfThenElse(JFlatParser.IfThenElseContext ctx) {
		if (!inFunction)
			return 0;

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
		if (!inFunction)
			return 0;

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
		if (!inFunction)
			return 0;

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

	public Integer visitVarDeclare(JFlatParser.VarDeclareContext ctx) {
		if (!inFunction)
			return 0;
		// Only local variables
		// Variable Declaration
		String variableName = ctx.IDENTIFIER().toString();

		// Enter variable into local symbol table with the local variable number
		SymTabEntry variableId = symTabStack.enterLocal(variableName);
		variableId.setDefinition(VARIABLE);
		variableId.setAttribute(SymTabKeyImpl.DATA_VALUE, localVarNum++);
		variableId.setTypeSpec(null);

		return visitChildren(ctx);
	}

	public Integer visitVarDeclareAssign(JFlatParser.VarDeclareAssignContext ctx) {
		if (!inFunction)
			return 0;

		assignLv++;
		Integer value = visit(ctx.expr());

		// Dup if part of another assignment statement
		assignLv--;

		if (assignLv > 0)
			jFile.println("\tdup");

		// Declaration
		String variableName = ctx.IDENTIFIER().toString();

		TypeSpec exprType = ctx.expr().type;

		// Enter variable into local symbol table with the local variable number
		SymTabEntry variableId = symTabStack.enterLocal(variableName);
		variableId.setDefinition(VARIABLE);
		variableId.setAttribute(SymTabKeyImpl.DATA_VALUE, localVarNum++);

		// Setting typeSpec of the variable to the expression
		variableId.setTypeSpec(exprType);

		// Assignment
		// Lookup in Symbol table stack
		SymTabEntry idEntry = symTabStack.lookupLocal((ctx.IDENTIFIER().getText()));

		int i = (int) idEntry.getAttribute(SymTabKeyImpl.DATA_VALUE);

		String typeIndicator = (ctx.expr().type == Predefined.integerType) ? "i"
				: (ctx.expr().type == Predefined.realType) ? "f" : "?";

		jFile.println("\t" + typeIndicator + "store" + " " + i);

		return value;
	}

	public Integer visitVarAssign(JFlatParser.VarAssignContext ctx) {
		if (!inFunction)
			return 0;

		assignLv++;
		Integer value = visit(ctx.expr());

		// Dup if part of another assignment statement
		assignLv--;

		if (assignLv > 0)
			jFile.println("\tdup");

		// Lookup in Symbol table stack
		SymTabEntry idEntry = symTabStack.lookupLocal((ctx.IDENTIFIER().getText()));

		// Local
		if (idEntry != null) {
			int i = (int) idEntry.getAttribute(SymTabKeyImpl.DATA_VALUE);

			if (idEntry.getTypeSpec() == null) {
				idEntry.setTypeSpec(ctx.expr().type);
			}
			ctx.type = ctx.expr().type;

			String typeIndicator = (ctx.expr().type == Predefined.integerType) ? "i"
					: (ctx.expr().type == Predefined.realType) ? "f" : "?";

			jFile.println("\t" + typeIndicator + "store" + " " + i);
		} else {
			// Global
			// TODO: Could be missing from symtab

			idEntry = symTabStack.lookup(ctx.IDENTIFIER().getText());
			if (idEntry == null) {

			}

			String typeIndicator = (ctx.expr().type == Predefined.integerType) ? "I"
					: (ctx.expr().type == Predefined.realType) ? "F" : "?";

			// Emit a field put instruction.
			jFile.println("\tputstatic\t" + programName + "/" + ctx.IDENTIFIER().toString() + " " + typeIndicator);
		}

		return value;
	}

	public Integer visitMulDivMod(JFlatParser.MulDivModContext ctx) {
		if (!inFunction)
			return 0;

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
		
		TypeSpec type = integerMode ? Predefined.integerType : realMode ? Predefined.realType : null;
		ctx.type = type;

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
		if (!inFunction)
			return 0;

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
		
		TypeSpec type = integerMode ? Predefined.integerType : realMode ? Predefined.realType : null;
		ctx.type = type;

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
		if (!inFunction)
			return 0;

		Integer value = visitChildren(ctx);

		TypeSpec type1 = ctx.expr(0).type;
		TypeSpec type2 = ctx.expr(1).type;

		boolean integerMode = (type1 == Predefined.integerType) && (type2 == Predefined.integerType);

		TypeSpec type = integerMode ? Predefined.integerType : null;
		ctx.type = type;

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
		if (!inFunction)
			return 0;

		String variableName = ctx.IDENTIFIER().toString();
		TypeSpec type;

		// Lookup in Symbol table stack
		SymTabEntry idEntry = symTabStack.lookupLocal((ctx.IDENTIFIER().getText()));

		// Local
		if (idEntry != null) {
			ctx.type = idEntry.getTypeSpec();
			int i = (int) idEntry.getAttribute(SymTabKeyImpl.DATA_VALUE);
			type = ctx.type;

			String typeIndicator = (type == Predefined.integerType) ? "i" : (type == Predefined.realType) ? "f" : "?";

			jFile.println("\t" + typeIndicator + "load" + " " + i);

		} else {
			// Global

			idEntry = symTabStack.lookup(ctx.IDENTIFIER().getText());
			ctx.type = idEntry.getTypeSpec();
			type = ctx.type;
			// TODO: Could be missing from symtab
			String typeIndicator = (type == Predefined.integerType) ? "I" : (type == Predefined.realType) ? "F" : "?";

			// Emit a field get instruction.
			jFile.println("\tgetstatic\t" + programName + "/" + variableName + " " + typeIndicator);
		}

		return visitChildren(ctx);
	}

	public Integer visitParens(JFlatParser.ParensContext ctx) {
		Integer value = visitChildren(ctx);
		ctx.type = ctx.expr().type;
		return value;
	}

	public Integer visitUnsignNumber(JFlatParser.UnsignNumberContext ctx) {
		Integer value = visit(ctx.number());
		ctx.type = ctx.number().type;
		return value;
	}

	public Integer visitSignedNum(JFlatParser.SignedNumContext ctx) {
		Integer value = visit(ctx.signedNumber());
		ctx.type = ctx.signedNumber().type;
		return value;
	}

	public Integer visitSignedNumber(JFlatParser.SignedNumberContext ctx) {
		if (!inFunction)
			return 0;

		Integer value = visitChildren(ctx);
		TypeSpec type = ctx.number().type;
		ctx.type = ctx.number().type;

		if (ctx.sign().getChild(0) == ctx.sign().SUB()) {
			String opcode = (type == Predefined.integerType) ? "ineg" : (type == Predefined.realType) ? "fneg" : "?neg";

			// Emit a negate instruction.
			jFile.println("\t" + opcode);
		}

		return value;
	}

	public Integer visitIntConst(JFlatParser.IntConstContext ctx) {
		if (!inFunction)
			return 0;

		ctx.type = Predefined.integerType;
		// Emit a load constant instruction.
		jFile.println("\tldc\t" + ctx.getText());

		return visitChildren(ctx);
	}

	public Integer visitRealConst(JFlatParser.RealConstContext ctx) {
		if (!inFunction)
			return 0;

		ctx.type = Predefined.realType;
		// Emit a load constant instruction.
		jFile.println("\tldc\t" + ctx.getText());

		return visitChildren(ctx);
	}

	public Integer visitBoolean(JFlatParser.BooleanContext ctx) {
		if (!inFunction)
			return 0;

		ctx.type = Predefined.integerType;

		if ("false".equals(ctx.getText())) {
			jFile.println("\tldc\t" + "0");
		} else {
			jFile.println("\tldc\t" + "1");
		}

		return visitChildren(ctx);
	}

	public Integer visitPrint(JFlatParser.PrintContext ctx) {
		if (!inFunction)
			return 0;

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
