package exception;

public class NoSuchParserTypeException extends Exception {
    private static final long serialVersionUID = -3098758624392149410L;

    public NoSuchParserTypeException() {
        super();
    }

    public NoSuchParserTypeException(String message) {
        super(message);
    }

    public NoSuchParserTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchParserTypeException(Throwable cause) {
        super(cause);
    }

    protected NoSuchParserTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
