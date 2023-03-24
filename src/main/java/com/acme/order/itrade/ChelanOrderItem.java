package com.acme.order.itrade;

import java.math.BigDecimal;
import java.util.EnumMap;

public class ChelanOrderItem {
    private String lineId;
    private String itemSeqId;
    private BigDecimal quantity;
    private QuantityUom quantityUom;
    private BigDecimal unitPrice;
    private String sku;
    private String buyerSku;
    private String description;
    private ChelanOrderParty shipFromParty;

    private String countryOfOrigin;


    public ChelanOrderItem lineId(String lineId){
//        System.out.println("-----chelanOrderItem-------------lineId::"+lineId);
        this.lineId = lineId;
        return this;
    }

    public ChelanOrderItem itemSeqId(String itemSeqId){
        this.itemSeqId = itemSeqId;
        return this;
    }

    public ChelanOrderItem quantity(BigDecimal quantity){
//        System.out.println("-----chelanOrderItem-------------quantity::"+quantity);
        this.quantity = quantity;
        return this;
    }

    public ChelanOrderItem quantityUom(QuantityUom quantityUom){
        this.quantityUom = quantityUom;
        return this;
    }

    public ChelanOrderItem unitPrice(BigDecimal unitPrice){
        this.unitPrice = unitPrice;
        return this;
    }

    public ChelanOrderItem sku(String sku){
        this.sku = sku;
        return this;
    }

    public ChelanOrderItem buyerSku(String buyerSku){
        this.buyerSku = buyerSku;
        return this;
    }

    public ChelanOrderItem description(String description){
        this.description = description;
        return this;
    }

    public ChelanOrderItem shipFromParty(ChelanOrderParty shipFromParty){
        this.shipFromParty = shipFromParty;
        return this;
    }

    public ChelanOrderItem countryOfOrigin(String countryOfOrigin){
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public String getLineId() {
        return lineId;
    }

    public String getItemSeqId() {
        return itemSeqId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public QuantityUom getQuantityUom() {
        return quantityUom;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public String getSku() {
        return sku;
    }

    public String getBuyerSku() {
        return buyerSku;
    }

    public String getDescription() {
        return description;
    }

    public ChelanOrderParty getShipFromParty() {
        return shipFromParty;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    @Override
    public String toString() {
        return "lineId=" + lineId + ", itemSeqId=" + itemSeqId + ", quantity=" + quantity + ", quantityUom=" + quantityUom + ", unitPrice=" + unitPrice + ", sku=" + sku +
                ", buyerSku=" + buyerSku + ", description=" + description +", shipFromParty=" + shipFromParty;
    }

}
