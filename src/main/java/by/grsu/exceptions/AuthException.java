package by.grsu.exceptions;

public class AuthException extends RuntimeException{
    public AuthException(){
        super("Invalid credentials");
    }
}