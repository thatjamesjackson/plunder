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
public class MapControlExeption extends Exception{

    public MapControlExeption() {
    }

    public MapControlExeption(String message) {
        super(message);
    }

    public MapControlExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public MapControlExeption(Throwable cause) {
        super(cause);
    }

    public MapControlExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    
}
