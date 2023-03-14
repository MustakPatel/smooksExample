package com.acme.order.model;

import com.acme.order.itrade.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;

public class ChelanOrder {
    private OrderPurpose purpose;
    private String senderId;
    private String customerOrderId;
    private FobPaymentMethod fobPaymentMethod;
    private String orderDate;
    private List<String> notes = new ArrayList<>();
    private List<ChelanOrderItem> items = new LinkedList<>();
    private List<ChelanOrderParty> role = new LinkedList<>();
    private EnumMap<OrderRole, ChelanOrderParty> roles = new EnumMap<>(OrderRole.class);
    private String internalOrderId;
    private String revisionNumber;
    private String internalRevisionNumber;

    public FobPaymentMethod getFobPaymentMethod() {
        return fobPaymentMethod;
    }

    public void setFobPaymentMethod(FobPaymentMethod fobPaymentMethod) {
        this.fobPaymentMethod = fobPaymentMethod;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(String customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public OrderPurpose getPurpose() {
        return purpose;
    }

    public void setPurpose(OrderPurpose purpose) {
        this.purpose = purpose;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(String note) {
        this.notes.add(note);
    }

    public String getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(String revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public String getInternalRevisionNumber() {
        return internalRevisionNumber;
    }

    public void setInternalRevisionNumber(String internalRevisionNumber) {
        this.internalRevisionNumber = internalRevisionNumber;
    }

    public String getInternalOrderId() {
        return internalOrderId;
    }

    public void setInternalOrderId(String internalOrderId) {
        this.internalOrderId = internalOrderId;
    }
    public List<ChelanOrderItem> getItems() {
        return items;
    }
    public void setItems(ChelanOrderItem item) {
        this.items.add(item);
    }

    public List<ChelanOrderParty> getRole() {
        return role;
    }
    public void setRole(ChelanOrderParty role) {
        this.role.add(role);
        for (ChelanOrderParty party : this.role) {
            List<OrderRole> roleList = party.getRole();
            if (!roleList.isEmpty()) {
                OrderRole orderRole = roleList.get(0);
                addRole(orderRole, party);
            }
        }
    }
    public void addRole(OrderRole orderRole, ChelanOrderParty party) {
        this.roles.put(orderRole, party);
    }

    public EnumMap<OrderRole, ChelanOrderParty> getRoles() {
        return roles;
    }


    @Override
    public String toString() {
        return "ChelanOrder{" +
                "purpose=" + purpose +
                ", senderId='" + senderId + '\'' +
                ", customerOrderId='" + customerOrderId + '\'' +
                ", fobPaymentMethod=" + fobPaymentMethod +
                ", orderDate='" + orderDate + '\'' +
                ", notes=" + notes +
                ", items=" + items +
                ", roles=" + roles +
                ", internalOrderId='" + internalOrderId + '\'' +
                ", revisionNumber='" + revisionNumber + '\'' +
                ", internalRevisionNumber='" + internalRevisionNumber + '\'' +
                '}';
    }
}
