package com.acme.order.itrade;

public enum OrderRole {
    BILL_TO("BT"),
    BUYER("BY"),
    SHIP_TO("ST"),
    VENDOR("VN");
    private String code;
    OrderRole(String code) {
        this.code = code;
    }

    public static OrderRole findByCode(String code) {
        for (OrderRole om : values()) {
            if (om.code.equals(code)) {
                return om;
            }
        }
        return null;
    }
}
