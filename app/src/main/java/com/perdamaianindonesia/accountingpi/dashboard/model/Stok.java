package com.perdamaianindonesia.accountingpi.dashboard.model;

public class Stok {
    private String nama,stok, nominal;

    public Stok() {
    }

    public Stok(String nama,String stok, String nominal) {
        this.nama=nama;
        this.stok = stok;
        this.nominal = nominal;
    }

    public String getStok(){return stok;}

    public String setStok(String stok){return stok;}

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