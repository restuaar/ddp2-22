class Pembeli {

	// TODO: Implementasi visibility modifier yang sesuai
	String nama;
	long jumlahUang;
	Pesanan[] listPesanan = new Pesanan[20];
	final int MAKS_JUMLAH_BARANG = 20;

	// TODO: Implementasi constructor yang sesuai
	public Pembeli() {

	}

	/*
	 * Method yang akan mengembalikan sebuah String yang merupakan pesan hasil dari
	 * query BELI.
	 */
	public String tambahPesanan(Barang barang, int jumlah) {
		// TODO: Implementasi method tambahPesanan

		return null;
	}

	/*
	 * Method untuk mengosongkan list pesanan
	 */
	public void resetPesanan() {
		listPesanan = new Pesanan[20];
	}

	// TODO: Tambahkan getter/setter/method lain yang diperlukan

	public String getNama() {
		return nama;
	}

}
