package exception;

public class VoucherSetBuildingException extends Exception {

    private static final long serialVersionUID = -2895643392822882277L;

    public VoucherSetBuildingException() {
        super();
    }

    public VoucherSetBuildingException(String message) {
        super(message);
    }

    public VoucherSetBuildingException(String message, Throwable cause) {
        super(message, cause);
    }

    public VoucherSetBuildingException(Throwable cause) {
        super(cause);
    }

    protected VoucherSetBuildingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
