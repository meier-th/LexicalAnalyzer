package state;

import semantics.Variable;
import value.BooleanValue;
import value.IntegerValue;

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

    public static void printVariables() {
        OperationsHolder.executeBeforeEnd();
        System.out.println("Final variables' values:");
        variables.forEach((name, var) -> {
            if (var.getValue() == null)
                System.out.println(var.getName() + " = null");
            if (var.getValue() instanceof IntegerValue)
                System.out.printf("%s = %d\n", var.getName(), ((IntegerValue)var.getValue()).getValue());
            else
                System.out.printf("%s = %s\n", var.getName(), ((BooleanValue)var.getValue()).getValue() ? "true": "false");
        });
    }

}
