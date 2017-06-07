package io.crowdcode.spring.restsoap.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * Created by idueppe on 06.06.17.
 */
public class BetriebsstaetteDto implements Serializable {

    private static final long serialVersionUID = -5857580560880503258L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", locale = "de-DE", timezone = "Europe/Berlin")
    private ZonedDateTime gueltigBis;

    private String kennung;
    private String uniqueKey;

    public ZonedDateTime getGueltigBis() {
        return gueltigBis;
    }

    public void setGueltigBis(ZonedDateTime gueltigBis) {
        this.gueltigBis = gueltigBis;
    }

    public String getKennung() {
        return kennung;
    }

    public void setKennung(String kennung) {
        this.kennung = kennung;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }
}
