package br.com.hdi.insurance.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class AppException extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler( { BrokerInactiveException.class } )
    public ResponseEntity<Object> handleBrokerInactiveException(BrokerInactiveException ex, WebRequest webRequest) {
        String messageUser = messageSource.getMessage("broker.inactive",null, LocaleContextHolder.getLocale());
        String messageDev = ExceptionUtils.getRootCauseMessage(ex);
        List<Erro> erros = List.of(new Erro(messageUser, messageDev));
        return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
    }

    @ExceptionHandler( { BrokerServiceNotFoundException.class } )
    public ResponseEntity<Object> handleBrokerNotFException(BrokerServiceNotFoundException ex, WebRequest webRequest) {
        String messageUser = messageSource.getMessage("broker.not.found",null, LocaleContextHolder.getLocale());
        String messageDev = ExceptionUtils.getRootCauseMessage(ex);
        List<Erro> erros = List.of(new Erro(messageUser, messageDev));
        return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
    }

    public static class Erro {

        private String messageToUser;
        private String messageToDev;

        public Erro(String messageToUser, String messageToDev) {
            this.messageToUser = messageToUser;
            this.messageToDev = messageToDev;
        }

        public String getMessageToUser() {
            return messageToUser;
        }

        public String getMessageToDev() {
            return messageToDev;
        }
    }

}
