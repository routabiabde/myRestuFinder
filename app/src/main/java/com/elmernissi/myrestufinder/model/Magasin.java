package com.elmernissi.myrestufinder.model;

public class Magasin {
    private  String nomRes,nomVill,tel;


    public Magasin(String nomRes, String nomVill, String tel) {
        this.nomRes = nomRes;
        this.nomVill = nomVill;
        this.tel = tel;
    }

    public String getNomRes() {
        return nomRes;
    }

    public String getNomVill() {
        return nomVill;
    }

    public String getTel() {
        return tel;
    }
}
