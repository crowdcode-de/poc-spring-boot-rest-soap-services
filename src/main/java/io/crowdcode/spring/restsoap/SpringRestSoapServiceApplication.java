package io.crowdcode.spring.restsoap;

import io.crowdcode.spring.restsoap.model.Betriebsstaette;
import io.crowdcode.spring.restsoap.model.Rahmenvertrag;
import io.crowdcode.spring.restsoap.repository.RahmenvertragRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@SpringBootApplication
public class SpringRestSoapServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringRestSoapServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner runAfterStart(final RahmenvertragRepository repository) {
        return args -> {
            Betriebsstaette one = new Betriebsstaette();
            one.setGueltigBis(ZonedDateTime.now().plusDays(1));
            one.setKennung("ONE");
            one.setUniqueKey(UUID.randomUUID().toString());

            Betriebsstaette two = new Betriebsstaette();
            two.setGueltigBis(ZonedDateTime.now().truncatedTo(ChronoUnit.DAYS));
            two.setKennung("TWO");
            two.setUniqueKey(UUID.randomUUID().toString());

            Rahmenvertrag rahmenvertrag1 = new Rahmenvertrag();
            rahmenvertrag1.setName("RV1");
            rahmenvertrag1.setTyp("TYP");
            rahmenvertrag1.getBetriebsstaetten().add(one);
            rahmenvertrag1.getBetriebsstaetten().add(two);
            repository.save(rahmenvertrag1);

            Betriebsstaette three = new Betriebsstaette();
            three.setGueltigBis(ZonedDateTime.now().plusDays(1));
            three.setKennung("THREE");
            three.setUniqueKey(UUID.randomUUID().toString());

            Betriebsstaette four = new Betriebsstaette();
            four.setGueltigBis(ZonedDateTime.now().truncatedTo(ChronoUnit.DAYS));
            four.setKennung("FOUR");
            four.setUniqueKey(UUID.randomUUID().toString());

            Rahmenvertrag rahmenvertrag2 = new Rahmenvertrag();
            rahmenvertrag2.setTyp("TYP");
            rahmenvertrag2.setName("RV2");
            rahmenvertrag2.getBetriebsstaetten().add(three);
            rahmenvertrag2.getBetriebsstaetten().add(four);

            repository.save(rahmenvertrag2);

            repository.flush();
        };
    }
}
