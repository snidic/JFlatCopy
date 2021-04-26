import static wci.intermediate.symtabimpl.DefinitionImpl.VARIABLE;
import static wci.intermediate.symtabimpl.SymTabKeyImpl.ROUTINE_SYMTAB;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import wci.intermediate.SymTabEntry;
import wci.intermediate.SymTabFactory;
import wci.intermediate.SymTabStack;
import wci.intermediate.TypeSpec;
import wci.intermediate.symtabimpl.DefinitionImpl;
import wci.intermediate.symtabimpl.Predefined;
import wci.intermediate.symtabimpl.SymTabKeyImpl;
import wci.util.CrossReferencer;

public class Pass1Visitor extends JFlatBaseVisitor<Integer> {
	private SymTabStack symTabStack;
	private SymTabEntry programId;
	private ArrayList<SymTabEntry> variableIdList;
	private PrintWriter jFile;
	private String programName;

	public Pass1Visitor(String progName, SymTabStack symTab) {
		programName = progName;
		symTabStack = symTab;
		variableIdList = new ArrayList<SymTabEntry>();
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

	public Integer visitProg(JFlatParser.ProgContext ctx) {

		// Create the assembly output file.
		try {
			jFile = new PrintWriter(new FileWriter(programName + ".j"));
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}

		// Emit the program header.
		jFile.println(".class public " + programName);
		jFile.println(".super java/lang/Object");

		// Emit the RunTimer and PascalTextIn fields.
		jFile.println();
		jFile.println(".field private static _runTimer LRunTimer;");
		jFile.println(".field private static _standardIn LPascalTextIn;");

		Integer value = visitChildren(ctx);

		emitFieldDeclarations();

		// Emit the class constructor.
		jFile.println();
		jFile.println(".method public <init>()V");
		jFile.println();
		jFile.println("\taload_0");
		jFile.println("\tinvokenonvirtual    java/lang/Object/<init>()V");
		jFile.println("\treturn");
		jFile.println();
		jFile.println(".limit locals 1");
		jFile.println(".limit stack 1");
		jFile.println(".end method");

		// Print the cross-reference table.
		CrossReferencer crossReferencer = new CrossReferencer();
		crossReferencer.print(symTabStack);

		return value;
	}

	private void emitFieldDeclarations() {
		// Loop over symbol table entries
		for (SymTabEntry id : variableIdList) {
			TypeSpec type = id.getTypeSpec();
			String typeIndicator;

			if (type == Predefined.integerType) {
				typeIndicator = "I";
			} else if (type == Predefined.realType) {
				typeIndicator = "F";
			} else {
				typeIndicator = "?";
			}

			// Emit a field declaration.
			jFile.println(".field private static " + id.getName() + " " + typeIndicator);
		}
	}

	public Integer visitFunctApply(JFlatParser.FunctApplyContext ctx) {

		SymTabEntry currentEntry = symTabStack.lookup(ctx.IDENTIFIER().getText());

		String returnType = (String) currentEntry.getAttribute(SymTabKeyImpl.DATA_VALUE);
		if (returnType.equals("I")) {
			ctx.type = Predefined.integerType;
		} else if (returnType.equals("F")) {
			ctx.type = Predefined.realType;
		}
		visitChildren(ctx);
		
		return 0;
	}

	public Integer visitFunctDeclare(JFlatParser.FunctDeclareContext ctx) {
		return 0;
	}

	public Integer visitVarListDeclare(JFlatParser.VarDeclareAssignContext ctx) {
		// Visiting a declaration statement
		jFile.println("\n; " + ctx.getText() + "\n");
		return visitChildren(ctx);
	}

	public Integer visitVarDeclare(JFlatParser.VarDeclareContext ctx) {
		// Variable Declaration
		String variableName = ctx.IDENTIFIER().toString();

		// Enter variable into symbol table with a null TypeSpec
		SymTabEntry variableId = symTabStack.enterLocal(variableName);
		variableId.setDefinition(VARIABLE);
		variableIdList.add(variableId);
		variableId.setTypeSpec(null);

		return visitChildren(ctx);
	}

	public Integer visitVarDeclareAssign(JFlatParser.VarDeclareAssignContext ctx) {
		Integer value = visitChildren(ctx);
		// Enter variable into symbol table
		String variableName = ctx.IDENTIFIER().toString();

		SymTabEntry variableId = symTabStack.enterLocal(variableName);
		variableId.setDefinition(VARIABLE);
		variableIdList.add(variableId);

		TypeSpec exprType = ctx.expr().type;

		// Setting typeSpec of the variable to the expression
		variableId.setTypeSpec(exprType);

		return value;
	}

	public Integer visitVarAssign(JFlatParser.VarAssignContext ctx) {
		Integer value = visitChildren(ctx);

		String variableName = ctx.IDENTIFIER().toString();
		SymTabEntry variableId = symTabStack.lookup(variableName);

		// Unassigned declared variable set to the expression's TypeSpec

		if (variableId.getTypeSpec() == null) {
			variableId.setTypeSpec(ctx.expr().type);
		}
		ctx.type = ctx.expr().type;
		return value;
	}

	public Integer visitMulDivMod(JFlatParser.MulDivModContext ctx) {
		Integer value = visitChildren(ctx);

		TypeSpec type1 = ctx.expr(0).type;
		TypeSpec type2 = ctx.expr(1).type;

		boolean integerMode = (type1 == Predefined.integerType) && (type2 == Predefined.integerType);
		boolean realMode = ((type1 == Predefined.realType) && (type2 == Predefined.realType)) || ((type1 == Predefined.realType) && (type2 == Predefined.integerType)) || ((type1 == Predefined.integerType) && (type2 == Predefined.realType));

		TypeSpec type = integerMode ? Predefined.integerType : realMode ? Predefined.realType : null;
		ctx.type = type;

		return value;
	}

	public Integer visitAddSub(JFlatParser.AddSubContext ctx) {
		Integer value = visitChildren(ctx);

		TypeSpec type1 = ctx.expr(0).type;
		TypeSpec type2 = ctx.expr(1).type;

		boolean integerMode = (type1 == Predefined.integerType) && (type2 == Predefined.integerType);
		boolean realMode = ((type1 == Predefined.realType) && (type2 == Predefined.realType)) || ((type1 == Predefined.realType) && (type2 == Predefined.integerType)) || ((type1 == Predefined.integerType) && (type2 == Predefined.realType));
		
		TypeSpec type = integerMode ? Predefined.integerType : realMode ? Predefined.realType : null;
		ctx.type = type;

		return value;
	}

	public Integer visitComparison(JFlatParser.ComparisonContext ctx) {
		Integer value = visitChildren(ctx);

		TypeSpec type1 = ctx.expr(0).type;
		TypeSpec type2 = ctx.expr(1).type;

		boolean integerMode = (type1 == Predefined.integerType) && (type2 == Predefined.integerType);

		TypeSpec type = integerMode ? Predefined.integerType : null;
		ctx.type = type;

		return value;
	}

	public Integer visitVarRef(JFlatParser.VarRefContext ctx) {
		String variableName = ctx.IDENTIFIER().toString();
		SymTabEntry variableId = symTabStack.lookup(variableName);

		ctx.type = variableId.getTypeSpec();
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
		Integer value = visit(ctx.number());
		ctx.type = ctx.number().type;
		return value;
	}

	public Integer visitIntConst(JFlatParser.IntConstContext ctx) {
		ctx.type = Predefined.integerType;
		return visitChildren(ctx);
	}

	public Integer visitRealConst(JFlatParser.RealConstContext ctx) {
		ctx.type = Predefined.realType;
		return visitChildren(ctx);
	}

	public Integer visitBoolean(JFlatParser.BooleanContext ctx) {
		ctx.type = Predefined.integerType;
		return visitChildren(ctx);
	}

}
