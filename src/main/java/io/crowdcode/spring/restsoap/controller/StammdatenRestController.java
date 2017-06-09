package io.crowdcode.spring.restsoap.controller;

import io.crowdcode.spring.restsoap.dto.BetriebsstaetteDto;
import io.crowdcode.spring.restsoap.dto.StammdatenResponseDto;
import io.crowdcode.spring.restsoap.exception.StammdatenServiceException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class StammdatenRestController {

    private static final Logger log = LoggerFactory.getLogger(StammdatenRestController.class);

    @Autowired
    private StammdatenController stammdatenController;

    @ApiOperation(value = "Gibt Stammdaten zu Aufrufendem zurück.", nickname = "getStammdaten", httpMethod = "GET", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = StammdatenResponseDto.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @GetMapping("/v1/api/stammdaten")
    public ResponseEntity<StammdatenResponseDto> getStammdaten(
            @ApiParam("Name des Rahmenvertrags") @RequestParam(required = false, name = "name") String
                    rahmenvertragName)
            throws StammdatenServiceException {

        log.info("Holen der Stammdaten fuer {}", rahmenvertragName);

        try {
            return ResponseEntity.ok(stammdatenController.getStammdaten(rahmenvertragName));
        } catch (StammdatenServiceException sse) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/v1/api/stammdaten/{rahmenvertragsName}")
    public ResponseEntity<Void> postBetriebsstaette(@RequestBody BetriebsstaetteDto betriebsstaette, @PathVariable
            ("rahmenvertragsName") String rahmenvertragName, UriComponentsBuilder uriComponentsBuilder) {

        try {
            stammdatenController.postBetriebsstaette(betriebsstaette, rahmenvertragName);
        return ResponseEntity.created(uriComponentsBuilder.build().toUri()).build();
        } catch (StammdatenServiceException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
}
