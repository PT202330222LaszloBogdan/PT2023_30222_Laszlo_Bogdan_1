package com.example.pt2023_3022_laszlo_bogdan_1;
public class Main {
    public static void main(String[] args) {
        View view=new View();
        Operation operation=new Operation();
        new Controller(view, operation);
    }
}