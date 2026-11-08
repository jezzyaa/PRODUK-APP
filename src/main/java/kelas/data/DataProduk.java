package kelas.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kelas.model.Produk;

public class DataProduk {

    private final ObservableList<Produk> daftar = FXCollections.observableArrayList();
    private int urutan = 1;

    public ObservableList<Produk> getDaftar() {
        return FXCollections.unmodifiableObservableList(daftar);
    }

    public Produk tambah(String nama, String kategori, long harga) {
        //P%03d  Bagian ini digunakan untuk membuat kode produk, misalnya P001, P002, dan seterusnya.
        Produk p = new Produk(String.format("P%03d", urutan), nama, kategori, harga);
        daftar.add(p);
        urutan++;
        return p;
    }
}
