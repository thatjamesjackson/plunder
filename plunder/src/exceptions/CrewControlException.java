/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author James
 */
public class CrewControlException extends Exception{

    public CrewControlException() {
    }

    public CrewControlException(String message) {
        super(message);
    }

    public CrewControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public CrewControlException(Throwable cause) {
        super(cause);
    }

    public CrewControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
