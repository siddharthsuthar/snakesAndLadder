package com.company;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Enter number of Turns to play the Game : ");
        Scanner s = new Scanner(System.in);
        int numTimes = s.nextInt();
        SnakeNLadder game = new SnakeNLadder();
        game.startGame(numTimes);
    }
}

class SnakeNLadder
{

    final static int WINPOINT = 100;
    static Map<Integer,Integer> snake = new HashMap<Integer,Integer>(); // using a Map to help with searching of snakes and ladder in constant time.
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
        int min = 1 ,  max = 3;         // could use for conditional boolean even , max = even?3:6;
        n=r.nextInt(max)+min; // this will choose number between 1-3 equal probability distribution
        return  (n*2);  // (even?n*2:n); for even dice values.
    }

    public void startGame(int numTimes)
    {
        int player1 = 0; // can have a list of players for multiple players. int [] players
        int diceValue = 0;
        while(numTimes>0) // automatically play for numTimes
        {
            diceValue = rollDice(); // flag = false for all numbers
            player1 = calculatePlayerValue(player1,diceValue);
            if(isWin(player1)) {
                System.out.println("First player wins");
                return;
            }
            numTimes--;
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
            System.out.println("From : " + player + " to " + snake.get(player));
            player= snake.get(player);
        }
        if(null!=ladder.get(player))
        {
            System.out.println("climb up the ladder");
            System.out.println("From : " + player + " to " + ladder.get(player));
            player= ladder.get(player);
        }
        return player;
    }

    public boolean isWin(int player)
    {
        return WINPOINT == player;
    }
}
