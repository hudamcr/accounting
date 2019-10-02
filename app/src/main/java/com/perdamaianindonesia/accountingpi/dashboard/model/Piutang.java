package com.perdamaianindonesia.accountingpi.dashboard.model;

public class Piutang {
    private String id,nama, nominal;

    public Piutang() {
    }

    public Piutang(String id,String nama, String nominal) {
        this.id=id;
        this.nama = nama;
        this.nominal = nominal;
    }

    public String getId(){return id;}

    public String setId(){return id;}

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