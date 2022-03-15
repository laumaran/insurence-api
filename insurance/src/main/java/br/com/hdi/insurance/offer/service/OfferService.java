package br.com.hdi.insurance.offer.service;

import br.com.hdi.insurance.models.BrokerData;

public interface OfferService {

    BrokerData verifyBroker(String document);

}
