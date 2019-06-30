package com.boom.Domain;

import java.util.List;

public class PartThreeResult {
    private String[] wordTrunk;
    private String[] strTrunk;
    private List<Part3Print> part3PrintList;

    public String[] getWordTrunk() {
        return wordTrunk;
    }

    public void setWordTrunk(String[] wordTrunk) {
        this.wordTrunk = wordTrunk;
    }

    public String[] getStrTrunk() {
        return strTrunk;
    }

    public void setStrTrunk(String[] strTrunk) {
        this.strTrunk = strTrunk;
    }

    public List<Part3Print> getPart3PrintList() {
        return part3PrintList;
    }

    public void setPart3PrintList(List<Part3Print> part3PrintList) {
        this.part3PrintList = part3PrintList;
    }
}
