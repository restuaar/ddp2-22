/**
 * Nama : Restu Ahmad Ar Ridho
 * NPM : 2206028951
 * Lab06
 */

// melakukan inheritance class Coffee dari Beverage
public class Tea extends Beverage {
    // iniasi tambahan atribut class
    private boolean hasMilk;

    // Constructor
    public Tea(String nama, String size, boolean isCold) {
        super(nama, size, isCold);
    }

    @Override
    public void calculatePrice() {
        if (this.size.equalsIgnoreCase("Tall")) {
            this.price = 15000;
          } else if (this.size.equalsIgnoreCase("Grande")) {
            this.price = 20000;
          } else if (this.size.equalsIgnoreCase("Venti")) {
            this.price = 25000;
          }
    }

    /**
     * Method untuk menambahkan topping dengan mengubah attribut topping dan
     * menambahkan harga pada class Tea
     */
    public void addMilk() {
      if (!this.hasMilk) {
        this.hasMilk = true;
        this.price += 7000;
      }
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