@XmlJavaTypeAdapters(
        @XmlJavaTypeAdapter(value = ZonedDateTimeAdapter.class, type = ZonedDateTime.class )
)
package io.crowdcode.spring.restsoap.dto;

import io.crowdcode.spring.restsoap.adapter.ZonedDateTimeAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.time.ZonedDateTime;