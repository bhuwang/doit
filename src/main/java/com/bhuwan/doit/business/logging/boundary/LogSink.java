/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhuwan.doit.business.logging.boundary;

/**
 *
 * @author bhuwan
 */
@FunctionalInterface
public interface LogSink {
    void log(String message);
}
