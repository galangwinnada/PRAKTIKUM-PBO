public class Gym {
    private String namaGym;
    private Manajer manajer;       // Relasi Agregasi: Manajer mengelola Gym
    private Loker[] daftarLoker;   // Relasi Komposisi: Loker dibuat bersamaan dengan Gym

    public Gym(String namaGym, Manajer manajer, int kapasitasLoker) {
        this.namaGym = namaGym;
        this.manajer = manajer;
        // Komposisi: Loker diinisialisasi dan dibuat di dalam konstruktor Gym
        this.daftarLoker = new Loker[kapasitasLoker];
        for (int i = 0; i < kapasitasLoker; i++) {
            daftarLoker[i] = new Loker(i + 1); // Penomoran loker dari 1 sampai kapasitasLoker
        }
    }

    public String getNamaGym() {
        return namaGym;
    }

    public void setNamaGym(String namaGym) {
        this.namaGym = namaGym;
    }

    public Manajer getManajer() {
        return manajer;
    }

    public void setManajer(Manajer manajer) {
        this.manajer = manajer;
    }

    public Loker[] getDaftarLoker() {
        return daftarLoker;
    }

    public int getJumlahLoker() {
        return daftarLoker.length;
    }

    // Helper: Cek apakah member sudah menyewa salah satu loker
    public boolean sudahPunyaLoker(Membership m) {
        for (Loker loker : daftarLoker) {
            if (!loker.isKosong() && loker.getPenyewa().getIdMember().equals(m.getIdMember())) {
                return true;
            }
        }
        return false;
    }

    // Method Overloading 1: Sewa loker kosong pertama yang tersedia
    public boolean sewaLoker(Membership m) {
        if (m == null) {
            System.out.println("Gagal sewa loker: Objek membership tidak valid (null).");
            return false;
        }

        if (sudahPunyaLoker(m)) {
            System.out.println("Gagal sewa loker: Member " + m.getNama() + " (" + m.getIdMember() + ") sudah memiliki loker yang disewa.");
            return false;
        }

        for (Loker loker : daftarLoker) {
            if (loker.isKosong()) {
                loker.isiLoker(m);
                System.out.println("Berhasil: Member " + m.getNama() + " berhasil menyewa Loker #" + loker.getNomorLoker() + " (loker kosong pertama).");
                return true;
            }
        }

        System.out.println("Gagal sewa loker: Maaf, semua loker di " + namaGym + " sedang penuh.");
        return false;
    }

    // Method Overloading 2: Sewa loker pada nomor tertentu
    public boolean sewaLoker(Membership m, int nomor) {
        if (m == null) {
            System.out.println("Gagal sewa loker: Objek membership tidak valid (null).");
            return false;
        }

        if (nomor < 1 || nomor > daftarLoker.length) {
            System.out.println("Gagal sewa loker: Nomor loker #" + nomor + " tidak valid. Tersedia loker #1 s/d #" + daftarLoker.length + ".");
            return false;
        }

        if (sudahPunyaLoker(m)) {
            System.out.println("Gagal sewa loker: Member " + m.getNama() + " (" + m.getIdMember() + ") sudah memiliki loker yang disewa.");
            return false;
        }

        Loker targetLoker = daftarLoker[nomor - 1];
        if (!targetLoker.isKosong()) {
            System.out.println("Gagal sewa loker: Loker #" + nomor + " sudah disewa oleh " + targetLoker.getPenyewa().getNama() + ".");
            return false;
        }

        targetLoker.isiLoker(m);
        System.out.println("Berhasil: Member " + m.getNama() + " berhasil menyewa Loker #" + nomor + ".");
        return true;
    }

    // Melepas loker berdasarkan nomor loker (membership tetap aktif)
    public boolean lepasLoker(int nomor) {
        if (nomor < 1 || nomor > daftarLoker.length) {
            System.out.println("Gagal lepas loker: Nomor loker #" + nomor + " tidak valid.");
            return false;
        }

        Loker targetLoker = daftarLoker[nomor - 1];
        if (targetLoker.isKosong()) {
            System.out.println("Loker #" + nomor + " memang sudah kosong.");
            return false;
        }

        String namaPenyewa = targetLoker.getPenyewa().getNama();
        targetLoker.lepas(); // Membership dilepas, tetapi objek membership tetap ada dan aktif
        System.out.println("Berhasil: Loker #" + nomor + " (sebelumnya disewa oleh " + namaPenyewa + ") telah dilepas dan kini kosong.");
        return true;
    }

    // Melepas loker berdasarkan objek Membership
    public boolean lepasLoker(Membership m) {
        if (m == null) return false;
        for (Loker loker : daftarLoker) {
            if (!loker.isKosong() && loker.getPenyewa().getIdMember().equals(m.getIdMember())) {
                loker.lepas();
                System.out.println("Berhasil: Loker #" + loker.getNomorLoker() + " milik member " + m.getNama() + " telah dilepas.");
                return true;
            }
        }
        System.out.println("Member " + m.getNama() + " tidak sedang menyewa loker manapun.");
        return false;
    }

    // Menampilkan status seluruh loker
    public void tampilDaftarLoker() {
        System.out.println("\n--- Status Loker di " + namaGym + " ---");
        for (Loker loker : daftarLoker) {
            loker.tampilInfo();
        }
    }

    public void tampilInfo() {
        System.out.println("=== INFO GYM ===");
        System.out.println("Nama Gym      : " + namaGym);
        System.out.println("Manajer       : " + (manajer != null ? manajer.getNama() : "Belum ditentukan"));
        System.out.println("Jumlah Loker  : " + daftarLoker.length);
    }
}
