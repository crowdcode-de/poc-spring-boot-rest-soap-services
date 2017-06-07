package io.crowdcode.spring.restsoap.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Created by idueppe on 06.06.17.
 */
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
