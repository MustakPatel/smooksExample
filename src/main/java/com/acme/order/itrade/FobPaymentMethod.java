package com.acme.order.itrade;

public enum FobPaymentMethod {
    DELIVERED("PP"),
    FOB("PB");
    private String code;
    FobPaymentMethod(String code) {
        this.code = code;
    }

    public static FobPaymentMethod findByCode(String code) {
        for (FobPaymentMethod om : values()) {
            if (om.code.equals(code)) {
                return om;
            }
        }
        return null;
    }
}