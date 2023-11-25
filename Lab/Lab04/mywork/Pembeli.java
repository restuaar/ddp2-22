/*
 * Nama = Restu Ahmad Ar Ridho
 * NPM = 2206028951
 * Lab04
 */

import java.util.ArrayList;

class Pembeli {

	// Inisiasi awal properti class Pembeli
	private String nama;
	private long jumlahUang;
	private ArrayList<Pesanan> listPesanan = new ArrayList<>();
	private final int MAKS_JUMLAH_BARANG = 20;

	private int jumlahBarang; // properti untuk menghitung banyaknya barang yang sudah dipesan
	private int diskon; // properti pembeli mendapatkan diskon

	public Pembeli(String nama, long jumlahUang) {
		this.nama = nama;
		this.jumlahUang = jumlahUang;
		// inisiasi properti jumlahBarang dan diskon
		this.jumlahBarang = 0;
		this.diskon = 0;
	}

	/*
	 * Method yang akan mengembalikan sebuah String yang merupakan pesan hasil dari
	 * query BELI.
	 */
	public String tambahPesanan(Barang barang, int jumlah) {

		// Menambahkan jumlah barang yang sudah dipesan dan diskon
		int jumlahBarangBaru = this.getJumlahBarang() + jumlah;
		this.setJumlahBarang(jumlahBarangBaru);
		this.setDiskon(jumlahBarangBaru);

		// Mengurangi stok barang yang dipesan
		barang.setStok(barang.getStok() - jumlah);

		// Mencari barang dalam pesanan
		Pesanan pesanan = cariPesanan(barang);

		// Membagi kasus untuk barang sudah dipesan atau belum
		if (pesanan != null) { // Ketika barang sudah dipesan
			// Menambahkan jumlah pesanan yang lalu
			pesanan.setJumlahBarang(pesanan.getJumlahBarang() + jumlah);
			return String.format("%s berhasil memesan %s sebanyak %d buah",
					this.getNama(), pesanan.getBarang().getNama(),
					jumlah);
		} else { // Ketika barang belum dipesan
			// Membuat object pesanan baru dan melakukan assign kedalam list
			Pesanan pesananBaru = new Pesanan(barang, jumlah);
			listPesanan.add(pesananBaru);
			return String.format("%s berhasil memesan %s sebanyak %d buah",
					this.getNama(), pesananBaru.getBarang().getNama(),
					jumlah);
		}
	}

	/**
	 * Method untuk mengosongkan list pesanan
	 */
	public void resetPesanan() {
		this.setJumlahBarang(0); // Mengembalikan banyak jumlah barang
		listPesanan.removeAll(listPesanan);
	}

	/**
	 * Method untuk menghitung sisa Uang
	 * 
	 * @return long sisa uang dari pembeli
	 */
	public long sisaUang() {
		long uangSisa = this.getJumlahUang();
		for (Pesanan pesanan : listPesanan) {
			uangSisa -= pesanan.totalHarga();
		}
		return uangSisa;
	}

	/**
	 * Method untuk mencari barang dalam listPesanan
	 * 
	 * @param barang
	 * @return bila barang sesuai maka Barang dan jika tidak sesuai maka null
	 */
	public Pesanan cariPesanan(Barang barang) {
		for (Pesanan pesanan : listPesanan) {
			if (pesanan.getBarang().getNama().equals(barang.getNama()))
				return pesanan;
		}
		return null;
	}

	// Method getter
	public String getNama() {
		return this.nama;
	}

	public long getJumlahUang() {
		return this.jumlahUang;
	}

	public int getMaksJumlahBarang() {
		return this.MAKS_JUMLAH_BARANG;
	}

	public int getJumlahBarang() {
		return this.jumlahBarang;
	}

	public int getDiskon() {
		return this.diskon;
	}

	public ArrayList<Pesanan> getPesanan() {
		return this.listPesanan;
	}

	// Method setter
	public void setJumlahUang(long jumlahUang) {
		this.jumlahUang = jumlahUang;
	}

	public void setJumlahBarang(int jumlah) {
		this.jumlahBarang = jumlah;
	}

	public void setDiskon(int diskon) {
		this.diskon = diskon;
	}
}
