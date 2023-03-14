package com.acme.order.itrade;

public enum OrderPurpose {
    ORIGINAL("00"),
    CANCELLATION("01"),
    REPLACE("05");
    private String code;
    OrderPurpose(String code) {
        this.code = code;
    }

    public static OrderPurpose findByCode(String code) {
        for (OrderPurpose om : values()) {
            if (om.code.equals(code)) {
                return om;
            }
        }
        return null;
    }
}