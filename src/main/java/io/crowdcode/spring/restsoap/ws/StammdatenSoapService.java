package io.crowdcode.spring.restsoap.ws;

import io.crowdcode.spring.restsoap.controller.StammdatenServiceController;
import io.crowdcode.spring.restsoap.dto.StammdatenResponseDto;
import io.crowdcode.spring.restsoap.exception.StammdatenServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService
@Transactional
public class StammdatenSoapService {

    private static final Logger log = LoggerFactory.getLogger(StammdatenSoapService.class);

    private StammdatenServiceController controller;

    public StammdatenSoapService() {
        log.error("DEFAULT CONSTRUCTOR CALLED");
    }

    @Autowired
    public StammdatenSoapService(StammdatenServiceController controller) {
        this.controller = controller;
    }

    @WebMethod
    public StammdatenResponseDto getStammdaten(@WebParam(name="rahmenvertragName") String name) throws
            StammdatenServiceException {
        return controller.getStammdaten(name).getBody();
    }
}
