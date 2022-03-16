package br.com.hdi.insurance.offer.controller;

import br.com.hdi.insurance.models.BrokerUpdateDTO;
import br.com.hdi.insurance.offer.service.OfferService;
import br.com.hdi.insurance.models.BrokerData;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("v1/offer")
public class OfferController {

    private final OfferService offerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/verify-broker/{document}")
    public ResponseEntity<BrokerData> verifyBroker(@PathVariable String document) {
        return ResponseEntity.ok(offerService.verifyBroker(document));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{code}")
    public ResponseEntity<BrokerUpdateDTO> updateBrokerStatus(@PathVariable String code, @RequestBody BrokerUpdateDTO brokerUpdateDTO) {
        return ResponseEntity.ok(offerService.updateBrokerStatus(code, brokerUpdateDTO));
    }

}
