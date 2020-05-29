package semantics;

import value.Value;

public interface Operator {
    enum Operations {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        GREATER,
        LESSER,
        EQUALS
    }
    enum UnaryOperations {
        NOT,
        MINUS
    }

    Value getResultValue();

}
