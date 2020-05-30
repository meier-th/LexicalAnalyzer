package semantics;

public class Program implements Printable {

    private SemanticList variablesDeclaration;
    private SemanticList computations;

    public Program(SemanticList variables, SemanticList computations) {
        this.variablesDeclaration = variables;
        this.computations = computations;
    }

    @Override
    public void print(String prefix) {
        System.out.println("Program");
        variablesDeclaration.print("\t");
        computations.print("\t");
    }
}
