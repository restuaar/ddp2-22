/**
 * Nama : Restu Ahmad Ar Ridho
 * NPM : 2206028951
 * Lab05
 */

// import library yang diperlukan
import java.util.ArrayList;
import java.util.Scanner;

public class PacilWorks {
  // iniasi variable awal
  private static ArrayList<Employee> employees = new ArrayList<>();
  private static Scanner in = new Scanner(System.in);

  /**
   * Method untuk mencetak pembatas
   */
  private static void printSeparator() {
    System.out.println("=".repeat(64));
  }

  /**
   * Method untuk menampilkan semua employee
   */
  private static void daftarEmployee() {
    // ketika daftar employee kosong
    if (employees.size() == 0) {
      System.out.println("PacilWorks tidak memiliki karyawan :(");
      printSeparator();
      return;
    }
    printSeparator();
    System.out.printf("PacilWorks memiliki %d total karyawan:\n", employees.size());
    // melakukan iterasi untuk mencetak employee
    for (Employee e : employees) {
      System.out.println("- " + e + "\n");
    }
    printSeparator();
  }

  /**
   * Method untuk meng-handle opsi simulasi n-tahun
   * 
   * @param n
   */
  private static void nextYear(int n) {
    for (Employee e : employees) {
      e.nextYear(n);
    }
  }

  /**
   * Method untuk membuat class baru dan menyimpan pada array employees
   */
  private static void handleAddEmployee() {
    System.out.print("Masukkan role employee: ");
    String role = in.nextLine();
    System.out.print("Nama: ");
    String nama = in.nextLine();

    // membagi kasus sesuai dengan input user pada role
    if (role.equalsIgnoreCase("Engineer")) {
      // meminta input user untuk side jobs
      System.out.print("Banyak Side Jobs: ");
      int banyakSideJobs = in.nextInt();
      in.nextLine();
      employees.add(new Engineer(nama, banyakSideJobs)); // menyimpan class baru
    } else if (role.equalsIgnoreCase("Secretary")) {
      // meminta input user untuk banyak tunjangan
      System.out.print("Banyak Tunjangan: ");
      double banyakTunjangan = in.nextDouble();
      in.nextLine();
      employees.add(new Secretary(nama, banyakTunjangan)); // menyimpan class baru
    } else if (role.equalsIgnoreCase("Manager")) {
      employees.add(new Manager(nama)); // menyimpan class baru
    } else { // ketika input tidak sesuai
      System.out.println("Masukkan tidak sesuai. Silahkan coba lagi!");
    }
  }

  public static void main(String[] args) {
    System.out.print("Selamat datang di PacilWorks!");
    System.out.print("\n");

    // melakukan pengulangan sampai user meminta keluar
    while (true) {
      System.out.printf("" +
          "Silakan pilih salah satu opsi berikut:\n" +
          "[1] Daftar Karyawan\n" +
          "[2] Tambah Karyawan\n" +
          "[3] Simulasi n-tahun berikutnya\n" +
          "[*] Keluar\n");
      printSeparator();

      // meminta input user
      System.out.print("Input: ");
      String pilihan = in.nextLine();

      // menghandle setiap input user sesuai dengan opsi
      if (pilihan.equals("1")) {
        daftarEmployee();
      } else if (pilihan.equals("2")) {
        handleAddEmployee();
      } else if (pilihan.equals("3")) {
        System.out.print("Masukkan banyak tahun yang ingin disimulasikan: ");
        // meminta input user untuk mendapatkan berapa tahun yang disimulasikan
        int banyakTahun = Integer.parseInt(in.nextLine());
        nextYear(banyakTahun);
        System.out.printf("%d tahun telah berlalu...\n", banyakTahun);
        printSeparator();
      } else {
        System.out.println("Terima kasih telah menggunakan layanan PacilWorks ~ !");
        break;
      }
    }

    in.close(); // menutup object scanner
  }
}