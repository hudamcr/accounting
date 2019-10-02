package com.perdamaianindonesia.accountingpi.penjualan.Model;

public class Kwitansi {
    String no_nota,no_surat_jalan,nilai,no_faktur_pajak;


    public Kwitansi(String no_nota,String no_surat_jalan,String nilai,String no_faktur_pajak) {
        this.no_nota=no_nota;
        this.no_surat_jalan = no_surat_jalan;
        this.no_faktur_pajak = no_faktur_pajak;
        this.nilai = nilai;
    }
    public String getNo_nota() {
        return no_nota;
    }

    public void setNo_nota(String no_nota) {
        this.no_nota = no_nota;
    }


    public String getNo_surat_jalan() {
        return no_surat_jalan;
    }

    public void setNo_surat_jalan(String no_surat_jalan) {
        this.no_surat_jalan = no_surat_jalan;
    }

    public String getNo_faktur_pajak() {
        return no_faktur_pajak;
    }
    public void setNo_faktur_pajak(String no_surat_jalan) {
        this.no_surat_jalan = no_surat_jalan;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

}
