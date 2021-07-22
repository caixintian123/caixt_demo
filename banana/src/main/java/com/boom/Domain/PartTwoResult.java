package com.boom.Domain;

import java.util.List;

public class PartTwoResult {

    private String[] wordTrunk;
    private List<Answer> answers;
    private String[] misWordTrunk;

    public String[] getMisordTrunk() {
        return misWordTrunk;
    }

    public void setMisordTrunk(String[] misordTrunk) {
        this.misWordTrunk = misordTrunk;
    }

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
