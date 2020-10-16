package com.example.coafsoapclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

    private String passwordPfx;

    public static class Coaf{

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }


    public String getPasswordPfx() {
        return passwordPfx;
    }

    public void setPasswordPfx(String passwordPfx) {
        this.passwordPfx = passwordPfx;
    }
}