# Worksheet 2 - PTML

- Batas waktu eksekusi program : 3 detik / kasus uji
- Batas memori program : 256 MB / kasus uji

Peter adalah mahasiswa Fasilkom UI pencipta sebuah Markup Language baru yang
disebut nama Peter Markup Language (PTML). PTML memiliki aturan tagging yang
sangat rapi dan terstruktur, sebagai berikut:

1.  Setiap ​*opening tag*​ harus memiliki ​*matching closing tag*.
2.  Format ​*tagging*:

    - Tag adalah suatu string yang diawali dengan karakter '<' lalu diikuti
      dengan nama tag dan diakhiri dengan karakter '>' pada baris yang sama.

    - _Opening tag_ adalah suatu string yang diawali dengan string '<' lalu
      diikuti dengan nama tag dan diakhiri dengan karakter '>'

    - _Closing tag_ adalah suatu string yang diawali dengan string '</' lalu
      diikuti dengan nama tag dan diakhiri dengan karakter '>'

3.  Tag dapat memiliki konten string di dalamnya ataupun tidak, dan dapat
    memiliki beberapa nested tags di dalamnya ataupun tidak.
4.  Untuk suatu ​*opening tag*, ​ maka ​*closing tag*-nya harus muncul setelah
    semua konten (jika ada) dan semua nested tagging di dalamnya (jika ada)
    sudah ditutup.

| **Contoh Dokumen PTML yang Valid:**                          |
| ------------------------------------------------------------ |
| `<p>Saya Suka <u>Perancangan <b>Pemrograman</b> Web</u></p>` |
| `<p>Saya juga suka Struktur Data dan Algoritma</p>`          |

| **Contoh Dokumen PTML yang Tidak Valid:** |
| ----------------------------------------- |
| `<a><b><c></a></c></b>`                   |
| `<div>Halo<br></div>`                     |

Tugas Anda, bantulah Peter untuk menentukan apakah suatu konten dokumen PTML
adalah sintaks yang valid atau tidak. Jika valid, Peter ingin tahu berapa
kedalaman terjauh dari _​tagging-tagging_ ​yang paling dalam (​*inner-most*)
pada dokumen tersebut.

Kedalaman suatu ​*tagging* x didefinisikan sebagai berapa banyak _opening tag_
yang belum ditutup yang muncul sebelum _opening tag_ x hingga ke kedalaman 0.
Kedalaman 0 adalah tagging yang paling luar (​*outer-most*).

Contoh:

```text
<a>
  <b>
    <c>
    </c>
    <d>
      <e></e>
    </d>
  </b>
</a>
```

Pada contoh di atas, kedalaman yang paling besar adalah 3 yang dimiliki oleh tag
e. kedalaman untuk tag a, b, c, d, e adalah masing masing 0, 1, 2, 2, 3.

Dalam mengerjakan soal ini, Anda dipersilakan untuk menggunakan Collection yang
sudah disediakan di Java, tidak perlu mengimplementasikan Class Collection
sendiri. Pikirkanlah Collection apa yang paling cocok untuk problem PTML ini.
(https://docs.oracle.com/javase/6/docs/api/java/util/).

---

## Format Masukan

Baris pertama berisi satu string yang merupakan isi dokumen PTML.

(Catatan: Anda tidak perlu melakukan validasi input terhadap kriteria dokumen di
atas.)

## Batasan:

- String pada masukan hanya terdiri dari karakter ‘<’, ‘>’, ‘/’, dan alfabet
  huruf kecil.
- Panjang dari nama tag minimum 1 karakter dan tidak lebih dari 16 karakter.
- Jumlah karakter pada masukan tidak lebih dari 200.000.

## Format Keluaran

Apabila PTML masukan valid, keluarkan satu baris yang berisi "YA x" di mana x
adalah kedalaman maksimum suatu tag pada dokumen tersebut. Jika tidak valid
maka keluarkan "TIDAK".

---

## Contoh Masukan 1:

```text
<a><b><c><d></d><d></d></c></b></a>
```

## Contoh Keluaran 1:

```text
YA 3
```

## Contoh Masukan 2:

```text
<ptml><body><p>hello</body></p></ptml>
```

## Contoh Keluaran 2:

```text
TIDAK
```

## Contoh Masukan 3:

```text
<a><a></a></a>
```

## Contoh Keluaran 3:

```text
YA 1
```
