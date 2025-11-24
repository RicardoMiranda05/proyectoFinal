package menues;

public class MenuNotClosedException extends MenuRuntimeException {
    public MenuNotClosedException(String msg) {
        super(msg);
    }
}
