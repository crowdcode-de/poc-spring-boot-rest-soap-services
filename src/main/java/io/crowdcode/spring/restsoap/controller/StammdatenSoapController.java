package io.crowdcode.spring.restsoap.controller;

import io.crowdcode.spring.restsoap.dto.BetriebsstaetteDto;
import io.crowdcode.spring.restsoap.dto.StammdatenResponseDto;
import io.crowdcode.spring.restsoap.exception.StammdatenServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService
public class StammdatenSoapController {

    private static final Logger log = LoggerFactory.getLogger(StammdatenSoapController.class);

    private final StammdatenController controller;

    @Autowired
    public StammdatenSoapController(StammdatenController controller) {
        this.controller = controller;
    }

    @WebMethod
    public StammdatenResponseDto getStammdaten(@WebParam(name = "rahmenvertragName") String name) throws
            StammdatenServiceException {
        return controller.getStammdaten(name);
    }

    @WebMethod()
    public void addBetriebsstaette(@WebParam(name = "betriebsstaette") BetriebsstaetteDto betriebsstaette,
                                   @WebParam(name = "rahmenvertrag") String rahmenvertragName) throws StammdatenServiceException {
        controller.postBetriebsstaette(betriebsstaette, rahmenvertragName);
    }
}
