package io.crowdcode.spring.restsoap.controller;

import io.crowdcode.spring.restsoap.dto.BetriebsstaetteDto;
import io.crowdcode.spring.restsoap.dto.RahmenvertragDto;
import io.crowdcode.spring.restsoap.dto.StammdatenResponseDto;
import io.crowdcode.spring.restsoap.exception.StammdatenServiceException;
import io.crowdcode.spring.restsoap.model.Betriebsstaette;
import io.crowdcode.spring.restsoap.model.Rahmenvertrag;
import io.crowdcode.spring.restsoap.repository.RahmenvertragRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Transactional
public class StammdatenController {

    private static final Logger log = LoggerFactory.getLogger(StammdatenController.class);

    @Autowired
    private RahmenvertragRepository rahmenvertragRepository;

    public StammdatenResponseDto getStammdaten(String rahmenvertragName)
            throws StammdatenServiceException {

        log.info("Holen der Stammdaten fuer {}", rahmenvertragName);

        Rahmenvertrag rahmenvertrag = rahmenvertragRepository.findByName(rahmenvertragName);

        if (rahmenvertrag == null) {
            throw new StammdatenServiceException();
        }

        StammdatenResponseDto responseDto = new StammdatenResponseDto();
        responseDto.setRahmenvertrag(mapToDto(rahmenvertrag));
        responseDto.setBetriebsstaetten(mapToDtos(rahmenvertrag.getBetriebsstaetten()));

        return responseDto;
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


    public Long postBetriebsstaette(BetriebsstaetteDto betriebsstaette, String rahmenvertragName) throws
            StammdatenServiceException {

        Rahmenvertrag rahmenvertrag = rahmenvertragRepository.findByName(rahmenvertragName);

        if (rahmenvertrag == null) {
            throw new StammdatenServiceException();
        }

        Betriebsstaette bs = new Betriebsstaette();
        bs.setKennung(betriebsstaette.getKennung());
        bs.setUniqueKey(betriebsstaette.getUniqueKey());
        bs.setGueltigBis(betriebsstaette.getGueltigBis());

        rahmenvertrag.getBetriebsstaetten().add(bs);
        rahmenvertragRepository.save(rahmenvertrag);

        return bs.getId();

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
