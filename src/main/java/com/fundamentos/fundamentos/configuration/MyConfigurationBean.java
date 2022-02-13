package com.fundamentos.fundamentos.configuration;

import com.fundamentos.fundamentos.bean.MyBean;
import com.fundamentos.fundamentos.bean.MyBeanImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBeanImplement();
    }
}
