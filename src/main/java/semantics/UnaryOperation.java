package semantics;

import value.IntegerValue;
import value.Value;

public class UnaryOperation implements Operation {

    private UnaryOperations operation;
    private Operation operand;
    private Variable varOperand;

    @Override
    public Value getResultValue() {
        Value operandValue;
        if (operation == UnaryOperations.NOTHING)
            if (varOperand != null)
                operandValue = varOperand.getValue();
            else
                operandValue = new IntegerValue(0);
        else
            operandValue = operand.getResultValue();
        return operandValue.applyUnaryOperator(operation);
    }

    public UnaryOperation(UnaryOperations operation, Operation operand) {
        this.operation = operation;
        this.operand = operand;
    }

    public UnaryOperation(Variable operand) {
        this.operation = UnaryOperations.NOTHING;
        this.varOperand = operand;
    }

    @Override
    public void print(String prefix) {
        if (operation == UnaryOperations.NOTHING) {
            if (varOperand != null)
                varOperand.print(prefix);
            else
                System.out.println(prefix+"Undeclared variable");
        }
        else {
            System.out.println(prefix + "Unary operation");
            operation.print(prefix + '\t');
            operand.print(prefix + '\t');
        }
    }
}
