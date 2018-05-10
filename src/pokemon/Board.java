/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

/**
 *
 * @author 373000888
 */
public class Board
{
    public final static int numRows = 12;
    public final static int numColumns = 12;
    public final static int WALL = 0;
    public final static int PATH = 1;
    public final static int SECR = 2;
    public final static int SEC2 = 3;
    public final static int ROCK = 4;
                                                                                                 //12
       public static int board[][] = {  {WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},
                                        {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
                                        {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
                                        {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
                                        {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
                                        {WALL,PATH,PATH,ROCK,ROCK,PATH,PATH,ROCK,ROCK,PATH,PATH,WALL},
                                        {WALL,PATH,PATH,ROCK,ROCK,PATH,PATH,ROCK,ROCK,PATH,PATH,WALL},
                                        {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
                                        {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
                                        {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
                                        {WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
                                        {WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL}}; //12
                                       
}