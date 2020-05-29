package value;

import semantics.Operation;

public interface Value extends Comparable<Value> {
    Value executeOperation(Value secondArg, Operation.Operations operation);
    Object getValue();
    Value applyUnaryOperator(Operation.UnaryOperations operator);
}
