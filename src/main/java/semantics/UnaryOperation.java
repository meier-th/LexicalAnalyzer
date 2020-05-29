package semantics;

import value.Value;

public class UnaryOperation implements Operation {

    private UnaryOperations operation;
    private Value operand;

    @Override
    public Value getResultValue() {
        return operand.applyUnaryOperator(operation);
    }

    public UnaryOperation(UnaryOperations operation, Operation operand) {
        this.operation = operation;
        this.operand = operand.getResultValue();
    }

    public UnaryOperation(Variable operand) {
        this.operation = UnaryOperations.NOTHING;
        this.operand = operand.getValue();
    }
}
