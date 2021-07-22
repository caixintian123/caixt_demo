package com.boom.Domain;

public class Answer {
    private String matchNum;
    private String choose;
    private String answerRank;
    private String numCode;
    private String tureWords;
    private String tureWordCnt;

    public String getTureWordCnt() {
        return tureWordCnt;
    }

    public void setTureWordCnt(String tureWordCnt) {
        this.tureWordCnt = tureWordCnt;
    }

    public String getTureWords() {
        return tureWords;
    }

    public void setTureWords(String tureWords) {
        this.tureWords = tureWords;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getAnswerRank() {
        return answerRank;
    }

    public void setAnswerRank(String answerRank) {
        this.answerRank = answerRank;
    }

    public String getMatchNum() {
        return matchNum;
    }

    public void setMatchNum(String matchNum) {
        this.matchNum = matchNum;
    }

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose;
    }
}
