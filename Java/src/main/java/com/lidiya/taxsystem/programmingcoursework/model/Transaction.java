package com.lidiya.taxsystem.programmingcoursework.model;

import java.util.Objects;

public class Transaction {
    private String itemCode;
    private double internalPrice;
    private double discount;
    private double salePrice;
    private int quantity;
    private int checksum;
    private double profit;
    private double tax;

    // Constructor
    public Transaction(String itemCode, double internalPrice, double discount, double salePrice, int quantity, int checksum) {
        this.itemCode = itemCode;
        this.internalPrice = internalPrice;
        this.discount = discount;
        this.salePrice = salePrice;
        this.quantity = quantity;
        this.checksum = checksum;
        this.profit = 0;  // Default profit
        this.tax = 0;    // Default tax
    }

    // Getters and setters
    public String getItemCode() { return itemCode; }
    public void setItemCode(String itemCode) { this.itemCode = itemCode; }

    public double getInternalPrice() { return internalPrice; }
    public void setInternalPrice(double internalPrice) { this.internalPrice = internalPrice; }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }

    public double getSalePrice() { return salePrice; }
    public void setSalePrice(double salePrice) { this.salePrice = salePrice; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getChecksum() { return checksum; }
    public void setChecksum(int checksum) { this.checksum = checksum; }

    public double getProfit() { return profit; }
    public void setProfit(double profit) { this.profit = profit; }

    public double getTax() { return tax; }
    public void setTax(double tax) { this.tax = tax; }

    // isValid method to check if the transaction is valid
    public boolean isValid() {
        return itemCode != null && !itemCode.isEmpty()
                && internalPrice >= 0
                && salePrice >= 0
                && quantity > 0
                && checksum >= 0;
    }

    // Override equals and hashCode for valid object comparisons and removal from lists
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.internalPrice, internalPrice) == 0
                && Double.compare(that.discount, discount) == 0
                && Double.compare(that.salePrice, salePrice) == 0
                && quantity == that.quantity
                && checksum == that.checksum
                && itemCode.equals(that.itemCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemCode, internalPrice, discount, salePrice, quantity, checksum);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "itemCode='" + itemCode + '\'' +
                ", internalPrice=" + internalPrice +
                ", discount=" + discount +
                ", salePrice=" + salePrice +
                ", quantity=" + quantity +
                ", checksum=" + checksum +
                ", profit=" + profit +
                ", tax=" + tax +
                '}';
    }
}
