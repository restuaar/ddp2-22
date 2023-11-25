/**
 * Nama : Restu Ahmad Ar Ridho
 * NPM : 2206028951
 * Lab05
 */

package card;

import item.Item;

public class ElectronicCard extends Card implements Topupable {
  public ElectronicCard(String companyName, double balance) {
    super(companyName, balance, "ELECTRONIC");
  }

  @Override
  public void pay(Item item) {
    // iniasi harga dan balance
    int hargaItem = item.getPrice();
    double balance = this.getBalance();

    // melakukan kalkulasi dan set balance
    this.setBalance(balance - (double) hargaItem);
  }

  @Override
  public void topup(double amount) {
    double balance = this.getBalance();

    // set balance setelah di topup
    this.setBalance(balance + amount);
  }
}