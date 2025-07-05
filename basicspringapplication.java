// File: SpringBasicApp.java

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.BeanFactory;

// Simple service class
class HelloService {
    public void sayHello() {
        System.out.println("Hello from Spring!");
    }
}

public class SpringBasicApp {
    public static void main(String[] args) {
        // Spring XML configuration as string
        String config = 
            "<?xml version='1.0' encoding='UTF-8'?>" +
            "<beans xmlns='http://www.springframework.org/schema/beans' " +
            "       xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' " +
            "       xsi:schemaLocation='http://www.springframework.org/schema/beans " +
            "       http://www.springframework.org/schema/beans/spring-beans.xsd'>" +
            "   <bean id='helloService' class='HelloService'/>" +
            "</beans>";

        // Load configuration from string
        Resource resource = new ByteArrayResource(config.getBytes());
        BeanFactory factory = new XmlBeanFactory(resource);

        // Get bean and call method
        HelloService helloService = (HelloService) factory.getBean("helloService");
        helloService.sayHello();
    }
}
