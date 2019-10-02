package com.perdamaianindonesia.accountingpi.penjualan.Model;

public class DaftarPiutang {
    private String kode_pelanggan,jumlah,nama,status;

    public DaftarPiutang() {
    }

    public DaftarPiutang(String kode_pelanggan,String nama,String jumlah,String status) {
        this.kode_pelanggan=kode_pelanggan;
        this.jumlah = jumlah;
        this.nama = nama;
        this.status = status;
    }

    public String getKode_pelanggan(){return kode_pelanggan;}

    public String setKode_pelanggan(String kode_pelanggan){return kode_pelanggan;}
    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
