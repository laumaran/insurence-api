package br.com.hdi.insurance.offer.service.impl;

import br.com.hdi.insurance.broker.service.BrokerService;
import br.com.hdi.insurance.exception.BrokerInactiveException;
import br.com.hdi.insurance.exception.BrokerServiceNotFoundException;
import br.com.hdi.insurance.models.BrokerData;
import br.com.hdi.insurance.models.BrokerDataResponse;
import br.com.hdi.insurance.models.BrokerResponse;
import br.com.hdi.insurance.offer.service.OfferService;
import br.com.hdi.insurance.utils.ActiveUtils;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private Logger logger = LoggerFactory.getLogger(OfferServiceImpl.class);

    @Autowired
    private final BrokerService brokerService;

    public OfferServiceImpl(BrokerService brokerService) {
        this.brokerService = brokerService;
    }

    @Override
    public BrokerData verifyBroker(String document) {
        logger.info("Starting active broker search");
        try {
            BrokerResponse brokerResponse = brokerService.getBrokerByDocument(document);
            BrokerDataResponse brokerDataResponse = brokerService.getBrokerByCode(brokerResponse.getCode());
            if (ActiveUtils.checkActive(brokerDataResponse.getActive())) {
                return BrokerData.builder()
                        .name(brokerResponse.getName())
                        .document(brokerResponse.getDocument())
                        .code(brokerResponse.getCode())
                        .createDate(brokerResponse.getCreateDate())
                        .commissionRate(brokerDataResponse.getCommissionRate())
                        .isActive(brokerDataResponse.getActive())
                        .build();
            } else {
                logger.error("Broker is inactive");
                throw new BrokerInactiveException("Broker is inactive");
            }

        } catch (FeignException ex) {
            logger.error(ex.getMessage());
            throw new BrokerServiceNotFoundException(ex.getMessage());
        }
    }

}
