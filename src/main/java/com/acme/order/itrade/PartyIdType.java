package com.acme.order.itrade;

public enum PartyIdType {
    DUNS4("9"),
    BUYER_CODE("91");
    private String code;
    PartyIdType(String code) {
        this.code = code;
    }

    public static PartyIdType findByCode(String code) {
        for (PartyIdType om : values()) {
            if (om.code.equals(code)) {
                return om;
            }
        }
        return null;
    }
}