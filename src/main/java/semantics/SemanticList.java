package semantics;

public class SemanticList {

    public enum SemanticTypes {
        COMPUTATIONS,
        VARIABLES_DECLARATION
    }

    private SemanticTypes type;
    private String keyWord;
    private Listable firstChild;

    public SemanticList(SemanticTypes type, Listable firstChild) {
        this.type = type;
        if (type == SemanticTypes.VARIABLES_DECLARATION)
            keyWord = "VAR";
        this.firstChild = firstChild;
    }

}
