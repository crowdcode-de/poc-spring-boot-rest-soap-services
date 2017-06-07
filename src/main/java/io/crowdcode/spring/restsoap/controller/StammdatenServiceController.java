package io.crowdcode.spring.restsoap.controller;

import io.crowdcode.spring.restsoap.dto.BetriebsstaetteDto;
import io.crowdcode.spring.restsoap.dto.RahmenvertragDto;
import io.crowdcode.spring.restsoap.dto.StammdatenResponseDto;
import io.crowdcode.spring.restsoap.exception.StammdatenServiceException;
import io.crowdcode.spring.restsoap.model.Betriebsstaette;
import io.crowdcode.spring.restsoap.model.Rahmenvertrag;
import io.crowdcode.spring.restsoap.repository.RahmenvertragRepository;
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

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class StammdatenServiceController {

    private static final Logger log = LoggerFactory.getLogger(StammdatenServiceController.class);


    @Autowired
    private RahmenvertragRepository rahmenvertragRepository;

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

        Rahmenvertrag rahmenvertrag = rahmenvertragRepository.findByName(rahmenvertragName);

        if (rahmenvertrag == null) {
            return ResponseEntity.notFound().build();
        }

        StammdatenResponseDto responseDto = new StammdatenResponseDto();
        responseDto.setRahmenvertrag(mapToDto(rahmenvertrag));
        responseDto.setBetriebsstaetten(mapToDtos(rahmenvertrag.getBetriebsstaetten()));

        return ResponseEntity.ok(responseDto);

    }


    @PostMapping("/v1/api/stammdaten/{rahmenvertragsName}")
    public ResponseEntity<Void> postBetriebsstaette(@RequestBody Betriebsstaette betriebsstaette, @PathVariable
            ("rahmenvertragsName") String rahmenvertragName, UriComponentsBuilder uriComponentsBuilder) {

        Rahmenvertrag rahmenvertrag = rahmenvertragRepository.findByName(rahmenvertragName);

        if (rahmenvertrag == null) {
            return ResponseEntity.notFound().build();
        }

        Betriebsstaette bs = new Betriebsstaette();
        bs.setKennung(betriebsstaette.getKennung());
        bs.setUniqueKey(betriebsstaette.getUniqueKey());
        bs.setGueltigBis(betriebsstaette.getGueltigBis());

        rahmenvertrag.getBetriebsstaetten().add(bs);
        rahmenvertragRepository.save(rahmenvertrag);


        return ResponseEntity.created(uriComponentsBuilder.build().toUri()).build();
    }


    private Set<BetriebsstaetteDto> mapToDtos(Set<Betriebsstaette> betriebsstaetten) {
        if (betriebsstaetten == null) {
            return Collections.emptySet();
        } else {
            return betriebsstaetten
                    .stream()
                    .map(this::mapToDto)
                    .collect(Collectors.toSet());
        }
    }

    public RahmenvertragDto mapToDto(Rahmenvertrag rahmenvertrag) {
        RahmenvertragDto dto = new RahmenvertragDto();
        dto.setName(rahmenvertrag.getName());
        dto.setTyp(rahmenvertrag.getTyp());
        return dto;
    }

    public BetriebsstaetteDto mapToDto(Betriebsstaette betriebsstaette) {
        BetriebsstaetteDto dto = new BetriebsstaetteDto();
        dto.setKennung(betriebsstaette.getKennung());
        dto.setGueltigBis(betriebsstaette.getGueltigBis());
        dto.setUniqueKey(betriebsstaette.getUniqueKey());
        return dto;
    }

}
