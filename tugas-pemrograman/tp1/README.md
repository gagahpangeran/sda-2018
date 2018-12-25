# Tugas Pemrograman 1 - Dylan dan Milya

- Nama Berkas Kode Sumber : SDA18191T.java
- Batas waktu eksekusi program : 3 detik / kasus uji
- Batas memori program : 256 MB / kasus uji

## <i>"Aku ramal, nanti kita akan bertemu di kantin"</i>

Milya bertemu dengan Dylan di sebuah SMA di Depok. Saat itu tahun 1999, ketika
Milya pindah dari Jakarta ke Depok. Perkenalan yang tidak biasa kemudian membawa
Milya mulai mengenal keunikan Dylan lebih jauh. Dylan pintar, baik hati, dan
romantis namun dianggap sebagai berandal karena aktif di geng motor terkenal di
Depok sebagai panglima tempur​. Cara Dylan mendekati Milya tidak sama dengan
teman-teman pria lainnya. ​ Cara Dylan berbicara yang terdengar baku, lambat laun
membuat Milya kerap merindukannya jika sehari saja tak mendengar suara itu. Hari
demi hari hubungan Dylan dan Milya semakin akrab hingga akhirnya mereka berpisah
ketika lulus SMA. Sebelum berpisah, mereka berjanji akan bertemu kembali setelah
lima tahun.

Lima tahun yang berat telah mereka lalui, tak satu hari pun mereka melupakan
masa-masa indah ketika SMA. Hari yang ditunggu pun tiba, Dylan bersiap untuk
menemui Milya di tempat yang mereka janjikan lima tahun silam. Ternyata, Milya
telah tiba terlebih dahulu di tempat perjanjian. Karena terlambat, Dylan
bergegas berangkat menuju Milya. Dylan dan Milya saat ini terpisah sejauh **S**
**meter**​. Dylan berpindah dengan menggunakan salah satu dari **N transportasi**
**yang ada tiap detiknya (waktu pergantian transportasi diabaikan)**​.
Transportasi ke `i` memiliki kecepatan `V[i]` **meter/detik** ​ dan tiap
transportasi memiliki kecepatan yang **unik**. Dylan meminta Milya untuk
menunggu di tempat perjanjian. Namun, karena Milya tidak sabar untuk bisa
bertemu dengan Dylan, Ia juga berjalan menuju Dylan dengan kecepatan
**​U meter/detik** (jika U = 0, maka Milya diam)​.

Dylan dan Milya dikatakan **​bertemu jika dan hanya jika mereka berada di titik**
**yang sama pada detik yang sama (detik merupakan bilangan bulat)**. Perhatikan
bahwa mereka dapat melewati satu sama lain tanpa bertemu di titik yang sama
sehingga mereka tidak akan pernah bertemu.

Kalian (sebagai sahabat Dylan dan Milya) yang sedang kuliah di Fasilkom UI,
penasaran dan ingin memodelkan beberapa hal, yaitu:

- **Ada berapa cara berbeda Dylan dan Milya menggunakan alat transportasi**
  **sehingga mereka bisa bertemu?**
- **Berapa waktu minimal yang dapat ditempuh Dylan untuk bertemu Milya?**

## Ilustrasi

Todo

## Definisi Problem

Setiap testcase mengandung salah satu dari dua permasalahan berikut :

- Menghitung banyaknya cara Dylan menggunakan alat transportasi sehingga ia
  dapat bertemu dengan Milya.

  Karena banyaknya cara mereka bertemu dapat bernilai sangat besar, **outputkan**
  **banyaknya cara setelah dimodulo dengan 1000000007. Hati-hati dengan kasus**
  **penjumlahan yang melewati batas integer sebelum di-modulo**. ​ Mohon untuk
  mengingat kembali materi aritmatika modulo agar tidak salah dalam
  mengoperasikannya​.

  Contoh : Jika banyaknya cara bernilai 1000000010, maka jawaban yang
  dioutputkan adalah 3.

- Menghitung waktu minimal yang dapat ditempuh Dylan untuk bertemu dengan Milya
  dan memberikan langkah-langkah yang dilakukan setiap detiknya. Apabila
  terdapat lebih dari satu konfigurasi langkah dengan waktu minimal, cetak
  konfigurasi langkah dengan **leksikografis terkecil​**.

  Misal terdapat dua konfigurasi langkah **A** dan **B** dengan `A[i]` dan `B[i]`
  masing-masing menyatakan langkah pada detik ke `i` pada konfigurasi langkah
  **A** dan **B**. Maka, **A lebih kecil secara leksikografis dari B**, jika dan
  hanya jika terdapat j, sehingga `A[i] = B[i]` untuk setiap `i < j` dan
  `A[j] < B[j]`.

  Contoh : Pada ilustrasi ke-2 yang telah dipaparkan di atas, terdapat 4
  konfigurasi langkah dengan waktu minimal yaitu = {(1, 4, 4), (4, 1, 4),
  (4, 4, 1), (3, 3, 3)}. Dengan definisi leksikografis di atas, (1, 4, 4)
  merupakan konfigurasi langkah dengan leksikografis terkecil.

Grading system di Aren akan menyediakan sejumlah test case dengan tingkat
kesulitan beragam (Easy, Medium, Hard). Gambaran kasar: 80% testcase memiliki
kesulitan Easy atau Medium, sisanya 20% kesulitan Hard.

### Input Program

Masukan akan diberikan dengan format :

```text
S N U
V[1] V[2] ... V[N]
P
```

Dengan catatan:

- `S` = Jarak antara Dylan dengan Milya.
- `N` = Jumlah transportasi berbeda yang dapat Dylan gunakan untuk berpindah
  tempat tiap detiknya.
- `U` = Besar kecepatan yang dapat Milya tempuh untuk berpindah.
- `V[i]` = Besar kecepatan yang dapat Dylan tempuh untuk berpindah pada
  transportasi tertentu.
- `P` = Berisi ​ 'A’' atau ​ 'B'​ yang menyatakan jenis permasalahan sesuai dengan
  penjelasan pada bagian Definisi Problem.

Batas masukan untuk test case dengan tingkat kesulitan easy / medium:

- **1** ≤ `S` ≤ **20**
- **1** ≤ `N` ≤ **4**
- `N` ≤ `S`
- **0** ≤ `U` < `S`
- **0** < `V[1]` < `V[2]` < ... < `V[N]` ≤ `S`

Batas masukan untuk test case dengan tingkat kesulitan hard:

- **1** ≤ `S` ≤ **3000**
- **1** ≤ `N` ≤ **100**
- `N` ≤ `S`
- **0** ≤ `U` < `S`
- **0** < `V[1]` < `V[2]` < ... < `V[N]` ≤ `S`

### Output Program

Untuk setiap testcase,

Jika ​ `P` = 'A'​, cetak:

```text
X
```

- `X` = Banyaknya cara Dylan berada pada titik yang sama dengan Milya​. Apabila
  tidak ada cara yang memungkinkan bagi Dylan untuk bertemu dengan Milya maka
  tuliskan '0'.

Jika `P` = 'B', cetak:

```text
Y
V[1] V[2] ... V[Y]
```

- `Y` = Waktu minimal Dylan bertemu dengan Milya. Apabila tidak ada cara yang
  memungkinkan bagi Dylan untuk bertemu dengan Milya maka cetak 'NA'.
- `V[1] V[2] ... V[Y]` = Konfigurasi langkah yang dapat diambil oleh Dylan
  dengan Waktu minimal. Apabila terdapat lebih dari satu konfigurasi langkah
  dengan waktu minimal, cetak konfigurasi langkah dengan **leksikografis**
  **terkecil** (seperti yang dijelaskan pada bagian Definisi Problem)

Todo : Contoh Masukan dan keluaran
