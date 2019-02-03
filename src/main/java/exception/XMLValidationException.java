package exception;

public class XMLValidationException extends Exception {
    private static final long serialVersionUID = 1682726548787813303L;

    public XMLValidationException() {
        super();
    }

    public XMLValidationException(String message) {
        super(message);
    }

    public XMLValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLValidationException(Throwable cause) {
        super(cause);
    }

    protected XMLValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
