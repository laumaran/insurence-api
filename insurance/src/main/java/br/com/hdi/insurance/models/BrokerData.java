package br.com.hdi.insurance.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BrokerData {

    private String name;
    private String document;
    private String code;
    private LocalDate createDate;
    private double commissionRate;
    private String isActive;

}
