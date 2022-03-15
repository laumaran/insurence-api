package br.com.hdi.insurance.broker.service;

import br.com.hdi.insurance.models.BrokerDataResponse;
import br.com.hdi.insurance.models.BrokerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "brokerService", url = "${client.baseUrl}")
public interface BrokerService {

    @RequestMapping("/insurance/v1/broker")
    List<BrokerResponse> getBrokers();

    @RequestMapping("/insurance/v1/broker/{document}")
    BrokerResponse getBrokerByDocument(@PathVariable("document") String document);

    @RequestMapping("/insurance/v1/brokerData/{code}")
    BrokerDataResponse getBrokerByCode(@PathVariable("code") String code);
}
