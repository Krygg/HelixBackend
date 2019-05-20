package Interpreter.AST;

public class TypeCheckingError extends RuntimeException {

    public TypeCheckingError(String message) {
        super(message);
    }
}
