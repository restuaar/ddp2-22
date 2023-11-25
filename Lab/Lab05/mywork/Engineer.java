/**
 * Nama : Restu Ahmad Ar Ridho
 * NPM : 2206028951
 * Lab05
 */

public class Engineer extends Employee {
  // iniasi atribut dari subclass
  int banyakSideJobs;

  // constractor class engineer
  Engineer(String nama, int banyakSideJobs) {
    super(nama); // memanggil constractor class utama
    this.banyakSideJobs = banyakSideJobs;
  }

  @Override
  public String toString() {
    // memanggil method toString dari class utama
    String container = super.toString();
    // menambahkan output sesuai dengan class Engineer
    container += "\nRole: Engineer";
    container += "\nBanyak SideJobs: " + this.banyakSideJobs;
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
  void pembagianGajiDanJabatanTetap(int tahunBekerja) {
    // iniasi gaji untuk side jobs
    double gajiSideJobs = this.banyakSideJobs * 500000;
    // membagi kasus ketika sudah dikatakan pensiun
    if (tahunBekerja <= 15) {
      // membagi kasus jabatan dan gaji sesuai dengan pengalaman bekerja
      if (tahunBekerja <= 5) {
        super.setJabatan("Junior");
        super.setGaji(4000000 + gajiSideJobs);
      } else if (tahunBekerja > 5 && tahunBekerja <= 10) {
        super.setJabatan("Senior");
        super.setGaji(8000000 + gajiSideJobs);
      } else if (tahunBekerja > 10 && tahunBekerja <= 15) {
        super.setJabatan("Expert");
        super.setGaji(12000000 + gajiSideJobs);
      }
    } else { // ketika pengalaman bekerja sudah mencapai pensiun
      super.status = false;
      super.setJabatan("Pensiun");
      super.setGaji(0);
    }
  }
}