package semantics;

public abstract class Operator implements Listable {

    private Operator nextOperator;

    @Override
    public Listable getNext() {
        return nextOperator;
    }

    public void setNext(Operator operator) {
        this.nextOperator = operator;
    }

    public abstract void execute();

}
