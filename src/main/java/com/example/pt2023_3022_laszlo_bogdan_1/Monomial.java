package com.example.pt2023_3022_laszlo_bogdan_1;

public class Monomial {
    private double coeff;
    private int pow;
    public Monomial(int pow,Double coeff) {
        this.coeff = coeff;
        this.pow = pow;
    }
    public void setCoeff(Double coeff) {
        this.coeff = coeff;
    }
    public void setPow(int pow) {
        this.pow = pow;
    }
    public double getCoeff() {
        return coeff;
    }
    public int getPow() {
        return pow;
    }
}