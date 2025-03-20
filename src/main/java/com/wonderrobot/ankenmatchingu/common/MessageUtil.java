package com.wonderrobot.ankenmatchingu.common;
// MessageUtil.vm
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * MessageUtil
 */
@Component
public class MessageUtil {

    @Autowired
    private MessageSource messageSource;
    /**
     * Get the message delegation to the spring MessageSource according to the message key and parameters
     *
     * @param code Message key
     * @param args parameter
     * @return
     */
    public String message(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}