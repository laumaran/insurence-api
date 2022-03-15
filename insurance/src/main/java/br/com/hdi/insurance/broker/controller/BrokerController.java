package br.com.hdi.insurance.broker.controller;

import br.com.hdi.insurance.broker.service.BrokerService;
import br.com.hdi.insurance.models.BrokerDataResponse;
import br.com.hdi.insurance.models.BrokerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("v1/brokers")
public class BrokerController {

    private final BrokerService brokerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<BrokerResponse> getBrokers() {
        return brokerService.getBrokers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{document}")
    public BrokerResponse getBrokerByDocument(@PathVariable String document) {
        return brokerService.getBrokerByDocument(document);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/data/{code}", produces = "application/json")
    public BrokerDataResponse getBrokerData(@PathVariable String code) {
        return brokerService.getBrokerByCode(code);
    }

}
