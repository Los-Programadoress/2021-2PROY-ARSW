package edu.eci.arsw.lacman.persistence;


public class LacmanNotFoundException extends Exception {
    public LacmanNotFoundException(String message) {
        super(message);
    }

    public LacmanNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}