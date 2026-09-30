package com.mycompany.cartflow;

// Subclass 2 (Celana)
public class Celana extends Barang {

    private int ukuranCelana;
    private String model;

    public Celana(String nama, int harga, int jumlah,
                  int ukuranCelana, String model) {
        super(nama, harga, jumlah);
        setUkuranCelana(ukuranCelana);
        setModel(model);
    }
    public int getUkuranCelana() {
        return this.ukuranCelana;
    }
    public void setUkuranCelana(int ukuranCelana) {
        if (ukuranCelana <= 0) {
            System.out.println("Ukuran celana tidak valid.");
            this.ukuranCelana = 1;
        } else {
            this.ukuranCelana = ukuranCelana;
        }
    }
    public String getModel() {
        return this.model;
    }
    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            this.model = "Tidak diketahui";
        } else {
            this.model = model;
        }
    }

    @Override
    public void tampilkanInfoBarang() {
        super.tampilkanInfoBarang();
        System.out.printf(
            "  -> Kategori: Celana | Ukuran: %d | Model: %s%n",
            this.ukuranCelana,
            this.model
        );
    }
}