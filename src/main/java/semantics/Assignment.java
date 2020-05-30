package semantics;

import state.VariablesState;

public class Assignment implements Operator {

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

    @Override
    public void print(String prefix) {
        System.out.println(prefix+"Assignment");
        if (VariablesState.getVariable(variableName) != null)
            VariablesState.getVariable(variableName).print(prefix+'\t');
        else
            System.out.println(prefix+ "\tUndeclared variable " +variableName);
        System.out.println(prefix + "\tAssignment operator =");
        value.print(prefix+'\t');
    }
}
