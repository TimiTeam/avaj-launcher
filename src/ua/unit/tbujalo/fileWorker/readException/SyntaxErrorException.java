package ua.unit.tbujalo.fileWorker.readException;

public class SyntaxErrorException extends Exception {
    @Override
    public String getMessage() {
        return "Wrong syntax";
    }
}
