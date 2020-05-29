package semantics;

import value.BooleanValue;
import value.Value;

public class LoopOperator extends Operator {

    private Operation condition;
    private Operator action;

    @Override
    public void execute() {
        Value condValue = condition.getResultValue();
        if (condValue instanceof BooleanValue)
            while (((BooleanValue)condValue).getValue()) {
                action.execute();
            }
    }

    public LoopOperator(Operation condition, Operator action) {
        this.condition = condition;
        this.action = action;
    }

}
