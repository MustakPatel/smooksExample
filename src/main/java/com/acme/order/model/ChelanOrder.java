package com.acme.order.model;

import com.acme.order.itrade.*;
import com.acme.order.itrade.ReferenceIdentification;

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
    private List<ReferenceIdentification> identifications = new LinkedList<>();
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

    public void setIdentifications(ReferenceIdentification identifications) {
        this.identifications.add(identifications);
        for (ReferenceIdentification identification : this.identifications) {
            System.out.println("");
            setIdentity(identification);
        }
    }
        public void setIdentity(ReferenceIdentification id){
            System.out.println("list::" + id);
                if ("IL".equals(id.getReferenceIdentificationQualifier())) {
                    this.internalOrderId = id.getReferenceIdentificationCode();
                }
                if ("YB".equals(id.getReferenceIdentificationQualifier())) {
                    this.internalRevisionNumber = id.getReferenceIdentificationCode();
                }
                if ("ZI".equals(id.getReferenceIdentificationQualifier())) {
                    this.revisionNumber = id.getReferenceIdentificationCode();
                }
            }



    @Override
    public String toString() {
        StringBuffer desc = new StringBuffer();
        desc.append("Order Header: \n");
        desc.append("\tpurpose: " + purpose + "\n");
        desc.append("\tinternalOrderId: " +internalOrderId + "\n");
        desc.append("\trevisionNumber: " +revisionNumber + "\n");
        desc.append("\tinternalRevisionNumber: " +internalRevisionNumber + "\n");
        desc.append("\tsenderId: " +senderId + "\n");
        desc.append("\tcustomerOrderId: " +customerOrderId + "\n");
        desc.append("\tfobPaymentMethod: " +fobPaymentMethod + "\n");
        desc.append("\torderDate: " +orderDate + "\n");
        desc.append("\tOrder Notes: \n");
        for(int i = 0; i < notes.size(); i++) {
            desc.append("\t" + "(" + i +  "): " + notes.get(i)).append("\n");
        }
        desc.append("Order Items: \n");
        for(int i = 0; i < items.size(); i++) {
            desc.append("\t" + "(" + i +  "): " + items.get(i)).append("\n");
        }
        desc.append("Order Roles: \n");
        desc.append(roles);
        desc.append("Order Identifications: \n");
        for(int i = 0; i < identifications.size(); i++) {
            desc.append("\t" + "(" + i +  "): " + identifications.get(i)).append("\n");
        }
        return desc.toString();
    }
}
