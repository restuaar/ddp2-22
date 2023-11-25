
/**
 * Nama : Restu Ahmad Ar Ridho
 * NPM : 2206028951
 * Lab06
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Starcil {
  // iniasi variabel awal
  private static InputReader in;
  private static PrintWriter out;
  private static Beverage[] daftarMinuman = new Beverage[0];

  /**
   * Method untuk memasukkan minuman baru kedalam daftar minuman
   * 
   * @param beverage
   */
  private static void masukkanKeDaftarMinuman(Beverage beverage) {
    // membuat array baru dengan panjang lebih satu dari sebelumnya
    Beverage[] newDaftarMinuman = new Beverage[daftarMinuman.length + 1];
    // melakukan copy dari array sebelumnya
    for (int i = 0; i < daftarMinuman.length; i++) {
      newDaftarMinuman[i] = daftarMinuman[i];
    }
    daftarMinuman = newDaftarMinuman; // mengubah referensi variabel
    // melakukan penambahan minuman baru
    newDaftarMinuman[daftarMinuman.length - 1] = beverage;
  }

  /**
   * Method untuk mencari minuman sesuai dengan nama pada array daftarMinuman
   * 
   * @param namaMinuman
   * @return Jika ada maka object Minuman, sebaliknya Null
   */
  private static Beverage getMinuman(String namaMinuman) {
    for (Beverage drink : daftarMinuman) {
      if (drink.getName().equalsIgnoreCase(namaMinuman)) {
        return drink;
      }
    }
    return null;
  }

  /**
   * Main Program
   */
  public void mainProgram() {
    // iniasi object input dan output
    InputStream inputStream = System.in;
    in = new InputReader(inputStream);
    OutputStream outputStream = System.out;
    out = new PrintWriter(outputStream);

    // melakukan iterasi sesuai dengan input jumlah program yang ingin dijalankan
    int N;
    N = in.nextInt();
    for (int i = 0; i < N; i++) {
      String event = in.next();

      // handle untuk masukan "ADD"
      if (event.equals("ADD")) {
        // meminta input user
        String jenisMinuman = in.next();
        String nama = in.next();
        String size = in.next();
        boolean isCold = in.next().equals("YES");

        // membuat object baru dan melakukan assign kedalam daftarMinuman sesuai
        // inputnya
        if (jenisMinuman.equals("COFFEE")) {
          masukkanKeDaftarMinuman(new Coffee(nama, size, isCold));
        } else {
          masukkanKeDaftarMinuman(new Tea(nama, size, isCold));
        }
      }

      // handle untuk masukan "TOPPING"
      else if (event.equals("TOPPING")) {
        String namaMinuman = in.next();
        // mendapatkan minuman yang dicari
        Beverage minuman = getMinuman(namaMinuman);

        // membagi kasus sesuai dengan instance-nya dan melakukan penambahan topping
        if (minuman instanceof Coffee) {
          ((Coffee) minuman).addWhipCream();
        } else if (minuman instanceof Tea) {
          ((Tea) minuman).addMilk();
        }
      }

      // handle untuk masukan "ORDERAN"
      else if (event.equals("ORDERAN")) {
        String jenisMinuman = in.next();
        // membagi kasus sesuai dengan input user
        if (jenisMinuman.equals("COFFEE")) {
          // melakukan iterasi pada setiap elemen daftarMinuman
          for (Beverage drink : daftarMinuman) {
            if (drink instanceof Coffee) {
              // mencetak orderan
              out.println(drink.toString());
            }
          }
        } else {
          // melakukan iterasi pada setiap elemen daftarMinuman
          for (Beverage drink : daftarMinuman) {
            if (drink instanceof Tea) {
              // mencetak orderan
              out.println(drink.toString());
            }
          }
        }
      }

      // handle ketika masukan tidak sesuai
      else {
        out.println("PERINTAH TIDAK DITEMUKAN");
      }

    }
    out.flush(); // mencetak semua output kedalam terminal
  }

  public static void main(String[] args) {
    Starcil cafe = new Starcil();
    cafe.mainProgram(); // menjalakan program
  }

  // taken from https://codeforces.com/submissions/Petr
  // together with PrintWriter, these input-output (IO) is much faster than the
  // usual Scanner(System.in) and System.out
  // please use these classes to avoid your fast algorithm gets Time Limit
  // Exceeded caused by slow input-output (IO)
  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }
  }
}