package semantics;

import value.Value;

public interface Operation {
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
        MINUS,
        NOTHING
    }

    Value getResultValue();

}
