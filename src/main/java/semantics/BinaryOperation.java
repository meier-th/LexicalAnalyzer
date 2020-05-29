package semantics;

import value.Value;

public class BinaryOperation implements Operation {
    private Operations operation;
    private Value leftOperand;
    private Value rightOperand;

    @Override
    public Value getResultValue() {
        return leftOperand.executeOperation(rightOperand, operation);
    }

    public BinaryOperation(Operation left, Operation right, Operations operation) {
        this.leftOperand = left.getResultValue();
        this.rightOperand = right.getResultValue();
        this.operation = operation;
    }

}
