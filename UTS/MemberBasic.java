public class MemberBasic extends Membership {
    public static final double TARIF_DASAR_PER_BULAN = 200000.0;
    public static final double BIAYA_KARTU = 50000.0;

    // Constructor MemberBasic tanpa trainer
    public MemberBasic(String idMember, String nama, int durasiBulan) {
        super(idMember, nama, durasiBulan);
    }

    // Constructor MemberBasic dengan trainer jika ingin didampingi trainer
    public MemberBasic(String idMember, String nama, int durasiBulan, PersonalTrainer trainer) {
        super(idMember, nama, durasiBulan, trainer);
    }

    // Overriding perhitungan iuran: iuran dasar (200.000 x bulan) + biaya kartu 50.000
    @Override
    public double hitungIuran() {
        double iuranDasar = TARIF_DASAR_PER_BULAN * durasiBulan;
        return iuranDasar + BIAYA_KARTU;
    }

    @Override
    public String getJenisMember() {
        return "Member Basic";
    }

    @Override
    public void tampilInfo() {
        System.out.println("=== INFO MEMBER BASIC ===");
        super.tampilInfo();
        System.out.println("Rincian      : (Rp 200.000 x " + durasiBulan + " bln) + Biaya Kartu Rp 50.000");
    }
}
