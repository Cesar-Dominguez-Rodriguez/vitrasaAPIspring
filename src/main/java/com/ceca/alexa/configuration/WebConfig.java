package com.ceca.alexa.configuration;

import com.ceca.alexa.servlet.AlexaServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpServlet;

import static org.springframework.core.io.support.PropertiesLoaderUtils.loadProperties;


public class WebConfig {

    @Bean
    public ServletRegistrationBean<HttpServlet> alexaServlet() {
        loadProperties();
        ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
        servRegBean.setServlet(new AlexaServlet());
        servRegBean.addUrlMappings("/alexa/*");
        servRegBean.setLoadOnStartup(1);
        return servRegBean;
    }

    private void loadProperties() {
    }
}
