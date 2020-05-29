package semantics;

import value.IntegerValue;
import value.Value;

public class Variable {
    private String name;
    private Value value;

    public Variable(String name) {
        this.name = name;
        this.value = null;
    }

    public Variable(int value) {
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
}
