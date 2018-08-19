package com.stan.HospitalInfoDemo;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class HospitalInfoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalInfoDemoApplication.class, args);
	}
	
	//JMS,read from appication.properties file
		@Value("${jms.broker-url}")
		private String jmsBrokerUrl;
		
		@Value("${jms.user}")
		private String user;
		
		@Value("${jms.password}")
		private String password;
		
		@Bean
		public ConnectionFactory connectionFactory() {
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
			factory.setBrokerURL(jmsBrokerUrl);
			factory.setUserName(user);
			factory.setPassword(password);
			return factory;
		}
		
		@Bean
		public JmsTemplate jmsTemplate() {
			JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
			jmsTemplate.setDefaultDestinationName("outPatientQueue");
			return jmsTemplate;
		}
		
		@Bean(name = "patientContainer")
	   public DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory() {
	       DefaultJmsListenerContainerFactory factory =
	               new DefaultJmsListenerContainerFactory();
	       factory.setConnectionFactory(connectionFactory());
	       factory.setConcurrency("1");
	       factory.setRecoveryInterval(1000L);
	       return factory;
	   }
}
