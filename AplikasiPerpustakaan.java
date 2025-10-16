import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplikasiPerpustakaan {
    private List<Petugas> daftarPetugas = new ArrayList<>();
    private List<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    private List<Buku> daftarBuku = new ArrayList<>();
    private List<Peminjaman> daftarPeminjaman = new ArrayList<>();
    private Petugas petugasAktif;

    public void inisialisasiData() {
        // Data dummy
        daftarPetugas.add(new Petugas("P1", "Admin", "admin", "pass"));
        daftarMahasiswa.add(new Mahasiswa("M1", "Mahasiswa1", "NIM001"));
        daftarBuku.add(new Buku("B1", "Java Basics", "Author1", 5));
    }

    public boolean loginPetugas(String username, String password) {
        for (Petugas petugas : daftarPetugas) {
            if (petugas.login(username, password)) {
                petugasAktif = petugas;
                return true;
            }
        }
        return false;
    }

    public void mengelolaPetugas(Scanner scanner) {
        System.out.println("Opsi: 1. Tambah Data 2. Lihat Data");
        int opsi = scanner.nextInt();
        scanner.nextLine();
        if (opsi == 1) {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            Petugas newPetugas = new Petugas(id, nama, username, password);
            daftarPetugas.add(newPetugas);
            newPetugas.tambahData(scanner);
        } else if (opsi == 2) {
            for (Petugas petugas : daftarPetugas) {
                petugas.lihatData();
            }
        }
    }

    public void mengelolaBuku(Scanner scanner) {
        System.out.println("Opsi: 1. Tambah Data 2. Lihat Data");
        int opsi = scanner.nextInt();
        scanner.nextLine();
        if (opsi == 1) {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Judul: ");
            String judul = scanner.nextLine();
            System.out.print("Penulis: ");
            String penulis = scanner.nextLine();
            System.out.print("Stok: ");
            int stok = scanner.nextInt();
            Buku newBuku = new Buku(id, judul, penulis, stok);
            daftarBuku.add(newBuku);
            newBuku.tambahData(scanner);
        } else if (opsi == 2) {
            for (Buku buku : daftarBuku) {
                buku.lihatData();
            }
        }
    }

    public void mengelolaMahasiswa(Scanner scanner) {
        System.out.println("Opsi: 1. Tambah Data 2. Lihat Data 3. Lihat Riwayat");
        int opsi = scanner.nextInt();
        scanner.nextLine();
        if (opsi == 1) {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("NIM: ");
            String nim = scanner.nextLine();
            Mahasiswa newMahasiswa = new Mahasiswa(id, nama, nim);
            daftarMahasiswa.add(newMahasiswa);
            newMahasiswa.tambahData(scanner);
        } else if (opsi == 2) {
            for (Mahasiswa mahasiswa : daftarMahasiswa) {
                mahasiswa.lihatData();
            }
        } else if (opsi == 3) {
            System.out.print("ID Mahasiswa: ");
            String idMhs = scanner.nextLine();
            for (Mahasiswa mhs : daftarMahasiswa) {
                if (mhs.getId().equals(idMhs)) {
                    mhs.lihatRiwayat();
                    break;
                }
            }
        }
    }

    public void mengelolaPeminjaman(Scanner scanner) {
        System.out.println("Opsi: 1. Pinjam Buku 2. Lihat Data");
        int opsi = scanner.nextInt();
        scanner.nextLine();
        if (opsi == 1) {
            System.out.print("ID Buku: ");
            String idBuku = scanner.nextLine();
            System.out.print("ID Mahasiswa: ");
            String idMahasiswa = scanner.nextLine();

            Buku selectedBuku = null;
            for (Buku buku : daftarBuku) {
                if (buku.getId().equals(idBuku) && buku.getStok() > 0) {
                    selectedBuku = buku;
                    break;
                }
            }
            Mahasiswa selectedMhs = null;
            for (Mahasiswa mhs : daftarMahasiswa) {
                if (mhs.getId().equals(idMahasiswa)) {
                    selectedMhs = mhs;
                    break;
                }
            }

            if (selectedBuku != null && selectedMhs != null) {
                String idPinjam = "PIN" + (daftarPeminjaman.size() + 1);
                Peminjaman peminjaman = new Peminjaman(idPinjam, petugasAktif, selectedBuku, selectedMhs);
                daftarPeminjaman.add(peminjaman);

                // Catat riwayat
                RiwayatPeminjaman riwayat = new RiwayatPeminjaman(idPinjam, LocalDate.now().toString());
                selectedMhs.tambahRiwayat(riwayat);

                peminjaman.pinjamBuku(idBuku, idMahasiswa);
            } else {
                System.out.println("Buku tidak tersedia atau Mahasiswa tidak ditemukan.");
            }
        } else if (opsi == 2) {
            for (Peminjaman pinjam : daftarPeminjaman) {
                pinjam.lihatData();
            }
        }
    }
}