package br.com.hdi.insurance.offer.service;

import br.com.hdi.insurance.models.BrokerData;
import br.com.hdi.insurance.models.BrokerUpdateDTO;

public interface OfferService {

    BrokerData verifyBroker(String document);
    BrokerUpdateDTO updateBrokerStatus(String code, BrokerUpdateDTO brokerUpdateDTO);

}
