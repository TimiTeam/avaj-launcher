package ua.unit.tbujalo.fileWorker.readException;

public class UnknownTransportException extends Exception{

    public UnknownTransportException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Unknown vehicle: '"+super.getMessage()+"'";
    }
}
