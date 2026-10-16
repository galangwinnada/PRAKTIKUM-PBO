public class PersonalTrainer {
    private String idTrainer;
    private String nama;
    private String spesialisasi;

    public PersonalTrainer(String idTrainer, String nama, String spesialisasi) {
        this.idTrainer = idTrainer;
        this.nama = nama;
        this.spesialisasi = spesialisasi;
    }

    public String getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(String idTrainer) {
        this.idTrainer = idTrainer;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    public void tampilInfo() {
        System.out.println("ID Trainer   : " + idTrainer);
        System.out.println("Nama Trainer : " + nama);
        System.out.println("Spesialisasi : " + spesialisasi);
    }
}
