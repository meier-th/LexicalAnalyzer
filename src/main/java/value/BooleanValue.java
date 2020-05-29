package value;

import semantics.Operation;

public class BooleanValue implements Value {

    private boolean value;

    @Override
    public Value executeOperation(Value secondArg, Operation.Operations operation) {
        if (secondArg == null)
            secondArg = new BooleanValue(false);
        if (secondArg instanceof BooleanValue) {
            boolean foreignValue = ((BooleanValue)secondArg).getValue();
            switch (operation) {
                case ADDITION:
                    return or((BooleanValue) secondArg);
                case MULTIPLICATION:
                    return and((BooleanValue) secondArg);
                case GREATER:
                    return new BooleanValue(Boolean.compare(value, foreignValue) > 0);
                case LESSER:
                    return new BooleanValue(Boolean.compare(value, foreignValue) < 0);
                case EQUALS:
                    return new BooleanValue(value == foreignValue);
            }
            // no more operations (division, multiplication) available
            return new BooleanValue(false);
        }
        else {
            int representation = this.value ? 1 : 0;
            int foreignValue = ((IntegerValue)secondArg).getValue();
            switch (operation) {
                case EQUALS:
                    return new BooleanValue(representation == foreignValue);
                case LESSER:
                    return new BooleanValue(representation < foreignValue);
                case GREATER:
                    return new BooleanValue(representation > foreignValue);
                case SUBTRACTION:
                    return new IntegerValue(representation - foreignValue);
                case DIVISION:
                    return new IntegerValue(representation / foreignValue);
                case ADDITION:
                    return new IntegerValue(representation + foreignValue);
                default:
                    return new IntegerValue(representation * foreignValue);
            }
        }
    }

    @Override
    public Value applyUnaryOperator(Operation.UnaryOperations operator) {
        if (operator == Operation.UnaryOperations.NOTHING)
            return new BooleanValue(value);
        // it's either NOT or '-'
        return new BooleanValue(!value);
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    @Override
    public int compareTo(Value value) {
        if (value instanceof BooleanValue) {
            if (((BooleanValue) value).getValue()) {
                if (this.value)
                    return 0;
                else
                    return -1;
            }
            else {
                if (this.value)
                    return 1;
                else
                    return 0;
            }
        }
        else {
            int representation = this.value ? 1 : 0;
            int foreignValue = ((IntegerValue) value).getValue();
            return Integer.compare(representation, foreignValue);
        }
    }

    public BooleanValue(boolean val) {
        this.value = val;
    }

    private BooleanValue or(BooleanValue second) {
        return new BooleanValue(value | second.getValue());
    }

    private BooleanValue and(BooleanValue second) {
        return new BooleanValue(value & second.getValue());
    }


}
