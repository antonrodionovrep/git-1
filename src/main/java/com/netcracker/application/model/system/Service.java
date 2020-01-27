package com.netcracker.application.model.system;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="costPerMonth")
    private BigDecimal costPerMonth;

    public Service() {
    }

    public Service(String name, BigDecimal costPerMonth) {
        this.name = name;
        this.costPerMonth = costPerMonth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCostPerMonth() {
        return costPerMonth;
    }

    public void setCostPerMonth(BigDecimal costPerMonth) {
        this.costPerMonth = costPerMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;
        Service service = (Service) o;
        return Objects.equals(getId(), service.getId()) &&
                Objects.equals(getName(), service.getName()) &&
                Objects.equals(getCostPerMonth(), service.getCostPerMonth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCostPerMonth());
    }
}
