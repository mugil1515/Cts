// File: DependencyInjectionExample.java

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.BeanFactory;

// Dependency to be injected
class MessageService {
    public String getMessage() {
        return "Hello from MessageService!";
    }
}

// Dependent class
class MessagePrinter {
    private MessageService service;

    // Constructor Injection
    public MessagePrinter(MessageService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(service.getMessage());
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        // XML configuration as a string
        String xmlConfig =
            "<?xml version='1.0' encoding='UTF-8'?>" +
            "<beans xmlns='http://www.springframework.org/schema/beans' " +
            "       xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' " +
            "       xsi:schemaLocation='http://www.springframework.org/schema/beans " +
            "       http://www.springframework.org/schema/beans/spring-beans.xsd'>" +
            "   <bean id='messageService' class='MessageService'/>" +
            "   <bean id='messagePrinter' class='MessagePrinter'>" +
            "       <constructor-arg ref='messageService'/>" +
            "   </bean>" +
            "</beans>";

        // Load XML config
        Resource resource = new ByteArrayResource(xmlConfig.getBytes());
        BeanFactory factory = new XmlBeanFactory(resource);

        // Get and use the bean
        MessagePrinter printer = (MessagePrinter) factory.getBean("messagePrinter");
        printer.printMessage();
    }
}
