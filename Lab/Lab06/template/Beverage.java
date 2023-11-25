public class Beverage {
  // TODO: Ubah modifier yang tepat untuk atribut pada class ini
  private String name;
  private String size;
  private boolean isCold;
  private int price;

  public Beverage(String name, String size, boolean isCold) {
    this.name = name;
    this.size = size;
    this.isCold = isCold;
  }

  // Method sengaja dikosongkan
  public void calculatePrice() {
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