# Tugas Pemrograman 4 - Gate to The Abyss

![Abyss](img/hl.png?raw=true)

**Gambar 1. The Abyss**

( [​http://coolvibe.com/2012/illustration-into-the-abyss/](​http://coolvibe.com/2012/illustration-into-the-abyss/) )

Para penjelajah _​Black Whistles_ ​yang dibantu oleh sistem penjelajahan yang
baik berhasil mencapai kedalaman The Abyss yang belum pernah dicapai oleh para
penjelajah sebelumnya. Selama penjelajahan berlangsung para ​*Black Whistles*
telah menemukan pemandangan-pemandangan indah dan memukau yang tidak dapat
dilihat dimanapun selain di The Abyss. Selain itu, mereka juga menemukan
teknologi dari peradaban purba yang sangat canggih sehingga dapat membantu
memajukan kualitas hidup semua orang. Akan tetapi, eksplorasi The Abyss telah
menemukan sebuah ​bottleneck dimana terdapat sebuah gerbang yang menghalangi
tim penjelajah _Black Whistles_ untuk melanjutkan penjelajahan ke kedalaman
yang paling dalam.

Setelah menganalisa gerbang tersebut secara teliti, para _​Black Whistles_ telah
menyadari bahwa gerbang ini ditutupi oleh _hieroglyph_ yang bisa jadi menjadi
kunci untuk membuka gerbang tersebut. _Hieroglyph_ tersebut berupa sebuah String
**berisi huruf kecil** yang memiliki pola-pola tertentu. Tugas Anda sebagai
salah satu pemimpin penjelajahan para _Black Whistles_ adalah untuk menemukan
rahasia dibalik pola-pola _hieroglyph_ tersebut.

Terdapat `Q` kode yang harus Anda pecahkan. Kode dengan tipe pertama adalah
sebuah kode yang **menghitung banyaknya kemunculan** suatu pola pada
*hieroglyph*​. Sedangkan kode dengan tipe kedua adalah mencari pola di
_​hieroglyph_ yang memiliki **kemunculan terbanyak​** ​dimulai​ dari pola dengan
panjang **1** hingga |`S`|.

Kemunculan diartikan sebagai banyaknya pola yang terlihat pada _hieroglyph​_.
Sebagai contoh, pada _hieroglyph_ "degodesososon" dapat terlihat dua kemunculan
pola "soso" (degode**​soso**​son dan degodeso**​soso**​n).

## Format Input/Output

Baris pertama berisi sebuah string `S`.

Baris kedua berisi sebuah integer `Q` yang menyatakan banyaknya kode yang
diberikan kepada Anda.

`Q` baris berikutnya berisi sebuah kode yang harus anda pecahkan dengan tipe (0
dan 1)

- Tipe 0 berarti anda harus menghitung banyaknya kemunculan sebuah pola di
  *hieroglyph*​ Query dengan tipe ini diikuti dengan sebuah string `T`
- Tipe 1 berarti anda harus mencari pola di ​*hieroglyph​* yang memiliki
  kemunculan terbanyak dimulai dari panjang 1 sampai dengan panjang |`S`|

Untuk setiap ​*test case* dijamin kode dengan tipe 1 akan muncul maksimal
sebanyak satu kali.

Batasan :

- |`S`|, |`T`|, `Q` ≤ **1000**
- `S` hanya terdiri dari huruf kecil ('a'-'z')

### Tipe 0

Hanya menanyakan kode dengan tipe 0

Contoh Masukan 1:

```text
usama
2
0 a
0 ama
```

Contoh Keluaran 1

```text
2
1
```

### Tipe 1

Tidak ada batasan lain

Contoh Masukan 2:

```text
usama
3
0 a
0 ama
1
```

Contoh Keluaran 2:

```text
2
1
a 2
us 1
usa 1
usam 1
usama 1
```

#### Penjelasan

1. "a" memiliki jumlah kemunculan 2
2. "ama" memiliki jumlah kemunculan 1
3. Memunculkan substring pada S dengan panjang dimulai dari **1** sampai panjang
   `S` yang memiliki kemunculan terbanyak dibanding substring lainnya dengan
   panjang yang sama:

   - **Panjang 1**:​ "a" memiliki **​kemunculan terbanyak**​ dibanding "u", "s",
     atau "m"
   - **Panjang 2**: "us" memiliki kemunculan yang sama dengan "sa", "am", dan
     "ma" tetapi "us" diambil karena memiliki **kemunculan pertama**
   - **Panjang 3**: ​ "usa" memiliki kemunculan yang sama dengan "sam" dan "ama",
     tetapi "usa" diambil karena memiliki ​**kemunculan pertama**
   - Panjang 4​: memiliki kasus yang sama seperti Panjang 2 dan 3
   - Panjang 5​: karena panjang substring sama dengan panjang `S`, maka cukup
     mengeluarkan `S` dan kemunculannya 1

#### Petunjuk

1. Gunakan Hash Table untuk pengerjaan soal ini
2. Anda tidak diperkenankan menggunakan fungsi Hash yang disediakan oleh Java
3. Anda tidak diperkenankan menggunakan library ADT yang memanfaatkan Hash

Sebagai referensi anda bisa membaca tentang seni hashing pada link berikut ini :

1. http://kupaskode.blogspot.com/2015/09/tentang-hashing.html
2. http://kupaskode.blogspot.com/2015/09/seni-hashing.html
