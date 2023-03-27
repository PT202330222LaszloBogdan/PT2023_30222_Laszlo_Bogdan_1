package com.example.pt2023_3022_laszlo_bogdan_1.App;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Polynomial {
    private HashMap<Integer,Double> polinom=new HashMap<>();

    public HashMap<Integer, Double> getPolinom() {
        return polinom;
    }

    public void setPolinom(HashMap<Integer, Double> polinom) {
        this.polinom = polinom;
    }

    Pattern pattern=Pattern.compile("(\\W?)(\\d{0,9}.\\d{0,9})(x\\^)(\\d{0,9})");
    public Polynomial(){
    }
    public void addMonom(Monomial mon){
        this.polinom.put(mon.getPow(), mon.getCoeff());
    }
    public void createPol(String input){
        //if(!verifInput(input)) throw  new IllegalArgumentException("Bad Input");1.0x^5-3.0x^3+2.0x^1-3.0x^0
        Matcher mat=pattern.matcher(input);
        Monomial mon=new Monomial(0,0.0);
        double coef=0.0;
        while(mat.find()){
            if(mat.group(1).equals("-")) {
                mon.setPow(Integer.parseInt(mat.group(4)));
                coef=Double.parseDouble(mat.group(2));
                mon.setCoeff(-coef);
            }
            else{
                mon.setPow(Integer.parseInt(mat.group(4)));
                coef=Double.parseDouble(mat.group(2));
                mon.setCoeff(coef);
            }
            this.addMonom(mon);
        }
    }
    boolean verifInput(String input){
        return input.matches("(^-?\\d*(\\.\\d+)?(x\\^\\d+)?([+\\-*\\/][-+]?\\d*(\\.\\d+)?(x\\^\\d+)?)?([+\\-*\\/][-+]?\\d*(\\.\\d+)?(x\\^\\d+)?)?\\s*$)");
    }
    @Override
    public String toString() {
        String s="";
        for(Map.Entry<Integer,Double> entry1: this.polinom.entrySet()){
            if(entry1.getValue()>=0) {
                s=s+"+"+entry1.getValue()+"x^"+entry1.getKey();
            } else {
                s=s+entry1.getValue()+"x^"+entry1.getKey();
            }
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polynomial that = (Polynomial) o;
        return Objects.equals(polinom, that.polinom) && Objects.equals(pattern, that.pattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(polinom, pattern);
    }
}