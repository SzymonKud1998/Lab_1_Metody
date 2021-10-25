package com.company;

public class Main {

    public static void main(String[] args) {
        double poczatek = 1.26;
        double koniec = 2.997;
        double liczbaPrzedzialow = 90;

        M_prostokatow metodaProstokatow = new M_prostokatow(poczatek,koniec,liczbaPrzedzialow);
        M_trapezow metodaTrapezow = new M_trapezow(poczatek,koniec,liczbaPrzedzialow);
        M_Simpsona metodaSimpsona = new M_Simpsona(poczatek,koniec,liczbaPrzedzialow);

        metodaProstokatow.start();
        metodaTrapezow.start();
        metodaSimpsona.start();

        double sumaTrzech =metodaProstokatow.dzialanie()+metodaTrapezow.dzialania_funkcji()+metodaSimpsona.dzialanie();
        System.out.println(
                "Suma metod: "+sumaTrzech
        );
    }
}
