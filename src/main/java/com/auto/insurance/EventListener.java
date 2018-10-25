package com.auto.insurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import java.util.Optional;

@Component
public class EventListener {

    @Autowired
    CreditRepository creditRepository;

    @StreamListener(Streams.INPUT)
    public void handle(@Payload CustomerRegisteredEvent customerRegisteredEvent) {

        System.out.println("Credit rating for " + customerRegisteredEvent.getSsn());

        Optional<Credit> optional = (creditRepository.findById(customerRegisteredEvent.getSsn()));

        Credit credit = optional.get();

        if(credit.getCreditRate().compareTo("B") > 0 ){
            System.out.println("신용도가 B 이상이어야 합니다.");


        }else{


            Streams streams = Application.getApplicationContext().getBean(Streams.class);

            MessageChannel messageChannel = streams.outboundChannel();

            CreditOkEvent creditOkEvent = new CreditOkEvent();

            creditOkEvent.setSsn(customerRegisteredEvent.getSsn());

            messageChannel.send(MessageBuilder
                    .withPayload(creditOkEvent)
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                    .build());

            System.out.println("Event published");

        }

    }
}