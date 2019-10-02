package com.perdamaianindonesia.accountingpi.penjualan.Model;

public class FakturJual {
    private String no_faktur, nama, alamat,no_faktur_pajak, tanggal,no_surat_jalan,termin;

    public FakturJual() {
    }

    public FakturJual(String no_faktur, String nama, String alamat,String no_faktur_pajak, String tanggal, String no_surat_jalan, String termin) {
        this.no_faktur = no_faktur;
        this.nama = nama;
        this.alamat = alamat;
        this.no_faktur_pajak =no_faktur_pajak;
        this.tanggal = tanggal;
        this.no_surat_jalan=no_surat_jalan;
        this.termin=termin;
    }

    public String getNo_faktur() {
        return no_faktur;
    }

    public void setNo_faktur(String no_faktur) {
        this.no_faktur = no_faktur;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_faktur_pajak() {
        return no_faktur_pajak;
    }

    public void setNo_faktur_pajak(String no_faktur_pajak) {
        this.no_faktur_pajak = no_faktur_pajak;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String setTanggal(String tanggal) {
        return tanggal;
    }

    public String getNo_surat_jalan() {
        return no_surat_jalan;
    }

    public void setNo_surat_jalan(String no_surat_jalan) {
        this.no_surat_jalan = no_surat_jalan;
    }


    public String getTermin() {
        return termin;
    }
    public void setTermin(String termin) {
        this.termin = termin;
    }
}

