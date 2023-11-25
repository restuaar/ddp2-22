/**
 * Nama : Restu Ahmad Ar Ridho
 * NPM : 2206028951
 * Lab05
 */

package card;

import item.Item;

public abstract class Card implements Comparable<Card> {
  private String type;
  private static int idCounter = 0;
  private String companyName;
  private double balance;
  private int id;

  /**
   * Constructor
   * 
   * @param companyName -> Nama company dari kartu
   * @param balance     -> Isi balance kartu
   * @param type        -> Tipe jenis kartu
   */
  protected Card(String companyName, double balance, String type) {
    this.companyName = companyName;
    this.balance = balance;
    this.type = type;
    id = idCounter++;
  }

  /**
   * Method untuk melakukan pembayaran menggunakan kartu
   * 
   * @param item -> Object item barang yang dijual
   */
  public abstract void pay(Item item);

  @Override
  public int compareTo(Card o) {
    // jika balance lebih besar maka sort lebih awal
    if (this.balance > o.getBalance()) {
      return -1;
    } else if (this.balance == o.getBalance()) { // jika balance sama
      // id yang lebih kecil maka sort lebih awal
      if (this.id == o.getId()) {
        return 0;
      } else if (this.id > o.getId()) {
        return 1;
      } else {
        return -1;
      }
    }
    return 1;
  }

  @Override
  public String toString() {
    return String.format("Card %s %s - id: %d, balance: %.2f",
        companyName, type, id, balance);
  }

  // Getter dan Setter
  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public int getId() {
    return id;
  }

  public String getType() {
    return type;
  }
}