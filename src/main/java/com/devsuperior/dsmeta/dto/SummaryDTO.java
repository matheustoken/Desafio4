package com.devsuperior.dsmeta.dto;

public class SummaryDTO {

    private String name;
    private Double sum;

    public SummaryDTO(){
    }

    public SummaryDTO(String name, Double sum) {
        this.name = name;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "SummaryDTO{" +
                "name='" + name + '\'' +
                ", sum=" + sum +
                '}';
    }
}