package com.perdamaianindonesia.accountingpi.penjualan.Model;

public class ReturPenjualan {
String tanggal,kode,nama,banyak,satuan;
    public ReturPenjualan() {
    }

    public ReturPenjualan(String tanggal,String kode,String nama,String banyak,String satuan) {
        this.tanggal=tanggal;
        this.kode = kode;
        this.nama = nama;
        this.banyak = banyak;
        this.satuan =satuan;
    }
    public String getTanggal(){return tanggal;}

    public String setTanggal(String tanggal){return tanggal;}

    public String getKode(){return kode;}

    public String setKode(String kode){return kode;}


    public String getBanyak() {
        return banyak;
    }

    public void setBanyak(String banyak) {
        this.banyak = banyak;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }
}
