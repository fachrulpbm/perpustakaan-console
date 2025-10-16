import java.util.Scanner;

public class Petugas extends Pengguna {
    private String username;
    private String password;

    public Petugas(String id, String nama, String username, String password) {
        super(id, nama);
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public void tambahData(Scanner scanner) {
        System.out.println("Tambah data Petugas: ID=" + id + ", Nama=" + nama + ", Username=" + username);        
    }

    @Override
    public void lihatData() {
        System.out.println("Data Petugas: ID=" + id + ", Nama=" + nama + ", Username=" + username);
    }
}