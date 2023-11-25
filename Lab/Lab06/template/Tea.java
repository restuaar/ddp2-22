public class Tea extends Beverage {
  // TODO: Ubah modifier yang tepat untuk atribut pada class ini
  private boolean hasMilk;

  public Tea(String nama, String size, boolean isCold) {
    super(nama, size, isCold);
  }

  @Override
  public void calculatePrice() {
    // TODO: Sesuaikan harga dengan kompisisi teh yang ada

  }

  public void addMilk() {
    // TODO: inisiasi susu pada tea
  }

  @Override
  public String toString() {
    String res = super.toString();

    if (hasMilk) {
      res += " with Milk";
    }

    res += " Rp. " + this.getPrice() + ",-";

    return res;
  }
}