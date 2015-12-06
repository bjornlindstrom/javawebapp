package com.bjorn.domain;

import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by Björn on 2015-12-05.
 */
@Entity
public class Stock extends AbstractPersistable<Long> {

    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String shortName;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date inserted;

    public Stock() {
    }

    public Stock(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Date getInserted() {
        return inserted;
    }

    public void setInserted(Date inserted) {
        this.inserted = inserted;
    }
}
