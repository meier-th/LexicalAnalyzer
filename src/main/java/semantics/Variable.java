package semantics;

import state.VariablesState;
import value.IntegerValue;
import value.Value;

public class Variable implements Listable {
    private String name;
    private Value value;
    private Variable nextVariable;

    public static Variable createVariable(String name) {
        Variable var = new Variable(name);
        boolean added = VariablesState.addVariable(var);
        return added ? var : VariablesState.getVariable(name);
    }

    public static Variable createVariable(String name, Variable next) {
        Variable var = createVariable(name);
        var.nextVariable = next;
        return var;
    }

    public static Variable getVariable(String name) {
        return VariablesState.getVariable(name);
    }

    public static Variable createLiteral(int value) {
        return new Variable(value);
    }

    private Variable(String name) {
        this.name = name;
        this.value = null;
    }

    private Variable(int value) {
        this.value = new IntegerValue(value);
        this.name = "";
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Variable getNextVariable() {
        return nextVariable;
    }

    @Override
    public Listable getNext() {
        return nextVariable;
    }
}
