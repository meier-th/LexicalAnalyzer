package semantics;

import value.BooleanValue;
import value.Value;

public class BinaryOperator implements Operator {
    private Operations operation;
    private Value leftOperand;
    private Value rightOperand;

    @Override
    public Value getResultValue() {
        switch (operation) {
            case EQUALS:
                return new BooleanValue(leftOperand.compareTo(rightOperand) == 0);
            case LESSER:
                return new BooleanValue(leftOperand.compareTo(rightOperand) < 0);
            case GREATER:
                return new BooleanValue(leftOperand.compareTo(rightOperand) > 0);
        }
        return leftOperand.executeOperation(rightOperand, operation);
    }

    public BinaryOperator(Operator left, Operator right, Operations operation) {
        this.leftOperand = left.getResultValue();
        this.rightOperand = right.getResultValue();
        this.operation = operation;
    }

}
