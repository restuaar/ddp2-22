/**
 * Nama = Restu Ahmad Ar Ridho
 * NPM = 2206028951
 * Kelas = C
 */

public class MiniQuiz6 {
  public static void main(String[] args) {
    Burung b = new Burung("Merpati", "Putih", 2);
    Kelinci c = new Kelinci("Kelinci Salju", "Putih", 3);
    Harimau d = new Harimau("Harimau Sumatra", "Orange", 48);

    b.fly();
    b.walk();
    b.jump();
    b.attack();

    c.jump();
    c.attack();

    d.walk();
    d.jump();
    d.attack();
  }

  public static class Hewan {
    public String Nama;
    public String Warna;
    public int Berat;

    public Hewan(String nama, String warna, int berat) {
      this.Nama = nama;
      this.Warna = warna;
      this.Berat = berat;
    }

    public void jump() {
      System.out.printf("%s lompat...\n", this.Nama);
    }

    public void attack() {
      System.out.printf("%s menyerang...\n", this.Nama);
    }
  }

  public static class Burung extends Hewan {
    public Burung(String nama, String warna, int berat) {
      super(nama, warna, berat);
    }

    public void fly() {
      System.out.printf("%s terbang...\n", this.Nama);
    }

    public void walk() {
      System.out.printf("%s jalan...\n", this.Nama);
    }
  }

  public static class Kelinci extends Hewan {
    public Kelinci(String nama, String warna, int berat) {
      super(nama, warna, berat);
    }
  }

  public static class Harimau extends Hewan {
    public Harimau(String nama, String warna, int berat) {
      super(nama, warna, berat);
    }

    public void walk() {
      System.out.printf("%s jalan...\n", this.Nama);
    }
  }
}
