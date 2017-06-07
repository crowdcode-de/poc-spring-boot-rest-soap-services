package io.crowdcode.spring.restsoap.config;

import io.crowdcode.spring.restsoap.controller.StammdatenServiceController;
import io.crowdcode.spring.restsoap.ws.StammdatenSoapService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.ws.config.annotation.EnableWs;

import javax.xml.ws.Endpoint;

/**
 * Created by idueppe on 06.06.17.
 */
@Configuration
@EnableWs
@Profile("soap")
public class WebServicesConfig {

    @Bean
    public StammdatenSoapService stammdatenWebService(StammdatenServiceController controller) {
        return new StammdatenSoapService(controller);
    }


    @Bean
    public ServletRegistrationBean wsDispatcherServlet() {
        CXFServlet cxfServlet = new CXFServlet();
        return new ServletRegistrationBean(cxfServlet, "/services/*");
    }

    @Bean(name= Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint stammdatenEndpoint(SpringBus springBus, StammdatenSoapService stammdatenSoapService) {
        EndpointImpl endpoint = new EndpointImpl(springBus, stammdatenSoapService);
        endpoint.publish("stammdatenWS");
        endpoint.setWsdlLocation("Stammdatenservice.wsdl");
        return endpoint;
    }

}


