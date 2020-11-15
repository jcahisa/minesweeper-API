package gojoego.exception;

public class GameNotFoundException extends BusinessLogicException {
    public GameNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
