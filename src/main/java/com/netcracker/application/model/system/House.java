package com.netcracker.application.model.system;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="houses")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "street_id", referencedColumnName = "id")
    private Street street;

    @Column(name="houseNumber")
    private String houseNumber;

    public House() {
    }

    public House(City city, Street street, String houseNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House)) return false;
        House house = (House) o;
        return Objects.equals(getId(), house.getId()) &&
                Objects.equals(getCity(), house.getCity()) &&
                Objects.equals(getStreet(), house.getStreet()) &&
                Objects.equals(getHouseNumber(), house.getHouseNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCity(), getStreet(), getHouseNumber());
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", city=" + city +
                ", street=" + street +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }
}
