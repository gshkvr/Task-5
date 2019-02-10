package exception;

public class SAXVoucherBuilderConstructorException extends Exception {

    private static final long serialVersionUID = -7453234138373117619L;

    public SAXVoucherBuilderConstructorException() {
        super();
    }

    public SAXVoucherBuilderConstructorException(String message) {
        super(message);
    }

    public SAXVoucherBuilderConstructorException(String message, Throwable cause) {
        super(message, cause);
    }

    public SAXVoucherBuilderConstructorException(Throwable cause) {
        super(cause);
    }

    protected SAXVoucherBuilderConstructorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
