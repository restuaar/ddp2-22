
/**
 * Nama : Restu Ahmad Ar Ridho
 * NPM : 2206028951
 * Lab08
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Lab08 {
  // membuat properti agar dapat dilakukan modifikasi
  static Scanner in = new Scanner(System.in);
  static String[] daftarLagu = new String[0];

  public static void main(String[] args) {

    // membuat try untuk handle exception
    try {
      // meminta input nama file pertama
      System.out.print("File playlist pertama: ");
      String filePertama = in.nextLine();

      // membungkus file dan mendapatkan scanner
      File fileInput = new File(filePertama);
      Scanner scannerFile = new Scanner(fileInput);

      // melakukan iterasi setiap baris
      String text;
      while (scannerFile.hasNextLine()) {
        text = scannerFile.nextLine();
        generateLagu(text);
      }

      scannerFile.close(); // menutup object scanner

      // meminta input nama file kedua
      System.out.print("File playlist kedua: ");
      String fileKedua = in.nextLine();

      // membungkus file dan mendapatkan scanner
      fileInput = new File(fileKedua);
      scannerFile = new Scanner(fileInput);

      // melakukan iterasi setiap baris
      while (scannerFile.hasNextLine()) {
        text = scannerFile.nextLine();
        generateLagu(text);
      }

      scannerFile.close(); // menutup scanner

      // meminta input file output
      System.out.print("File playlist output: ");
      String fileOutput = in.nextLine();

      // menulis kedalam file output sesuai dengan list lagu
      PrintWriter output = new PrintWriter(fileOutput);
      for (int i = 0; i < daftarLagu.length; i++) {
        output.println(daftarLagu[i]);
      }

      output.close(); // menutup scanner

      System.out.printf("Berhasil menimpa playlist, jumlah lagu adalah: %d", daftarLagu.length);

    } catch (InvalidPlaylistException e) { // handle error ketika playlist invalid
      System.out.println("Playlist tidak valid!");

    } catch (FileNotFoundException e) { // handle error ketika file input tidak ditemukan
      System.out.println("File tidak ditemukan!");
    }
  }

  /**
   * Method untuk melakukan cek lagu
   * 
   * @param text -> String format lagu
   * @throws InvalidPlaylistException
   */
  private static void generateLagu(String text) throws InvalidPlaylistException {
    String[] lagu = text.split("\\|\\|"); // membagi artist dan title
    // melakukan pengecekan dari hasil pembagian lagu
    switch (lagu.length) {
      case 2 -> addLagu(text);
      default -> throw new InvalidPlaylistException();
    }
  }

  /**
   * Method untuk mengecek dan menambahkan lagu kedalam daftarLagu
   * 
   * @param list -> array berisikan artist dan title
   */
  private static void addLagu(String list) {
    // melakukan pengecekan lagu sebelumnya
    for (String lagu : daftarLagu) {
      if (list.equals(lagu)) {
        return;
      }
    }

    // menambahkan lagu
    daftarLagu = Arrays.copyOf(daftarLagu, daftarLagu.length + 1);
    daftarLagu[daftarLagu.length - 1] = list;
  }
}

/**
 * Class InvalidPlayException yang merupakan subclass dari Exception untuk
 * lagu yang invalid
 */
class InvalidPlaylistException extends Exception {
}
