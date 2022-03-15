package br.com.hdi.insurance.exception;

import java.io.Serializable;

public class BrokerInactiveException extends RuntimeException implements Serializable {

    public BrokerInactiveException(String message) {
        super(message);
    }
}
