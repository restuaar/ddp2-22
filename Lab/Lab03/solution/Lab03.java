import java.util.Arrays;
import java.util.Scanner;

class SolusiLab3 {
  private static final Scanner input = new Scanner(System.in);
  private static String[] kumpulanNamaMahasiswa;
  private static String[] kumpulanNamaMatkul;
  private static int[][] score;
  private static int jumlahMatkul;

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
    kumpulanNamaMahasiswa = Arrays.copyOf(kumpulanNamaMahasiswa, kumpulanNamaMahasiswa.length + 1);
    kumpulanNamaMahasiswa[kumpulanNamaMahasiswa.length - 1] = namaMahasiswa;

    int[][] result = new int[score.length + 1][jumlahMatkul];

    for (int i = 0; i < score.length; i++) {
      result[i] = score[i];
    }

    result[score.length] = insertedRow;
    return result;
  }

  static void init() {
    System.out.println("Selamat datang di BeJayNG!");
    System.out.println("==============Initial Input==============");
    System.out.print("Masukkan jumlah mata kuliah: ");
    jumlahMatkul = input.nextInt();
    input.nextLine();
    kumpulanNamaMatkul = new String[jumlahMatkul];
    kumpulanNamaMahasiswa = new String[0];
    score = new int[0][jumlahMatkul];
    for (int i = 0; i < jumlahMatkul; i++) {
      System.out.print("Masukkan nama mata kuliah: ");
      kumpulanNamaMatkul[i] = input.nextLine();
    }
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
    System.out.print("Masukkan nama mahasiswa: ");
    String namaMahasiswa = input.nextLine();

    int[] nilaiNilaiMatkul = new int[jumlahMatkul];

    for (int i = 0; i < jumlahMatkul; i++) {
      System.out.print("Masukkan nilai " + kumpulanNamaMatkul[i] + ": ");
      nilaiNilaiMatkul[i] = input.nextInt();
    }
    score = insertRow(nilaiNilaiMatkul, namaMahasiswa);

    System.out.printf("Nilai mahasiswa bernama %s berhasil diinput ke BeJayNG%n", namaMahasiswa);
  }

  static void menghapusMahasiswa() {
    System.out.println("==============Menghapus Mahasiswa==============");
    System.out.print("Masukkan nama mahasiswa: ");
    String namaMahasiswa = input.nextLine();

    int index = -1;
    for (int i = 0; i < kumpulanNamaMahasiswa.length; i++) {
      if (kumpulanNamaMahasiswa[i].equals(namaMahasiswa)) {
        index = i;
        break;
      }
    }

    if (index == -1) {
      System.out.printf("Mahasiswa bernama %s tidak ditemukan%n", namaMahasiswa);
      return;
    }

    score = removeElement(index);
    System.out.printf("Mahasiswa bernama %s telah dihapus dari BeJayNG%n", namaMahasiswa);
  }

  public static int[][] removeElement(int index) {
    String[] anotherArray = new String[kumpulanNamaMahasiswa.length - 1];

    for (int i = 0, k = 0; i < kumpulanNamaMahasiswa.length; i++) {
      if (i == index) {
        continue;
      }

      anotherArray[k++] = kumpulanNamaMahasiswa[i];
    }

    kumpulanNamaMahasiswa = anotherArray;

    int[][] result = new int[score.length - 1][jumlahMatkul];

    for (int i = 0, k = 0; i < score.length; i++) {
      if (i == index) {
        continue;
      }

      result[k++] = score[i];
    }

    return result;
  }

  static void mencetakTabel() {
    System.out.println("==============Mencetak Tabel==============");

    int[][] newOrder = new int[kumpulanNamaMahasiswa.length][jumlahMatkul];

    String[] kumpulanMahasiswa = new String[kumpulanNamaMahasiswa.length];

    for (int i = 0; i < kumpulanNamaMahasiswa.length; i++) {
      kumpulanMahasiswa[i] = kumpulanNamaMahasiswa[i];
    }

    for (int i = 0; i < kumpulanMahasiswa.length; i++) {
      for (int j = 0; j < kumpulanNamaMahasiswa.length; j++) {
        if (kumpulanMahasiswa[i].equals(kumpulanNamaMahasiswa[j])) {
          newOrder[i] = score[j];
          break;
        }
      }
    }

    System.out.print("Nama\t\t\t");

    for (int i = 0; i < jumlahMatkul; i++) {
      System.out.print(kumpulanNamaMatkul[i] + "\t");
    }
    System.out.println();

    for (int i = 0; i < score.length; i++) {
      System.out.print(kumpulanMahasiswa[i] + "\t\t\t");
      for (int j = 0; j < jumlahMatkul; j++) {
        System.out.print(newOrder[i][j] + "\t");
      }
      System.out.println();
    }
  }

  static void mencetakNilai() {
    System.out.println("==============Mencetak Nilai==============");
    System.out.print("Masukkan nama mahasiswa: ");
    String namaMahasiswa = input.nextLine();
    System.out.print("Masukkan nama mata kuliah: ");
    String namaMatkul = input.nextLine();

    int indexMahasiswa = -1;
    for (int i = 0; i < kumpulanNamaMahasiswa.length; i++) {
      if (kumpulanNamaMahasiswa[i].equals(namaMahasiswa)) {
        indexMahasiswa = i;
        break;
      }
    }

    int indexMatkul = -1;
    for (int i = 0; i < kumpulanNamaMatkul.length; i++) {
      if (kumpulanNamaMatkul[i].equals(namaMatkul)) {
        indexMatkul = i;
        break;
      }
    }

    System.out.printf("Nilai %s di mata kuliah %s adalah %d%n", namaMahasiswa, namaMatkul,
        score[indexMahasiswa][indexMatkul]);
  }
}