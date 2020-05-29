package state;

import semantics.Variable;

import java.util.HashMap;
import java.util.Map;

public class VariablesState {

    private static Map<String, Variable> variables = new HashMap<>();

    public static boolean addVariable(Variable var) {
        return variables.putIfAbsent(var.getName(), var) != null;
    }

    public static Variable getVariable(String name) {
        return variables.get(name);
    }

}
