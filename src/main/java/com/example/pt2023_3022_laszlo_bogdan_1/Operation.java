package com.example.pt2023_3022_laszlo_bogdan_1;

import java.util.Map;
import java.util.Objects;

public class Operation {

    public Polynomial addPol(Polynomial p1,Polynomial p2) {
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> entry1 : p1.polinom.entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : p2.polinom.entrySet()) {
                if (entry1.getKey().equals(entry2.getKey())) {
                        res.addMonom(new Monomial(entry1.getKey(), entry1.getValue() + entry2.getValue()));
                } else {
                    res.polinom.putIfAbsent(entry1.getKey(), entry1.getValue());
                    res.polinom.putIfAbsent(entry2.getKey(), entry2.getValue());
                }
            }
        }
        return res;
    }
    public Polynomial subsPol(Polynomial p1,Polynomial p2) {
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> entry1 : p1.polinom.entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : p2.polinom.entrySet()) {
                if (Objects.equals(entry1.getKey(), entry2.getKey())) {
                    res.addMonom(new Monomial(entry1.getKey(), entry1.getValue() - entry2.getValue()));
                } else {
                    res.polinom.putIfAbsent(entry1.getKey(), entry1.getValue());
                    res.polinom.putIfAbsent(entry2.getKey(), -entry2.getValue());
                }
            }
        }
        return res;
    }
    public Polynomial mulPol(Polynomial p1,Polynomial p2){
        Polynomial res= new Polynomial();
        for(Map.Entry<Integer,Double> entry1: p1.polinom.entrySet()){
            for(Map.Entry<Integer,Double> entry2: p2.polinom.entrySet()) {
                res.polinom.putIfAbsent(entry1.getKey() + entry2.getKey(), entry1.getValue() * entry2.getValue());

            }
        }
        return res;
    }
    public Polynomial derivPol(Polynomial p1){
        Polynomial res=new Polynomial();
        for(Map.Entry<Integer,Double> entry:p1.polinom.entrySet()){
            if(entry.getKey()!=0){
                res.polinom.putIfAbsent(entry.getKey()-1, entry.getValue()* entry.getKey());
            }
        }
        return res;
    }
    public Polynomial integrPol(Polynomial p1){
        Polynomial res=new Polynomial();
        for(Map.Entry<Integer,Double> entry:p1.polinom.entrySet()) {
            if (entry.getKey() != 0) {
                res.polinom.putIfAbsent(entry.getKey() + 1, entry.getValue() / (entry.getKey() + 1));
            } else {
                res.polinom.putIfAbsent(0, 1.0);
            }
        }
        return res;
    }
}