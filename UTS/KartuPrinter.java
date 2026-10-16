public class KartuPrinter {
    // Catatan: KartuPrinter TIDAK memiliki atribut penyimpan data member (Stateless).
    // Relasi ke Membership adalah Ketergantungan (Dependency).

    public void cetakKartu(Membership m) {
        if (m == null) {
            System.out.println("Gagal mencetak: Objek membership kosong (null).");
            return;
        }

        System.out.println("=========================================");
        System.out.println("          KARTU MEMBER GYM               ");
        System.out.println("=========================================");
        System.out.println("ID Member    : " + m.getIdMember());
        System.out.println("Nama         : " + m.getNama());
        System.out.println("Tipe Member  : " + m.getJenisMember());
        System.out.println("Durasi       : " + m.getDurasiBulan() + " Bulan");
        if (m.getTrainer() != null) {
            System.out.println("Trainer      : " + m.getTrainer().getNama() + " (" + m.getTrainer().getSpesialisasi() + ")");
        } else {
            System.out.println("Trainer      : - (Tanpa Trainer)");
        }
        System.out.println("Total Iuran  : Rp " + String.format("%,.0f", m.hitungIuran()));
        System.out.println("Status       : AKTIF");
        System.out.println("=========================================\n");
    }
}
