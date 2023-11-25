public class Employee {
  // TODO lengkapi visibility modifier atribut dan methods berikut
  String nama;
  int pengalamanKerja;
  boolean status;
  double netWorth;
  String jabatan;
  double gaji;

  Employee(String nama) {
    // TODO lengkapi constructor ini
  }

  void nextYear(int tahun) {
    this.pengalamanKerja += tahun;
  }

  public String getNama() {
    return nama;
  }

  public void setJabatan(String jabatan) {
    this.jabatan = jabatan;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public int getPengalamanKerja() {
    return pengalamanKerja;
  }

  public double getNetWorth() {
    return netWorth;
  }

  public void setNetWorth(double n) {
    netWorth = n;
  }

  public void setGaji(double gaji) {
    this.gaji = gaji;
  }

  public double getGaji() {
    return gaji;
  }

}