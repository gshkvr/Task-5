package exception;

public class VoucherDOMBuilderConstructorException extends Exception {

    private static final long serialVersionUID = 7385056749366172769L;

    public VoucherDOMBuilderConstructorException() {
        super();
    }

    public VoucherDOMBuilderConstructorException(String message) {
        super(message);
    }

    public VoucherDOMBuilderConstructorException(String message, Throwable cause) {
        super(message, cause);
    }

    public VoucherDOMBuilderConstructorException(Throwable cause) {
        super(cause);
    }

    protected VoucherDOMBuilderConstructorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
