/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhuwan.doit.business.reminders.entity;

import com.bhuwan.doit.business.validation.boundary.CrossCheck;
import com.bhuwan.doit.business.ValidEntity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bhuwan
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = ToDo.FINDALL, query = "SELECT t from ToDo t")
@CrossCheck
public class ToDo implements ValidEntity {

    private static final String PREFIX = "com.bhuwan.doit.business.reminders.boundary.";
    public static final String FINDALL = PREFIX + "findAll";

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(min = 1, max = 256)
    private String caption;
    private String description;
    private int priority;
    private boolean done;
    @Version
    private int version;

    public ToDo(String caption, String description, int priority) {
        this.caption = caption;
        this.description = description;
        this.priority = priority;
    }

    public ToDo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean isValid() {
        if (this.priority <= 10) {
            return true;
        }
        return this.description != null;
    }

}
