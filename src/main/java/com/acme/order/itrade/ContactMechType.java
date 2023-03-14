package com.acme.order.itrade;

public enum ContactMechType {
    TELEPHONE("TE"),
    EMAIL("EA");
    private String code;
    ContactMechType(String code) {
        this.code = code;
    }

    public static ContactMechType findByCode(String code) {
        for (ContactMechType om : values()) {
            if (om.code.equals(code)) {
                return om;
            }
        }
        return null;
    }
}

