package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

public class SalesReportDTO {

    private Long sellerId;
    private String sellerName;
    private Double amount;
    private LocalDate date;

    // Construtor público correspondente aos campos esperados
    public SalesReportDTO(Long sellerId, String sellerName, Double amount,LocalDate date) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.amount = amount;
        this.date = date;
    }

    // Getters e Setters (opcional, dependendo de como o DTO será usado)
    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
