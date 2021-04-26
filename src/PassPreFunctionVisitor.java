import static wci.intermediate.symtabimpl.SymTabKeyImpl.ROUTINE_CODE;
import static wci.intermediate.symtabimpl.SymTabKeyImpl.ROUTINE_SYMTAB;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import wci.intermediate.RoutineCode;
import wci.intermediate.SymTab;
import wci.intermediate.SymTabEntry;
import wci.intermediate.SymTabFactory;
import wci.intermediate.SymTabStack;
import wci.intermediate.TypeSpec;
import wci.intermediate.symtabimpl.DefinitionImpl;
import wci.intermediate.symtabimpl.Predefined;
import wci.intermediate.symtabimpl.SymTabKeyImpl;
import wci.util.CrossReferencer;

public class PassPreFunctionVisitor extends JFlatBaseVisitor<Integer> {
	private String programName;
	private SymTabStack symTabStack;
	private String paramString;
	private SymTabEntry functEntry;
	private SymTabEntry programId;

	public PassPreFunctionVisitor(String inputFile) {
		// Create and initialize the symbol table stack.
		symTabStack = SymTabFactory.createSymTabStack();
		Predefined.initialize(symTabStack);
		programName = (inputFile != null) ? retrieveFileName(inputFile) : "unnamed";
	}

	private void initializePredefinedFunctions() {
		addFunction("addToList", "II", "V", Predefined.undefinedType, DefaultRoutineCode.ADDTOLIST);
		addFunction("createNewList", "", "I", Predefined.integerType, DefaultRoutineCode.CREATENEWLIST);
		addFunction("listSize", "I", "I", Predefined.integerType, DefaultRoutineCode.LISTSIZE);
		addFunction("getFromList", "II", "I", Predefined.integerType, DefaultRoutineCode.GETFROMLIST);
		addFunction("setToList", "III", "V", Predefined.integerType, DefaultRoutineCode.SETTOLIST);
		
		addFunction("addColor", "III", "I", Predefined.integerType, DefaultRoutineCode.ADDCOLOR);
		addFunction("createPaintGUI", "II", "V", Predefined.undefinedType, DefaultRoutineCode.CREATEPAINTGUI);
		addFunction("isLeftClick", "", "I", Predefined.integerType, DefaultRoutineCode.ISLEFTCLICK);
		addFunction("isRightClick", "", "I", Predefined.integerType, DefaultRoutineCode.ISRIGHTCLICK);
		addFunction("isDrag", "", "I", Predefined.integerType, DefaultRoutineCode.ISDRAG);
		addFunction("getMouseX", "", "I", Predefined.integerType, DefaultRoutineCode.GETMOUSEX);
		addFunction("getMouseY", "", "I", Predefined.integerType, DefaultRoutineCode.GETMOUSEY);
		addFunction("createLine", "III", "V", Predefined.undefinedType, DefaultRoutineCode.CREATELINE);
		addFunction("addPoint", "II", "V", Predefined.undefinedType, DefaultRoutineCode.ADDPOINT);
		addFunction("endLine", "II", "V", Predefined.undefinedType, DefaultRoutineCode.ENDLINE);
		addFunction("paintGUIExited", "", "I", Predefined.integerType, DefaultRoutineCode.PAINTGUIEXITED);
		addFunction("getColorSize", "", "I", Predefined.integerType, DefaultRoutineCode.GETCOLORSIZE);
		addFunction("refresh", "", "V", Predefined.undefinedType, DefaultRoutineCode.REFRESH);
		
		addFunction("sqrti", "I", "F", Predefined.realType, DefaultRoutineCode.SQRTI);
		addFunction("sqrtr", "F", "F", Predefined.realType, DefaultRoutineCode.SQRTR);
		addFunction("toReal", "I", "F", Predefined.realType, DefaultRoutineCode.TOREAL);
		addFunction("toInt", "F", "I", Predefined.integerType, DefaultRoutineCode.TOINT);
		addFunction("random", "", "F", Predefined.realType, DefaultRoutineCode.RANDOM);
	}

	private void addFunction(String name, String params, String returnType, TypeSpec typeSpec,
			RoutineCode routineCode) {
		functEntry = symTabStack.enterLocal(name);
		functEntry.setDefinition(DefinitionImpl.FUNCTION);
		functEntry.setAttribute(SymTabKeyImpl.ROUTINE_PARMS, params);
		functEntry.setAttribute(SymTabKeyImpl.DATA_VALUE, returnType);
		functEntry.setTypeSpec(typeSpec);
		functEntry.setAttribute(SymTabKeyImpl.ROUTINE_CODE, routineCode);
	}

	private String retrieveFileName(String input) {
		return input.substring(0, input.indexOf("."));
	}

	public String getProgramName() {
		return programName;
	}

	public SymTabStack getSymTabStack() {
		return symTabStack;
	}

	public Integer visitProg(JFlatParser.ProgContext ctx) {
		programId = symTabStack.enterLocal(programName);
		programId.setDefinition(DefinitionImpl.PROGRAM);
		programId.setAttribute(ROUTINE_SYMTAB, symTabStack.push());
		symTabStack.setProgramId(programId);

		initializePredefinedFunctions();

		Integer value = visitChildren(ctx);

		return value;
	}

	public Integer visitFunctDeclare(JFlatParser.FunctDeclareContext ctx) {
		// Add a new symbol table entry with function name
		functEntry = symTabStack.enterLocal(ctx.IDENTIFIER().getText());
		functEntry.setDefinition(DefinitionImpl.FUNCTION);

		// Visit function return type and set it as an attribute to the entry
		visit(ctx.primType());
		TypeSpec type = ctx.primType().type;
		String returnType = (type == Predefined.integerType) ? "I" : (type == Predefined.realType) ? "F" : "V";
		functEntry.setAttribute(SymTabKeyImpl.DATA_VALUE, returnType);
		functEntry.setTypeSpec(type);

		visit(ctx.params());

		// Visit body of the function
		for (JFlatParser.StatContext s : ctx.stat()) {
			visit(s);
		}

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
		}

		// Add paramString to the parent entry as a parameter
		functEntry.setAttribute(SymTabKeyImpl.ROUTINE_PARMS, paramString);

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

}
