package gojoego.exception;

public class UserNameAlreadyExists extends BusinessLogicException {
    public UserNameAlreadyExists(String errorMessage) {
        super(errorMessage);
    }
}
