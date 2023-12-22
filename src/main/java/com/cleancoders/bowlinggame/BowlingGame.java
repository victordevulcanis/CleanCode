package com.cleancoders.bowlinggame;

public class BowlingGame {

    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;

        for (int frame = 0; frame < 10; frame++)
            if (isStrike(frameIndex)) {
                score += 10 + nextTwoRollsAfterStrike(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += 10 + nextRollAfterSpare(frameIndex);
                frameIndex += 2;
            } else {
                score += twoRollsInFrame(frameIndex);
                frameIndex += 2;
            }
        return score;
    }

    private int nextTwoRollsAfterStrike(int frameIndex){
        return  rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private int nextRollAfterSpare(int frameIndex){
        return rolls[frameIndex + 2];
    }

    private int twoRollsInFrame(int frameIndex){
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }   


}
