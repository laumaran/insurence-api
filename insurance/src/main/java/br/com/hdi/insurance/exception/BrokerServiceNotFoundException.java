package br.com.hdi.insurance.exception;

import java.io.Serializable;

public class BrokerServiceNotFoundException extends RuntimeException implements Serializable {

    public BrokerServiceNotFoundException(String message) {
        super(message);
    }
}
