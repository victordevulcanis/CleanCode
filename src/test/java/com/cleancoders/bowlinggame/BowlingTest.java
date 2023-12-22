package com.cleancoders.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {

    private BowlingGame g = new BowlingGame();

    private void rollMany(int numberOfFrames, int numberOfPins) {
        for (int i = 0; i < numberOfFrames; i++) {
            g.roll(numberOfPins);
        }
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }

    private void rollStrike() {
        g.roll(10);
    }

    @Test
    public void canRoll() {
        g.roll(0);
    }

    @Test
    public void gutterGame() {
        rollMany(20, 0);
        assertEquals(0, g.score());
    }

    @Test
    public void allOnes() {
        rollMany(20, 1);
        assertEquals(20, g.score());
    }

    @Test
    public void oneSpare() {
        rollSpare();
        g.roll(3);
        rollMany(17, 0);
        assertEquals(16, g.score());
    }

    @Test
    public void oneStrike() {
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(16, 0);
        assertEquals(24, g.score());
    }

    @Test
    public void perfectGame() {
        rollMany(12, 10);
        assertEquals(300, g.score());
    }

}