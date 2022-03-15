package br.com.hdi.insurance.models;

import lombok.Data;

@Data
public class BrokerDataResponse {

    private String code;
    private double commissionRate;
    private String active;

}
