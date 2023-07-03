package br.com.alura.Model;

import com.google.gson.annotations.SerializedName;

public class Endereco {
    private String cep;
    @SerializedName("logradouro")
    private String rua;
    private String bairro;
    private String complemento;
    @SerializedName("localidade")
    private String cidade;
    private String uf;
    private String numero;

    public Endereco(){

    }


    @Override
    public String toString() {
        return String.format("""
                Cep = %s,
                Rua = %s,
                Número = %s
                Bairro = %s,
                Comp = %s,
                Cidade = %s,
                Estado = %s
                """,
                cep, rua, numero, bairro, complemento, cidade, uf);
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
