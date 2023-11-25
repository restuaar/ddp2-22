package card;

import item.Item;

public abstract class Card implements Comparable<Card> {
  private static int idCounter = 0;
  private double balance;
  private String companyName;
  private int id;
  private String type;

  protected Card(String companyName, double balance, String type) {
    this.companyName = companyName;
    this.balance = balance;
    this.type = type;
    id = idCounter++;
  }

  public abstract void pay(Item item);

  @Override
  public int compareTo(Card o) {
    // TODO: implementasikan compareTo sesuai urutan sorting pada soal

    // kode di bawah hanyalah placeholder
    return 0;
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
