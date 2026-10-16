public class Loker {
    private int nomorLoker;
    private Membership penyewa; // Asosiasi ke Membership (bisa null jika kosong)

    public Loker(int nomorLoker) {
        this.nomorLoker = nomorLoker;
        this.penyewa = null;
    }

    public int getNomorLoker() {
        return nomorLoker;
    }

    public void setNomorLoker(int nomorLoker) {
        this.nomorLoker = nomorLoker;
    }

    public Membership getPenyewa() {
        return penyewa;
    }

    public void setPenyewa(Membership penyewa) {
        this.penyewa = penyewa;
    }

    public boolean isKosong() {
        return this.penyewa == null;
    }

    // Mengisi loker dengan membership
    public void isiLoker(Membership m) {
        this.penyewa = m;
    }

    // Melepas loker: data membership dilepas dari loker, namun membership tetap aktif dan tidak dihapus
    public void lepas() {
        this.penyewa = null;
    }

    public void tampilInfo() {
        if (isKosong()) {
            System.out.println("Loker #" + nomorLoker + " : [KOSONG]");
        } else {
            System.out.println("Loker #" + nomorLoker + " : Terisi oleh " + penyewa.getNama() + " (" + penyewa.getIdMember() + ")");
        }
    }
}
