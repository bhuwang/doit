/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhuwan.doit.presentation;

import com.bhuwan.doit.business.reminders.boundary.ToDoManager;
import com.bhuwan.doit.business.reminders.entity.ToDo;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author bhuwan
 */
@Model
public class Index {

    @Inject
    ToDoManager boundary;

    @Inject
    Validator validator;

    ToDo todo;

    @PostConstruct
    public void init() {
        todo = new ToDo();
    }

    public ToDo getTodo() {
        return todo;
    }
    
    public List<ToDo> getToDos(){
        return this.boundary.findAll();
    }

    public Object save() {
        Set<ConstraintViolation<ToDo>> voilations = this.validator.validate(this.todo);
        for (ConstraintViolation<ToDo> voilation : voilations) {
            this.showValidationErrorMessage(voilation.getMessage());
        }
        if (voilations.isEmpty()) {
            this.boundary.save(todo);
        }
        return null;
    }

    public void showValidationErrorMessage(String msg) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg);
        FacesContext.getCurrentInstance().addMessage("", message);
    }
}
