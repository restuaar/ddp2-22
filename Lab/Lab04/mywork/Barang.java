/*
 * Nama = Restu Ahmad Ar Ridho
 * NPM = 2206028951
 * Lab04
 */

class Barang {
	// Inisiasi awal properti class Barang
	private long harga;
	private String nama;
	private int stok;

	// Constructor class Barang
	public Barang(long harga, String nama, int stok) {
		this.nama = nama;
		this.harga = harga;
		this.stok = stok;
	}

	// Method getter
	public long getHarga() {
		return this.harga;
	}

	public int getStok() {
		return this.stok;
	}

	public String getNama() {
		return this.nama;
	}

	// Method setter
	public void setHarga(long harga) {
		this.harga = harga;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}
}
