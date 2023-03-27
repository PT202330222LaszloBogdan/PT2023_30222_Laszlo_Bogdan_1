package com.example.pt2023_3022_laszlo_bogdan_1.Interfata;

import com.example.pt2023_3022_laszlo_bogdan_1.App.Polynomial;

import javax.swing.*;
import java.awt.event.ActionListener;

public class View extends JFrame{
    private JTextField polinom1= new JTextField(20);
    private JTextField polinom2=new JTextField(20);
    private JButton add=new JButton("Add");
    private JButton sub=new JButton("Subtract");
    private JButton div=new JButton("Divide");
    private JButton mul=new JButton("Multiply");
    private JButton deriv=new JButton("Derivative");
    private JButton integ=new JButton("Integrate");
    private JButton clear=new JButton("Clear");
    private JTextField total=new JTextField(20);

    public View(){
        JPanel panelText=new JPanel();
        JPanel panelBtn=new JPanel();
        JPanel panelRes=new JPanel();
        JPanel p=new JPanel();
        panelText.add(polinom1);
        panelText.add(polinom2);
        panelBtn.add(add);
        panelBtn.add(sub);
        panelBtn.add(div);
        panelBtn.add(mul);
        panelBtn.add(deriv);
        panelBtn.add(integ);
        panelRes.add(total);
        panelRes.add(clear);
        p.add(panelText);
        p.add(panelBtn);
        p.add(panelRes);
        this.setContentPane(p);
        this.pack();
        this.setTitle("Polynomial Calculator");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,200);
        this.setLocationRelativeTo(null);
    }
    String getPol1(){
        return polinom1.getText();
    }
    String getPol2(){
        return polinom2.getText();
    }
    void clearPolinom1(){polinom1.setText(" ");}
    void clearPolinom2(){polinom2.setText(" ");}
    void clearRes(){total.setText(" ");}
    void setErr(){
        total.setText("Bad Input");
    }
    void clear(ActionListener clearO) {
        clear.addActionListener(clearO);
    }
    void setRes(Polynomial polynomial){
        total.setText(polynomial.toString());
    }
    void addOp(ActionListener addO){
        add.addActionListener(addO);
    }
    void subOp(ActionListener subO){
        sub.addActionListener(subO);
    }
    void mulOp(ActionListener mulO){
        mul.addActionListener(mulO);
    }
    void derivOp(ActionListener derivO){
        deriv.addActionListener(derivO);
    }
    void integOp(ActionListener integO){
        integ.addActionListener(integO);
    }
}