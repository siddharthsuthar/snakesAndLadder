package com.company;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner s = new Scanner(System.in);
        int numTimes = s.nextInt();
        SnakeNLadder game = new SnakeNLadder();
        game.startGame(numTimes);
    }
}

class SnakeNLadder
{

    final static int WINPOINT = 100;
    static Map<Integer,Integer> snake = new HashMap<Integer,Integer>();
    static Map<Integer,Integer> ladder = new HashMap<Integer,Integer>();
//    fill the board with snakes and Ladder
    {
        snake.put(99,54);
        snake.put(70,55);
        snake.put(52,42);
        snake.put(25,2);
        snake.put(95,72);
        snake.put(99,54);

        ladder.put(6,25);
        ladder.put(11,40);
        ladder.put(60,85);
        ladder.put(46,90);
        ladder.put(17,69);
    }



    public int rollDice()
    {
        int n = 0;
        Random r = new Random();
        n=r.nextInt(4-1)+1; // this will choose number between 1-3 even probability distribution
        System.out.println("Value of N : "+n);
        return (n==0?2:n*2); // for even dice values.
    }

    public void startGame(int numTimes)
    {
        int player1 =0;
        int diceValue =0;
        int count = 0;
        while(count<numTimes)
        {

            diceValue = rollDice();
            System.out.println("Dice Value : "+diceValue);
            player1 = calculatePlayerValue(player1,diceValue);
            System.out.println("Count : "+ count);
            if(isWin(player1)) {
                System.out.println("First player wins");
                return;
            }
            count++;
        }
    }


    public int calculatePlayerValue(int player, int diceValue)
    {
        player = player + diceValue;

        if(player > WINPOINT)
        {
            player = player - diceValue;
            return player;
        }

        if(null!=snake.get(player))
        {
            System.out.println("swallowed by snake");
            player= snake.get(player);
        }

        if(null!=ladder.get(player))
        {
            System.out.println("climb up the ladder");
            player= ladder.get(player);
        }
        return player;
    }

    public boolean isWin(int player)
    {
        return WINPOINT == player;
    }

}
