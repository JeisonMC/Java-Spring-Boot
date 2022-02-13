package com.fundamentos.fundamentos.configuration;

import com.fundamentos.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentos.fundamentos.paco.UserPaco;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(UserPaco.class)
@Configuration
public class GeneralConfig {

    @Value("${value.name}")
    private String name;

    @Value("${value.lastName}")
    private String lastName;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(name,lastName);
    }
}
