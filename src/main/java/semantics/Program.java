package semantics;

public class Program {

    private SemanticList variablesDeclaration;
    private SemanticList computations;

    public Program(SemanticList variables, SemanticList computations) {
        this.variablesDeclaration = variables;
        this.computations = computations;
    }


}
