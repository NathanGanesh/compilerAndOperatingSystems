package nl.saxion.cos.exception;

/**
 * Thrown when the checker finds an error.
 */
public class CompilerException extends RuntimeException {
    public CompilerException( String msg ) {
        super(msg);
    }
}
