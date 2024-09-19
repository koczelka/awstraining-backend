package com.awstraining.backend.business.notifyme;

import com.awstraining.backend.business.notifyme.adapter.MessageSnsAWSSender;
import org.springframework.stereotype.Service;

@Service
public class NotifyMeService {

    // DONE: lab1
    //  1. Inject MessageSender.
    private MessageSender sender;
    // DONE lab2
    //  1. Inject Translator
    private Translator translator;
    // TODO lab3
    //  1. Inject sentiment detector
    private  Sentiment sentiment;
//    @Autowired
    public NotifyMeService(MessageSender sender, Translator translator) {
        this.sender = sender;
        this.translator = translator;
    }
    
    public String notifyMe(NotifyMeDO notifyMe) {
      String textToBeSend =  notifyMe.text();
        String translateTextToSend = translator.translate(notifyMe);
        // TODO: lab1
        //  1. Send text using sender.
        //  2. Return sent message.

        // TODO: lab2
        //  1. Translate text from using translator.
        //  2. Change sending of text to "translated text" and return it.
        // TODO: lab3
        //  1. Detect sentiment of translated message.
        //  2. Change sending of text to "setiment: translated text" and return it.
       String sentimentString = sentiment.detectSentiment(notifyMe.targetLc(), translateTextToSend);
        sender.send("Sentiment " + sentimentString + " text : " + translateTextToSend);

        return "This service is not available.";
    }
    
}
