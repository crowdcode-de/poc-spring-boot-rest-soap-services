

package io.crowdcode.spring.restsoap.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.crowdcode.spring.restsoap.adapter.ZonedDateTimeAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * Created by idueppe on 06.06.17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class BetriebsstaetteDto implements Serializable {

    private static final long serialVersionUID = -5857580560880503258L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", locale = "de-DE", timezone = "Europe/Berlin")
    @XmlJavaTypeAdapter(value = ZonedDateTimeAdapter.class, type = ZonedDateTime.class )
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
