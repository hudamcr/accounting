package com.perdamaianindonesia.accountingpi.dashboard.model;

public class DialogSummaryPenjualan {
    private String nama, berat,qty,total;

    public DialogSummaryPenjualan() {
    }

    public DialogSummaryPenjualan(String nama,String berat,String qty, String total) {
        this.nama = nama;
        this.berat = berat;
        this.qty = qty;
        this.total=total;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
