import java.util.Date;

public class Peminjaman {
    private String id;
    private Date tanggalPinjam;
    private String status;
    private Petugas petugas;
    private Buku buku;
    private Mahasiswa mahasiswa;

    public Peminjaman(String id, Petugas petugas, Buku buku, Mahasiswa mahasiswa) {
        this.id = id;
        this.petugas = petugas;
        this.buku = buku;
        this.mahasiswa = mahasiswa;
        this.tanggalPinjam = new Date();
        this.status = "Dipinjam";
        this.buku.kurangiStok();
    }

    public void pinjamBuku(String idBuku, String idMahasiswa) {        
        System.out.println("Peminjaman berhasil: ID=" + id + ", Buku=" + buku.getJudul() + ", Mahasiswa=" + mahasiswa.getNama() + ", Petugas=" + petugas.getNama());
    }

    public void lihatData() {
        System.out.println("Data Peminjaman: ID=" + id + ", Tanggal Pinjam=" + tanggalPinjam + ", Status=" + status);
    }
}