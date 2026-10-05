package com.mycompany.cartflow;

// Subclass 1 (Baju)
public class Baju extends Barang {

    private String ukuran;
    private String warna;

    public Baju(String nama, int harga, int jumlah, String ukuran, String warna) {
        super(nama, harga, jumlah);
        setUkuran(ukuran);
        setWarna(warna);
    }
    public String getUkuran() {
        return this.ukuran;
    }
    public void setUkuran(String ukuran) {
        if (ukuran == null || ukuran.trim().isEmpty()) {
            this.ukuran = "Tidak diketahui";
        } else {
            this.ukuran = ukuran;
        }
    }
    public String getWarna() {
        return this.warna;
    }
    public void setWarna(String warna) {
        if (warna == null || warna.trim().isEmpty()) {
            this.warna = "Tidak diketahui";
        } else {
            this.warna = warna;
        }
    }
    @Override
    public void tampilkanInfoBarang() {
        super.tampilkanInfoBarang();
        System.out.printf("  -> Kategori: Baju | Ukuran: %s | Warna: %s%n", this.ukuran, this.warna);
    }
    @Override
    public void prosesLayanan(){
        System.out.println("[Layanan Baju] " + getNama() + " siap dilipat dan dikemas dalam plastik pembungkus.");
    }
}