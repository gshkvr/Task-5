package exception;

public class XMLFileNotFoundException extends Exception {
    private static final long serialVersionUID = 548356593840588578L;

    public XMLFileNotFoundException() {
        super();
    }

    public XMLFileNotFoundException(String message) {
        super(message);
    }

    public XMLFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLFileNotFoundException(Throwable cause) {
        super(cause);
    }

    protected XMLFileNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
