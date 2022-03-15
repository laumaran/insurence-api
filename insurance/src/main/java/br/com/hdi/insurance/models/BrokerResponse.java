package br.com.hdi.insurance.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class BrokerResponse {

    private String name;
    private String document;
    private String code;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate;

}
