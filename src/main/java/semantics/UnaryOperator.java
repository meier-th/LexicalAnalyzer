package semantics;

import value.Value;

public class UnaryOperator implements Operator {

    private UnaryOperations operation;
    private Value operand;

    @Override
    public Value getResultValue() {
        return operand.applyUnaryOperator(operation);
    }

    public UnaryOperator(UnaryOperations operation, Operator operand) {
        this.operation = operation;
        this.operand = operand.getResultValue();
    }
}
