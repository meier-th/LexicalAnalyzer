package semantics;

import value.Value;

public class BinaryOperation implements Operation {
    private Operations operation;
    private Value leftOperandValue;
    private Value rightOperandValue;
    private Operation leftOperand;
    private Operation rightOperand;

    @Override
    public Value getResultValue() {
        return leftOperandValue.executeOperation(rightOperandValue, operation);
    }

    public BinaryOperation(Operation left, Operation right, Operations operation) {
        this.leftOperand = left;
        this.rightOperand = right;
        this.leftOperandValue = left.getResultValue();
        this.rightOperandValue = right.getResultValue();
        this.operation = operation;
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + "Binary operation");
        leftOperand.print(prefix+'\t');
        operation.print(prefix+'\t');
        rightOperand.print(prefix+'\t');
    }
}
