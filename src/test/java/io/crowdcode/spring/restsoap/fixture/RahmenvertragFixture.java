package io.crowdcode.spring.restsoap.fixture;

import io.crowdcode.spring.restsoap.model.Betriebsstaette;
import io.crowdcode.spring.restsoap.model.Rahmenvertrag;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Created by idueppe on 06.06.17.
 */
public class RahmenvertragFixture {

    public static Rahmenvertrag buildDefaultRV(String name) {
        Rahmenvertrag rv = new Rahmenvertrag();
        rv.setName(name);
        rv.setTyp("typ");
        rv.getBetriebsstaetten().add(buildDefaultBetriebsstaette("A"));
        return rv;
    }

    public static Betriebsstaette buildDefaultBetriebsstaette(String kennung) {
        Betriebsstaette b = new Betriebsstaette();
        b.setGueltigBis(ZonedDateTime.now());
        b.setKennung(kennung);
        b.setUniqueKey(UUID.randomUUID().toString());
        return b;
    }
}
