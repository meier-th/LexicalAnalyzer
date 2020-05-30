package semantics;

import value.Value;

public interface Operation extends Printable {
    enum Operations implements Printable{
        ADDITION {
            @Override
            public void print(String prefix) {
                printOperator(prefix, "+");
            }
        },
        SUBTRACTION {
            @Override
            public void print(String prefix) {
                printOperator(prefix, "-");
            }
        },
        MULTIPLICATION {
            @Override
            public void print(String prefix) {
                printOperator(prefix, "*");
            }
        },
        DIVISION {
            @Override
            public void print(String prefix) {
                printOperator(prefix, "/");
            }
        },
        GREATER {
            @Override
            public void print(String prefix) {
                printOperator(prefix, ">");
            }
        },
        LESSER {
            @Override
            public void print(String prefix) {
                printOperator(prefix, "<");
            }
        },
        EQUALS {
            @Override
            public void print(String prefix) {
                printOperator(prefix, "==");
            }
        };
        void printOperator(String prefix, String operator) {
            System.out.printf("%sBinary operator %s\n", prefix, operator);
        }
    }
    enum UnaryOperations implements Printable {
        NOT {
            @Override
            public void print(String prefix) {
                System.out.println(prefix + "Unary operator NOT");
            }
        },
        MINUS {
            @Override
            public void print(String prefix) {
                System.out.println(prefix + "Unary operator -");
            }
        },
        NOTHING {
            @Override
            public void print(String prefix) {}
        }
    }

    Value getResultValue();

}
