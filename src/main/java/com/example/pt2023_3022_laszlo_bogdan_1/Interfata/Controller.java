package com.example.pt2023_3022_laszlo_bogdan_1.Interfata;


import com.example.pt2023_3022_laszlo_bogdan_1.App.Polynomial;

public class Controller {
    View view;
    Operation op;
    public Controller(View view, Operation op){
        this.op=op;
        this.view=view;

        view.addOp(e -> {
            try {
                String input1 = view.getPol1();
                String input2 = view.getPol2();
                Polynomial pol1 = new Polynomial();
                pol1.createPol(input1);
                Polynomial pol2 = new Polynomial();
                pol2.createPol(input2);
                new Polynomial();
                Polynomial res = op.addPol(pol1, pol2);
                view.setRes(res);
            } catch (IllegalArgumentException exception) {
                view.setErr();
            }
        });
        view.subOp(e -> {
            try {
                String input1 = view.getPol1();
                String input2 = view.getPol2();
                Polynomial pol1 = new Polynomial();
                pol1.createPol(input1);
                Polynomial pol2 = new Polynomial();
                pol2.createPol(input2);
                new Polynomial();
                Polynomial res = op.subsPol(pol1, pol2);
                view.setRes(res);
            } catch (IllegalArgumentException exception) {
                view.setErr();
            }
        });
        view.mulOp(e -> {
            try {
                String input1 = view.getPol1();
                String input2 = view.getPol2();
                Polynomial pol1 = new Polynomial();
                pol1.createPol(input1);
                Polynomial pol2 = new Polynomial();
                pol2.createPol(input2);
                new Polynomial();
                Polynomial res = op.mulPol(pol1, pol2);
                view.setRes(res);
            } catch (IllegalArgumentException exception) {
                view.setErr();

            }
        });
        view.derivOp(e -> {
            try {
                String input1 = view.getPol1();
                Polynomial pol1 = new Polynomial();
                pol1.createPol(input1);
                new Polynomial();
                Polynomial res = op.derivPol(pol1);
                view.setRes(res);
            } catch (IllegalArgumentException exception){
                view.setErr();
            }
        });
        view.integOp(e -> {
            try {
                String input1 = view.getPol1();
                Polynomial pol1 = new Polynomial();
                pol1.createPol(input1);
                new Polynomial();
                Polynomial res = op.integrPol(pol1);
                view.setRes(res);
            } catch (IllegalArgumentException exception){
                view.setErr();
            }
        });
        view.clear(e -> {
            view.clearPolinom1();
            view.clearPolinom2();
            view.clearRes();
        });
    }
}