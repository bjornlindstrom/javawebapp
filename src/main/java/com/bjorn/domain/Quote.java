package com.bjorn.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by A500189 on 2015-12-20.
 */
@Entity
public class Quote extends AbstractPersistable<Long> {

    private Stock stock;
    private String price;
    private long timestamp;

    private DateFormat format = DateFormat.getTimeInstance();

    public Quote() {
        this(null, null);
    }

    public Quote(Stock stock, String price) {
        this(stock, price, new Date().getTime());
    }

    public Quote(Stock stock, String price, long timestamp) {
        this.stock = stock;
        this.price = price;
        this.timestamp = timestamp;
    }

    public Stock getStock() {
        return this.stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public String getPrice() {
        return price;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimeString() {
        return format.format(new Date(timestamp));
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Quote [time=" + getTimeString() + ", stock=" + stock + ", price=" + price + "]";
    }
}
