import java.util.Scanner;

class Template {
  private static final Scanner input = new Scanner(System.in);
  private static String[] kumpulanNamaMahasiswa;
  private static String[] kumpulanNamaMatkul;
  private static int[][] score;
  private static int banyakMatkul;

  public static void main(String[] args) {
    init();

    while (true) {
      printMenu();
      System.out.print("Masukkan pilihan: ");
      int pilihan = input.nextInt();
      input.nextLine();
      switch (pilihan) {
        case 1:
          menambahMahasiswa();
          break;
        case 2:
          menghapusMahasiswa();
          break;
        case 3:
          mencetakTabel();
          break;
        case 4:
          mencetakNilai();
          break;
        case 0:
          System.out.println("Terima kasih telah menggunakan BeJayNG!");
          System.exit(0);
          break;
        default:
          System.out.println("Pilihan tidak valid!");
          break;
      }
    }
  }

  public static int[][] insertRow(int[] insertedRow, String namaMahasiswa) {
    // TODO: Insert row baru ke dalam array 2D score dan kumpulanNamaMahasiswa
    return null;
  }

  static void init() {
    System.out.println("Selamat datang di BeJayNG!");
    System.out.println("==============Initial Input==============");

    // TODO: Inisialisasi array 2D score, kumpulanNamaMatkul dan
    // kumpulanNamaMahasiswa
    return;
  }

  static void printMenu() {
    System.out.println("==============Menu==============");
    System.out.println("[1] Menambah Mahasiswa");
    System.out.println("[2] Menghapus Mahasiswa");
    System.out.println("[3] Mencetak Tabel");
    System.out.println("[4] Mencetak Nilai");
    System.out.println("[0] Keluar");
  }

  static void menambahMahasiswa() {
    System.out.println("==============Menambah Mahasiswa==============");

    // TODO: Menambahkan mahasiswa baru ke dalam array 2D score dan
    // kumpulanNamaMahasiswa
    return;
  }

  static void menghapusMahasiswa() {
    System.out.println("==============Menghapus Mahasiswa==============");

    // TODO: Menghapus mahasiswa dari array 2D score dan kumpulanNamaMahasiswa
    return;
  }

  public static int[][] removeElement(int index) {
    // TODO: Kamu bisa gunakan method ini untuk menghapus mahasiswa dari array 2D
    // score dan kumpulanNamaMahasiswa

    return null;
  }

  static void mencetakTabel() {
    System.out.println("==============Mencetak Tabel==============");

    // TODO: Mencetak tabel nilai berdasarkan urutan mahasiswa ketika diinput
    return;
  }

  static void mencetakNilai() {
    System.out.println("==============Mencetak Nilai==============");

    // TODO: Mencetak nilai matakuliah seorang siswa
    return;
  }
}