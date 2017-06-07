package io.crowdcode.spring.restsoap.model;

import javax.persistence.Entity;
import java.time.ZonedDateTime;

@Entity
public class Betriebsstaette extends AbstractEntity {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Betriebsstaette that = (Betriebsstaette) o;

        return uniqueKey != null ? uniqueKey.equals(that.uniqueKey) : that.uniqueKey == null;
    }

    @Override
    public int hashCode() {
        return uniqueKey != null ? uniqueKey.hashCode() : 0;
    }
}
