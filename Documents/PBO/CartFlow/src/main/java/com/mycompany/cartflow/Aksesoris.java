package com.mycompany.cartflow;

// Subclass 5 (Aksesoris)

import com.mycompany.DapatDikemas;
import com.mycompany.cartflow.BisaDiberiLabel;

public class Aksesoris extends Barang implements DapatDikemas, BisaDiberiLabel{

    private String jenisAksesoris;

    public Aksesoris(String nama, int harga, int jumlah, String jenisAksesoris) {
        super(nama, harga, jumlah);
        setJenisAksesoris(jenisAksesoris);
    }
    public String getJenisAksesoris() {
        return this.jenisAksesoris;
    }
    public void setJenisAksesoris(String jenisAksesoris) {
        if (jenisAksesoris == null || jenisAksesoris.trim().isEmpty()) {
            System.out.println("Jenis aksesoris tidak boleh kosong!");
            this.jenisAksesoris = "Umum";
        } else {
            this.jenisAksesoris = jenisAksesoris;
        }
    }
    @Override
    public void tampilkanInfoBarang() {
        super.tampilkanInfoBarang();
        System.out.printf("  -> Kategori: Alsesoris | jenis: %s%n", this.jenisAksesoris);
    }
    @Override
    public void prosesLayanan(){
        System.out.println("[Layanan Aksesoris] " + getNama() + " dimasukkan ke dalam kantong beludru cantik.");
    }
    @Override
    public void kemasBarang(){
        System.out.println("Aksesoris sedang dikemaas.");
    }
    @Override
    public void beriLabel(){
        System.out.println("Label kategori Aksesoris dipasang pada " + getNama() + ".");
    }
}
