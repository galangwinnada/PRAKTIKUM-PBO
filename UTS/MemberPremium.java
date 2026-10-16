public class MemberPremium extends Membership {
    public static final double TARIF_PREMIUM_PER_BULAN = 350000.0;
    public static final double DISKON_LEBIH_6_BULAN = 0.20; // 20% diskon

    public MemberPremium(String idMember, String nama, int durasiBulan) {
        super(idMember, nama, durasiBulan);
    }

    public MemberPremium(String idMember, String nama, int durasiBulan, PersonalTrainer trainer) {
        super(idMember, nama, durasiBulan, trainer);
    }

    // Overriding perhitungan iuran: Rp 350.000 x bulan, diskon 20% jika bulan > 6
    @Override
    public double hitungIuran() {
        double subtotal = TARIF_PREMIUM_PER_BULAN * durasiBulan;
        if (durasiBulan > 6) {
            double potongan = subtotal * DISKON_LEBIH_6_BULAN;
            return subtotal - potongan;
        }
        return subtotal;
    }

    @Override
    public String getJenisMember() {
        return "Member Premium";
    }

    @Override
    public void tampilInfo() {
        System.out.println("=== INFO MEMBER PREMIUM ===");
        super.tampilInfo();
        double subtotal = TARIF_PREMIUM_PER_BULAN * durasiBulan;
        if (durasiBulan > 6) {
            double potongan = subtotal * DISKON_LEBIH_6_BULAN;
            System.out.println("Rincian      : Subtotal Rp " + String.format("%,.0f", subtotal) + 
                               " - Diskon 20% (Rp " + String.format("%,.0f", potongan) + ")");
        } else {
            System.out.println("Rincian      : Rp 350.000 x " + durasiBulan + " bln (Tanpa Diskon, durasi <= 6 bulan)");
        }
    }
}
