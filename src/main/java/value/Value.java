package value;

import semantics.Operator;

public interface Value extends Comparable<Value> {
    Value executeOperation(Value secondArg, Operator.Operations operation);
    Object getValue();
    Value applyUnaryOperator(Operator.UnaryOperations operator);
}
