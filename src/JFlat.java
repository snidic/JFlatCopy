import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import wci.intermediate.SymTabStack;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;

public class JFlat {
	public static void main(String[] args) throws Exception {
		String inputFile = null;

		// Create the input stream.
		if (args.length > 0) {
			inputFile = args[0];
			System.out.println("Compiling " + inputFile);
		}
		InputStream is = (inputFile != null) ? new FileInputStream(inputFile) : System.in;

		// Create the character stream from the input stream.
		CharStream cs = CharStreams.fromStream(is);

		// Create a lexer which scans the character stream
		// to create a token stream.
		JFlatLexer lexer = new JFlatLexer(cs);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// // Dump the token stream.
		// System.out.println("Tokens:");
		// tokens.fill();
		// for (Token token : tokens.getTokens()) {
		// System.out.println(token.toString());
		// }

		// Create a parser which parses the token stream
		// to create a parse tree.
		JFlatParser parser = new JFlatParser(tokens);
		ParseTree tree = parser.prog();

		// // Print the parse tree in Lisp format.
		// System.out.println("\nParse tree (Lisp format):");
		// System.out.println(tree.toStringTree(parser));

		PassPreFunctionVisitor preFunctVistor = new PassPreFunctionVisitor(inputFile);
		preFunctVistor.visit(tree);

		String programName = preFunctVistor.getProgramName();
		SymTabStack symTab = preFunctVistor.getSymTabStack();

		Pass1Visitor pass1 = new Pass1Visitor(programName, symTab);
		pass1.visit(tree);

		PrintWriter jFile = pass1.getAssemblyFile();
		programName = pass1.getProgramName();
		symTab = pass1.getSymTabStack();

		PassFunctionVisitor passf = new PassFunctionVisitor(jFile, programName, symTab);
		passf.visit(tree);
		
		jFile = passf.getAssemblyFile();
		programName = passf.getProgramName();
		symTab = passf.getSymTabStack();

		Pass2Visitor pass2 = new Pass2Visitor(jFile, programName, symTab);
		pass2.visit(tree);
	}
}
