/**
 * Nama : Restu Ahmad Ar Ridho
 * NPM : 2206028951
 * Lab06
 */

// melakukan inheritance class Coffee dari Beverage
public class Coffee extends Beverage {
  // iniasi tambahan atribut class
  private boolean hasWhipCream = false;

  // Constructor
  public Coffee(String nama, String size, boolean isCold) {
    super(nama, size, isCold);
  }

  @Override
  public void calculatePrice() {
    if (this.size.equalsIgnoreCase("Tall")) {
      this.price = 20000;
    } else if (this.size.equalsIgnoreCase("Grande")) {
      this.price = 25000;
    } else if (this.size.equalsIgnoreCase("Venti")) {
      this.price = 30000;
    }
  }

  /**
   * Method untuk menambahkan topping dengan mengubah attribut topping dan
   * menambahkan harga pada class Coffee
   */
  public void addWhipCream() {
    if (!this.hasWhipCream) {
      this.hasWhipCream = true;
      this.price += 5000;
    }
  }

  @Override
  public String toString() {
    String res = super.toString();

    if (hasWhipCream) {
      res += " with Whip Cream";
    }
    res += " Rp. " + super.getPrice() + ",-";

    return res;
  }
}