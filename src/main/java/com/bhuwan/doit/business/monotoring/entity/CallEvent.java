/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhuwan.doit.business.monotoring.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bhuwan
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CallEvent {

    public CallEvent() {
    }

    private String methodName;
    private long duration;

    public CallEvent(String methodName, long duration) {
        this.methodName = methodName;
        this.duration = duration;
    }

    public String getMethodName() {
        return methodName;
    }

    public long getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "CallEvent{" + "methodName=" + methodName + ", duration=" + duration + '}';
    }
    
}
