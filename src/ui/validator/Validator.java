/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.validator;

import exception.ValidationException;

/**
 *
 * @author Milica i Nikola
 */
public interface Validator {
     void validate(Object object) throws ValidationException;
}
