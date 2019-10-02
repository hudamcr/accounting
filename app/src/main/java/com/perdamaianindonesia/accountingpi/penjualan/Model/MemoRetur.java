package com.perdamaianindonesia.accountingpi.penjualan.Model;

public class MemoRetur {
    String tanggal,kode,nama,kesimpulan,vertifikator;
    public MemoRetur() {
    }

    public MemoRetur(String tanggal,String kode,String nama,String kesimpulan,String vertifikator) {
        this.tanggal=tanggal;
        this.kode = kode;
        this.nama = nama;
        this.kesimpulan = kesimpulan;
        this.vertifikator =vertifikator;
    }
    public String getTanggal(){return tanggal;}

    public String setTanggal(String tanggal){return tanggal;}

    public String getKode(){return kode;}

    public String setKode(String kode){return kode;}

    public String getNama(){return nama;}

    public String setNama(String nama){return nama;}

    public String getKesimpulan(){return kesimpulan;}

    public String setKesimpulan(String kesimpulan){return kesimpulan;}

    public String getVertifikator(){return vertifikator;}

    public String setVertifikator(String vertifikator){return vertifikator;}
}
