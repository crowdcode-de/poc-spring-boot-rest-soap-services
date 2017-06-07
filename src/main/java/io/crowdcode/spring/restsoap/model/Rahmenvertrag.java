package io.crowdcode.spring.restsoap.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by idueppe on 06.06.17.
 */
@Entity
public class Rahmenvertrag extends AbstractEntity {

    @NotNull
    @Column(unique = true)
    private String name;
    
    private String typ;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Betriebsstaette> betriebsstaetten = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Set<Betriebsstaette> getBetriebsstaetten() {
        return betriebsstaetten;
    }

    public void setBetriebsstaetten(Set<Betriebsstaette> betriebsstaetten) {
        this.betriebsstaetten = betriebsstaetten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rahmenvertrag that = (Rahmenvertrag) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return typ != null ? typ.equals(that.typ) : that.typ == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (typ != null ? typ.hashCode() : 0);
        return result;
    }
}
