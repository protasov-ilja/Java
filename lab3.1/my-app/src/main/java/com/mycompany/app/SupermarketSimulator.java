package com.mycompany.app;

import com.mycompany.app.supermarket.Supermarket;

public class SupermarketSimulator {
    public static void main(String[] args) {
        try {
            Supermarket supermarket = new Supermarket("08:00", "19:30");
            supermarket.work();
        } catch (Exception er) {
            System.out.println(er.getMessage());
        }
    }
}
