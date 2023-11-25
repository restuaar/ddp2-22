/**
 * Nama : Restu Ahmad Ar Ridho
 * NPM : 2206028951
 * Lab05
 */

public class Manager extends Employee {
  // iniasi atribut dari subclass
  final double raise = 1.25;

  // constractor class manager
  Manager(String nama) {
    super(nama);
  }

  @Override
  public String toString() {
    // memanggil method toString dari class utama dan menambahkan sesuai degan
    // class Manager
    return super.toString() + "\nRole: Manager";
  }

  @Override
  void nextYear(int n) {
    if (super.getStatus()) {
      // melakukan iterasi setiap tahunnya
      for (int i = 0; i < n; i++) {
        int tahunBekerja = super.getPengalamanKerja() + 1;
        // mengecek perubahan gaji, status, dan jabatan
        this.pembagianJabatanTetap(tahunBekerja);
        // menambahkan gaji kedalam networth
        super.setNetWorth(super.getNetWorth() + super.getGaji());
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
  void pembagianJabatanTetap(int tahunBekerja) {
    // membagi kasus ketika sudah dikatakan pensiun
    if (tahunBekerja <= 15) {
      // membagi kasus jabatan sesuai dengan pengalaman bekerja
      if (tahunBekerja <= 5) {
        super.setJabatan("Junior");
      } else if (tahunBekerja > 5 && tahunBekerja <= 10) {
        super.setJabatan("Senior");
      } else if (tahunBekerja > 10 && tahunBekerja <= 15) {
        super.setJabatan("Expert");
      }

      // membagi kasus untuk gaji pertama dan selanjutnya
      if (tahunBekerja == 1) {
        super.setGaji(2000000 * this.raise);
      } else {
        // gaji merupakan raise dikali gajisebelumnya
        double gajiBaru = super.getGaji() * this.raise;
        super.setGaji(gajiBaru);
      }
    } else { // ketika pengalaman bekerja sudah mencapai pensiun
      super.status = false;
      super.setJabatan("Pensiun");
      super.setGaji(0);
    }
  }
}
