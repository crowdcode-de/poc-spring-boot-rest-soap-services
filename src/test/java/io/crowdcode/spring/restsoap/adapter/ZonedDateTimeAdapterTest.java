package io.crowdcode.spring.restsoap.adapter;

import org.junit.Test;

import java.time.ZonedDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by idueppe on 07.06.17.
 */
public class ZonedDateTimeAdapterTest {

    private ZonedDateTimeAdapter adapter = new ZonedDateTimeAdapter();

    @Test
    public void testParsing() throws Exception {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime found = adapter.unmarshal(adapter.marshal(now));

        assertThat(found, is(equalTo(now)));
    }
}