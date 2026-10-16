public class Manajer {
    private String idManajer;
    private String nama;

    public Manajer(String idManajer, String nama) {
        this.idManajer = idManajer;
        this.nama = nama;
    }

    public String getIdManajer() {
        return idManajer;
    }

    public void setIdManajer(String idManajer) {
        this.idManajer = idManajer;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void tampilInfo() {
        System.out.println("ID Manajer : " + idManajer);
        System.out.println("Nama       : " + nama);
    }
}
