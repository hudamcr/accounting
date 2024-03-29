package com.perdamaianindonesia.accountingpi.penjualan.Model;

public class JadwalPengiriman {
    private String no_surat_jalan, nama, driver,keterangan, waktu;

    public JadwalPengiriman() {
    }

    public JadwalPengiriman(String waktu, String nama, String no_surat_jalan, String driver,String keterangan) {
        this.waktu = waktu;
        this.nama = nama;
        this.no_surat_jalan = no_surat_jalan;
        this.driver = driver;
        this.keterangan = keterangan;
    }

    public String getWaktu() {
        return waktu;
    }

    public String setWaktu(String waktu) {
        return waktu;
    }

    public String getNo_surat_jalan() {
        return no_surat_jalan;
    }

    public void setNo_surat_jalan(String no_surat_jalan) {
        this.no_surat_jalan = no_surat_jalan;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
