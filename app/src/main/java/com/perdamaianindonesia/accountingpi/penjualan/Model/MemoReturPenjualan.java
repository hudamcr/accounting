package com.perdamaianindonesia.accountingpi.penjualan.Model;

public class MemoReturPenjualan {
    String tanggal,kode,nama,customerservice,vertifikator;
    public MemoReturPenjualan() {
    }

    public MemoReturPenjualan(String tanggal,String kode,String nama,String customerservice,String vertifikator) {
        this.tanggal=tanggal;
        this.kode = kode;
        this.nama = nama;
        this.customerservice = customerservice;
        this.vertifikator = vertifikator;
    }
    public String getTanggal(){return tanggal;}

    public String setTanggal(String tanggal){return tanggal;}

    public String getKode(){return kode;}

    public String setKode(String kode){return kode;}


    public String getVertifikator() {
        return vertifikator;
    }

    public void setVertifikator(String vertifikator) {
        this.vertifikator = vertifikator;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getCustomerservice() {
        return customerservice;
    }

    public void setCustomerservice(String customerservice) {
        this.customerservice = customerservice;
    }

}
