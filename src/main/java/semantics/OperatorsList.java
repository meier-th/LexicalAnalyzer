package semantics;

public class OperatorsList implements Listable {

    private OperatorsList nextOperator;
    private Operator operator;

    @Override
    public Listable getNext() {
        return nextOperator;
    }

    public OperatorsList(Operator operator) {
        this.operator = operator;
    }

    public OperatorsList(Operator operator, OperatorsList next) {
        this.operator = operator;
        this.nextOperator = next;
    }

    @Override
    public void print(String prefix) {
            operator.print(prefix);
    }
}
