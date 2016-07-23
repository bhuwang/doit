/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhuwan.doit.business.validation.boundary;

import com.bhuwan.doit.business.ValidEntity;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author bhuwan
 */
public class CrossCheckConstraintValidator implements ConstraintValidator<CrossCheck, ValidEntity> {
    
    @Override
    public void initialize(CrossCheck constraintAnnotation) {
    }
    
    @Override
    public boolean isValid(ValidEntity entity, ConstraintValidatorContext context) {
        return entity.isValid();
    }
}
