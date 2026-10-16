public abstract class Membership {
    protected String idMember;
    protected String nama;
    protected int durasiBulan;
    protected PersonalTrainer trainer;

    public Membership(String idMember, String nama, int durasiBulan) {
        this.idMember = idMember;
        this.nama = nama;
        this.durasiBulan = durasiBulan;
        this.trainer = null; // Default tanpa trainer
    }

    public Membership(String idMember, String nama, int durasiBulan, PersonalTrainer trainer) {
        this.idMember = idMember;
        this.nama = nama;
        this.durasiBulan = durasiBulan;
        this.trainer = trainer;
    }

    public String getIdMember() {
        return idMember;
    }

    public void setIdMember(String idMember) {
        this.idMember = idMember;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getDurasiBulan() {
        return durasiBulan;
    }

    public void setDurasiBulan(int durasiBulan) {
        this.durasiBulan = durasiBulan;
    }

    public PersonalTrainer getTrainer() {
        return trainer;
    }

    public void setTrainer(PersonalTrainer trainer) {
        this.trainer = trainer;
    }

    // Method Overloading 1: Menambah 1 bulan
    public void perpanjang() {
        this.durasiBulan += 1;
        System.out.println("Membership " + nama + " diperpanjang 1 bulan. Durasi sekarang: " + this.durasiBulan + " bulan.");
    }

    // Method Overloading 2: Menambah sesuai argumen tambahan bulan
    public void perpanjang(int tambahan) {
        if (tambahan > 0) {
            this.durasiBulan += tambahan;
            System.out.println("Membership " + nama + " diperpanjang " + tambahan + " bulan. Durasi sekarang: " + this.durasiBulan + " bulan.");
        } else {
            System.out.println("Jumlah perpanjangan bulan harus lebih dari 0.");
        }
    }

    // Method Abstract yang wajib di-override oleh subclass (Polimorfisme)
    public abstract double hitungIuran();

    public abstract String getJenisMember();

    public void tampilInfo() {
        System.out.println("ID Member    : " + idMember);
        System.out.println("Nama         : " + nama);
        System.out.println("Jenis Member : " + getJenisMember());
        System.out.println("Durasi       : " + durasiBulan + " bulan");
        if (trainer != null) {
            System.out.println("Trainer      : " + trainer.getNama() + " (" + trainer.getSpesialisasi() + ")");
        } else {
            System.out.println("Trainer      : Tanpa Trainer");
        }
        System.out.println("Total Iuran  : Rp " + String.format("%,.0f", hitungIuran()));
    }
}
