@XmlJavaTypeAdapters(
        @XmlJavaTypeAdapter(value = ZonedDateTimeAdapter.class, type = ZonedDateTime.class )
)
/**
 * Created by idueppe on 07.06.17.
 */
package io.crowdcode.spring.restsoap.dto;

import io.crowdcode.spring.restsoap.adapter.ZonedDateTimeAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.time.ZonedDateTime;