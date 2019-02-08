package exception;

public class VoucherSAXBuilderConstructorException extends Exception {

    private static final long serialVersionUID = -7453234138373117619L;

    public VoucherSAXBuilderConstructorException() {
        super();
    }

    public VoucherSAXBuilderConstructorException(String message) {
        super(message);
    }

    public VoucherSAXBuilderConstructorException(String message, Throwable cause) {
        super(message, cause);
    }

    public VoucherSAXBuilderConstructorException(Throwable cause) {
        super(cause);
    }

    protected VoucherSAXBuilderConstructorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
