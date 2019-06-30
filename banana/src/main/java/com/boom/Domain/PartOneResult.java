package com.boom.Domain;

import java.util.List;

public class PartOneResult {

    private Interval[] wordTrunk;
    private List<Answer> answers;

    public Interval[] getWordTrunk() {
        return wordTrunk;
    }

    public void setWordTrunk(Interval[] wordTrunk) {
        this.wordTrunk = wordTrunk;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
