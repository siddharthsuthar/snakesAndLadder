package com.company;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SnakeNLadderTest {

    @Test
    void rollDice() {
        SnakeNLadder s = new SnakeNLadder();
        int val = s.rollDice();
        assertTrue(val%2==0);
        assertTrue(1<=val && val <=6); // check for val between 1-6
    }

    @Test
    void calculatePlayerValue() {
        SnakeNLadder s = new SnakeNLadder();
        assertEquals(97,s.calculatePlayerValue(97,6)); // should return 97
        assertEquals(100,s.calculatePlayerValue(94,6));
    }

    @Test
    void isWin() {
        SnakeNLadder s = new SnakeNLadder();
        assertTrue(s.isWin(100)); //
        int n = 0;
        Random r = new Random();
        n=r.nextInt(100); // should return false for any value not 100
        assertFalse(s.isWin(n));
    }
}