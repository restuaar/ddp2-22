/*
 * Nama = Restu Ahmad Ar Ridho
 * NPM = 2206028951
 * Lab04
 */

class Pesanan {
	// Inisiasi awal properti class Pesanan
	private Barang barang;
	private int jumlahBarang;

	// Constructor class Pesanan
	public Pesanan(Barang barang, int jumlahBarang) {
		this.barang = barang;
		this.jumlahBarang = jumlahBarang;
	}

	/*
	 * Method yang mengembalikan total harga dari suatu pesanan
	 */
	public long totalHarga() {
		return barang.getHarga() * jumlahBarang;
	}

	// Method getter
	public Barang getBarang() {
		return barang;
	}

	public int getJumlahBarang() {
		return jumlahBarang;
	}

	// Method setter
	public void setJumlahBarang(int jumlahBarang) {
		this.jumlahBarang = jumlahBarang;
	}
}
