# Worksheet 1 - Rentang Waktu Permainan Menang

Pak Asep senang bermain computer game. Setiap kali bermain, aplikasi game itu
selalu mencatat nilai yang ia peroleh. Jika kalah pemain mendapatkan nilai
bilangan bulat negatif dan jika menang bilangan bulat positif sementara kalau
tidak menang atau tidak kalah hanya 0. Ia ingin mengetahui beberapa rentang
waktu mana saja ia mengalami kemenangan terbesar. Setiap rentang waktu yang ia
cari harus **tidak terputus** (**contiguous**). Selain itu **rentang-rentang**
**yang diperoleh tidak boleh saling overlap**. Dua rentang disebut overlap jika
terdapat bagian dari kedua rentang pada posisi yang sama. Dan, rentang juga
harus **sependek-pendeknya** yaitu jika di ujung-ujungnya tidak ada potongan
dengan total 0.

Anda diminta membuat program untuk mencari rentang-rentang itu dan anda
disarankan menggunakan algoritma maximum subsequence sum O(n) (dengan
modifikasi!) karena besarnya data yang diberikan sehingga **tidak dapat**
**disimpan dalam array** (batas memory sangat kecil untuk menyimpan array
sebanyak data. Dengan demikian proses pencarian harus sekaligus **dilakukan**
**saat data dibaca**.

## Input Data

Baris pertama berisi bilangan `N` dan `k`. Dengan `N` ≤ **100.000**, menyatakan
banyaknya data yang akan diproses. Dan, `k` ≤ **10** menyatakan banyaknya
rentang terbesar yang bukan 0 yang hendak dicari.

## Output Data

Bisa saja banyaknya rentang yang diperoleh kurang dari `k`. Maka, dalam `k`
baris keluaran atau kurang, setiap rentang dicetak dalam satu baris dengan
format: `l r v` (`l` adalah posisi terkiri rentang, `r` adalah posisi terkanan
rentang, dan `v` adalah total bilangan dalam rentang tersebut, dipisahkan satu
spasi dengan `v` > **0**. Rentang-rentang diurutkan menurut `v` dari terbesar
lebih dulu sementara jika terdapat `v` yang sama, maka ditulis dari yang terkiri
lebih dulu. Catatan: dijamin minimal ada 1 rentang dengan `v` > **0**.

## Petunjuk

1. 5 testcase hanya meminta `k` = **1** dan dalam rentang yang diperoleh
   algoritma dalam slide selalu sudah terpendek. Jadi dengan memodifikasi
   algoritma itu dengan mencatat posisi ujung-ujung rentang dengan benar maka
   anda akan mendapat nilai 33.3.
2. 5 testcase berikutnya masih `k` = **1** tetapi di dalam setiap rentang bisa
   terdapat deretan bilangan di ujung rentang yang bernilai 0. Jadi anda harus
   memodifikasi lagi bagaimana deretan di ujung ini bisa dihilangkan. Jika anda
   berhasil membuatnya maka anda akan mendapatkan nilai 66.7.
3. Setelah berhasil mendapatkan no 2, modifikasilah dengan menambahkan kembali
   baris-baris perintah untuk dapat mencatat `k` terbesar. Ada 5 testcase
   demikian, jika anda dapat menyimpan `k` interval terbesar ini maka anda akan
   mendapatkan nilai 100.
