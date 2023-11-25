/**
 * Nama : Restu Ahmad Ar Ridho
 * NPM : 2206028951
 * Lab05
 */

public class Secretary extends Employee {
  // iniasi atribut dari subclass
  final double tunjangan;

  // constractor class secretary
  Secretary(String nama, double tunjangan) {
    super(nama); // memanggil constractor class utama
    this.tunjangan = tunjangan;
  }

  @Override
  public String toString() {
    // memanggil method toString dari class utama
    String container = super.toString();
    // menambahkan output sesuai dengan class Engineer
    container += "\nRole: Secretary";
    container += String.format("\nBanyak Tunjangan: %.2f", this.tunjangan);
    return container;
  }

  @Override
  void nextYear(int n) {
    if (super.getStatus()) {
      // melakukan iterasi untuk setiap tahunnya
      for (int i = 0; i < n; i++) {
        int tahunBekerja = super.getPengalamanKerja() + 1;
        // mengecek perubahan gaji, status, dan jabatan
        this.pembagianGajiDanJabatanTetap(tahunBekerja);
        // menambahkan gaji kedalam networth
        super.setNetWorth(super.getNetWorth() + super.getGaji() + this.tunjangan);
        // menambahkan pengalam kerja
        super.nextYear(1);
        // jika sudah pensiun maka tidak dilanjutkan;
        if (!super.status) {
          break;
        }
      }
    }
  }

  /**
   * Method untuk mengecek perubahan gaji, status, dan jabatan setiap tahunnya
   * 
   * @param tahunBekerja
   */
  void pembagianGajiDanJabatanTetap(int tahunBekerja) {
    // membagi kasus ketika sudah dikatakan pensiun
    if (tahunBekerja <= 15) {
      // membagi kasus jabatan dan gaji sesuai dengan pengalaman bekerja
      if (tahunBekerja <= 5) {
        super.setJabatan("Junior");
        super.setGaji(3000000);
      } else if (tahunBekerja > 5 && tahunBekerja <= 10) {
        super.setJabatan("Senior");
        super.setGaji(6000000);
      } else if (tahunBekerja > 10 && tahunBekerja <= 15) {
        super.setJabatan("Expert");
        super.setGaji(9000000);
      }
    } else { // ketika pengalaman bekerja sudah mencapai pensiun
      super.status = false;
      super.setJabatan("Pensiun");
      super.setGaji(0);
    }
  }
}