package com.netcracker.application.model.system;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="house_id", referencedColumnName = "id")
    private House house;

    @Column(name="flat")
    private Integer flat;

    public Address() {
    }

    public Address(House house, Integer flat) {
        this.house = house;
        this.flat = flat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getId(), address.getId()) &&
                Objects.equals(getHouse(), address.getHouse()) &&
                Objects.equals(getFlat(), address.getFlat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHouse(), getFlat());
    }

    @Override
    public String toString() {
        return "AddressModel{" +
                "id=" + id +
                ", house=" + house +
                ", flat=" + flat +
                '}';
    }
}
