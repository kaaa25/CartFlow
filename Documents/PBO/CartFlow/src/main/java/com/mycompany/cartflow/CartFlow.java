package com.mycompany.cartflow;

import java.util.Scanner;

public class CartFlow {
    public static void cariBarang(String nama,Barang[] daftarBarang,int jumlahBarang) {
        System.out.println("\n==== Cari Barang Berdasarkan Nama ====");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahBarang; i++) {
            if (daftarBarang[i].getNama()
                    .toLowerCase()
                    .contains(nama.toLowerCase())) {
                System.out.println("Barang ditemukan:");
                daftarBarang[i].tampilkanInfoBarang();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Barang tidak ditemukan.");
        }
    }

    // Method Overloading: cariBarang berdasarkan HARGA
    public static void cariBarang(int harga,Barang[] daftarBarang,int jumlahBarang) {
        System.out.println("\n==== Cari Barang Berdasarkan Harga ====");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahBarang; i++) {
            if (daftarBarang[i].getHargaBarang() == harga) {
                System.out.println("Barang ditemukan:");
                daftarBarang[i].tampilkanInfoBarang();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Barang tidak ditemukan.");
        }
    }
    public static void simulasiProsesBarang(Barang item){
        System.out.println("\n>>> [MEMPROSES ITEM POLIMORFIS] <<<");
        System.out.println("Memproses item: " + item.getNama() + " (Tipe Asli: " + item.getClass().getSimpleName() + ")");
        
        item.prosesLayanan();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array superclass 
        Barang[] daftarBarang = new Barang[10];
        int jumlahBarang = 0;
        boolean isRunning = true;
        System.out.println("=================================");
        System.out.println("         SELAMAT DATANG");
        System.out.println("     CARTFLOW FASHION STORE");
        System.out.println("=================================");
        while (isRunning) {
            System.out.println("\n========== MENU UTAMA ==========");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Daftar Barang");
            System.out.println("3. Lihat Jumlah Barang");
            System.out.println("4. Lihat Total Harga");
            System.out.println("5. Cari Barang");
            System.out.println("6. Simulasi Layanan Barang )Dynamic Binding");
            System.out.println("7. Keluar");
            System.out.print("Pilih Menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:
                    if (jumlahBarang < daftarBarang.length) {
                        System.out.println("\n.....Tambah Barang.....");

                        System.out.print("Nama Barang  : ");
                        String namaBarang = scanner.nextLine();

                        System.out.print("Harga Barang : Rp");
                        int hargaBarang = scanner.nextInt();

                        System.out.print("Jumlah       : ");
                        int jumlah = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("\nPilih Kategori:");
                        System.out.println("1. Baju");
                        System.out.println("2. Celana");
                        System.out.println("3. Sepatu");
                        System.out.println("4. Tas");
                        System.out.println("5. Aksesoris");
                        System.out.print("Pilihan (1-5): ");

                        int tipe = scanner.nextInt();
                        scanner.nextLine();

                        if (tipe == 1) {
                            System.out.print("Ukuran Baju (S/M/L/XL): ");
                            String ukuran = scanner.nextLine();

                            System.out.print("Warna: ");
                            String warna = scanner.nextLine();

                            daftarBarang[jumlahBarang] = new Baju(namaBarang, hargaBarang, jumlah, ukuran, warna);

                            jumlahBarang++;
                            System.out.println("Sukses! Baju berhasil ditambahkan.");
                        } else if (tipe == 2) {
                            System.out.print("Ukuran Celana: ");
                            int ukuranCelana = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Model Celana: ");
                            String model = scanner.nextLine();

                            daftarBarang[jumlahBarang] = new Celana(namaBarang, hargaBarang, jumlah, ukuranCelana, model);

                            jumlahBarang++;

                            System.out.println("Sukses! Celana berhasil ditambahkan.");
                        } else if (tipe == 3) {

                            System.out.print("Ukuran Sepatu: ");
                            int ukuranSepatu = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Merek Sepatu: ");
                            String merek = scanner.nextLine();

                            daftarBarang[jumlahBarang] = new Sepatu(namaBarang, hargaBarang,jumlah, ukuranSepatu, merek);

                            jumlahBarang++;
                            System.out.println("Sukses! Sepatu berhasil ditambahkan.");
                        } else if (tipe == 4) {
                            System.out.print("Bahan Tas: ");
                            String bahan = scanner.nextLine();

                            System.out.print("Kapasitas Tas (Liter): ");
                            int kapasitas = scanner.nextInt();
                            scanner.nextLine();

                            daftarBarang[jumlahBarang] = new Tas(namaBarang, hargaBarang,jumlah, bahan, kapasitas);
                            
                            jumlahBarang++;
                            System.out.println("Sukses! Tas berhasil ditambahkan.");
                            
                        }else if (tipe == 5){
                            System.out.println("Jenis Aksesoris (Kalung/Kacamata/Topi): ");
                            String jenis = scanner.nextLine();
                            
                            daftarBarang[jumlahBarang] = new Aksesoris(namaBarang, hargaBarang, jumlah, jenis);
                            
                            jumlahBarang++;
                            System.out.println("Sukses! Aksesoris berhasil ditambahkan.");
                        } else {
                            System.out.println("Kategori tidak valid.");
                        }
                    } else{
                        System.out.println("Maaf, kapasitas keranjang penuh.");  
                    }
                    break;

                case 2:
                    System.out.println("\n.....Daftar Barang Fashion.....");
                    if (jumlahBarang == 0) {

                        System.out.println("Belum ada barang yang tersimpan.");
                    } else {
                        for (int i = 0; i < jumlahBarang; i++) {
                            System.out.println("\n" + (i + 1) + ".");
                            daftarBarang[i].tampilkanInfoBarang();
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n.....Jumlah Barang.....");
                    System.out.println("Jumlah barang dalam keranjang: " + jumlahBarang);
                    System.out.println("Total objek Barang pernah dibuat: " + Barang.totalBarangBerhasilDibuat);
                    break;

                case 4:
                    System.out.println("\n.....Total Harga Seluruh Barang.....");
                    if (jumlahBarang == 0) {
                        System.out.println("Belum ada barang.");
                    } else {
                        int totalHarga = 0;
                        for (int i = 0; i < jumlahBarang; i++) {
                            totalHarga +=
                                daftarBarang[i].getTotalHarga();
                        }
                        System.out.println("Total Harga: Rp" + totalHarga);
                    }
                    break;

                case 5:
                    System.out.println("\n.....Cari Barang.....");
                    System.out.println("1. Cari berdasarkan Nama");
                    System.out.println("2. Cari berdasarkan Harga");
                    System.out.print("Pilih: ");

                    int pilihanCari = scanner.nextInt();
                    scanner.nextLine();

                    if (pilihanCari == 1) {
                        System.out.print("Masukkan Nama Barang: ");
                        String namaCari = scanner.nextLine();
                        cariBarang(namaCari, daftarBarang, jumlahBarang);
                    } else if (pilihanCari == 2) {
                        System.out.print("Masukkan Harga Barang: ");
                        int hargaCari = scanner.nextInt();
                        scanner.nextLine();

                        cariBarang(hargaCari,daftarBarang,jumlahBarang);
                    } else {
                        System.out.println("Pilihan pencarian tidak valid.");
                    }
                    break;

                case 6:
                    if (jumlahBarang == 0){
                        System.out.println("Keranjang masih kosong.");
                    } else {
                        System.out.println("n=== Simulasi Pengemasan / Layanan Barang ===");
                        for (int i = 0; i < jumlahBarang; i++){
                            simulasiProsesBarang(daftarBarang[i]);
                        }
                    }
                    break;
                    
                case 7:
                    System.out.println("\nTerima kasih telah menggunakan " + "CartFlow Fashion Store!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid, " + "silakan masukkan angka 1-7.");
                    break;
            }
        }

        scanner.close();
    }
}