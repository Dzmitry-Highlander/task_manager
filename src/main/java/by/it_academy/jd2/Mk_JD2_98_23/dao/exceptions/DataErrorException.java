package by.it_academy.jd2.Mk_JD2_98_23.dao.exceptions;

public class DataErrorException extends RuntimeException {
    public DataErrorException() {
        super();
    }

    public DataErrorException(String message) {
        super(message);
    }

    public DataErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataErrorException(Throwable cause) {
        super(cause);
    }

    protected DataErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
