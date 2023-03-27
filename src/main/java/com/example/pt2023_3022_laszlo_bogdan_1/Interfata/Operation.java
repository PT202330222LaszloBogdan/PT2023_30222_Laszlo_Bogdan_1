package com.example.pt2023_3022_laszlo_bogdan_1.Interfata;

import com.example.pt2023_3022_laszlo_bogdan_1.App.Monomial;
import com.example.pt2023_3022_laszlo_bogdan_1.App.Polynomial;

import java.util.Map;
import java.util.Objects;

public class Operation {

    public Polynomial addPol(Polynomial p1, Polynomial p2) {
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> entry1 : p1.getPolinom().entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : p2.getPolinom().entrySet()) {
                if (entry1.getKey().equals(entry2.getKey())) {
                        res.addMonom(new Monomial(entry1.getKey(), entry1.getValue() + entry2.getValue()));
                } else {
                    res.getPolinom().putIfAbsent(entry1.getKey(), entry1.getValue());
                    res.getPolinom().putIfAbsent(entry2.getKey(), entry2.getValue());
                }
            }
        }
        return res;
    }
    public Polynomial subsPol(Polynomial p1,Polynomial p2) {
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> entry1 : p1.getPolinom().entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : p2.getPolinom().entrySet()) {
                if (Objects.equals(entry1.getKey(), entry2.getKey())) {
                    res.addMonom(new Monomial(entry1.getKey(), entry1.getValue() - entry2.getValue()));
                } else {
                    res.getPolinom().putIfAbsent(entry1.getKey(), entry1.getValue());
                    res.getPolinom().putIfAbsent(entry2.getKey(), -entry2.getValue());
                }
            }
        }
        return res;
    }
    public Polynomial mulPol(Polynomial p1,Polynomial p2){
        Polynomial res= new Polynomial();
        for(Map.Entry<Integer,Double> entry1: p1.getPolinom().entrySet()){
            for(Map.Entry<Integer,Double> entry2: p2.getPolinom().entrySet()) {
                res.getPolinom().putIfAbsent(entry1.getKey() + entry2.getKey(), entry1.getValue() * entry2.getValue());

            }
        }
        return res;
    }
    public Polynomial derivPol(Polynomial p1){
        Polynomial res=new Polynomial();
        for(Map.Entry<Integer,Double> entry: p1.getPolinom().entrySet()){
            if(entry.getKey()!=0){
                res.getPolinom().putIfAbsent(entry.getKey()-1, entry.getValue()* entry.getKey());
            }
        }
        return res;
    }
    public Polynomial integrPol(Polynomial p1){
        Polynomial res=new Polynomial();
        for(Map.Entry<Integer,Double> entry: p1.getPolinom().entrySet()) {
            if (entry.getKey() != 0) {
                res.getPolinom().putIfAbsent(entry.getKey() + 1, entry.getValue() / (entry.getKey() + 1));
            } else {
                res.getPolinom().putIfAbsent(0, 1.0);
            }
        }
        return res;
    }
}