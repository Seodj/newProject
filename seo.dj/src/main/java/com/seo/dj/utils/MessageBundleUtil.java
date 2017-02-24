package com.seo.dj.utils;

import org.springframework.context.support.MessageSourceAccessor;

public class MessageBundleUtil {
    private MessageSourceAccessor accessor = null;

    public String getMessage(String key) {
        return accessor.getMessage(key);
    }

    public String getMessageWithParam(String key, String[] params) {
        return accessor.getMessage(key, params);
    }

    public void setMessageSourceAccessor(MessageSourceAccessor accessor) {
        this.accessor = accessor;
    }
}
