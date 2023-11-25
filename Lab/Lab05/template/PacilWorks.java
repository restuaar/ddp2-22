import java.util.ArrayList;
import java.util.Scanner;

public class PacilWorks {
  private static ArrayList<Employee> employees = new ArrayList<>();
  private static Scanner in = new Scanner(System.in);

  private static void printSeparator() {
    System.out.println("=".repeat(64));
  }

  private static void daftarEmployee() {
    if (employees.size() == 0) {
      System.out.println("PacilWorks tidak memiliki karyawan :(");
      printSeparator();
      return;
    }
    printSeparator();
    System.out.printf("PacilWorks memiliki %d total karyawan:\n", employees.size());
    for (Employee e : employees) {
      System.out.println("- " + e);
    }
    printSeparator();
  }

  private static void nextYear(int n) {
    for (Employee e : employees) {
      e.nextYear(n);
    }
  }

  private static void handleAddEmployee() {
    System.out.print("Masukkan role employee: ");
    String role = in.nextLine();

    if (role.equalsIgnoreCase("Engineer")) {
      // TODO tambahkan engineer ke array employees

    } else if (role.equalsIgnoreCase("Secretary")) {
      // TODO tambahkan secretary ke array employees

    } else if (role.equalsIgnoreCase("Manager")) {
      // TODO tambahkan manager ke array employees

    } else {
      System.out.println("Masukkan tidak sesuai. Silahkan coba lagi!");
    }
  }

  public static void main(String[] args) {
    System.out.print("Selamat datang di PacilWorks!");
    System.out.print("\n");

    while (true) {
      System.out.printf("" +
          "Silakan pilih salah satu opsi berikut:\n" +
          "[1] Daftar Karyawan\n" +
          "[2] Tambah Karyawan\n" +
          "[3] Simulasi n-tahun berikutnya\n" +
          "[*] Keluar\n");
      printSeparator();

      System.out.print("Input: ");
      String pilihan = in.nextLine();

      if (pilihan.equals("1")) {
        daftarEmployee();
      } else if (pilihan.equals("2")) {
        handleAddEmployee();
      } else if (pilihan.equals("3")) {
        System.out.print("Masukkan banyak tahun yang ingin disimulasikan: ");
        int banyakTahun = Integer.parseInt(in.nextLine());
        nextYear(banyakTahun);
        System.out.printf("%d tahun telah berlalu...\n", banyakTahun);
        printSeparator();
      } else {
        System.out.println("Terima kasih telah menggunakan layanan PacilWorks ~ !");
        break;
      }
    }

    in.close();
  }
}