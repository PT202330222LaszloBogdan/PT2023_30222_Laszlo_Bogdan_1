package com.example.pt2023_3022_laszlo_bogdan_1.App;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monomial monomial = (Monomial) o;
        return Double.compare(monomial.coeff, coeff) == 0 && pow == monomial.pow;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coeff, pow);
    }
}