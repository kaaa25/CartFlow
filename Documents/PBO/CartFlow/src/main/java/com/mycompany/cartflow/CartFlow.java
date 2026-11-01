package com.mycompany.cartflow;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import com.mycompany.DapatDikemas;

public class CartFlow {

    public static int inputAngka(Scanner sc)
            throws DataTidakValidException {

        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            throw new DataTidakValidException("Input harus berupa angka!");
        }
    }

    // Mencari barang berdasarkan nama
    public static void cariBarang(String nama,
            ArrayList<Barang> daftarBarang)
            throws DataTidakDitemukanException {

        boolean ditemukan = false;

        for (Barang barang : daftarBarang) {
            if (barang.getNama().toLowerCase()
                    .contains(nama.toLowerCase())) {

                barang.tampilkanInfoBarang();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            throw new DataTidakDitemukanException(
                    "Barang tidak ditemukan!");
        }
    }

    // Mencari barang berdasarkan harga
    public static void cariBarang(int harga,
            ArrayList<Barang> daftarBarang)
            throws DataTidakDitemukanException {

        boolean ditemukan = false;

        for (Barang barang : daftarBarang) {
            if (barang.getHargaBarang() == harga) {
                barang.tampilkanInfoBarang();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            throw new DataTidakDitemukanException(
                    "Barang tidak ditemukan!");
        }
    }

    // Menambahkan barang
    public static void tambahBarang(Scanner sc, ArrayList<Barang> daftarBarang) throws DataTidakValidException {

        System.out.println("\n========== TAMBAH BARANG ==========");

        System.out.print("Nama Barang: ");
        String nama = sc.nextLine();

        if (nama.trim().isEmpty()) {
            throw new DataTidakValidException(
                    "Nama barang tidak boleh kosong!");
        }

        System.out.print("Harga Barang: Rp");
        int harga = inputAngka(sc);

        System.out.print("Jumlah Barang: ");
        int jumlah = inputAngka(sc);

        if (harga <= 0 || jumlah <= 0) {
            throw new DataTidakValidException("Harga dan jumlah harus lebih dari 0!");
        }

        System.out.println("\nPilih Kategori:");
        System.out.println("1. Baju");
        System.out.println("2. Celana");
        System.out.println("3. Sepatu");
        System.out.println("4. Tas");
        System.out.println("5. Aksesoris");

        System.out.print("Pilih Kategori: ");
        int kategori = inputAngka(sc);

        switch (kategori) {

            case 1:
                System.out.print("Ukuran Baju: ");
                String ukuran = sc.nextLine();

                System.out.print("Warna: ");
                String warna = sc.nextLine();

                daftarBarang.add(new Baju(nama, harga, jumlah, ukuran, warna));
                break;

            case 2:
                System.out.print("Ukuran Celana: ");
                int ukuranCelana = inputAngka(sc);

                System.out.print("Model Celana: ");
                String model = sc.nextLine();

                daftarBarang.add(new Celana(nama, harga, jumlah, ukuranCelana, model));
                break;

            case 3:
                System.out.print("Ukuran Sepatu: ");
                int ukuranSepatu = inputAngka(sc);

                System.out.print("Merek Sepatu: ");
                String merek = sc.nextLine();

                daftarBarang.add(new Sepatu(nama, harga, jumlah, ukuranSepatu, merek));
                break;

            case 4:
                System.out.print("Bahan Tas: ");
                String bahan = sc.nextLine();

                System.out.print("Kapasitas Tas: ");
                int kapasitas = inputAngka(sc);

                daftarBarang.add(new Tas(nama, harga, jumlah, bahan, kapasitas));
                break;

            case 5:
                System.out.print("Jenis Aksesoris: ");
                String jenis = sc.nextLine();

                daftarBarang.add(new Aksesoris(nama, harga, jumlah, jenis));
                break;

            default:
                throw new DataTidakValidException("Kategori tidak valid!");
        }

        System.out.println("Barang berhasil ditambahkan!");
    }

    // Mengelola data anggota menggunakan HashMap
    public static void kelolaAnggota(Scanner sc,
            HashMap<String, Anggota> anggota)
            throws DataTidakValidException,
            DataTidakDitemukanException {

        boolean kembali = false;

        while (!kembali) {

            System.out.println("\n===== KELOLA DATA ANGGOTA =====");
            System.out.println("1. Tambah Anggota");
            System.out.println("2. Ubah Anggota");
            System.out.println("3. Cari Anggota");
            System.out.println("4. Hapus Anggota");
            System.out.println("5. Tampilkan Semua Anggota");
            System.out.println("6. Kembali");

            System.out.print("Pilih Menu: ");
            int pilihan = inputAngka(sc);

            String id;
            String nama;

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID/NPM: ");
                    id = sc.nextLine();

                    System.out.print("Nama Anggota: ");
                    nama = sc.nextLine();

                    if (id.trim().isEmpty()
                            || nama.trim().isEmpty()) {
                        throw new DataTidakValidException("ID dan nama tidak boleh kosong!");
                    }

                    if (anggota.containsKey(id)) {
                        throw new DataTidakValidException("ID anggota sudah terdaftar!");
                    }

                    anggota.put(id, new Anggota(id, nama));

                    System.out.println("Anggota berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.print("Masukkan ID/NPM: ");
                    id = sc.nextLine();

                    if (!anggota.containsKey(id)) {
                        throw new DataTidakDitemukanException("Anggota tidak ditemukan!");
                    }

                    System.out.print("Nama Baru: ");
                    nama = sc.nextLine();

                    if (nama.trim().isEmpty()) {
                        throw new DataTidakValidException("Nama tidak boleh kosong!");
                    }

                    anggota.get(id).setNama(nama);

                    System.out.println("Data anggota berhasil diubah!");
                    break;

                case 3:
                    System.out.print("Masukkan ID/NPM: ");
                    id = sc.nextLine();

                    if (!anggota.containsKey(id)) {
                        throw new DataTidakDitemukanException("Anggota tidak ditemukan!");
                    }

                    anggota.get(id).tampilkanInfo();
                    break;

                case 4:
                    System.out.print("Masukkan ID/NPM: ");
                    id = sc.nextLine();

                    if (!anggota.containsKey(id)) {
                        throw new DataTidakDitemukanException("Anggota tidak ditemukan!");
                    }

                    anggota.remove(id);

                    System.out.println("Anggota berhasil dihapus!");
                    break;

                case 5:
                    System.out.println("\n===== DAFTAR ANGGOTA =====");

                    if (anggota.isEmpty()) {
                        System.out.println("Belum ada anggota.");
                    } else {
                        for (String key : anggota.keySet()) {
                            anggota.get(key).tampilkanInfo();
                        }
                    }
                    break;

                case 6:
                    kembali = true;
                    break;

                default:
                    throw new DataTidakValidException("Pilihan menu tidak valid!");
            }
        }
    }

    // PROGRAM MAIN
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        //ArrayList untuk menyimpan barang
        ArrayList<Barang> daftarBarang = new ArrayList<>();

        //HashMap untuk menyimpan anggota
        HashMap<String, Anggota> anggota = new HashMap<>();

        // 3 data awal anggota
        anggota.put("23001", new Anggota("23001", "Revan"));

        anggota.put("23002", new Anggota("23002", "Ika"));

        anggota.put("23003", new Anggota("23003", "Nadia"));

        boolean isRunning = true;

        System.out.println("=================================");
        System.out.println("         SELAMAT DATANG");
        System.out.println("     CARTFLOW FASHION STORE");
        System.out.println("=================================");

        while (isRunning) {

            try {

                // MENU UTAMA
                System.out.println("\n========== MENU UTAMA ==========");
                System.out.println("1. Tambah Barang");
                System.out.println("2. Lihat Daftar Barang");
                System.out.println("3. Lihat Jumlah Barang");
                System.out.println("4. Lihat Total Harga");
                System.out.println("5. Cari Barang");
                System.out.println("6. Simulasi Layanan Barang (Dynamic Binding)");
                System.out.println("7. Kelola Data Anggota (HashMap)");
                System.out.println("8. Keluar");

                System.out.print("Pilih Menu: ");
                int pilihan = inputAngka(sc);

                switch (pilihan) {

                    // 1. Tambah Barang
                    case 1:
                        tambahBarang(sc, daftarBarang);
                        break;

                    // 2. Lihat Daftar Barang
                    case 2:
                        System.out.println("\n===== DAFTAR BARANG =====");

                        if (daftarBarang.isEmpty()) {
                            System.out.println("Belum ada barang.");
                        } else {
                            for (int i = 0;
                                    i < daftarBarang.size(); i++) {

                                System.out.println("\nBarang ke-" + (i + 1));
                                daftarBarang.get(i).tampilkanInfoBarang();
                            }
                        }
                        break;

                    // 3. Lihat Jumlah Barang
                    case 3:
                        System.out.println("\n===== JUMLAH BARANG =====");

                        System.out.println("Jumlah jenis barang: "
                                + daftarBarang.size());

                        System.out.println("Total objek barang dibuat: "
                                + Barang.totalBarangBerhasilDibuat);
                        break;

                    // 4. Lihat Total Harga
                    case 4:
                        int totalHarga = 0;

                        for (Barang barang : daftarBarang) {
                            totalHarga += barang.getTotalHarga();
                        }

                        System.out.println("\nTotal Harga: Rp" + totalHarga);
                        break;

                    // 5. Cari Barang
                    case 5:
                        System.out.println("\n===== CARI BARANG =====");
                        System.out.println("1. Berdasarkan Nama");
                        System.out.println("2. Berdasarkan Harga");

                        System.out.print("Pilih: ");
                        int cari = inputAngka(sc);

                        if (cari == 1) {
                            System.out.print("Nama Barang: ");
                            String nama = sc.nextLine();
                            cariBarang(nama, daftarBarang);
                        } else if (cari == 2) {
                            System.out.print("Harga Barang: ");
                            int harga = inputAngka(sc);
                            cariBarang(harga, daftarBarang);
                        } else {
                            throw new DataTidakValidException("Pilihan pencarian tidak valid!");
                        }
                        break;
                    // 6. Simulasi Layanan Barang (Dynamic Binding)
                    case 6:
                        if (daftarBarang.isEmpty()) {
                            throw new DataTidakDitemukanException("Belum ada barang untuk diproses!");
                        }
                        for (Barang barang : daftarBarang) {
                            barang.prosesLayanan();
                            if (barang instanceof DapatDikemas) {
                                DapatDikemas kemasan =
                                        (DapatDikemas) barang;
                                kemasan.kemasBarang();
                            }
                            if (barang instanceof BisaDiberiLabel) {
                                BisaDiberiLabel label =
                                        (BisaDiberiLabel) barang;
                                label.beriLabel();
                            }
                        }
                        break;
                    // 7. Kelola Data Anggota (HashMap)
                    case 7:
                        kelolaAnggota(sc, anggota);
                        break;
                    // 8. Keluar
                    case 8:
                        System.out.println("Terima kasih telah menggunakan CartFlow!");
                        isRunning = false;
                        break;
                    default:
                        throw new DataTidakValidException("Pilihan menu tidak valid!");
                }
            } catch (DataTidakValidException e) {

                System.out.println("\nERROR DATA TIDAK VALID: "
                        + e.getMessage());
            } catch (DataTidakDitemukanException e) {
                System.out.println("\nERROR DATA TIDAK DITEMUKAN: "
                        + e.getMessage());
            } finally {
                System.out.println("\n[FINALLY] Proses menu telah selesai.");
            }
        }
        sc.close();
    }
}