package nyc.c4q.wesniemarcelin.nikoandroidclone.model;

import java.io.Serializable;
import java.util.Calendar;

import nl.qbusict.cupboard.annotation.Column;

/**
 * Created by wesniemarcelin on 12/4/16.
 */

public class Cat implements Serializable {
    // a POJO for cupboard must always contain a variable of type Long called _id.
    // this will serve as the index for the POJO within the SQLite table and will
    // auto-increment.
    private Long _id;

    private String name;

    private String catUrl;

    // column name defaults to field name
    // or we can use @Column annotation to specify a custom name
    @Column("last_fed")
    private Long lastFed;

    // required zero argument constructor
    public Cat() {
        this.name = "Unknown";
        this.lastFed = Calendar.getInstance().getTimeInMillis();
    }

    public Cat(String name, Long lastFed, String catUrl) {
        this.name = name;
        this.lastFed = lastFed;
        this.catUrl = catUrl;
    }

    public String getCatUrl() {
        return catUrl;
    }

    public Long getId() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLastFed() {
        return lastFed;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }
}
