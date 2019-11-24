package com.qtatelier.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author JazzXia
 * @create 2019-10-16:00
 */
@ConfigurationProperties(prefix = "qtatelier.hello")
public class HelloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
