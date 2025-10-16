public class RiwayatPeminjaman {
    private String idPeminjaman;
    private String tanggalPinjam;    
    private Mahasiswa mahasiswa;

    public RiwayatPeminjaman(String idPeminjaman, String tanggalPinjam) {
        this.idPeminjaman = idPeminjaman;
        this.tanggalPinjam = tanggalPinjam;        
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public void menyajikanRiwayat() {
        System.out.println("Riwayat: ID Peminjaman=" + idPeminjaman + ", Nama Mahasiswa= " + mahasiswa.getNama() + "Tanggal Pinjam=" + tanggalPinjam);
    }
}