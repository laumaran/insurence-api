package br.com.hdi.insurance.broker.service;

import br.com.hdi.insurance.models.BrokerDataResponse;
import br.com.hdi.insurance.models.BrokerResponse;
import br.com.hdi.insurance.models.BrokerUpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "brokerService", url = "${client.baseUrl}")
public interface BrokerService {

    @GetMapping("/insurance/v1/broker/{document}")
    BrokerResponse getBrokerByDocument(@PathVariable("document") String document);

    @GetMapping("/insurance/v1/brokerData/{code}")
    BrokerDataResponse getBrokerByCode(@PathVariable("code") String code);

    @PutMapping("/insurance/v1/brokerData/{code}")
    BrokerUpdateDTO updateBrokerStatus(@PathVariable("code") String code, @RequestBody BrokerUpdateDTO brokerUpdateDTO);

}
