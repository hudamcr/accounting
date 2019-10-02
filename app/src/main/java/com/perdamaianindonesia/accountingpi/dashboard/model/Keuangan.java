package com.perdamaianindonesia.accountingpi.dashboard.model;

public class Keuangan {
    private String nama, nominal;

    public Keuangan() {
    }

    public Keuangan(String nama, String nominal) {
        this.nama = nama;
        this.nominal = nominal;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }
}