package com.company;
import produse.*;
import comanda.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Produs myobj= new Produs();
        Produs myobj1= new Produs();
        myobj.setNr(0);
        myobj.setNr(1);
        myobj.setPret(10);
        myobj1.setPret(5);
        ArrayList<Integer> cumparate = new ArrayList<>();
        cumparate.add(myobj.getNr());
        cumparate.add(myobj1.getNr());
        for(int i: cumparate)
            System.out.println(i);
        Cos unu= new Cos();
        unu.setTotal(myobj);
        unu.setTotal(myobj1);
       System.out.println(unu.getTotal());
    }
}
