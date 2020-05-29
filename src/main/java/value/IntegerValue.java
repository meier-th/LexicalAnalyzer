package value;

import semantics.Operation;

public class IntegerValue implements Value {

    private int value;

    @Override
    public Value executeOperation(Value secondArg, Operation.Operations operation) {
        int foreignValue;
        if (secondArg instanceof IntegerValue)
            foreignValue = ((IntegerValue) secondArg).getValue();
        else
            foreignValue = ((BooleanValue)secondArg).getValue() ? 1 : 0;

        switch (operation) {
            case MULTIPLICATION:
                return new IntegerValue(value*foreignValue);
            case ADDITION:
                return new IntegerValue(value+foreignValue);
            case DIVISION:
                return new IntegerValue(value/foreignValue);
            case SUBTRACTION:
                return new IntegerValue(value-foreignValue);
            case GREATER:
                return new BooleanValue(value > foreignValue);
            case LESSER:
                return new BooleanValue(value < foreignValue);
            default:
                return new BooleanValue(value == foreignValue);
        }
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Value applyUnaryOperator(Operation.UnaryOperations operator) {
        if (operator == Operation.UnaryOperations.NOTHING)
            return new IntegerValue(value);
        if (operator == Operation.UnaryOperations.MINUS)
            return new IntegerValue(value * (-1));
        return new IntegerValue(~value);
    }

    @Override
    public int compareTo(Value value) {
        if (value instanceof IntegerValue)
            return Integer.compare(this.value, ((IntegerValue)value).getValue());
        else {
            int foreignValue = ((BooleanValue)value).getValue() ? 1 : 0;
            return Integer.compare(this.value, foreignValue);
        }
    }

    public IntegerValue(int value) {
        this.value = value;
    }
}
