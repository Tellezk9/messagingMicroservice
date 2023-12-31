package com.messaging.messagingmicroservice.domain.model;

public class Client {
    private Long id;
    private Long securityPin;
    private String name;
    private String lastName;
    private Integer dniNumber;
    private String phone;
    private String mail;

    public Client(Long id, Long securityPin, String name, String lastName, Integer dniNumber, String phone, String mail) {
        this.id = id;
        this.securityPin = securityPin;
        this.name = name;
        this.lastName = lastName;
        this.dniNumber = dniNumber;
        this.phone = phone;
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSecurityPin() {
        return securityPin;
    }

    public void setSecurityPin(Long securityPin) {
        this.securityPin = securityPin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDniNumber() {
        return dniNumber;
    }

    public void setDniNumber(Integer dniNumber) {
        this.dniNumber = dniNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
