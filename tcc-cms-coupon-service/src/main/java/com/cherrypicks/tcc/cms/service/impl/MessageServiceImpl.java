package com.cherrypicks.tcc.cms.service.impl;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Service;

import com.cherrypicks.tcc.cms.enums.Lang;
import com.cherrypicks.tcc.cms.service.MessageService;



@Service
public class MessageServiceImpl implements MessageService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageSource messageSource;

    @Override
    public String getMessage(final int errorCode, final Object[] args, String lang) {
        if (StringUtils.isBlank(lang)) {
            lang = Lang.getDefaultLang().toValue();
        }
        return getMessage(errorCode, args, Lang.toLang(lang).toLocale());
    }

    @Override
    public String getMessage(final String key, final Object[] args, String lang) {
        if (StringUtils.isBlank(lang)) {
            lang = Lang.getDefaultLang().toValue();
        }
        return getMessage(key, args, Lang.toLang(lang).toLocale());
    }

    @Override
    public String getMessage(final int errorCode, final Object[] args, final Locale locale) {
        String errorMessage = "";
        try {
            errorMessage = messageSource.getMessage(String.valueOf(errorCode), args, locale);
        } catch (final NoSuchMessageException ex) {
            logger.warn(ex.getMessage());
        }
        return errorMessage;
    }

    @Override
    public String getMessage(final String key, final Object[] args, final Locale locale) {
        String errorMessage = "";
        try {
            errorMessage = messageSource.getMessage(key, args, locale);
        } catch (final NoSuchMessageException ex) {
            logger.warn(ex.getMessage());
        }
        return errorMessage;
    }
}
