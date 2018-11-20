package com.company;

import com.company.supermarket.Supermarket;

public class SupermarketSimulator {

    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket("08:00", "19:30");
        supermarket.work();
    }
}
