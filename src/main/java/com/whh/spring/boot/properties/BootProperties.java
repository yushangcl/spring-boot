package com.whh.spring.boot.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author huahui.wu.
 *         Created on 2018/1/9.
 */
@Component
public class BootProperties {
    @Value("{com.whh.boot.value}")
    private String value;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
