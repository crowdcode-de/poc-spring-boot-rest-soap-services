package io.crowdcode.spring.restsoap.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.ZonedDateTime;

public class ZonedDateTimeAdapter extends XmlAdapter<String,ZonedDateTime> {

    @Override
    public ZonedDateTime unmarshal(String value) throws Exception {
        return ZonedDateTime.parse(value);
    }

    @Override
    public String marshal(ZonedDateTime value) throws Exception {
        if (value != null) {
            return value.toString();
        } else {
            return null;
        }
    }
}