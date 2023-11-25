public class Coffee extends Beverage {
  // TODO: Ubah modifier yang tepat untuk atribut pada class ini
  private boolean hasWhipCream = false;

  public Coffee(String nama, String size, boolean isCold) {
    super(nama, size, isCold);
  }

  @Override
  public void calculatePrice() {
    // TODO: set harga coffee sesuai komposisi
  }

  public void addWhipCream() {
    // TODO: inisiasi whip cream pada coffee
  }

  public String toString() {
    String res = super.toString();

    if (hasWhipCream) {
      res += " with Whip Cream";
    }
    res += " Rp. " + super.getPrice() + ",-";

    return res;
  }
}