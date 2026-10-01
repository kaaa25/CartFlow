package com.mycompany.cartflow;

// Subclass 4 (Tas)
public class Tas extends Barang {

    private String bahan;
    private int kapasitasLiter;

    public Tas(String nama, int harga, int jumlah, String bahan, int kapasitasLiter) {
        super(nama, harga, jumlah);
        setBahan(bahan);
        setKapasitasLiter(kapasitasLiter);
    }
    public String getBahan() {
        return this.bahan;
    }
    public void setBahan(String bahan) {
        if (bahan == null || bahan.trim().isEmpty()) {
            this.bahan = "Tidak diketahui";
        } else {
            this.bahan = bahan;
        }
    }
    public int getKapasitasLiter() {
        return this.kapasitasLiter;
    }
    public void setKapasitasLiter(int kapasitasLiter) {
        if (kapasitasLiter <= 0) {
            System.out.println("Kapasitas tas tidak valid.");
            this.kapasitasLiter = 1;
        } else {
            this.kapasitasLiter = kapasitasLiter;
        }
    }

    @Override
    public void tampilkanInfoBarang() {
        super.tampilkanInfoBarang();
        System.out.printf(
            "  -> Kategori: Tas | Bahan: %s | Kapasitas: %d Liter%n",
            this.bahan,
            this.kapasitasLiter
        );
    }
}