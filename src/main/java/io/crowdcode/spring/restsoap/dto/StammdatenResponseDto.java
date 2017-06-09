package io.crowdcode.spring.restsoap.dto;

import java.util.Set;


public class StammdatenResponseDto {

    private RahmenvertragDto rahmenvertrag;
    private Set<BetriebsstaetteDto> betriebsstaetten;

    public RahmenvertragDto getRahmenvertrag() {
        return rahmenvertrag;
    }

    public void setRahmenvertrag(RahmenvertragDto rahmenvertrag) {
        this.rahmenvertrag = rahmenvertrag;
    }

    public Set<BetriebsstaetteDto> getBetriebsstaetten() {
        return betriebsstaetten;
    }

    public void setBetriebsstaetten(Set<BetriebsstaetteDto> betriebsstaetten) {
        this.betriebsstaetten = betriebsstaetten;
    }
}
