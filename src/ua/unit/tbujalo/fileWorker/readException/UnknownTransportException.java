package ua.unit.tbujalo.fileWorker.readException;

public class UnknownTransportException extends Exception{
    @Override
    public String getMessage() {
        return "Unknown vehicle";
    }
}
