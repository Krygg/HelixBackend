package AST;

import antlr.CFGLexer;
import antlr.CFGParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class TestClass {

    public static void main(String[] args) {
        String string = "bpm(60);" +
                "num x = 9*8+5;" +
                "notes y = c4,c5;" +
                "start p;" +
                "Piano p {" +
                    "x = 9 + 8 * 7 + 6;" +
                    "mel(x);" +
                "}" +
                "Drum d {" +
                "if(1==3){" +
                "}}";
        CharStream charStream = CharStreams.fromString(string);

        CFGLexer lexer = new CFGLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CFGParser parser = new CFGParser(tokenStream);

        ParseTree tree = parser.program();

        BuildASTVisitor buildASTVisitor = new BuildASTVisitor();
        buildASTVisitor.visit(tree);

    }
}
