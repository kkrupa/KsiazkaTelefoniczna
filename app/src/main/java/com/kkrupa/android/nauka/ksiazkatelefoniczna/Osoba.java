package com.kkrupa.android.nauka.ksiazkatelefoniczna;

import android.provider.ContactsContract;

/**
 * Created by kkrupa on 18.01.16.
 */
public class Osoba {

    private String imie;
    private String nazwisko;
    private String numerTelefonu;
    private String email;


    public Osoba(String imie, String nazwisko, String numerTelefonu, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerTelefonu = numerTelefonu;
        this.email = email;
    }

    public String getImie() { return imie; }

    public String getNazwisko() { return nazwisko; }

    public String getNumerTelefonu() {
        return numerTelefonu;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setNumerTelefonu(String numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }

    @Override
    public String toString() {
        return "Imię: " + imie + ", Nazwisko: " + nazwisko +
                ", Numer: " + numerTelefonu + ", E-mail: " + email;
    }
}
