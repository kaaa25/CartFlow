package com.mycompany.cartflow;

// Subclass 3 (Sepatu)
public class Sepatu extends Barang {

    private int ukuranSepatu;
    private String merek;

    public Sepatu(String nama, int harga, int jumlah,
                  int ukuranSepatu, String merek) {
        super(nama, harga, jumlah);
        setUkuranSepatu(ukuranSepatu);
        setMerek(merek);
    }
    public int getUkuranSepatu() {
        return this.ukuranSepatu;
    }
    public void setUkuranSepatu(int ukuranSepatu) {
        if (ukuranSepatu <= 0) {
            System.out.println("Ukuran sepatu tidak valid.");
            this.ukuranSepatu = 1;
        } else {
            this.ukuranSepatu = ukuranSepatu;
        }
    }
    public String getMerek() {
        return this.merek;
    }
    public void setMerek(String merek) {
        if (merek == null || merek.trim().isEmpty()) {
            this.merek = "Tidak diketahui";
        } else {
            this.merek = merek;
        }
    }

    @Override
    public void tampilkanInfoBarang() {
        super.tampilkanInfoBarang();
        System.out.printf(
            "  -> Kategori: Sepatu | Ukuran: %d | Merek: %s%n",
            this.ukuranSepatu,
            this.merek
        );
    }
}