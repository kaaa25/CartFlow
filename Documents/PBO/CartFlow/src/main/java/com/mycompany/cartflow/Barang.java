package com.mycompany.cartflow;

// Superclass / class induk
public class Barang {

    private String nama;
    private int harga;
    private int jumlah;
    
    public static int totalBarangBerhasilDibuat = 0;

    public Barang(String nama, int harga, int jumlah) {
        setNama(nama);
        setHargaBarang(harga);
        setJumlah(jumlah);
        totalBarangBerhasilDibuat++;
    }

    // Getter dan Setter Nama
    public String getNama() {
        return this.nama;
    }
    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("Nama tidak boleh kosong.");
            this.nama = "Barang Tanpa Nama";
        } else {
            this.nama = nama;
        }
    }

    // Getter dan Setter Harga
    public int getHargaBarang() {
        return this.harga;
    }
    public void setHargaBarang(int harga) {
        if (harga < 0) {
            System.out.println("Harga tidak boleh negatif, diatur ke 0.");
            this.harga = 0;
        } else {
            this.harga = harga;
        }
    }

    // Getter dan Setter Jumlah
    public int getJumlah() {
        return this.jumlah;
    }
    public void setJumlah(int jumlah) {
        if (jumlah < 0) {
            System.out.println("Jumlah tidak boleh negatif, diatur ke 0.");
            this.jumlah = 0;
        } else {
            this.jumlah = jumlah;
        }
    }
    public int getTotalHarga() {
        return getHargaBarang() * getJumlah();
    }
    public void tampilkanInfoBarang() {
        System.out.printf(
            "Nama: %-20s | Harga: Rp%-10d | Jumlah: %-3d | Total: Rp%d%n",
            this.nama,
            this.harga,
            this.jumlah,
            getTotalHarga()
        );
    }
}