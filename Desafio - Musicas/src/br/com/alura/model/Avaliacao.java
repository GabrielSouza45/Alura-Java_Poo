package br.com.alura.model;

public class Avaliacao {
    public String inclui(Audio audio){
        if (audio.getClassificacao() >= 9){
            return "*****";
        } else if (audio.getClassificacao() >= 5) {
            return "***";
        }else {
            return "*";
        }
    }
}
