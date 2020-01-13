package ua.unit.tbujalo.fileWorker.readException;

public class SyntaxErrorException extends Exception {

    public SyntaxErrorException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Syntax error: '"+super.getMessage()+"'";
    }
}
