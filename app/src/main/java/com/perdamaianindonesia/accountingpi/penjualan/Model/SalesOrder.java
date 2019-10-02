package com.perdamaianindonesia.accountingpi.penjualan.Model;

public class SalesOrder {
    private String no_sales, nama, alamat, tanggal,catatan;

    public SalesOrder() {
    }

    public SalesOrder(String no_sales, String nama, String alamat, String tanggal,String catatan) {
        this.no_sales = no_sales;
        this.nama = nama;
        this.alamat = alamat;
        this.tanggal = tanggal;
        this.catatan =catatan;
    }

    public String getNo_sales() {
        return no_sales;
    }

    public void setNo_sales(String no_sales) {
        this.no_sales = no_sales;
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


    public String getTanggal() {
        return tanggal;
    }

    public String setTanggal(String tanggal) {
        return tanggal;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
}

