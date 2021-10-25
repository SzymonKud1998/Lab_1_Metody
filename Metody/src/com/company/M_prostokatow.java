package com.company;

public class M_prostokatow extends Thread{

    private double poczatek_przedzialu;
    private double koniec_przedzialu;
    private double ilosc_Przedzialow;

    public M_prostokatow(double poczatek,double koniec, double liczbaPrzedzialow){
        this.poczatek_przedzialu =poczatek;
        this.koniec_przedzialu =koniec;
        this.ilosc_Przedzialow =liczbaPrzedzialow;
    }

    private double funkcja(double x) {
        return Math.cos(x * x + 0.5) / (1.1 + Math.sin(0.7 * x + 0.4));
    }

    public double dzialanie(){
        double n = ilosc_Przedzialow;
        double dx = (koniec_przedzialu - poczatek_przedzialu) / ilosc_Przedzialow;
        double y = 0;
        for (int i=1; i<=n; i++) {
            y += funkcja(poczatek_przedzialu + i * dx);
        }
        double wynik = y * dx;
        return wynik;
    }

    @Override
    public void run() {
        System.out.println("Prostokaty: " + dzialanie());
    }
}