/**
 * Nama : Restu Ahmad Ar Ridho
 * NPM : 2206028951
 * Lab06
 */

public class Beverage {
  // iniasi atribut class
  private String name;
  protected String size;
  private boolean isCold;
  protected int price;

  // Constructor
  public Beverage(String name, String size, boolean isCold) {
    // melakukan assign kedalam atribut class sesuai dengan input
    this.name = name;
    this.size = size;
    this.isCold = isCold;
    this.calculatePrice(); // melakukan perhitungan untuk harga
  }

  // Method sengaja dikosongkan agar dapat di override dan dipanggil
  /**
   * Method untuk menyesuaikan harga dengan size
   */
  public void calculatePrice() {
  }
  
  // Method getter yang diperlukan
  public int getPrice() {
    return this.price;
  }
  public String getName() {
    return this.name;
  }

  public String toString() {
    String output = "";

    if (isCold) {
      output += "COLD ";
    } else {
      output += "HOT ";
    }

    output += this.size + " " + this.name;
    return output;
  }
}