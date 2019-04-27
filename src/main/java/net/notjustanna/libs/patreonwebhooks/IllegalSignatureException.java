package net.notjustanna.libs.patreonwebhooks;

/**
 * Exception thrown if the signature provided is invalid.
 */
public class IllegalSignatureException extends Exception {

    public IllegalSignatureException(String message) {
        super(message);
    }

    public IllegalSignatureException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalSignatureException(Throwable cause) {
        super(cause);
    }
}