package com.perdamaianindonesia.accountingpi.penjualan.Model;

public class SuratJalan {
    private String no_surat_jalan, nama, alamat, tanggal;

    public SuratJalan() {
    }

        public SuratJalan(String no_surat_jalan, String tanggal, String nama, String alamat) {
        this.tanggal = tanggal;
        this.no_surat_jalan = no_surat_jalan;
        this.nama = nama;
        this.alamat = alamat;
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
}
