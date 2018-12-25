# Pemakaian Bandwidth

## Deskripsi

Pak Asep adalah pengelola IT dari suatu perusahaan. Sistem IT yang dikelolanya
mencatat pemakaian total bandwidth yang digunakan setiap harinya. Pencatatan
dilakukan pada file log setiap harinya jam 23:59:59, dengan menyimpan tanggal
dan besarnya gigabyte (GB) pemakaian bandwidth yang terjadi dari jam 00:00:00
sampai 23:59:59 hari tersebut itu.

Suatu hari ia ditanyai pimpinan "jika dihitung mulai hari ke **d**, pada hari ke
berapakah akumulasi pemakaian mencapai **m** GB." (Catatan: hari ke d ikut dihitung).

Contoh: Diberikan data pemakaian pemakaiannya sebagaimana pada tabel berikut.

| Hari Ke        | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   |
| -------------- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| Pemakaian (GB) | 5   | 9   | 11  | 9   | 5   | 2   | 2   | 12  | 10  |

Jika dihitung mulai hari ke 3, pada hari ke berapakah terjadi akumulasi pemakaian
mencapai 30 GB? Hari ke 3, 11 GB, hari ke 4, menjadi 20 GB, hari ke 5 menjadi 25 GB,
hari ke 6 menjadi 27 GB, hari ke 7 menjadi 29 GB, dan hari ke 8 menjadi 41 GB.
Jadi akumulasi pemakaian 30 GB terjadi pada hari ke 8.

Banyaknya hari yang tercatat dalam data maksimum ada ≤ 1.000.000, dan untuk data
log yang sama pimpinan mengajukan sejumlah pertanyaan demikian sekaligus (≤
10.000 pertanyaan). Dalam tugas ini anda harus melengkapi suatu program templat
dengan menambahkan method untuk melakukan pencarian pada tabel data tersebut
yang sudah dibaca ke dalam array.

Program templat (program setengah jadi) sudah memiliki fungsi untuk membaca data
(jadi anda tidak perlu pusing dengan format input!) dan menyimpan harga-harga
akumulasinya ke dalam array berformat long integer (64 bit integer) bernama `X`.
Indeks array mulai dari **0**, dengan `X[0]` berisi harga **0**, kemudian `X[1]`
adalah pemakaian hingga **hari 1**, `X[2]` adalah pemakaian hingga **hari ke 2**,
... dan seterusnya hingga `X[N]` adalah pemakaian hingga hari ke **N**. Jadi
panjang array adalah **N+1**. Dijamin juga data dalam **X** yang terbaca akan
bersifat nondecreasing (deret menaik atau sama).

Kemudian, ada M pertanyaan yang harus dijawab. Harga **M** dibaca dari file data
dan pada setiap baris data berikutnya berisi data setiap pertanyaan yang berupa
dua bilangan **t** dan **V**.

Pada setiap pertanyaan **(t, V)** program harus me-_return_ **harga k terkecil**
(program menjawab: **k**) dari semua kemungkinan hari ke k yang memenuhi
`X[k-1] < (V + X[t]) ≤ X[k]`. Dan, jika ternyata dalam data `V+X[t] > X[N]` maka
program menjawab: **TIDAK ADA**.

## Contoh Input

```text
10
10
10
10
10
10
10
10
10
10
10
10
1 5
2 15
3 5
4 15
5 0
6 10
7 10
8 5
9 5
10 15
```

## Contoh Output

```text
2
4
4
6
5
7
8
9
10
TIDAK ADA
```
