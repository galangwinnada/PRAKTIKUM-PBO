public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================================");
        System.out.println("           SIMULASI SISTEM GYM & MEMBERSHIP (UTS PBO)           ");
        System.out.println("=================================================================\n");

        // 1. Inisialisasi Manajer (Agregasi dengan Gym)
        Manajer manajer = new Manajer("M-01", "Budi Santoso");

        // 2. Inisialisasi Gym beserta Loker (Komposisi: Loker dibuat di dalam Gym)
        Gym fitnessCenter = new Gym("FitLife Megagym", manajer, 5);
        fitnessCenter.tampilInfo();
        System.out.println();

        // 3. Inisialisasi Personal Trainer (1 Trainer dapat mendampingi banyak member)
        PersonalTrainer trainerAde = new PersonalTrainer("PT-001", "Ade Raihan", "Bodybuilding & Hypertrophy");
        PersonalTrainer trainerLisa = new PersonalTrainer("PT-002", "Lisa Weight", "Fat Loss & Cardio");

        System.out.println("--- DAFTAR PERSONAL TRAINER ---");
        trainerAde.tampilInfo();
        System.out.println();
        trainerLisa.tampilInfo();
        System.out.println();

        // 4. Inisialisasi Member Basic
        // - Aturan: Boleh tanpa trainer, iuran = (200.000 * durasi) + 50.000 biaya kartu
        System.out.println("--- 1. PENGUJIAN MEMBER BASIC ---");
        MemberBasic member1 = new MemberBasic("MB-001", "Galang Satriyo", 3); // Tanpa trainer
        MemberBasic member2 = new MemberBasic("MB-002", "Rina Permata", 2, trainerLisa); // Dengan trainer

        member1.tampilInfo();
        System.out.println();
        member2.tampilInfo();
        System.out.println();

        // 5. Inisialisasi Member Premium
        // - Aturan: Rp 350.000 x bulan, diskon 20% jika bulan > 6
        System.out.println("--- 2. PENGUJIAN MEMBER PREMIUM (ATURAN DISKON) ---");
        MemberPremium member3 = new MemberPremium("MP-001", "Doni Prasetyo", 4, trainerAde); // <= 6 bulan, tanpa diskon
        MemberPremium member4 = new MemberPremium("MP-002", "Siti Aminah", 10, trainerAde);  // > 6 bulan, diskon 20%

        member3.tampilInfo();
        System.out.println();
        member4.tampilInfo();
        System.out.println();

        // 6. Pengujian Method Overloading pada Membership (perpanjang() dan perpanjang(int tambahan))
        System.out.println("--- 3. PENGUJIAN OVERLOADING PERPANJANGAN MEMBERSHIP ---");
        System.out.println("[Uji 1] Perpanjang 1 bulan tanpa argumen: perpanjang()");
        System.out.println("Durasi sebelum: " + member1.getDurasiBulan() + " bulan. Iuran: Rp " + String.format("%,.0f", member1.hitungIuran()));
        member1.perpanjang(); // 3 -> 4 bulan
        System.out.println("Iuran setelah diperpanjang 1 bulan: Rp " + String.format("%,.0f", member1.hitungIuran()) + "\n");

        System.out.println("[Uji 2] Perpanjang dengan argumen tambahan: perpanjang(int tambahan)");
        System.out.println("Durasi member3 sebelum: " + member3.getDurasiBulan() + " bulan (Belum dapat diskon).");
        member3.perpanjang(4); // 4 + 4 = 8 bulan (> 6 bulan, sekarang berhak diskon 20%!)
        System.out.println("Durasi sekarang: " + member3.getDurasiBulan() + " bulan.");
        System.out.println("Iuran setelah diperpanjang (otomatis dapat diskon 20%): Rp " + String.format("%,.0f", member3.hitungIuran()) + "\n");

        // 7. Pengujian Method Overloading pada Gym (Sewa Loker)
        System.out.println("--- 4. PENGUJIAN OVERLOADING SEWA LOKER ---");
        fitnessCenter.tampilDaftarLoker();
        System.out.println();

        // Overloading 1: sewaLoker(Membership m) -> memakai loker kosong pertama
        System.out.println("[Uji Sewa 1] sewaLoker(member1) - mencari loker kosong pertama:");
        fitnessCenter.sewaLoker(member1); // Akan mengisi Loker #1

        // Overloading 2: sewaLoker(Membership m, int nomor) -> memakai loker nomor tertentu
        System.out.println("\n[Uji Sewa 2] sewaLoker(member3, 3) - memilih Loker #3 secara spesifik:");
        fitnessCenter.sewaLoker(member3, 3); // Akan mengisi Loker #3

        System.out.println("\n[Uji Sewa 3] sewaLoker(member2) - mencari loker kosong berikutnya:");
        fitnessCenter.sewaLoker(member2); // Akan mengisi Loker #2

        System.out.println("\n[Uji Sewa 4] sewaLoker(member4, 3) - mencoba memilih Loker #3 yang sudah terisi:");
        fitnessCenter.sewaLoker(member4, 3); // Harus gagal karena loker 3 sudah dipakai

        System.out.println("\n[Uji Sewa 5] sewaLoker(member1) - mencoba sewa lagi padahal sudah punya loker:");
        fitnessCenter.sewaLoker(member1); // Harus gagal karena member1 sudah punya loker

        fitnessCenter.tampilDaftarLoker();
        System.out.println();

        // 8. Pengujian Pelepasan Loker & Verifikasi Membership Tetap Aktif
        System.out.println("--- 5. PENGUJIAN PELEPASAN LOKER (MEMBERSHIP TETAP AKTIF) ---");
        System.out.println("Status member1 sebelum loker dilepas: " + member1.getNama() + " (" + member1.getIdMember() + ")");
        fitnessCenter.lepasLoker(1); // Melepas loker nomor 1
        fitnessCenter.tampilDaftarLoker();

        System.out.println("\nVerifikasi Membership setelah loker dilepas:");
        System.out.println("ID Member    : " + member1.getIdMember());
        System.out.println("Nama         : " + member1.getNama());
        System.out.println("Durasi Aktif : " + member1.getDurasiBulan() + " bulan");
        System.out.println("Status       : TETAP AKTIF (Membership tidak terpengaruh pelepasan loker)\n");

        // 9. Pengujian Pencetakan Kartu oleh KartuPrinter (Dependency)
        System.out.println("--- 6. PENGUJIAN KARTU PRINTER (DEPENDENCY) ---");
        KartuPrinter printer = new KartuPrinter();
        printer.cetakKartu(member1);
        printer.cetakKartu(member3);
        printer.cetakKartu(member4);

        System.out.println("=================================================================");
        System.out.println("                 SEMUA SKENARIO BERHASIL DIUJI!                  ");
        System.out.println("=================================================================");
    }
}
