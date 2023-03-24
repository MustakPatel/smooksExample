package com.acme.order.itrade;

import java.util.ArrayList;
import java.util.List;

public class ChelanOrderParty {
    private String name;
    private String nickName;
    private PartyIdType partyIdType;
    private String idCode;
    private String address1;
    private String address2;
    private String city;
    private String stateProvinceCode;
    private String postalCode;
    private String countryCode;
    private ContactMechType contactMechType;
    private String contactInfo;
    private List<OrderRole> role = new ArrayList<>();

    public List<OrderRole> getRole() {
        return role;
    }

    public void setRole(OrderRole role) {
        this.role.add(role);
    }

    public ChelanOrderParty name(String name) {
        this.name = name;
        return this;
    }

    public ChelanOrderParty nickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public ChelanOrderParty partyIdType(PartyIdType partyIdType) {
        this.partyIdType = partyIdType;
        return this;
    }

    public ChelanOrderParty idCode(String idCode) {
        this.idCode = idCode;
        return this;
    }

    public ChelanOrderParty address1(String address1) {
        this.address1 = address1;
        return this;
    }

    public ChelanOrderParty address2(String address2) {
        this.address2 = address2;
        return this;
    }

    public ChelanOrderParty city(String city) {
        this.city = city;
        return this;
    }

    public ChelanOrderParty stateProvinceCode(String stateProvinceCode) {
        this.stateProvinceCode = stateProvinceCode;
        return this;
    }

    public ChelanOrderParty postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public ChelanOrderParty countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public ChelanOrderParty contactMechType(ContactMechType contactMechType) {
        this.contactMechType = contactMechType;
        return this;
    }

    public ChelanOrderParty contactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public PartyIdType getPartyIdType() {
        return partyIdType;
    }

    public String getIdCode() {
        return idCode;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getStateProvinceCode() {
        return stateProvinceCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public ContactMechType getContactMechType() {
        return contactMechType;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    @Override
    public String toString() {
        return "ChelanOrderParty{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", partyIdType=" + partyIdType +
                ", idCode='" + idCode + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", stateProvinceCode='" + stateProvinceCode + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", contactMechType=" + contactMechType +
                ", contactInfo='" + contactInfo + '\'' +
                ", role=" + role + "}\n";
    }
}
