package com.awstraining.backend.business.notifyme.adapter;

import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;
import com.awstraining.backend.business.notifyme.NotifyMeDO;
import com.awstraining.backend.business.notifyme.Translator;
import com.awstraining.backend.config.TranslatorConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TranslatorImpl implements Translator {

    private static final Logger LOGGER = LogManager.getLogger(TranslatorImpl.class);
    

    private AmazonTranslate translatorConfig;
    // TODO: lab2
    //  1. Inject AWS AmazonTranslate from configuration TranslatorConfig.
   @Autowired
    public TranslatorImpl(AmazonTranslate translatorConfig) {
        this.translatorConfig = translatorConfig;
    }
    
    @Override
    public String translate(NotifyMeDO notifyMeDO) {

       final TranslateTextRequest translateTextRequest = new TranslateTextRequest().withText(notifyMeDO.text()).withSourceLanguageCode(notifyMeDO.sourceLc()).withTargetLanguageCode(notifyMeDO.targetLc());

        TranslateTextResult translateTextResult = translatorConfig.translateText(translateTextRequest);

        LOGGER.info("Text '{}' was successfully translated from '{}' to '{}",notifyMeDO.text(), notifyMeDO.sourceLc(), notifyMeDO.targetLc() );
        // TODO: lab2
        //  1. Create translate text request.
        //  2. Call translate.
        //  3. Log information about successful translated message.
        //  4. Return translated message
        return translateTextRequest.getText() ;
    }
}
