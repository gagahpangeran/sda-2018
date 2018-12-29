# Tugas Pemrograman 3 - Eksplorasi the Abyss

- Nama file kode sumber : SDA1819T3.java
- Batas waktu eksekusi program : 1 detik
- Batas memori program : 256 MB

![Abyss](img/ab1.png?raw=true)

**Gambar 1. The Abyss**

The Abyss adalah sebuah lubang raksasa yang ditemukan 1900 tahun lalu di sebuah
pulau di lautan selatan. The Abyss memiliki diameter sekitar 1,000 meter dengan
kedalaman yang sampai saat ini belum diketahui oleh siapapun. Banyak sekali
daerah di dalam The Abyss yang belum pernah disentuh manusia karena
lingkungannya yang sangat berbahaya. Akan tetapi, di balik ekosistemnya yang
unik terdapat di dalamnya sisa-sisa peradaban purba, dengan teknologi yang
sangat canggih yang mendorong orang-orang dari segala penjuru dunia untuk
menjelajahi The Abyss.

Anda sebagai _Black Whistles_ (penjelajah The Abyss dengan pengalaman yang
sangat tinggi) akan melakukan sebuah ekspedisi ke dalam The Abyss bersama
teman-teman Anda. Akan tetapi, untuk menjelajahi The Abyss Anda membutuhkan
sebuah sistem yang dapat membantu menjaga keutuhan tim Anda.

Penjelajah harus menggunakan tali untuk turun ke dalam The Abyss. Ini artinya,
setiap penjelajah akan terhubung dengan tali. Para Black Whistles tidak suka
formasi penjelajahan yang linear, mereka suka dengan formasi berbentuk tree.
Formasi tree yang mereka sukai pun punya aturan _yang sangat spesial sekali_.

![Abyss](img/ab2.png?raw=true)

**Gambar 2. Formasi Penjelajahan. Jarak antara ODIN dengan sumber cahaya**
**adalah 1 unit.**

Perhatikan gambar 2. Akan ada satu orang penjelajah yang menggantung semua
penjelajah lainnya secara langsung atau tidak langsung, dalam kasus ini,
Nanachi. Setiap penjelajah akan menggantung maksimal dua orang lainnya
menggunakan tali secara langsung. Dua penjelajah yang digantung oleh satu
penjelajah yang sama memiliki hubungan **partner**, yakni apabila X dan Y
digantung oleh Z, maka X adalah partner Y dan Y adalah partner X. Dalam hubungan
partner, ada dua jenis peran, yaitu **partner kiri** dan **partner kanan**.
Penting untuk diketahui bahwa partner kiri akan diposisikan lebih barat dari
partner kanannya dan penjelajah yang menggantungnya. Sebaliknya, partner kanan
akan diposisikan lebih timur dari partner kirinya dan penjelajah yang
menggantungnya. Partner kiri, partner kanan, dan penjelajah yang menggantungnya
tidak ditentukan secara sembarangan, partner kiri harus memiliki nama yang lebih
dahulu daripada nama penjelajah yang menggantungnya, secara leksikografs, dan
partner kanan harus memiliki nama yang lebih belakangan daripada nama penjelajah
yang menggantungnya secara leksikografs.

Banyak penjelajah yang ingin bergabung ke ekspedisi, beberapa penjelajah akan
bergabung ketika ekspedisi sedang berjalan. **Seorang penjelajah yang baru**
**bergabung, **pertama-tama** harus ditempatkan pada posisi yang paling bawah**. Selain adanya penjelajah yang ingin bergabung, **ada juga penjelajah yang**
**ingin berhenti atau terpaksa diberhentikan**. Untungnya, para leluhur _Delver_
sudah pernah memikirkan bahwa penempatan penjelajah baru secara sembarangan atau
penghapusan penjelajah dari formasi tree secara sembarangan dapat menyebabkan
struktur formasi tree menjadi tidak seimbang. Maka dari itu, leluhur Delver
menggunakan algoritma khusus untuk menentukan penempatan dan penghapusan
penjelajah. Algoritma khusus tersebut adalah algoritma yang dibuat oleh dua
ilmuwan inspiratif bernama **A**delson-**V**elsky dan **L**andis
<sup>[1](#fn1)</sup>.

Berdasarkan _Delver honor code_, **hanya boleh ada satu buah alat penerangan**
yang dibawa ke ekspedisi. _Delver honor code_ mengatur bahwa alat penerangan
harus dipegang oleh penjelajah yang posisinya paling tinggi. Sayangnya,
penjelajah yang ingin bergabung ke ekspedisi tidak semuanya memiliki penglihatan
yang normal. Ada saja penjelajah yang memiliki penglihatan terbatas. Seorang
penjelajah yang memiliki batas jarak pandang `K` harus diposisikan agar jaraknya
dari sumber cahaya tidak lebih dari `K`. Perhatikan gambar 2, **jarak antara**
**seorang penjelajah X dengan penjelajah Y yang memegang sumber cahaya adalah**
**banyaknya nama penjelajah di antara X dan Y apabila nama semua penjelajah**
**diurutkan secara leksikografs, inklusif Y, ekslusif X.** Apabila penjelajah
yang memiliki keterbatasan ini **tidak mungkin** ditempatkan dengan syarat
tersebut, **maka ia tidak dapat bergabung ke ekspedisi**. Setiap penjelajah yang
punya keterbatasan penglihatan yang berhasil bergabung akan mulai beradaptasi
dengan lingkungan The Abyss sehingga apabila kedepannya ia dipindahkan ke posisi
lain, ia tidak akan bermasalah.

The Abyss adalah tempat yang sangat berbahaya, sangat sering terjadi musibah
pada ekspedisi. Ada banyak jenis musibah yang dapat terjadi, tetapi yang pasti,
**apabila terjadi musibah, semua penjelajah yang berada di paling bawah, yaitu**
**penjelajah yang tidak menggantung penjelajah lain, akan <u>terjatuh secara</u>**
**<u>bersamaan</u> dan tewas terbunuh.**

Karena Anda adalah seorang Black Whistles yang kebetulan juga seorang computer
scientist, maka Anda lah yang ditugaskan untuk membuat sistem yang akan membantu
jalannya ekspedisi. Ekspedisi dijadwalkan untuk dimulai pada tanggal 26 November
2018 pukul 23.59. Para Black Whistles dan leluhur Delver tidak akan senang
apabila penjelajahan terpaksa diundur karena urusan sepele. Maka dari itu,
sistem yang Anda kembangkan harus selesai sebelum penjelajahan dimulai. _May_
_the Force be with you._

## Format Input/Output

Baris pertama program menerima input sebuah bilangan bulat `Q` (**1** ≤ `Q` ≤
**5 x 10<sup>4</sup>**) sebagai jumlah query program. Kemudian sebanyak `Q`
baris berikutnya program akan menerima sebuah query/operasi untuk setiap
barisnya. Setiap query punya format tertentu dan beberapa query ada yang meminta
output, ada juga yang tidak. Berikut rincian masing-masing query:

### GABUNG X

Penjelajah `X` bergabung ke eksplorasi The Abyss. Tidak ada output. Nama setiap
penjelajah dijamin berbeda.

### GABUNG X K

Penjelajah `X` dengan keterbatasan penglihatan yang memiliki jarak pandang `K`
(**0** ≤ `K` ≤ **10<sup>5</sup>**) ingin bergabung ke eksplorasi The Abyss.
Tidak ada output. Nama setiap penjelajah dijamin berbeda.

### PARTNER X

Output nama penjelajah yang merupakan **partner** dari `X`. Output "TIDAK ADA"
(tanpa tanda kutip) jika `X` tidak memiliki partner. Dijamin penjelajah `X`
sedang berada dalam ekspedisi.

### MENYERAH X

Penjelajah `X` mengundurkan diri dari eksplorasi The Abyss dan harus dihapus
dari sistem. Berdasarkan _Delver honor code_, apabila posisi penjelajah yang
mengundurkan diri tidak berada pada ujung tali, maka posisinya harus digantikan
oleh penjelajah lain. Prioritas pengganti adalah **penjelajah lain yang**
**digantung, secara langsung/tidak langsung, oleh penjelajah yang menyerah dan**
**namanya bersebelahan dengan nama penjelajah yang menyerah apabila nama semua**
**penjelajah diurutkan secara leksikografis**. Jika terdapat lebih dari satu
kandidat, maka yang menggantikan posisinya adalah <u>penjelajah yang posisinya</u>
<u>di barat penjelajah yang mengundurkan diri.</u>

Setelah penggantian posisi, formasi penjelajahan diseimbangkan kembali
berdasarkan algoritma yang sebelumnya disebutkan. Dijamin penjelajah `X` yang
mengundurkan diri dalam query sedang berada dalam ekspedisi.

### CEDERA X

Penjelajah `X` cedera dan terpaksa diberhentikan dari ekspedisi. Berdasarkan
_Delver honor code_, apabila posisi penjelajah yang cedera tidak berada pada
ujung tali, maka posisinya harus digantikan oleh penjelajah lain. Prioritas
pengganti adalah **penjelajah lain yang digantung, secara**
**langsung/tidak langsung, oleh penjelajah yang menyerah, dan namanya**
**bersebelahan dengan nama penjelajah yang cedera apabila nama semua**
**penjelajah diurutkan secara leksikografis.** **Jika terdapat lebih dari satu**
**kandidat, maka yang menggantikan adalah yang posisinya <u>paling dalam</u>**
**<sup>[2](#fn2)</sup>, dan jika kedalamannya sama, pilih yang posisinya**
**lebih timur.**

Setelah penggantian posisi, formasi penjelajahan diseimbangkan kembali
berdasarkan algoritma yang sebelumnya disebutkan. Dijamin penjelajah `X` yang
cedera dalam query sedang berada dalam ekspedisi.

### PRINT

Output semua nama penjelajah dalam tree secara **preorder** dan **postorder**.
Dijamin terdapat paling sedikit satu penjelajah saat query diberikan. Baris
pertama output adalah print preorder, baris kedua print postorder. Setiap
nama penjelajah diakhiri oleh semicolon (;), tanpa ada spasi. Silakan lihat
sample case. Dijamin total nama penjelajah yang di-output-kan dari seluruh query
≤ **5 x 10<sup>4</sup>**.

### MUSIBAH

Output <u>semua nama</u> penjelajah yang tewas akibat musibah, terurut secara
leksikografs. Musibah tidak mungkin terjadi apabila tidak ada penjelajah yang
sedang menjelajahi The Abyss. Setiap nama penjelajah diakhiri oleh semicolon
(;), tanpa ada spasi. Silakan lihat sample case.

### PANJANG-TALI X Y

Output total panjang tali penjelajahan yang menyambungkan penjelajah `X` dan
penjelajah `Y`. Asumsikan panjang tali antara dua penjelajah yang terhubung
langsung adalah satu satuan unit. Dijamin terdapat penjelajah dengan nama `X`
dan `Y` dalam ekspedisi saat query diberikan.

### GANTUNGAN N X<sub>1</sub> X<sub>2</sub> ... X<sub>N</sub>

Output nama seorang penjelajah **paling bawah** yang mana jika ia memutuskan
tali yang berada di atas kepalanya, maka penjelajah X<sub>1</sub>, X<sub>2</sub>
, ..., X<sub>N</sub> akan terjatuh dan tewas. (**2** ≤ `N` ≤ |`P`|) — |`P`|
adalah jumlah penjelajah pada saat query diberikan. Dijamin total N dari seluruh
query tidak melebihi **5 x 10<sup>4</sup>**.

## Batasan

Nama penjelajah merupakan string tidak kosong dan hanya berisi huruf kapital
(A-Z) tanpa spasi atau simbol apa pun dengan panjang maksimal 5.

---

## Contoh Kasus 1

| No  | Input            | Output                                                                                                   |
| --- | ---------------- | -------------------------------------------------------------------------------------------------------- |
| 1   | 19               |                                                                                                          |
| 2   | GABUNG LYZA      |                                                                                                          |
| 3   | GABUNG RYKO      |                                                                                                          |
| 4   | GABUNG SHIMRED   |                                                                                                          |
| 5   | GABUNG REG       |                                                                                                          |
| 6   | GABUNG NANACHI   |                                                                                                          |
| 7   | GABUNG BONDREWD  |                                                                                                          |
| 8   | GABUNG JIROU     |                                                                                                          |
| 9   | GABUNG KIWI 2    |                                                                                                          |
| 10  | PRINT            | NANACHI;JIROU;BONDREWD;LYZA;KIWI;RIKO;REG;SHIMRED;<br>BONDREWD;KIWI;LYZA;JIRUO;REG;SHIMRED;RIKO;NANACHI; |
| 11  | PARTNER LYZA     | BONDREWD                                                                                                 |
| 12  | PARTNER BONDREWD | LYZA                                                                                                     |
| 13  | CEDERA NANACHI   |                                                                                                          |
| 14  | CEDERA SHIMRED   |                                                                                                          |
| 15  | PRINT            | LYZA;JIRUO;BONDREWD;KIWI;REG;RIKO;<br>BONDREWD;KIWI;JIRUO;RIKO;REG;LYZA;                                 |
| 16  | MENYERAH LYZA    |                                                                                                          |
| 17  | PRINT            | KIWI;JIRUO;BONDREWD;REG;RIKO;<br>BONDREWD;JIRUO;RIKO;REG;KIWI;                                           |
| 18  | PARTNER RIKO     | TIDAK ADA                                                                                                |
| 19  | GABUNG SIGGY 2   |                                                                                                          |
| 20  | MUSIBAH          | BONDREWD;RIKO;                                                                                           |

## Penjelasan Contoh 1

![Abyss](img/ab3.png?raw=true)

![Abyss](img/ab4.png?raw=true)

![Abyss](img/ab5.png?raw=true)

![Abyss](img/ab6.png?raw=true)

---

## Contoh Kasus 2

| No  | Input                              | Output  |
| --- | ---------------------------------- | ------- |
| 1   | 13                                 |         |
| 2   | GABUNG ANTONIO                     |         |
| 3   | GABUNG RAMIREZ                     |         |
| 4   | GABUNG FERGUSO                     |         |
| 5   | GABUNG GARCIA                      |         |
| 6   | GABUNG SERGIO                      |         |
| 7   | GABUNG EMANUELA                    |         |
| 8   | GABUNG MARIA                       |         |
| 9   | GANTUNGAN 2 SERGIO MARIA           | RAMIREZ |
| 10  | GANTUNGAN 2 ANTONIO EMANUELA       | ANTONIO |
| 11  | GANTUNGAN 3 GARCIA SERGIO EMANUELA | FERGUSO |
| 12  | PANJANG-TALI MARIA GARCIA          | 1       |
| 13  | PANJANG-TALI EMANUELA RAMIREZ      | 3       |
| 14  | PANJANG-TALI FERGUSO FERGUSO       | 0       |

## Penjelasan Contoh 2

![Abyss](img/ab7.png?raw=true)
![Abyss](img/ab8.png?raw=true)

![Abyss](img/ab9.png?raw=true)
![Abyss](img/ab10.png?raw=true)

![Abyss](img/ab11.png?raw=true)
![Abyss](img/ab12.png?raw=true)

---

#### Footnote

1. <span id="fn1">https://en.wikipedia.org/wiki/AVL_tree</span>

2. <span id="fn2">Deskripsi ini tidak kontradiksi dengan deskripsi sebelumnya
   (terkait panjang tali)</span>
