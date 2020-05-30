package state;

import semantics.Assignment;

import java.util.LinkedList;

public class OperationsHolder {

    private static LinkedList<Assignment> assignments = new LinkedList<>();

    public static void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public static void executeBeforeLoop() {
        assignments.removeLast();
        executeBeforeEnd();
    }

    public static void executeBeforeEnd() {
        for (Assignment assignment : assignments) {
            assignment.execute();
        }
        assignments.clear();
    }

}
