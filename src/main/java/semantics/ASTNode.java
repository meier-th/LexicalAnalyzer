package semantics;

import java.util.Arrays;
import java.util.List;

public class ASTNode {
    public enum SemanticTypes {
        PROGRAM,
        COMPUTATIONS,
        VARIABLES_DECLARATION
    }

    private SemanticTypes type;
    private List<ASTNode> children;

    public ASTNode(SemanticTypes type) {
        this.type = type;
    }

    public ASTNode(ASTNode variables, ASTNode computations) {
        this.type = SemanticTypes.PROGRAM;
        this.children = Arrays.asList(variables, computations);
    }


}
