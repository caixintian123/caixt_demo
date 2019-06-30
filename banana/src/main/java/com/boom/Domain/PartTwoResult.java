package com.boom.Domain;

import java.util.List;

public class PartTwoResult {

    private String[] wordTrunk;
    private List<Answer> answers;

    public String[] getWordTrunk() {
        return wordTrunk;
    }

    public void setWordTrunk(String[] wordTrunk) {
        this.wordTrunk = wordTrunk;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
