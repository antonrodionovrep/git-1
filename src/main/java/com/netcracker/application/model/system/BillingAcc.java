package com.netcracker.application.model.system;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "billing_account")
public class BillingAcc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number")
    private String cardNumber;
    @Column(name = "validDate")
    private String validDate;
    @Column(name = "CVV")
    private String CVV;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name="bonus_points")
    private BigDecimal bonusPoints;

    public BillingAcc() {
    }

    public BillingAcc(String cardNumber,  String surname, String name, String patronymic,  String CVV, String validDate, BigDecimal bonusPoints) {
        this.cardNumber = cardNumber;
        this.validDate = validDate;
        this.CVV = CVV;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.bonusPoints = bonusPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public BigDecimal getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(BigDecimal bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

}
