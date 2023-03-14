package com.acme.order.itrade;

public enum QuantityUom {
    QTY_CASE("CA");
    private String code;
    QuantityUom(String code) {
        this.code = code;
    }

    public static QuantityUom findByCode(String code) {
        for (QuantityUom om : values()) {
            if (om.code.equals(code)) {
                return om;
            }
        }
        return null;
    }
}