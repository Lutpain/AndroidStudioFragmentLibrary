package com.example.ervin.zalorashope.Model;

/**
 * Created by VIN on 1/28/2018.
 */

public class Produk {

    String FotoProduk_, NamaProduk_, JenisProduk, UkuranProduk_;
    int StokProduk, HargaProduk_;

    public Produk(String fotoProduk_, String namaProduk_, String jenisProduk, String ukuranProduk_, int stokProduk, int hargaProduk_) {
        FotoProduk_ = fotoProduk_;
        NamaProduk_ = namaProduk_;
        JenisProduk = jenisProduk;
        UkuranProduk_ = ukuranProduk_;
        StokProduk = stokProduk;
        HargaProduk_ = hargaProduk_;
    }

    public String getFotoProduk_() {
        return FotoProduk_;
    }

    public void setFotoProduk_(String fotoProduk_) {
        FotoProduk_ = fotoProduk_;
    }

    public String getNamaProduk_() {
        return NamaProduk_;
    }

    public void setNamaProduk_(String namaProduk_) {
        NamaProduk_ = namaProduk_;
    }

    public String getJenisProduk() {
        return JenisProduk;
    }

    public void setJenisProduk(String jenisProduk) {
        JenisProduk = jenisProduk;
    }

    public String getUkuranProduk_() {
        return UkuranProduk_;
    }

    public void setUkuranProduk_(String ukuranProduk_) {
        UkuranProduk_ = ukuranProduk_;
    }

    public int getStokProduk() {
        return StokProduk;
    }

    public void setStokProduk(int stokProduk) {
        StokProduk = stokProduk;
    }

    public int getHargaProduk_() {
        return HargaProduk_;
    }

    public void setHargaProduk_(int hargaProduk_) {
        HargaProduk_ = hargaProduk_;
    }
}
