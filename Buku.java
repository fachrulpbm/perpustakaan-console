import java.util.Scanner;

public class Buku {
    private String id;
    private String judul;
    private String penulis;
    private int stok;

    public Buku(String id, String judul, String penulis, int stok) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.stok = stok;
    }

    public String getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public int getStok() {
        return stok;
    }

    public void kurangiStok() {
        if (stok > 0) stok--;
    }

    public void tambahData(Scanner scanner) {
        System.out.println("Tambah data Buku: ID=" + id + ", Judul=" + judul + ", Penulis=" + penulis + ", Stok=" + stok);        
    }

    public void lihatData() {
        System.out.println("Data Buku: ID=" + id + ", Judul=" + judul + ", Penulis=" + penulis + ", Stok=" + stok);
    }
}