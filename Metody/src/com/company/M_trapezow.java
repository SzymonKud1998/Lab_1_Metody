package com.company;

public class M_trapezow extends Thread{

    private double poczatek_przedzialu;
    private double koniec_przedzialu;
    private double ilosc_Przedzialow;

    public M_trapezow(double poczatek,double koniec, double liczbaPrzedzialow){
        this.poczatek_przedzialu =poczatek;
        this.koniec_przedzialu =koniec;
        this.ilosc_Przedzialow =liczbaPrzedzialow;
    }

    private double funkcja(double x) {
        return Math.cos(x * x + 0.5) / (1.1 + Math.sin(0.7 * x + 0.4));
    }

    public double dzialania_funkcji(){
        double dx = (koniec_przedzialu - poczatek_przedzialu) / ilosc_Przedzialow;
        double sumowanie = 0;
        double xi;
        for(int i = 0; i< ilosc_Przedzialow; i++){
            xi= poczatek_przedzialu + (i/ ilosc_Przedzialow) * (koniec_przedzialu - poczatek_przedzialu);
            sumowanie += funkcja(xi);
        }
        return dx * (funkcja(poczatek_przedzialu)/2 + sumowanie + funkcja(koniec_przedzialu)/2);
    }

    @Override
    public void run() {
        System.out.println("Trapez: " + dzialania_funkcji());
    }
}