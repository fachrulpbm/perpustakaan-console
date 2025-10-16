import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mahasiswa extends Pengguna {
    private String nim;
    private List<RiwayatPeminjaman> riwayatPeminjamanList = new ArrayList<>();

    public Mahasiswa(String id, String nama, String nim) {
        super(id, nama);
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void tambahRiwayat(RiwayatPeminjaman riwayat) {
        riwayatPeminjamanList.add(riwayat);
        riwayat.setMahasiswa(this);
    }

    public void lihatRiwayat() {
        System.out.println("Riwayat Peminjaman untuk Mahasiswa " + nama + ":");
        for (RiwayatPeminjaman riwayat : riwayatPeminjamanList) {
            riwayat.menyajikanRiwayat();
        }
    }

    @Override
    public void tambahData(Scanner scanner) {
        System.out.println("Tambah data Mahasiswa: ID=" + id + ", Nama=" + nama + ", NIM=" + nim);        
    }

    @Override
    public void lihatData() {
        System.out.println("Data Mahasiswa: ID=" + id + ", Nama=" + nama + ", NIM=" + nim);
    }
}