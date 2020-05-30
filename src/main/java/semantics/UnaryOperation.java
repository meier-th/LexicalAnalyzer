package semantics;

import value.Value;

public class UnaryOperation implements Operation {

    private UnaryOperations operation;
    private Operation operand;
    private Variable varOperand;
    private Value operandValue;

    @Override
    public Value getResultValue() {
        return operandValue.applyUnaryOperator(operation);
    }

    public UnaryOperation(UnaryOperations operation, Operation operand) {
        this.operation = operation;
        this.operand = operand;
        this.operandValue = operand.getResultValue();
    }

    public UnaryOperation(Variable operand) {
        this.operation = UnaryOperations.NOTHING;
        varOperand = operand;
        this.operandValue = operand.getValue();
    }

    @Override
    public void print(String prefix) {
        if (operation == UnaryOperations.NOTHING) {
            varOperand.print(prefix);
        }
        else {
            System.out.println(prefix + "Unary operation");
            operation.print(prefix + '\t');
            operand.print(prefix + '\t');
        }
    }
}
