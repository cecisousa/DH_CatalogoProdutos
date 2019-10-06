package com.example.dh_catalogoprodutos.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Produto implements Parcelable {

    private String nome;
    private int imagem;
    private String preco;
    private String tamanho;
    private String entrega;

    public Produto () {

    }

    public Produto(String nome, int imagem, String preco, String tamanho, String entrega) {
        this.nome = nome;
        this.imagem = imagem;
        this.preco = preco;
        this.tamanho = tamanho;
        this.entrega = entrega;
    }

    protected Produto(Parcel in) {
        imagem = in.readInt();
        nome = in.readString();
        preco = in.readString();
        tamanho = in.readString();
        entrega = in.readString();
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagem);
        dest.writeString(nome);
        dest.writeString(preco);
        dest.writeString(tamanho);
        dest.writeString(entrega);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }
}
