/**
 * Nama : Restu Ahmad Ar Ridho
 * NPM : 2206028951
 * Lab05
 */

public class Employee {

  // iniasi atribut dari superclass
  String nama;
  int pengalamanKerja;
  double gaji;
  boolean status;
  double netWorth;
  String jabatan;

  // constractor superclass Employee
  Employee(String nama) {
    this.nama = nama;
    this.pengalamanKerja = 0;
    this.gaji = 0;
    this.status = true;
    this.netWorth = 0;
    this.jabatan = "Junior";
  }

  /**
   * Method untuk mencetak informasi class employee
   * 
   * @return String
   */
  public String toString() {
    String container = "";
    container += "Nama: " + this.nama;
    container += "\nPengalaman Kerja: " + this.pengalamanKerja;
    container += "\nStatus: " + this.status;
    container += String.format("\nNetWorth: Rp%.2f", this.netWorth);
    container += "\nJabatan: " + this.jabatan;
    return container;
  }

  /**
   * Method untuk menambahkan pengalaman kerja sesuai dengan input
   * 
   * @param tahun
   */
  void nextYear(int tahun) {
    this.pengalamanKerja += tahun;
  }

  // method setter dan getter yang diperlukan
  public void setJabatan(String jabatan) {
    this.jabatan = jabatan;
  }

  public int getPengalamanKerja() {
    return this.pengalamanKerja;
  }

  public boolean getStatus() {
    return this.status;
  }

  public void setNetWorth(double n) {
    this.netWorth = n;
  }

  public double getNetWorth() {
    return this.netWorth;
  }

  public void setGaji(double gaji) {
    this.gaji = gaji;
  }

  public double getGaji() {
    return this.gaji;
  }
}