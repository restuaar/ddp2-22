/**
 * Nama : Restu Ahmad Ar Ridho
 * NPM : 2206028951
 * Lab05
 */

package card;

import item.Item;

public class GiftCard extends Card {
  public GiftCard(String companyName, double balance) {
    super(companyName, balance, "GIFT");
  }

  @Override
  public void pay(Item item) {
    // mendapatkan harga barang dan balance kartu
    int hargaItem = item.getPrice();
    double balance = this.getBalance();

    // melakukan kalkulasi dan set balance
    this.setBalance(balance - (double) (hargaItem * 0.9));
  }
}
