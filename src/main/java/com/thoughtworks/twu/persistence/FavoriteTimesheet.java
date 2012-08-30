package com.thoughtworks.twu.persistence;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table( name = "FAVORITE_TIMESHEET" )
public class FavoriteTimesheet {

    @Id
    @GeneratedValue(generator="id")
    @GenericGenerator(name="id", strategy = "increment")
    private int id;

    @Column
    private String name;

    @Column
    private String userId;

    public FavoriteTimesheet(String name) {
        this.name = name.trim();
        this.userId = "1234";
    }

    public FavoriteTimesheet() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavoriteTimesheet that = (FavoriteTimesheet) o;

        if (!name.equals(that.name)) return false;
        if (!userId.equals(that.userId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + userId.hashCode();
        return result;
    }
}
