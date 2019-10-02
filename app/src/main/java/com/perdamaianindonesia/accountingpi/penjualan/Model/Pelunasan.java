package com.perdamaianindonesia.accountingpi.penjualan.Model;

public class Pelunasan {
    private String tanggal_invoice, kode,nama, jumlah, tanggal_jatuh_tempo,pelunasan;

    public Pelunasan() {
    }

    public Pelunasan(String tanggal_invoice, String kode, String nama,String jumlah, String tanggal_jatuh_tempo,String pelunasan) {
        this.tanggal_invoice = tanggal_invoice;
        this.kode = kode;
        this.nama = nama;
        this.jumlah = jumlah;
        this.tanggal_jatuh_tempo = tanggal_jatuh_tempo;
        this.pelunasan = pelunasan;
    }

    public String getTanggal_invoice() {
        return tanggal_invoice;
    }

    public String setTanggal_invoice(String tanggal_invoice) {
        return tanggal_invoice;
    }

    public String getTanggal_jatuh_tempo() {
        return tanggal_jatuh_tempo;
    }

    public String setTanggal_jatuh_tempo(String tanggal_jatuh_tempo) {
        return tanggal_jatuh_tempo;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

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

    public String getPelunasan() {
        return pelunasan;
    }

    public void setPelunasan(String pelunasan) {
        this.pelunasan = pelunasan;
    }
}

