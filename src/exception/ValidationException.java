/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Milica i Nikola
 */
public class ValidationException extends  Exception{
      public ValidationException() {
        super();
    }

    public ValidationException(String message) {
        super(message);
    }
}
