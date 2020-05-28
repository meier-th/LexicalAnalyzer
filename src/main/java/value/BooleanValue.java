package value;

import semantics.Operator;

public class BooleanValue implements Value {

    private boolean value;

    @Override
    public Value executeOperation(Value secondArg, Operator.Operations operation) {
        if (secondArg instanceof BooleanValue) {
            switch (operation) {
                case ADDITION:
                    return or((BooleanValue) secondArg);
                case MULTIPLICATION:
                    return and((BooleanValue) secondArg);
                 // no more operations available
            }
        }
        // can't perform operations with strings or ints
        return null;
    }

    @Override
    public Value applyUnaryOperator(Operator.UnaryOperations operator) {
        // it's either not or -
        return new BooleanValue(!value);
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    @Override
    public int compareTo(Value value) {
        return 0;
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
