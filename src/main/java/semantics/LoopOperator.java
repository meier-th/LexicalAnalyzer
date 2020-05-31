package semantics;

import state.OperationsHolder;
import value.BooleanValue;
import value.Value;

public class LoopOperator implements Operator {

    private Operation condition;
    private Operator action;

    @Override
    public void execute() {
        if (action instanceof LoopOperator)
            OperationsHolder.executeBeforeEnd();
        else
            OperationsHolder.executeBeforeLoop();
        Value condValue = condition.getResultValue();
        if (condValue instanceof BooleanValue)
            while (((BooleanValue)condValue).getValue()) {
                action.execute();
                condValue = condition.getResultValue();
            }
    }

    public LoopOperator(Operation condition, Operator action) {
        this.condition = condition;
        this.action = action;
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix+"Loop operator");
        System.out.println(prefix+"\tKeyword WHILE");
        condition.print(prefix+'\t');
        System.out.println(prefix+"\tKeyword DO");
        action.print(prefix+'\t');
    }
}
