package com.perdamaianindonesia.accountingpi.penjualan.Model;

public class MemoOrder {
    private String tanggal,nama_costumer,kode,nama,qty;

    public MemoOrder() {
    }

    public MemoOrder(String tanggal,String nama_costumer,String kode,String nama,String qty) {
        this.tanggal=tanggal;
        this.nama_costumer = nama_costumer;
        this.kode = kode;
        this.nama = nama;
        this.qty = qty;
    }

    public String getTanggal(){return tanggal;}

    public String setTanggal(String tanggal){return tanggal;}

    public String getNama_costumer() {
        return nama_costumer;
    }

    public void setNama_costumer(String nama_costumer) {
        this.nama_costumer = nama_costumer;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}