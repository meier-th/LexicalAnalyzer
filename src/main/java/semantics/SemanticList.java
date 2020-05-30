package semantics;

public class SemanticList implements Printable {

    public enum SemanticTypes {
        COMPUTATIONS {
            @Override
            public String toString() {
                return "Computations";
            }
        },
        VARIABLES_DECLARATION {
            @Override
            public String toString() {
                return "Variables declaration";
            }
        }
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

    @Override
    public void print(String prefix) {
        System.out.println(prefix + type.toString());
        if (keyWord != null)
            System.out.println(prefix+"\tKeyword "+keyWord);
        Listable iterator = firstChild;
        while (iterator != null) {
            iterator.print(prefix+"\t");
            iterator = iterator.getNext();
        }
    }
}
