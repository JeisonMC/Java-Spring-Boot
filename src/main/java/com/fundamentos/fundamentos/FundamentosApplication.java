package com.fundamentos.fundamentos;

import com.fundamentos.fundamentos.bean.MyBean;
import com.fundamentos.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.fundamentos.component.ComponentDependency;
import com.fundamentos.fundamentos.paco.UserPaco;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner{

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean mybean;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPaco userPaco;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean mybean, MyBeanWithProperties myBeanWithProperties, UserPaco userpaco){
		this.componentDependency = componentDependency;
		this.mybean = mybean;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPaco = userpaco;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		mybean.print();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPaco.getEmail() + "-" + userPaco.getPassword());
		try{
			int value = 10/0;
			LOGGER.debug("Mi valor -> "+value);
		}catch (Exception e){
			LOGGER.error("Esto es un error al dividir por cero "+e.getClass());
		}
	}
}
