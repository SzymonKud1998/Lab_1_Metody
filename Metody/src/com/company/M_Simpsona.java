package com.company;

public class M_Simpsona extends Thread{

    private double poczatek_przedzialu;
    private double koniec_przedzialu;
    private double ilosc_Przedzialow;

    public M_Simpsona(double poczatek,double koniec, double liczbaPrzedzialow){
        this.poczatek_przedzialu =poczatek;
        this.koniec_przedzialu =koniec;
        this.ilosc_Przedzialow =liczbaPrzedzialow;
    }
    private double funkcja(double x) {
        return Math.cos(x * x + 0.5) / (1.1 + Math.sin(0.7 * x + 0.4));
    }

    public double dzialanie() {
        double suma = 0;
        double x;
        double sumat = 0;
        double h = (koniec_przedzialu - poczatek_przedzialu) / ilosc_Przedzialow;
        for (int i = 1; i < ilosc_Przedzialow + 1; i++) {
            x = poczatek_przedzialu + i * h;
            sumat += funkcja(x - h / 2);
            if (i < ilosc_Przedzialow)
                suma += funkcja(x);
        }
        return h / 6 * (funkcja(poczatek_przedzialu) + funkcja(koniec_przedzialu) + 2 * suma + 4 * sumat);
    }

    @Override
    public void run() {
        System.out.println("Simpson: " + dzialanie());
    }
}