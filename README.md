# ProdukApp - Daftar Produk Toko

Aplikasi desktop sederhana berbasis **JavaFX** untuk mencatat produk toko. Pengguna dapat menambahkan produk, melihat daftarnya dalam tabel, mencari produk berdasarkan nama, dan membuka halaman detail produk yang dipilih.

# Tampilan

<img width="900" height="680" alt="ProdukApp - Daftar Produk Toko 08_11_2026 22_15_17" src="https://github.com/user-attachments/assets/ad0eeeef-814d-4c8f-b0e0-b8e400cbb873" />
<img width="900" height="680" alt="ProdukApp - Daftar Produk Toko 08_11_2026 22_16_58" src="https://github.com/user-attachments/assets/f7f10b8d-71cb-421a-9376-9375499d8d22" />
<img width="900" height="680" alt="ProdukApp - Daftar Produk Toko 08_11_2026 22_16_13" src="https://github.com/user-attachments/assets/25bd7e01-dbe6-4be1-b899-f6a0b3d1ce28" />

## Pengujian

https://github.com/user-attachments/assets/d3784ebc-3458-4bb1-a64f-bdc8c63c4fe0

## Fitur

- **Tambah produk** lewat form (nama, kategori, harga). Kode produk dibuat otomatis: `P001`, `P002`, dan seterusnya.
- **Tabel produk** yang menampilkan kode, nama, kategori, dan harga.
- **Pencarian** berdasarkan nama produk lewat tombol **Cari** (tidak peka huruf besar/kecil, dan tombol **Reset** menampilkan semua produk lagi).
- **Lihat Detail** untuk membuka halaman detail produk yang dipilih di tabel.
- **Validasi input**: nama tidak boleh kosong dan harga harus lebih dari nol.

## Cara Menjalankan

### Lewat NetBeans
1. Buka folder `ProdukApp` sebagai proyek Maven (`File > Open Project`).
2. Klik **Run**.

### Lewat terminal
```bash
git clone https://github.com/jezzyaa/Produk-App.git
cd ProdukApp
mvn clean javafx:run
```

## Alur Penggunaan

```
Form Tambah Produk --(Simpan)--> Detail Produk --(Lihat Daftar)--> Daftar Produk

```

1. Aplikasi dibuka pada **form tambah produk**.
2. Setelah **Simpan Produk**, aplikasi menampilkan **detail produk yang baru ditambahkan**.
3. Dari halaman detail, pilih **Lihat Daftar** untuk membuka tabel atau **Tambah Produk Lain** untuk kembali ke form.
4. Pada halaman daftar, gunakan **Cari** / **Reset** untuk mencari produk, **Tambah** untuk membuka form, dan **Lihat Detail** (setelah memilih satu baris) untuk membuka detail produk tersebut.

## Aturan Validasi

| Input | Aturan | Pesan jika ditolak |
|---|---|---|
| Nama produk | Tidak boleh kosong atau hanya spasi | `Nama produk tidak boleh kosong.` |
| Harga | Harus berupa bilangan bulat (tanpa titik/huruf) | `Harga harus berupa bilangan bulat, misalnya 15000.` |

## Struktur Proyek

```
ProdukApp/
├── pom.xml
├── nbactions.xml
└── src/main/
    ├── java/kelas/
    │   ├── MainApp.java              # titik masuk aplikasi
    │   ├── Navigator.java            # perpindahan halaman (form, daftar, detail)
    │   ├── model/
    │   │   └── Produk.java           # atribut private, constructor, getter, validasi
    │   ├── data/
    │   │   └── DataProduk.java       # penyimpanan data di memori + pembuat kode produk
    │   └── controller/
    │       ├── FormController.java   # form tambah produk
    │       ├── DaftarController.java # tabel dan pencarian
    │       └── DetailController.java # menerima objek Produk dan menampilkannya
    └── resources/kelas/
        ├── form.fxml
        ├── daftar.fxml
        ├── detail.fxml
        └── styles/app.css
```

## Catatan Desain

- **Class `Produk`** memiliki atribut `private final`, constructor yang melakukan validasi (melempar `IllegalArgumentException` jika data tidak valid), dan getter. Tidak memakai inheritance karena tidak diperlukan.
- **Halaman detail** menerima objek `Produk` yang dipilih melalui `Navigator.bukaDetail(Produk)` dan `DetailController.setData(...)`, bukan menampilkan data yang ditulis langsung di dalam kode.
- **Data disimpan di memori** (`ObservableList`) selama aplikasi berjalan, sehingga data hilang saat aplikasi ditutup. Tidak ada database.
- **Kolom tabel** memakai `PropertyValueFactory`, sehingga nama kolom (`kode`, `nama`, `kategori`, `harga`) harus sesuai dengan getter pada class `Produk`.
