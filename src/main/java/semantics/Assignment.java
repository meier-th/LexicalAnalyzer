package semantics;

import state.VariablesState;

public class Assignment extends Operator {

    private String variableName;
    private Operation value;

    public Assignment(String variableName, Operation value) {
        this.variableName = variableName;
        this.value = value;
    }

    @Override
    public void execute() {
        Variable var = VariablesState.getVariable(variableName);
        if (var != null)
            var.setValue(value.getResultValue());
    }

}
