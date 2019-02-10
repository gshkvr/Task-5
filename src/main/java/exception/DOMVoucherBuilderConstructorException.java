package exception;

public class DOMVoucherBuilderConstructorException extends Exception {

    private static final long serialVersionUID = 7385056749366172769L;

    public DOMVoucherBuilderConstructorException() {
        super();
    }

    public DOMVoucherBuilderConstructorException(String message) {
        super(message);
    }

    public DOMVoucherBuilderConstructorException(String message, Throwable cause) {
        super(message, cause);
    }

    public DOMVoucherBuilderConstructorException(Throwable cause) {
        super(cause);
    }

    protected DOMVoucherBuilderConstructorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
