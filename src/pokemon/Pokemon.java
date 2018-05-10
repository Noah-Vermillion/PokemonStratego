/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;


  
import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class Pokemon extends JFrame implements Runnable {
   
    public enum State
    {
        Title,SetUp,Game,Help,Help2
    }
    Image image;
    Graphics2D g;
    boolean animateFirstTime = true;
//Location of the player.    
//    int currentRow;
//    int currentColumn;
//Direction that the player will move.
    int count;
    int speed;
    int columnDir;
    int rowDir;
    int numNPC = 4;

    Image Excadrill;
    Image Ditto;
    Image megaK;
    Image Sceptile;
    Image Rhydon;
    Image Electivire;
    Image bomb;
    Image Espeon;
    Image Garchomp;
    Image Greninja;
    Image Hydreigon;
    Image megaX;
    Image megaY;
    Image megaS;
    Image PrimalG;
    Image PrimalK;
    Image Ralts;
    Image Scizor;
    Image Abra;
    Image Bisharp;
    Image Red;
    Image Blue;
    Image Umbreon;
    Image Weavile;
    Image Zoroark;
    Image Title;
    Image Help;
    Image HelpBall;
    Image BattleField;
    Image Rock;
    Image Pokemon;
    Image vs;
    Image info;
    Image info2;
    Image Help2;
    Image Char;
    
     int mouseClicked;
    int changeInText;
    int BchangeInText;
    int BmouseClicked;
    
    Piece flagClone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece bomb1Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece bomb2Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece bomb3Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece bomb4Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece bomb5Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece bomb6Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece spyClone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece scout1Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece scout2Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece scout3Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece scout4Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece scout5Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece scout6Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece scout7Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece miner1Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece miner2Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece miner3Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece miner4Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece miner5Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece seargent1Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece seargent2Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece liutenant1Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece liutenant2Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece captain1Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece captain2Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece majorClone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece colonelClone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece generalClone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece marshallClone[][] = new Piece[Board.numRows][Board.numColumns];
    
    Piece BflagClone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bbomb1Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bbomb2Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bbomb3Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bbomb4Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bbomb5Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bbomb6Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece BspyClone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bscout1Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bscout2Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bscout3Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bscout4Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bscout5Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bscout6Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bscout7Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bminer1Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bminer2Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bminer3Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bminer4Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bminer5Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bseargent1Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bseargent2Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bliutenant1Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bliutenant2Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bcaptain1Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece Bcaptain2Clone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece BmajorClone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece BcolonelClone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece BgeneralClone[][] = new Piece[Board.numRows][Board.numColumns];
    Piece BmarshallClone[][] = new Piece[Board.numRows][Board.numColumns];
    
//    int numCoins = 7;
//    Coin coins[] = new Coin[numCoins];
    boolean resetComplete = false;
    boolean gameOver;
//    int value;
//    boolean secretPassageActive;

    Piece flag = Piece.addPiece(Piece.Type.Flag);
    Piece bomb1 = Piece.addPiece(Piece.Type.Bomb);
    Piece bomb2 = Piece.addPiece(Piece.Type.Bomb);
    Piece bomb3 = Piece.addPiece(Piece.Type.Bomb);
    Piece bomb4 = Piece.addPiece(Piece.Type.Bomb);
    Piece bomb5 = Piece.addPiece(Piece.Type.Bomb);
    Piece bomb6 = Piece.addPiece(Piece.Type.Bomb);
    Piece spy = Piece.addPiece(Piece.Type.Spy);
    Piece scout1 = Piece.addPiece(Piece.Type.Scout);
    Piece scout2 = Piece.addPiece(Piece.Type.Scout);
    Piece scout3 = Piece.addPiece(Piece.Type.Scout);
    Piece scout4 = Piece.addPiece(Piece.Type.Scout);
    Piece scout5 = Piece.addPiece(Piece.Type.Scout);
    Piece scout6 = Piece.addPiece(Piece.Type.Scout);
    Piece scout7 = Piece.addPiece(Piece.Type.Scout);
    Piece miner1 = Piece.addPiece(Piece.Type.Miner);
    Piece miner2 = Piece.addPiece(Piece.Type.Miner);
    Piece miner3 = Piece.addPiece(Piece.Type.Miner);
    Piece miner4 = Piece.addPiece(Piece.Type.Miner);
    Piece miner5 = Piece.addPiece(Piece.Type.Miner);
    Piece seargent1 = Piece.addPiece(Piece.Type.Seargent);
    Piece seargent2 = Piece.addPiece(Piece.Type.Seargent);
    Piece lieutenant1 = Piece.addPiece(Piece.Type.Lieutenant);
    Piece lieutenant2 = Piece.addPiece(Piece.Type.Lieutenant);
    Piece captain1 = Piece.addPiece(Piece.Type.Captain);
    Piece captain2 = Piece.addPiece(Piece.Type.Captain);
    Piece major = Piece.addPiece(Piece.Type.Major);
    Piece colonel = Piece.addPiece(Piece.Type.Colonel);
    Piece general = Piece.addPiece(Piece.Type.General);
    Piece marshall = Piece.addPiece(Piece.Type.Marshall);
    static Sound starwarsSound = null;
    static Sound ouchSound = null;
    
    boolean printRed;
    boolean firstTimeB;
    boolean firstTime;
    boolean firstTimeT;
    boolean firstTimeT2;
    boolean setUp;
    boolean gok;
    int gok2;
    int gok3;
    boolean firstTimeBetween;
    
    boolean playerRedTurn;
    boolean miner1selected;
    boolean miner2selected;
     
    boolean betweenTurns;
    int timeBetweenTurns = 3;
    int currTimeTillTurn;
    int timeShownBetweenTurns = 3;
    
    State state;
    State lastState;
    
    

    static Pokemon frame1;
    public static void main(String[] args) {
        frame1 = new Pokemon();
        frame1.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
    }

    public Pokemon() {

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.BUTTON1 == e.getButton()) {
                    if(state == State.Title && e.getX() >= Window.getX(0)+Window.getWidth2()/2-75 && e.getX() <= Window.getX(0)+Window.getWidth2()/2+75 
                            && e.getY() >= Window.getY(0)+Window.getHeight2()/2-150 && e.getY() <= Window.getY(0)+Window.getHeight2()/2+100)
                    {
                        lastState = state;
                        state = State.SetUp;
                        starwarsSound.stopPlaying = true;
                    }
                    else if(state == State.Title && e.getX() >= Window.getX(0)+Window.getWidth2()/2-75 && e.getX() <= Window.getX(0)+Window.getWidth2()/2+75 
                            && e.getY() >= Window.getY(0)+Window.getHeight2()-150 && e.getY() <= Window.getY(0)+Window.getHeight2())
                    {
                        lastState = state;
                        state = State.Help;
                        starwarsSound.stopPlaying = true;
                    }
                     else if(state == State.Help && e.getX() <= Window.getX(0)+Window.getWidth2() && e.getX() >= Window.getX(0)+Window.getWidth2()-125
                            && e.getY() >= Window.getY(0) && e.getY() <= Window.getY(0)+Window.getHeight2()/Board.numRows+20)
                    {
                       // lastState = state;
                        state = State.Help2;
                        starwarsSound.stopPlaying = true;
                    }
                    else if(state == State.SetUp && e.getX() <= Window.getX(0)+Window.getWidth2() && e.getX() >= Window.getX(0)+Window.getWidth2()- Window.getWidth2()/Board.numColumns 
                            && e.getY() >= Window.getY(0) && e.getY() <= Window.getY(0)+Window.getHeight2()/Board.numRows)
                    {
                        lastState = state;
                        state = State.Help;
                        starwarsSound.stopPlaying = true;
                    }
                    else if(state == State.Game && e.getX() <= Window.getX(0)+Window.getWidth2() && e.getX() >= Window.getX(0)+Window.getWidth2()- Window.getWidth2()/Board.numColumns 
                            && e.getY() >= Window.getY(0) && e.getY() <= Window.getY(0)+Window.getHeight2()/Board.numRows)
                    {
                        lastState = state;
                        state = State.Help;
                        starwarsSound.stopPlaying = true;
                    }
                    if(state == State.SetUp && !setUp)
                    {
                        lastState = state;
                        state = State.Game;
                        starwarsSound.stopPlaying = true;
                    }
                    int xpos = e.getX()-(Window.XBORDER+10);
                    int ypos = e.getY()-getY()+(Window.YBORDER + Window.YTITLE-30);
                     int ydelta = Window.getHeight2()/Board.numRows;
                     int xdelta = Window.getWidth2()/Board.numColumns;
                       /////////////////////////////////////////////////////////
                     if(ypos/ydelta <= 4 && ypos/ydelta > 1 && xpos/xdelta > 0 && xpos/xdelta < 11)
                    {
                        if(gok)
                        {
                        mouseClicked++;
                        gok=false;
                        }
                    }
                    if(ypos/ydelta <= Board.numRows-1 && ypos/ydelta > 8 && xpos/xdelta > 0 && xpos/xdelta < 11 && changeInText > 29)
                    {
                        if(gok)
                        {
                        BmouseClicked++;
                        gok=false;
                        }
                    }
                    
                    if(mouseClicked == 1)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (flagClone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11)
                        {
                                flag.setTurn(true);
                                flagClone[i][j-1] = new Piece(); 
                                flagClone[i][j-1].makeCColumn(i);
                                flagClone[i][j-1].makeCRow(j-1);
                                flag.makeCRow(j-1);
                                flag.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                gok2=i;
                                gok3=j-1;
                                Board.board[j-1][i] = Board.SECR;
                                
                                
                                                                  

                        }
                    
                    }
                    
                    if(mouseClicked == 2)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (bomb1Clone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                bomb1.setTurn(true);
                                bomb1Clone[i][j] = new Piece(); 
                                bomb1Clone[i][j].makeCColumn(i);
                                bomb1Clone[i][j].makeCRow(j-1);
                                bomb1.makeCRow(j-1);
                                bomb1.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;

                                

                        }
                    
                    }
                    if(mouseClicked == 3)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (/*bomb2Clone[i][j-1] != bomb1Clone[i][j-1]&&*/bomb2Clone[i][j-1] == null
                                && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                bomb2.setTurn(true);
                                bomb2Clone[i][j] = new Piece(); 
                                bomb2Clone[i][j].makeCColumn(i);
                                bomb2Clone[i][j].makeCRow(j-1);
                                bomb2.makeCRow(j-1);
                                bomb2.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;

                        }
                    
                    }
                    if(mouseClicked == 4)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (bomb3Clone[i][j-1] == null /*&&bomb3Clone[i][j-1] != bomb1Clone[i][j-1] &&bomb3Clone[i][j-1] != bomb2Clone[i][j-1]*/
                                && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                bomb3.setTurn(true);
                                bomb3Clone[i][j] = new Piece(); 
                                bomb3Clone[i][j].makeCColumn(i);
                                bomb3Clone[i][j].makeCRow(j-1);
                                bomb3.makeCRow(j-1);
                                bomb3.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;

                        }
                    
                    }
                    if(mouseClicked == 5)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (bomb4Clone[i][j-1] == null /*&&bomb4Clone[i][j-1] == flagClone[i][j-1] 
                            &&bomb4Clone[i][j-1] != bomb1Clone[i][j-1] &&bomb4Clone[i][j-1] != bomb2Clone[i][j-1]*/
                                && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                bomb4.setTurn(true);
                                bomb4Clone[i][j] = new Piece(); 
                                bomb4Clone[i][j].makeCColumn(i);
                                bomb4Clone[i][j].makeCRow(j-1);
                                bomb4.makeCRow(j-1);
                                bomb4.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;

                        }
                    
                    }
                    if(mouseClicked == 6)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (bomb5Clone[i][j-1] == null /*&&bomb5Clone[i][j-1] != bomb3Clone[i][j-1] &&bomb5Clone[i][j-1] == flagClone[i][j-1] 
                            &&bomb5Clone[i][j-1] != bomb1Clone[i][j-1] &&bomb5Clone[i][j-1] != bomb2Clone[i][j-1]*/
                                && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                bomb5.setTurn(true);
                                bomb5Clone[i][j] = new Piece(); 
                                bomb5Clone[i][j].makeCColumn(i);
                                bomb5Clone[i][j].makeCRow(j-1);
                                bomb5.makeCRow(j-1);
                                bomb5.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                                 

                        }
                    
                    }
                    if(mouseClicked == 7)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (bomb6Clone[i][j-1] == null /*&&bomb6Clone[i][j-1] != bomb4Clone[i][j-1] 
                            &&bomb6Clone[i][j-1] != bomb3Clone[i][j-1] &&bomb6Clone[i][j-1] == flagClone[i][j-1] 
                            &&bomb6Clone[i][j-1] != bomb1Clone[i][j-1] &&bomb6Clone[i][j-1] != bomb2Clone[i][j-1]*/
                                && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                bomb6.setTurn(true);
                                bomb6Clone[i][j] = new Piece(); 
                                bomb6Clone[i][j].makeCColumn(i);
                                bomb6Clone[i][j].makeCRow(j-1);
                                bomb6.makeCRow(j-1);
                                bomb6.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;

                        }
                    
                    }
                    if(mouseClicked == 8)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (spyClone[i][j-1] == null /*&&spyClone[i][j-1] != bomb5Clone[i][j-1] &&spyClone[i][j-1] != bomb4Clone[i][j-1] 
                            &&spyClone[i][j-1] != bomb3Clone[i][j-1] &&spyClone[i][j-1] == flagClone[i][j-1] 
                            &&spyClone[i][j-1] != bomb1Clone[i][j-1] &&spyClone[i][j-1] != bomb2Clone[i][j-1]*/
                                && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                spy.setTurn(true);
                                spyClone[i][j] = new Piece(); 
                                spyClone[i][j].makeCColumn(i);
                                spyClone[i][j].makeCRow(j-1);
                                spy.makeCRow(j-1);
                                spy.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;

                        }
                    
                    }
                    if(mouseClicked == 9)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (scout1Clone[i][j-1] == null /*&&scout1Clone[i][j-1] != bomb6Clone[i][j-1] 
                            &&scout1Clone[i][j-1] != bomb5Clone[i][j-1] &&scout1Clone[i][j-1] != bomb4Clone[i][j-1] 
                            &&scout1Clone[i][j-1] != bomb3Clone[i][j-1] &&scout1Clone[i][j-1] == flagClone[i][j-1] 
                            &&scout1Clone[i][j-1] != bomb1Clone[i][j-1] &&scout1Clone[i][j-1] != bomb2Clone[i][j-1]*/
                                && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                scout1.setTurn(true);
                                scout1Clone[i][j] = new Piece(); 
                                scout1Clone[i][j].makeCColumn(i);
                                scout1Clone[i][j].makeCRow(j-1);
                                scout1.makeCRow(j-1);
                                scout1.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;

                        }
                    
                    }
                    if(mouseClicked == 10)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (scout2Clone[i][j-1] == null /*&&scout2Clone[i][j-1] != spyClone[i][j-1] &&scout2Clone[i][j-1] != bomb6Clone[i][j-1] 
                            &&scout2Clone[i][j-1] != bomb5Clone[i][j-1] &&scout2Clone[i][j-1] != bomb4Clone[i][j-1] 
                            &&scout2Clone[i][j-1] != bomb3Clone[i][j-1] &&scout2Clone[i][j-1] == flagClone[i][j-1] 
                            &&scout2Clone[i][j-1] != bomb1Clone[i][j-1] &&scout2Clone[i][j-1] != bomb2Clone[i][j-1]*/
                                && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                scout2.setTurn(true);
                                scout2Clone[i][j] = new Piece(); 
                                scout2Clone[i][j].makeCColumn(i);
                                scout2Clone[i][j].makeCRow(j-1);
                                scout2.makeCRow(j-1);
                                scout2.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;

                        }
                    
                    }
                    if(mouseClicked == 11)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (scout3Clone[i][j-1] == null/*&&scout3Clone[i][j-1] != scout1Clone[i][j-1]
                            &&scout3Clone[i][j-1] != spyClone[i][j-1] &&scout3Clone[i][j-1] != bomb6Clone[i][j-1] 
                            &&scout3Clone[i][j-1] != bomb5Clone[i][j-1] &&scout3Clone[i][j-1] != bomb4Clone[i][j-1] 
                            &&scout3Clone[i][j-1] != bomb3Clone[i][j-1] &&scout3Clone[i][j-1] == flagClone[i][j-1] 
                            &&scout3Clone[i][j-1] != bomb1Clone[i][j-1] &&scout3Clone[i][j-1] != bomb2Clone[i][j-1]*/
                               && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                scout3.setTurn(true);
                                scout3Clone[i][j] = new Piece(); 
                                scout3Clone[i][j].makeCColumn(i);
                                scout3Clone[i][j].makeCRow(j-1);
                                scout3.makeCRow(j-1);
                                scout3.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 12)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (scout4Clone[i][j-1] == null/* &&scout4Clone[i][j-1] != scout2Clone[i][j-1] &&scout4Clone[i][j-1] != scout1Clone[i][j-1]
                            &&scout4Clone[i][j-1] != spyClone[i][j-1] &&scout4Clone[i][j-1] != bomb6Clone[i][j-1] 
                            &&scout4Clone[i][j-1] != bomb5Clone[i][j-1] &&scout4Clone[i][j-1] != bomb4Clone[i][j-1] 
                            &&scout4Clone[i][j-1] != bomb3Clone[i][j-1] &&scout4Clone[i][j-1] == flagClone[i][j-1] 
                            &&scout4Clone[i][j-1] != bomb1Clone[i][j-1] &&scout4Clone[i][j-1] != bomb2Clone[i][j-1]*/
                                && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                scout4.setTurn(true);
                                scout4Clone[i][j] = new Piece(); 
                                scout4Clone[i][j].makeCColumn(i);
                                scout4Clone[i][j].makeCRow(j-1);
                                scout4.makeCRow(j-1);
                                scout4.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 13)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (scout5Clone[i][j-1] == null/* &&scout5Clone[i][j-1] != scout3Clone[i][j-1] 
                            &&scout5Clone[i][j-1] != scout2Clone[i][j-1] &&scout5Clone[i][j-1] != scout1Clone[i][j-1]
                            &&scout5Clone[i][j-1] != spyClone[i][j-1] &&scout5Clone[i][j-1] != bomb6Clone[i][j-1] 
                            &&scout5Clone[i][j-1] != bomb5Clone[i][j-1] &&scout5Clone[i][j-1] != bomb4Clone[i][j-1] 
                            &&scout5Clone[i][j-1] != bomb3Clone[i][j-1] &&scout5Clone[i][j-1] == flagClone[i][j-1] 
                            &&scout5Clone[i][j-1] != bomb1Clone[i][j-1] &&scout5Clone[i][j-1] != bomb2Clone[i][j-1]*/
                                && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                scout5.setTurn(true);
                                scout5Clone[i][j] = new Piece(); 
                                scout5Clone[i][j].makeCColumn(i);
                                scout5Clone[i][j].makeCRow(j-1);
                                scout5.makeCRow(j-1);
                                scout5.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 14)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (scout6Clone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                scout6.setTurn(true);
                                scout6Clone[i][j] = new Piece(); 
                                scout6Clone[i][j].makeCColumn(i);
                                scout6Clone[i][j].makeCRow(j-1);
                                scout6.makeCRow(j-1);
                                scout6.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 15)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (scout7Clone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                scout7.setTurn(true);
                                scout7Clone[i][j] = new Piece(); 
                                scout7Clone[i][j].makeCColumn(i);
                                scout7Clone[i][j].makeCRow(j-1);
                                scout7.makeCRow(j-1);
                                scout7.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 16)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (miner1Clone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                miner1.setTurn(true);
                                miner1Clone[i][j] = new Piece(); 
                                miner1Clone[i][j].makeCColumn(i);
                                miner1Clone[i][j].makeCRow(j-1);
                                miner1.makeCRow(j-1);
                                miner1.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 17)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (miner2Clone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                miner2.setTurn(true);
                                miner2Clone[i][j] = new Piece(); 
                                miner2Clone[i][j].makeCColumn(i);
                                miner2Clone[i][j].makeCRow(j-1);
                                miner2.makeCRow(j-1);
                                miner2.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 18)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (miner3Clone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                miner3.setTurn(true);
                                miner3Clone[i][j] = new Piece(); 
                                miner3Clone[i][j].makeCColumn(i);
                                miner3Clone[i][j].makeCRow(j-1);
                                miner3.makeCRow(j-1);
                                miner3.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 19)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (miner4Clone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                miner4.setTurn(true);
                                miner4Clone[i][j] = new Piece(); 
                                miner4Clone[i][j].makeCColumn(i);
                                miner4Clone[i][j].makeCRow(j-1);
                                 miner4.makeCRow(j-1);
                                miner4.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 20)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (miner5Clone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                miner5.setTurn(true);
                                miner5Clone[i][j] = new Piece(); 
                                miner5Clone[i][j].makeCColumn(i);
                                miner5Clone[i][j].makeCRow(j-1);
                                miner5.makeCRow(j-1);
                                miner5.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 21)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (seargent1Clone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                seargent1.setTurn(true);
                                seargent1Clone[i][j] = new Piece(); 
                                seargent1Clone[i][j].makeCColumn(i);
                                seargent1Clone[i][j].makeCRow(j-1);
                                seargent1.makeCRow(j-1);
                                seargent1.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 22)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (seargent2Clone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                seargent2.setTurn(true);
                                seargent2Clone[i][j] = new Piece(); 
                                seargent2Clone[i][j].makeCColumn(i);
                                seargent2Clone[i][j].makeCRow(j-1);
                                seargent2.makeCRow(j-1);
                                seargent2.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 23)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (liutenant1Clone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                lieutenant1.setTurn(true);
                                liutenant1Clone[i][j] = new Piece(); 
                                liutenant1Clone[i][j].makeCColumn(i);
                                liutenant1Clone[i][j].makeCRow(j-1);
                                lieutenant1.makeCRow(j-1);
                                lieutenant1.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 24)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (liutenant2Clone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                lieutenant2.setTurn(true);
                                liutenant2Clone[i][j] = new Piece(); 
                                liutenant2Clone[i][j].makeCColumn(i);
                                liutenant2Clone[i][j].makeCRow(j-1);
                                lieutenant2.makeCRow(j-1);
                                lieutenant2.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 25)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (captain1Clone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                captain1.setTurn(true);
                                captain1Clone[i][j] = new Piece(); 
                                captain1Clone[i][j].makeCColumn(i);
                                captain1Clone[i][j].makeCRow(j-1);
                                captain1.makeCRow(j-1);
                                captain1.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 26)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (captain2Clone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                captain2.setTurn(true);
                                captain2Clone[i][j] = new Piece(); 
                                captain2Clone[i][j].makeCColumn(i);
                                captain2Clone[i][j].makeCRow(j-1);
                                captain2.makeCRow(j-1);
                                captain2.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 27)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (majorClone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                major.setTurn(true);
                                majorClone[i][j] = new Piece(); 
                                majorClone[i][j].makeCColumn(i);
                                majorClone[i][j].makeCRow(j-1);
                                major.makeCRow(j-1);
                                major.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 28)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (colonelClone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                colonel.setTurn(true);
                                colonelClone[i][j] = new Piece(); 
                                colonelClone[i][j].makeCColumn(i);
                                colonelClone[i][j].makeCRow(j-1);
                                colonel.makeCRow(j-1);
                                colonel.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(mouseClicked == 29)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (generalClone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                general.setTurn(true);
                                generalClone[i][j] = new Piece(); 
                                generalClone[i][j].makeCColumn(i);
                                generalClone[i][j].makeCRow(j-1);
                                general.makeCRow(j-1);
                                general.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                                

                        }
                    
                    }
                    if(mouseClicked == 30)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (marshallClone[i][j-1] == null && j<=4 && j > 1 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {

                                marshall.setTurn(true);
                                marshallClone[i][j] = new Piece(); 
                                marshallClone[i][j].makeCColumn(i);
                                marshallClone[i][j].makeCRow(j-1);
                                marshall.checkspot(marshall, i, j);
                                marshall.makeCRow(j-1);
                                marshall.makeCColumn(i);
                                gok=true;
                                changeInText++;
                                Board.board[j-1][i] = Board.SECR;
                        }
                    
                    }
                    if(BmouseClicked == 1)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (BflagClone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                flag.setTurn(false);
                                BflagClone[i][j] = new Piece(); 
                                BflagClone[i][j].makeCColumn(i);
                                BflagClone[i][j].makeCRow(j-1);
                                flag.makeCRow(j-1);
                                flag.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;
                        }
                    
                    }
                    if(BmouseClicked == 2)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bbomb1Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                               bomb1.setTurn(false);
                                Bbomb1Clone[i][j] = new Piece(); 
                                Bbomb1Clone[i][j].makeCColumn(i);
                                Bbomb1Clone[i][j].makeCRow(j-1);
                                bomb1.makeCRow(j-1);
                                bomb1.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;
                        }
                    
                    }
                    if(BmouseClicked == 3)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bbomb2Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                bomb2.setTurn(false);
                                Bbomb2Clone[i][j] = new Piece(); 
                                Bbomb2Clone[i][j].makeCColumn(i);
                                Bbomb2Clone[i][j].makeCRow(j-1);
                                bomb2.makeCRow(j-1);
                                bomb2.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;

                        }
                    
                    }
                    if(BmouseClicked == 4)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bbomb3Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                bomb3.setTurn(false);
                                Bbomb3Clone[i][j] = new Piece(); 
                                Bbomb3Clone[i][j].makeCColumn(i);
                                Bbomb3Clone[i][j].makeCRow(j-1);
                                bomb3.makeCRow(j-1);
                                bomb3.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;
                        }
                    
                    }
                    if(BmouseClicked == 5)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bbomb4Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                             bomb4.setTurn(false);
                                Bbomb4Clone[i][j] = new Piece(); 
                                Bbomb4Clone[i][j].makeCColumn(i);
                                Bbomb4Clone[i][j].makeCRow(j-1);
                                bomb4.makeCRow(j-1);
                                bomb4.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;
                        }
                    
                    }
                    if(BmouseClicked == 6)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bbomb5Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                 bomb5.setTurn(false);
                                Bbomb5Clone[i][j] = new Piece(); 
                                Bbomb5Clone[i][j].makeCColumn(i);
                                Bbomb5Clone[i][j].makeCRow(j-1);
                                bomb5.makeCRow(j-1);
                                bomb5.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;
                        }
                    
                    }
                    if(BmouseClicked == 7)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bbomb6Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                 bomb6.setTurn(false);
                                Bbomb6Clone[i][j] = new Piece(); 
                                Bbomb6Clone[i][j].makeCColumn(i);
                                Bbomb6Clone[i][j].makeCRow(j-1);
                                bomb6.makeCRow(j-1);
                                bomb6.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;


                        }
                    
                    }
                    if(BmouseClicked == 8)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (BspyClone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                               spy.setTurn(false);
                                BspyClone[i][j] = new Piece(); 
                                BspyClone[i][j].makeCColumn(i);
                                BspyClone[i][j].makeCRow(j-1);
                                spy.makeCRow(j-1);
                                spy.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;

                        }
                    
                    }
                    if(BmouseClicked == 9)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bscout1Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                               scout1.setTurn(false);
                                Bscout1Clone[i][j] = new Piece(); 
                                Bscout1Clone[i][j].makeCColumn(i);
                                Bscout1Clone[i][j].makeCRow(j-1);
                                scout1.makeCRow(j-1);
                                scout1.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;
                        }
                    
                    }
                    if(BmouseClicked == 10)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bscout2Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                               scout2.setTurn(false);
                                Bscout2Clone[i][j] = new Piece(); 
                                Bscout2Clone[i][j].makeCColumn(i);
                                Bscout2Clone[i][j].makeCRow(j-1);
                                scout2.makeCRow(j-1);
                                scout2.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;
                        }
                    
                    }
                    if(BmouseClicked == 11)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bscout3Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                  scout3.setTurn(false);
                                Bscout3Clone[i][j] = new Piece(); 
                                Bscout3Clone[i][j].makeCColumn(i);
                                Bscout3Clone[i][j].makeCRow(j-1);
                                scout3.makeCRow(j-1);
                                scout3.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;
                        }
                    
                    }
                    if(BmouseClicked == 12)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bscout4Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                scout4.setTurn(false);
                                Bscout4Clone[i][j] = new Piece(); 
                                Bscout4Clone[i][j].makeCColumn(i);
                                Bscout4Clone[i][j].makeCRow(j-1);
                                scout4.makeCRow(j-1);
                                scout4.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;
                        }
                    
                    }
                    if(BmouseClicked == 13)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bscout5Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                scout5.setTurn(false);
                                Bscout5Clone[i][j] = new Piece(); 
                                Bscout5Clone[i][j].makeCColumn(i);
                                Bscout5Clone[i][j].makeCRow(j-1);
                                scout5.makeCRow(j-1);
                                scout5.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;

                        }
                    
                    }
                    if(BmouseClicked == 14)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bscout6Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                  scout6.setTurn(false);
                                Bscout6Clone[i][j] = new Piece(); 
                                Bscout6Clone[i][j].makeCColumn(i);
                                Bscout6Clone[i][j].makeCRow(j-1);
                                scout6.makeCRow(j-1);
                                scout6.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;

                        }
                    
                    }
                    if(BmouseClicked == 15)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bscout7Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                  scout7.setTurn(false);
                                Bscout7Clone[i][j] = new Piece(); 
                                Bscout7Clone[i][j].makeCColumn(i);
                                Bscout7Clone[i][j].makeCRow(j-1);
                                scout7.makeCRow(j-1);
                                scout7.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;
                        }
                    
                    }
                    if(BmouseClicked == 16)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bminer1Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                miner1.setTurn(false);
                                Bminer1Clone[i][j] = new Piece(); 
                                Bminer1Clone[i][j].makeCColumn(i);
                                Bminer1Clone[i][j].makeCRow(j-1);
                                miner1.makeCRow(j-1);
                                miner1.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;


                        }
                    
                    }
                    if(BmouseClicked == 17)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bminer2Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                miner2.setTurn(false);
                                Bminer2Clone[i][j] = new Piece(); 
                                Bminer2Clone[i][j].makeCColumn(i);
                                Bminer2Clone[i][j].makeCRow(j-1);
                                miner2.makeCRow(j-1);
                                miner2.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;

                        }
                    
                    }
                    if(BmouseClicked == 18)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bminer3Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                miner3.setTurn(false);
                                Bminer3Clone[i][j] = new Piece(); 
                                Bminer3Clone[i][j].makeCColumn(i);
                                Bminer3Clone[i][j].makeCRow(j-1);
                                miner3.makeCRow(j-1);
                                miner3.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;
                        }
                    
                    }
                    if(BmouseClicked == 19)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bminer4Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                               
                                miner4.setTurn(false);
                                Bminer4Clone[i][j] = new Piece(); 
                                Bminer4Clone[i][j].makeCColumn(i);
                                Bminer4Clone[i][j].makeCRow(j-1);
                                miner4.makeCRow(j-1);
                                miner4.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;

                        }
                    
                    }
                    if(BmouseClicked == 20)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bminer5Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                miner5.setTurn(false);
                                Bminer5Clone[i][j] = new Piece(); 
                                Bminer5Clone[i][j].makeCColumn(i);
                                Bminer5Clone[i][j].makeCRow(j-1);
                                miner5.makeCRow(j-1);
                                miner5.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;

                        }
                    
                    }
                    if(BmouseClicked == 21)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bseargent1Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                seargent1.setTurn(false);
                                Bseargent1Clone[i][j] = new Piece(); 
                                Bseargent1Clone[i][j].makeCColumn(i);
                                Bseargent1Clone[i][j].makeCRow(j-1);
                                seargent1.makeCRow(j-1);
                                seargent1.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;

                        }
                    
                    }
                    if(BmouseClicked == 22)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bseargent2Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                seargent2.setTurn(false);
                                Bseargent2Clone[i][j] = new Piece(); 
                                Bseargent2Clone[i][j].makeCColumn(i);
                                Bseargent2Clone[i][j].makeCRow(j-1);
                                seargent2.makeCRow(j-1);
                                seargent2.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;

                        }
                    
                    }
                    if(BmouseClicked == 23)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bliutenant1Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                  lieutenant1.setTurn(false);
                                Bliutenant1Clone[i][j] = new Piece(); 
                                Bliutenant1Clone[i][j].makeCColumn(i);
                                Bliutenant1Clone[i][j].makeCRow(j-1);
                                lieutenant1.makeCRow(j-1);
                                lieutenant1.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;
                        }
                    
                    }
                    if(BmouseClicked == 24)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bliutenant2Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                 lieutenant2.setTurn(false);
                                Bliutenant2Clone[i][j] = new Piece(); 
                                Bliutenant2Clone[i][j].makeCColumn(i);
                                Bliutenant2Clone[i][j].makeCRow(j-1);
                                lieutenant2.makeCRow(j-1);
                                lieutenant2.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;
                        }
                    
                    }
                    if(BmouseClicked == 25)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bcaptain1Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                captain1.setTurn(false);
                                Bcaptain1Clone[i][j] = new Piece(); 
                                Bcaptain1Clone[i][j].makeCColumn(i);
                                Bcaptain1Clone[i][j].makeCRow(j-1);
                                captain1.makeCRow(j-1);
                                captain1.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;
                        }
                    
                    }
                    if(BmouseClicked == 26)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (Bcaptain2Clone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                               captain2.setTurn(false);
                                Bcaptain2Clone[i][j] = new Piece(); 
                                Bcaptain2Clone[i][j].makeCColumn(i);
                                Bcaptain2Clone[i][j].makeCRow(j-1);
                                captain2.makeCRow(j-1);
                                captain2.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;

                        }
                    
                    }
                    if(BmouseClicked == 27)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (BmajorClone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                major.setTurn(false);
                                BmajorClone[i][j] = new Piece(); 
                                BmajorClone[i][j].makeCColumn(i);
                                BmajorClone[i][j].makeCRow(j-1);
                                major.makeCRow(j-1);
                                major.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;

                        }
                    
                    }
                    if(BmouseClicked == 28)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (BcolonelClone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                colonel.setTurn(false);
                                BcolonelClone[i][j] = new Piece(); 
                                BcolonelClone[i][j].makeCColumn(i);
                                BcolonelClone[i][j].makeCRow(j-1);
                                colonel.makeCRow(j-1);
                                colonel.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;
                        }
                    
                    }
                    if(BmouseClicked == 29)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (BgeneralClone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                general.setTurn(false);
                                BgeneralClone[i][j-1] = new Piece(); 
                                BgeneralClone[i][j-1].makeCColumn(i);
                                BgeneralClone[i][j-1].makeCRow(j-1);
                                general.makeCRow(j-1);
                                general.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;
                               // general[i][j-1]=!null;

                        }
                    
                    }
                    if(BmouseClicked == 30)
                    {
                        int i = xpos/xdelta;
                        int j = ypos/ydelta;
                        if (BmarshallClone[i][j-1] == null && j<=Board.numRows-1 && j > 8 && i > 0 && i < 11 && Board.board[j-1][i] == Board.PATH)
                        {
                                marshall.setTurn(false);
                                BmarshallClone[i][j-1] = new Piece(); 
                                BmarshallClone[i][j-1].makeCColumn(i);
                                BmarshallClone[i][j-1].makeCRow(j-1);
                                marshall.makeCRow(j-1);
                                marshall.makeCColumn(i);
                                Board.board[j-1][i] = Board.SEC2;
                                gok=true;
                                BchangeInText++;
                        }
                    
                    }
                     
                     ///////////////////////////////////////////////////////
                     
                    if(Piece.playerRWin != true && Piece.playerBWin != true)
                    {
                     //marshall
                      if(marshall.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                         if(playerRedTurn)
                                         {
                                firstTime=false;
                                 if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                 System.out.println("1");
                                         }
                                else
                                   firstTimeB=false;
                                if(ypos/ydelta-1 == marshall.getCRow()+1)
                                {
                                    marshall.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == marshall.getCRow()-1)
                                {
                                    marshall.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == marshall.getCColumn()+1)
                                {
                                    marshall.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == marshall.getCColumn()-1)
                                {
                                    marshall.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(marshall);
                                marshall.movePiece(marshall, xpos/xdelta, ypos/ydelta);
                                betweenTurns = true; 
                                playerRedTurn = !playerRedTurn;
                                marshall.setSelected(false); 

                                }
                                  }
                                  else
                                  {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                         if(playerRedTurn)
                                firstTime=false;
                                else
                                         {
                                   firstTimeB=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                         }
                                if(ypos/ydelta-1 == marshall.getCRow()+1)
                                {
                                    marshall.setDirectionB(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == marshall.getCRow()-1)
                                {
                                    marshall.setDirectionB(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == marshall.getCColumn()+1)
                                {
                                    marshall.setDirectionB(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == marshall.getCColumn()-1)
                                {
                                    marshall.setDirectionB(Piece.Direction.Left);
                                } 
                                    Piece.checkFight(marshall);        
                                     marshall.movePiece(marshall, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     marshall.setSelected(false); 
                                }
                          }
                      }
                      
                     if(general.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == general.getCRow()+1)
                                {
                                    general.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == general.getCRow()-1)
                                {
                                    general.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == general.getCColumn()+1)
                                {
                                    general.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == general.getCColumn()-1)
                                {
                                    general.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(general);
                                     general.movePiece(general, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     general.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == general.getCRow()+1)
                                    {
                                        general.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == general.getCRow()-1)
                                    {
                                        general.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == general.getCColumn()+1)
                                    {
                                        general.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == general.getCColumn()-1)
                                    {
                                        general.setDirectionB(Piece.Direction.Left);
                                    }
                                    Piece.checkFight(general);       
                                     general.movePiece(general, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     general.setSelected(false); 
                                }
                          }
                      }

                     //colonel
                      if(colonel.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == colonel.getCRow()+1)
                                {
                                    colonel.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == colonel.getCRow()-1)
                                {
                                    colonel.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == colonel.getCColumn()+1)
                                {
                                    colonel.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == colonel.getCColumn()-1)
                                {
                                    colonel.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(colonel);
                                     colonel.movePiece(colonel, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     colonel.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == colonel.getCRow()+1)
                                    {
                                        colonel.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == colonel.getCRow()-1)
                                    {
                                        colonel.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == colonel.getCColumn()+1)
                                    {
                                        colonel.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == colonel.getCColumn()-1)
                                    {
                                        colonel.setDirectionB(Piece.Direction.Left);
                                    }
                                      Piece.checkFight(colonel);      
                                     colonel.movePiece(colonel, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     colonel.setSelected(false); 
                                }
                          }
                      }

                     //major
                      if(major.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == major.getCRow()+1)
                                {
                                    major.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == major.getCRow()-1)
                                {
                                    major.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == major.getCColumn()+1)
                                {
                                    major.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == major.getCColumn()-1)
                                {
                                    major.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(major);
                                     major.movePiece(major, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     major.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == major.getCRow()+1)
                                    {
                                        major.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == major.getCRow()-1)
                                    {
                                        major.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == major.getCColumn()+1)
                                    {
                                        major.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == major.getCColumn()-1)
                                    {
                                        major.setDirectionB(Piece.Direction.Left);
                                    }
                                      Piece.checkFight(major);     
                                     major.movePiece(major, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     major.setSelected(false); 
                                }
                          }
                      }

                     //captain
                      if(captain1.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == captain1.getCRow()+1)
                                {
                                    captain1.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == captain1.getCRow()-1)
                                {
                                    captain1.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == captain1.getCColumn()+1)
                                {
                                    captain1.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == captain1.getCColumn()-1)
                                {
                                    captain1.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(captain1);
                                     captain1.movePiece(captain1, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     captain1.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == captain1.getCRow()+1)
                                    {
                                        captain1.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == captain1.getCRow()-1)
                                    {
                                        captain1.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == captain1.getCColumn()+1)
                                    {
                                        captain1.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == captain1.getCColumn()-1)
                                    {
                                        captain1.setDirectionB(Piece.Direction.Left);
                                    }
                                     Piece.checkFight(captain1);     
                                     captain1.movePiece(captain1, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     captain1.setSelected(false); 
                                }
                          }
                      }

                      //
                       if(captain2.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == captain2.getCRow()+1)
                                {
                                    captain2.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == captain2.getCRow()-1)
                                {
                                    captain2.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == captain2.getCColumn()+1)
                                {
                                    captain2.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == captain2.getCColumn()-1)
                                {
                                    captain2.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(captain2);
                                     captain2.movePiece(captain2, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     captain2.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == captain2.getCRow()+1)
                                    {
                                        captain2.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == captain2.getCRow()-1)
                                    {
                                        captain2.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == captain2.getCColumn()+1)
                                    {
                                        captain2.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == captain2.getCColumn()-1)
                                    {
                                        captain2.setDirectionB(Piece.Direction.Left);
                                    }
                                     Piece.checkFight(captain2);       
                                     captain2.movePiece(captain2, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     captain2.setSelected(false); 
                                }
                          }
                      }

                     //lieutenant
                      if(lieutenant1.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == lieutenant1.getCRow()+1)
                                {
                                    lieutenant1.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == lieutenant1.getCRow()-1)
                                {
                                    lieutenant1.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == lieutenant1.getCColumn()+1)
                                {
                                    lieutenant1.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == lieutenant1.getCColumn()-1)
                                {
                                    lieutenant1.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(lieutenant1);
                                     lieutenant1.movePiece(lieutenant1, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     lieutenant1.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == lieutenant1.getCRow()+1)
                                    {
                                        lieutenant1.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == lieutenant1.getCRow()-1)
                                    {
                                        lieutenant1.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == lieutenant1.getCColumn()+1)
                                    {
                                        lieutenant1.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == lieutenant1.getCColumn()-1)
                                    {
                                        lieutenant1.setDirectionB(Piece.Direction.Left);
                                    }
                                     Piece.checkFight(lieutenant1);       
                                     lieutenant1.movePiece(lieutenant1, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     lieutenant1.setSelected(false); 
                                }
                          }
                      }

                      //
                       if(lieutenant2.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == lieutenant2.getCRow()+1)
                                {
                                    lieutenant2.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == lieutenant2.getCRow()-1)
                                {
                                    lieutenant2.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == lieutenant2.getCColumn()+1)
                                {
                                    lieutenant2.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == lieutenant2.getCColumn()-1)
                                {
                                    lieutenant2.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(lieutenant2);
                                     lieutenant2.movePiece(lieutenant2, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     lieutenant2.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == lieutenant2.getCRow()+1)
                                    {
                                        lieutenant2.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == lieutenant2.getCRow()-1)
                                    {
                                        lieutenant2.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == lieutenant2.getCColumn()+1)
                                    {
                                        lieutenant2.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == lieutenant2.getCColumn()-1)
                                    {
                                        lieutenant2.setDirectionB(Piece.Direction.Left);
                                    }
                                     Piece.checkFight(lieutenant2);      
                                     lieutenant2.movePiece(lieutenant2, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     lieutenant2.setSelected(false); 
                                }
                          }
                      }

                     //seargent
                      if(seargent1.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == seargent1.getCRow()+1)
                                {
                                    seargent1.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == seargent1.getCRow()-1)
                                {
                                    seargent1.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == seargent1.getCColumn()+1)
                                {
                                    seargent1.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == seargent1.getCColumn()-1)
                                {
                                    seargent1.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(seargent1);
                                     seargent1.movePiece(seargent1, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     seargent1.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == seargent1.getCRow()+1)
                                    {
                                        seargent1.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == seargent1.getCRow()-1)
                                    {
                                        seargent1.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == seargent1.getCColumn()+1)
                                    {
                                        seargent1.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == seargent1.getCColumn()-1)
                                    {
                                        seargent1.setDirectionB(Piece.Direction.Left);
                                    }
                                    Piece.checkFight(seargent1);
                                     seargent1.movePiece(seargent1, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     seargent1.setSelected(false); 
                                }
                          }
                      }

                     //
                      if(seargent2.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == seargent2.getCRow()+1)
                                {
                                    seargent2.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == seargent2.getCRow()-1)
                                {
                                    seargent2.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == seargent2.getCColumn()+1)
                                {
                                    seargent2.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == seargent2.getCColumn()-1)
                                {
                                    seargent2.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(seargent2);
                                     seargent2.movePiece(seargent2, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     seargent2.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == seargent2.getCRow()+1)
                                    {
                                        seargent2.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == seargent2.getCRow()-1)
                                    {
                                        seargent2.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == seargent2.getCColumn()+1)
                                    {
                                        seargent2.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == seargent2.getCColumn()-1)
                                    {
                                        seargent2.setDirectionB(Piece.Direction.Left);
                                    }
                                    Piece.checkFight(seargent2);      
                                     seargent2.movePiece(seargent2, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     seargent2.setSelected(false); 
                                }
                          }
                      }

                     //spy
                      if(spy.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == spy.getCRow()+1)
                                {
                                    spy.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == spy.getCRow()-1)
                                {
                                    spy.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == spy.getCColumn()+1)
                                {
                                    spy.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == spy.getCColumn()-1)
                                {
                                    spy.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(spy);
                                     spy.movePiece(spy, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     spy.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == spy.getCRow()+1)
                                    {
                                        spy.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == spy.getCRow()-1)
                                    {
                                        spy.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == spy.getCColumn()+1)
                                    {
                                        spy.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == spy.getCColumn()-1)
                                    {
                                        spy.setDirectionB(Piece.Direction.Left);
                                    }
                                    Piece.checkFight(spy);      
                                     spy.movePiece(spy, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     spy.setSelected(false); 
                                }
                          }
                      }
  
                     //miner
                      if(miner1.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == miner1.getCRow()+1)
                                {
                                    miner1.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == miner1.getCRow()-1)
                                {
                                    miner1.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == miner1.getCColumn()+1)
                                {
                                    miner1.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == miner1.getCColumn()-1)
                                {
                                    miner1.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(miner1);
                                     miner1.movePiece(miner1, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     miner1.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == miner1.getCRow()+1)
                                    {
                                        miner1.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == miner1.getCRow()-1)
                                    {
                                        miner1.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == miner1.getCColumn()+1)
                                    {
                                        miner1.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == miner1.getCColumn()-1)
                                    {
                                        miner1.setDirectionB(Piece.Direction.Left);
                                    }
                                   Piece.checkFight(miner1);      
                                     miner1.movePiece(miner1, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     miner1.setSelected(false); 
                                }
                          }
                      }

                     //
                      if(miner2.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == miner2.getCRow()+1)
                                {
                                    miner2.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == miner2.getCRow()-1)
                                {
                                    miner2.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == miner2.getCColumn()+1)
                                {
                                    miner2.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == miner2.getCColumn()-1)
                                {
                                    miner2.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(miner2);
                                     miner2.movePiece(miner2, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     miner2.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == miner2.getCRow()+1)
                                    {
                                        miner2.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == miner2.getCRow()-1)
                                    {
                                        miner2.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == miner2.getCColumn()+1)
                                    {
                                        miner2.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == miner2.getCColumn()-1)
                                    {
                                        miner2.setDirectionB(Piece.Direction.Left);
                                    }
                                    Piece.checkFight(miner2);       
                                     miner2.movePiece(miner2, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     miner2.setSelected(false); 
                                }
                          }
                      }

                     //
                      if(miner3.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == miner3.getCRow()+1)
                                {
                                    miner3.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == miner3.getCRow()-1)
                                {
                                    miner3.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == miner3.getCColumn()+1)
                                {
                                    miner3.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == miner3.getCColumn()-1)
                                {
                                    miner3.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(miner3);
                                     miner3.movePiece(miner3, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     miner3.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == miner3.getCRow()+1)
                                    {
                                        miner3.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == miner3.getCRow()-1)
                                    {
                                        miner3.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == miner3.getCColumn()+1)
                                    {
                                        miner3.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == miner3.getCColumn()-1)
                                    {
                                        miner3.setDirectionB(Piece.Direction.Left);
                                    }
                                     Piece.checkFight(miner3);       
                                     miner3.movePiece(miner3, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     miner3.setSelected(false); 
                                }
                          }
                      }

                      //
                       if(miner4.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == miner4.getCRow()+1)
                                {
                                    miner4.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == miner4.getCRow()-1)
                                {
                                    miner4.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == miner4.getCColumn()+1)
                                {
                                    miner4.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == miner4.getCColumn()-1)
                                {
                                    miner4.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(miner4);
                                     miner4.movePiece(miner4, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     miner4.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == miner4.getCRow()+1)
                                    {
                                        miner4.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == miner4.getCRow()-1)
                                    {
                                        miner4.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == miner4.getCColumn()+1)
                                    {
                                        miner4.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == miner4.getCColumn()-1)
                                    {
                                        miner4.setDirectionB(Piece.Direction.Left);
                                    }
                                    Piece.checkFight(miner4);      
                                     miner4.movePiece(miner4, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     miner4.setSelected(false); 
                                }
                          }
                      }

                     //
                      if(miner5.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == miner5.getCRow()+1)
                                {
                                    miner5.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == miner5.getCRow()-1)
                                {
                                    miner5.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == miner5.getCColumn()+1)
                                {
                                    miner5.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == miner5.getCColumn()-1)
                                {
                                    miner5.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(miner5);
                                     miner5.movePiece(miner5, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     miner5.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == miner5.getCRow()+1)
                                    {
                                        miner5.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == miner5.getCRow()-1)
                                    {
                                        miner5.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == miner5.getCColumn()+1)
                                    {
                                        miner5.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == miner5.getCColumn()-1)
                                    {
                                        miner5.setDirectionB(Piece.Direction.Left);
                                    }
                                       Piece.checkFight(miner5);
                                     miner5.movePiece(miner5, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     miner5.setSelected(false); 
                                }
                          }
                      }

                     
                      //scout
                       if(scout1.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == scout1.getCRow()+1)
                                {
                                    scout1.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == scout1.getCRow()-1)
                                {
                                    scout1.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == scout1.getCColumn()+1)
                                {
                                    scout1.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == scout1.getCColumn()-1)
                                {
                                    scout1.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(scout1);
                                     scout1.moveScout(scout1, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     scout1.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == scout1.getCRow()+1)
                                    {
                                        scout1.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == scout1.getCRow()-1)
                                    {
                                        scout1.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == scout1.getCColumn()+1)
                                    {
                                        scout1.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == scout1.getCColumn()-1)
                                    {
                                        scout1.setDirectionB(Piece.Direction.Left);
                                    }
                                       Piece.checkFight(scout1);      
                                     scout1.moveScout(scout1, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     scout1.setSelected(false); 
                                }
                          }
                      }

                      //
                       if(scout2.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == scout2.getCRow()+1)
                                {
                                    scout2.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == scout2.getCRow()-1)
                                {
                                    scout2.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == scout2.getCColumn()+1)
                                {
                                    scout2.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == scout2.getCColumn()-1)
                                {
                                    scout2.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(scout2);
                                     scout2.moveScout(scout2, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     scout2.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == scout2.getCRow()+1)
                                    {
                                        scout2.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == scout2.getCRow()-1)
                                    {
                                        scout2.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == scout2.getCColumn()+1)
                                    {
                                        scout2.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == scout2.getCColumn()-1)
                                    {
                                        scout2.setDirectionB(Piece.Direction.Left);
                                    }
                                       Piece.checkFight(scout2);      
                                     scout2.moveScout(scout2, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     scout2.setSelected(false); 
                                }
                          }
                      }

                     //
                      if(scout3.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == scout3.getCRow()+1)
                                {
                                    scout3.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == scout3.getCRow()-1)
                                {
                                    scout3.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == scout3.getCColumn()+1)
                                {
                                    scout3.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == scout3.getCColumn()-1)
                                {
                                    scout3.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(scout3);
                                     scout3.moveScout(scout3, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     scout3.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == scout3.getCRow()+1)
                                    {
                                        scout3.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == scout3.getCRow()-1)
                                    {
                                        scout3.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == scout3.getCColumn()+1)
                                    {
                                        scout3.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == scout3.getCColumn()-1)
                                    {
                                        scout3.setDirectionB(Piece.Direction.Left);
                                    }   
                                         Piece.checkFight(scout3);    
                                     scout3.moveScout(scout3, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     scout3.setSelected(false); 
                                }
                          }
                      }

                        //
                         if(scout4.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == scout4.getCRow()+1)
                                {
                                    scout4.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == scout4.getCRow()-1)
                                {
                                    scout4.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == scout4.getCColumn()+1)
                                {
                                    scout4.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == scout4.getCColumn()-1)
                                {
                                    scout4.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(scout4);
                                     scout4.moveScout(scout4, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     scout4.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                     if(ypos/ydelta-1 == scout4.getCRow()+1)
                                    {
                                        scout4.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == scout4.getCRow()-1)
                                    {
                                        scout4.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == scout4.getCColumn()+1)
                                    {
                                        scout4.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == scout4.getCColumn()-1)
                                    {
                                        scout4.setDirectionB(Piece.Direction.Left);
                                    }   
                                        Piece.checkFight(scout4);     
                                     scout4.moveScout(scout4, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     scout4.setSelected(false); 
                                }
                          }
                      }

                     //
                      if(scout5.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == scout5.getCRow()+1)
                                {
                                    scout5.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == scout5.getCRow()-1)
                                {
                                    scout5.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == scout5.getCColumn()+1)
                                {
                                    scout5.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == scout5.getCColumn()-1)
                                {
                                    scout5.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(scout5);
                                     scout5.moveScout(scout5, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     scout5.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == scout5.getCRow()+1)
                                    {
                                        scout5.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == scout5.getCRow()-1)
                                    {
                                        scout5.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == scout5.getCColumn()+1)
                                    {
                                        scout5.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == scout5.getCColumn()-1)
                                    {
                                        scout5.setDirectionB(Piece.Direction.Left);
                                    }   
                                       Piece.checkFight(scout5);      
                                     scout5.moveScout(scout5, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     scout5.setSelected(false); 
                                }
                          }
                      }

                      //
                       if(scout6.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == scout6.getCRow()+1)
                                {
                                    scout6.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == scout6.getCRow()-1)
                                {
                                    scout6.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == scout6.getCColumn()+1)
                                {
                                    scout6.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == scout6.getCColumn()-1)
                                {
                                    scout6.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(scout6);
                                     scout6.moveScout(scout6, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     scout6.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                         
                                    if(ypos/ydelta-1 == scout6.getCRow()+1)
                                    {
                                        scout6.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == scout6.getCRow()-1)
                                    {
                                        scout6.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == scout6.getCColumn()+1)
                                    {
                                        scout6.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == scout6.getCColumn()-1)
                                    {
                                        scout6.setDirectionB(Piece.Direction.Left);
                                    }
                                        Piece.checkFight(scout6);
                                     scout6.moveScout(scout6, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     scout6.setSelected(false); 
                                }
                          }
                      }

                     //
                      if(scout7.getSelected())
                      {
                          if(playerRedTurn)
                          {
                                if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                {
                                   
                                if(playerRedTurn)
                                {
                                    firstTime=false;
                                    if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SEC2)
                                    System.out.println("1");
                                }
                                else
                                    firstTimeB=false;
                                if(ypos/ydelta-1 == scout7.getCRow()+1)
                                {
                                    scout7.setDirectionR(Piece.Direction.Down);
                                }
                                else if(ypos/ydelta-1 == scout7.getCRow()-1)
                                {
                                    scout7.setDirectionR(Piece.Direction.Up);
                                }
                                else if(xpos/xdelta == scout7.getCColumn()+1)
                                {
                                    scout7.setDirectionR(Piece.Direction.Right);
                                }
                                else if(xpos/xdelta == scout7.getCColumn()-1)
                                {
                                    scout7.setDirectionR(Piece.Direction.Left);
                                }
                                Piece.checkFight(scout7);
                                     scout7.moveScout(scout7, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     scout7.setSelected(false); 
                                }
                          }
                          else
                          {
                                   if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.PATH||Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                {
                                    if(playerRedTurn)
                                         firstTime=false;
                                    else
                                    {
                                        firstTimeB=false;
                                        if(Board.board[(ypos/ydelta)-1][xpos/xdelta]==Board.SECR)
                                             System.out.println("1");
                                    }
                                    if(ypos/ydelta-1 == scout7.getCRow()+1)
                                    {
                                        scout7.setDirectionB(Piece.Direction.Down);
                                    }
                                    else if(ypos/ydelta-1 == scout7.getCRow()-1)
                                    {
                                        scout7.setDirectionB(Piece.Direction.Up);
                                    }
                                    else if(xpos/xdelta == scout7.getCColumn()+1)
                                    {
                                        scout7.setDirectionB(Piece.Direction.Right);
                                    }
                                    else if(xpos/xdelta == scout7.getCColumn()-1)
                                    {
                                        scout7.setDirectionB(Piece.Direction.Left);
                                    }
                                    Piece.checkFight(scout7);
                                     scout7.moveScout(scout7, xpos/xdelta, ypos/ydelta);
                                     betweenTurns = true;
                                    playerRedTurn = !playerRedTurn;
                                     scout7.setSelected(false); 
                                }
                          }
                      }
                    }
                }
                if(e.BUTTON2 == e.getButton())
                {
                   State ptr;
                    ptr = state;
                    if(lastState != State.Title)
                    {
                        state = lastState;
                    }
                    else if(lastState == State.Title&&state != State.Game)
                    state=State.Title;
                    
                    if(ptr != state)
                    {
                        starwarsSound.stopPlaying = true;
                    }
                }
                if (e.BUTTON3 == e.getButton()) {
                    //right button
//                    State ptr;
//                    ptr = state;
//                    state = lastState;
//                    if(ptr != state)
//                    {
//                        starwarsSound.stopPlaying = true;
//                    }
//                    reset();
                     int xpos = e.getX()-(Window.XBORDER+10);
                     int ypos = e.getY()-getY()+(Window.YBORDER + Window.YTITLE-30);
                     int ydelta = Window.getHeight2()/Board.numRows;
                     int xdelta = Window.getWidth2()/Board.numColumns;

                      //marshall
                     if (marshall.getCColumn()==xpos/xdelta && marshall.getCRow()==(ypos/ydelta)-1) 
                     {
                        marshall.setSelected(true); 

                        spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                    //    marshall.setSelected(false); 
                     }
                     //general
                     if (general.getCColumn()==xpos/xdelta && general.getCRow()==(ypos/ydelta)-1) 
                     {
                        general.setSelected(true); 
                        spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                     //   general.setSelected(false); 
                        marshall.setSelected(false); 
                     }
                     //colonel
                       if (colonel.getCColumn()==xpos/xdelta && colonel.getCRow()==(ypos/ydelta)-1) 
                       {
                        colonel.setSelected(true);   
                        spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                      //  colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                       }
                     //major
                      if (major.getCColumn()==xpos/xdelta && major.getCRow()==(ypos/ydelta)-1) 
                      {
                        major.setSelected(true);   
                        spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                       // major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                      }
                     //captain
                      if (captain1.getCColumn()==xpos/xdelta && captain1.getCRow()==(ypos/ydelta)-1) 
                      {
                        captain1.setSelected(true);   
                        spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                       // captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                      }
                       if (captain2.getCColumn()==xpos/xdelta && captain2.getCRow()==(ypos/ydelta)-1) 
                       {
                        captain2.setSelected(true);   
                        spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                      //  captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                       }
                    // lieutenant
                     if (lieutenant1.getCColumn()==xpos/xdelta && lieutenant1.getCRow()==(ypos/ydelta)-1) 
                     {
                        lieutenant1.setSelected(true);  
                        spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                      //  lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                     }
                       if (lieutenant2.getCColumn()==xpos/xdelta && lieutenant2.getCRow()==(ypos/ydelta)-1) 
                       {
                        lieutenant2.setSelected(true);   
                        spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                      //  lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                       }
                     //seargent
                      if (seargent1.getCColumn()==xpos/xdelta && seargent1.getCRow()==(ypos/ydelta)-1) 
                      {
                        seargent1.setSelected(true);  
                        spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                       // seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                      }
                       if (seargent2.getCColumn()==xpos/xdelta && seargent2.getCRow()==(ypos/ydelta)-1) 
                       {
                        seargent2.setSelected(true);   
                        spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                      //  seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                       }
                     //spy
                     if (spy.getCColumn()==xpos/xdelta && spy.getCRow()==(ypos/ydelta)-1) 
                     {
                        spy.setSelected(true);   
                       // spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                     }
                     //miner
                     if (miner1.getCColumn()==xpos/xdelta && miner1.getCRow()==(ypos/ydelta)-1) 
                     {
                        miner1.setSelected(true);    
                        spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                      //  miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                     }
                     if (miner2.getCColumn()==xpos/xdelta && miner2.getCRow()==(ypos/ydelta)-1) 
                     {
                       miner2.setSelected(true); 
                       spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                       // miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                     }
                      if (miner3.getCColumn()==xpos/xdelta && miner3.getCRow()==(ypos/ydelta)-1) 
                      {
                       miner3.setSelected(true); 
                       spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                      //  miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                      }
                       if (miner4.getCColumn()==xpos/xdelta && miner4.getCRow()==(ypos/ydelta)-1)
                       {
                        miner4.setSelected(true);  
                        spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                       // miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                       }
                        if (miner5.getCColumn()==xpos/xdelta && miner5.getCRow()==(ypos/ydelta)-1) 
                        {
                        miner5.setSelected(true); 
                        spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                       // miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                        }
                        //scout
                         if (scout1.getCColumn()==xpos/xdelta && scout1.getCRow()==(ypos/ydelta)-1) 
                         {
                        scout1.setSelected(true);    
                        spy.setSelected(false); 
                      //  scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                         }
                     if (scout2.getCColumn()==xpos/xdelta && scout2.getCRow()==(ypos/ydelta)-1) 
                     {
                       scout2.setSelected(true); 
                       spy.setSelected(false); 
                        scout1.setSelected(false); 
                       // scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                     }
                      if (scout3.getCColumn()==xpos/xdelta && scout3.getCRow()==(ypos/ydelta)-1) 
                      {
                       scout3.setSelected(true); 
                       spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                      //  scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                      }
                       if (scout4.getCColumn()==xpos/xdelta && scout4.getCRow()==(ypos/ydelta)-1) 
                       {
                        scout4.setSelected(true);  
                        spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                      //  scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                       }
                        if (scout5.getCColumn()==xpos/xdelta && scout5.getCRow()==(ypos/ydelta)-1) 
                        {
                        scout5.setSelected(true); 
                        spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                      //  scout5.setSelected(false); 
                        scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                        }
                         if (scout6.getCColumn()==xpos/xdelta && scout6.getCRow()==(ypos/ydelta)-1) 
                         {
                        scout6.setSelected(true);  
                        spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                      //  scout6.setSelected(false); 
                        scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                         }
                     if (scout7.getCColumn()==xpos/xdelta && scout7.getCRow()==(ypos/ydelta)-1) 
                     {
                       scout7.setSelected(true); 
                       spy.setSelected(false); 
                        scout1.setSelected(false); 
                        scout2.setSelected(false); 
                        scout3.setSelected(false); 
                        scout4.setSelected(false); 
                        scout5.setSelected(false); 
                        scout6.setSelected(false); 
                      //  scout7.setSelected(false); 
                        miner1.setSelected(false); 
                        miner2.setSelected(false); 
                        miner3.setSelected(false); 
                        miner4.setSelected(false); 
                        miner5.setSelected(false); 
                        seargent1.setSelected(false); 
                        seargent2.setSelected(false); 
                        lieutenant1.setSelected(false); 
                        lieutenant2.setSelected(false); 
                        captain1.setSelected(false); 
                        captain2.setSelected(false); 
                        major.setSelected(false); 
                        colonel.setSelected(false); 
                        general.setSelected(false); 
                        marshall.setSelected(false); 
                     }
                }
                repaint();
            }
        });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
//Keys that determine the direction to move the player.   
        if (gameOver)
            return;                
                if (e.VK_RIGHT == e.getKeyCode())
                {
                    rowDir = 0;
                    columnDir = 1;
                }
                if (e.VK_LEFT == e.getKeyCode())
                {
                    rowDir = 0;
                    columnDir = -1;
                }
                if (e.VK_UP == e.getKeyCode())
                {
                    rowDir = -1;
                    columnDir = 0;
                }
                if (e.VK_DOWN == e.getKeyCode())
                {
                    rowDir = 1;
                    columnDir = 0;
                }
      

                repaint();
            }
        });
        init();
        start();
    }




    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }
////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }

//fill background
        g.setColor(Color.black);

        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.white);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.black);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        if (!resetComplete)
            return;
        if(state == State.Title)
        {
            g.drawImage(Title,Window.getX(0),Window.getY(0),Window.getWidth2(),Window.getHeight2(),this);
            g.drawImage(Pokemon,Window.getX(0)+Window.getWidth2()/2-245,Window.getY(0),450,200,this);
            g.drawImage(vs,Window.getX(0)+Window.getWidth2()/2-140,Window.getY(0)+Window.getHeight2()/2-250,300,100,this);
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(Window.getX(0)+Window.getWidth2()/2-75,Window.getY(0)+Window.getHeight2()/2-150,150,250);
            g.setColor(Color.black);
            g.drawRect(Window.getX(0)+Window.getWidth2()/2-75,Window.getY(0)+Window.getHeight2()/2-150,150,250);
            g.setColor(Color.red);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Click",Window.getX(0)+Window.getWidth2()/2-70,Window.getY(0)+Window.getHeight2()/2-100);
            g.setColor(Color.blue);
            g.drawString("To",Window.getX(0)+Window.getWidth2()/2-70,Window.getY(0)+Window.getHeight2()/2-60);
            g.setColor(Color.yellow);
            g.drawString("Start",Window.getX(0)+Window.getWidth2()/2-70,Window.getY(0)+Window.getHeight2()/2-20);
            
            
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(Window.getX(0)+Window.getWidth2()/2-75,Window.getY(0)+Window.getHeight2()-150,150,100);
            g.setColor(Color.black);
            g.drawRect(Window.getX(0)+Window.getWidth2()/2-75,Window.getY(0)+Window.getHeight2()-150,150,100);
            g.setColor(Color.red);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("HELP",Window.getX(0)+Window.getWidth2()/2-45,Window.getY(0)+Window.getHeight2()-100);
            
        }
        else if(state == State.Help)
        {
            g.drawImage(Help,Window.getX(0),Window.getY(0),Window.getWidth2(),Window.getHeight2(),this);
            g.drawImage(info,Window.getX(0)+Window.getWidth2()/2-450,Window.getY(0)+300,345,284,this);
            g.drawImage(HelpBall,Window.getX(0)+Window.getWidth2()/20,Window.getY(0)+300,400,284,this);
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(Window.getX(0)+Window.getWidth2()-125,Window.getHeight2()/Board.numRows+Window.YTITLE-70,150,100);
            g.setColor(Color.black);
            g.drawRect(Window.getX(0)+Window.getWidth2()-125,Window.getHeight2()/Board.numRows+Window.YTITLE-70,150,100);
            g.setColor(Color.red);
            g.setFont(new Font("Monospaced",Font.BOLD,20) );
            g.drawString("Page 2 =>",Window.getX(0)+Window.getWidth2()-100,Window.getHeight2()/Board.numRows+Window.YTITLE-10);
           
        }
         else if(state == State.Help2)
        {
            g.drawImage(Help2,Window.getX(0),Window.getY(0),Window.getWidth2(),Window.getHeight2(),this);
            //gms
            g.drawImage(info2,Window.getX(0)+Window.getWidth2()/2-450,Window.getY(0)+300,345,284,this);
            g.drawImage(Char,Window.getX(0)+Window.getWidth2()/20,Window.getY(0)+300,400,284,this);
        }
        else if(state == State.Game)
        {
             //battle Field
            g.drawImage(BattleField,Window.getX(0),Window.getY(0),Window.getWidth2(),Window.getHeight2(),this);
            g.setColor(Color.black);
            
    //horizontal lines
            for (int zi=1;zi<Board.numRows;zi++)
            {
                g.drawLine(Window.getX(0) ,Window.getY(0)+zi*Window.getHeight2()/Board.numRows ,
                Window.getX(Window.getWidth2()) ,Window.getY(0)+zi*Window.getHeight2()/Board.numRows );
            }
    //vertical lines
            for (int zi=1;zi<Board.numColumns;zi++)
            {
                g.drawLine(Window.getX(0)+zi*Window.getWidth2()/Board.numColumns ,Window.getY(0) ,
                Window.getX(0)+zi*Window.getWidth2()/Board.numColumns,Window.getY(Window.getHeight2())  );
            }

    //Display the wall.
            for (int zrow=0;zrow<Board.numRows;zrow++)
            {
                for (int zcolumn=0;zcolumn<Board.numColumns;zcolumn++)
                {
                    if (Board.board[zrow][zcolumn] == Board.WALL)
                    {
                          g.setColor(Color.DARK_GRAY);
                        g.fillRect(Window.getX(0)+zcolumn*Window.getWidth2()/Board.numColumns,
                        Window.getY(0)+zrow*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,
                        Window.getHeight2()/Board.numRows);
                         g.drawRect(Window.getX(0)+zcolumn*Window.getWidth2()/Board.numColumns,
                        Window.getY(0)+zrow*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,
                        Window.getHeight2()/Board.numRows);
                    }  
                    if (Board.board[zrow][zcolumn] == Board.ROCK)
                    {
                        g.drawImage(Rock,Window.getX(0)+zcolumn*Window.getWidth2()/Board.numColumns,
                        Window.getY(0)+zrow*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,
                        Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
            
            g.setColor(Color.black);
            g.fillRect(Window.getX(-0)+11*Window.getWidth2()/Board.numColumns,Window.getY(0)+0*Window.getHeight2()/Board.numRows,Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
            g.setColor(Color.blue);
            g.drawRect(Window.getX(-0)+11*Window.getWidth2()/Board.numColumns,Window.getY(0)+0*Window.getHeight2()/Board.numRows,Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
            g.setFont(new Font("Monospaced",Font.BOLD,30));
            g.setColor(Color.blue);
            g.drawString("HELP",Window.getX(0)+Window.getWidth2()-80,Window.getY(0)+0*Window.getHeight2()/Board.numRows+Window.YTITLE);
        if(betweenTurns == true)
        {
            if(firstTimeBetween)
            {
                int i = 1;
                int j = 1;
                int a = 10;
                int s = 10;
                for (Piece ptr : Piece.pieces)
                {
                    g.setColor(Color.black);
                    g.fillRect(Window.getX(0)+i*Window.getWidth2()/Board.numColumns
                    ,Window.getY(0)+j*Window.getHeight2()/Board.numRows,
                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                    g.setColor(Color.red);
                    g.drawRect(Window.getX(0)+i*Window.getWidth2()/Board.numColumns
                    ,Window.getY(0)+j*Window.getHeight2()/Board.numRows,
                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                    g.setColor(Color.black);
                    g.fillRect(Window.getX(0)+a*Window.getWidth2()/Board.numColumns
                    ,Window.getY(0)+s*Window.getHeight2()/Board.numRows,
                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                    g.setColor(Color.red);
                    g.drawRect(Window.getX(0)+a*Window.getWidth2()/Board.numColumns
                    ,Window.getY(0)+s*Window.getHeight2()/Board.numRows,
                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                    i++;
                    if(i == 11)
                    {
                        i=1;
                        j++;
                    }
                    a--;
                    if(a == 0)
                    {
                        a=10;
                        s--;
                    }
                }
                firstTimeBetween = false;
            }
            for (Piece ptr : Piece.pieces)
            {
                if(ptr.getIsShowingB())
                {
                g.setColor(Color.black);
                g.fillRect(Window.getX(0)+ptr.getColumnB()*Window.getWidth2()/Board.numColumns
                ,Window.getY(0)+ptr.getRowB()*Window.getHeight2()/Board.numRows,
                Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                g.setColor(Color.red);
                g.drawRect(Window.getX(0)+ptr.getColumnB()*Window.getWidth2()/Board.numColumns
                ,Window.getY(0)+ptr.getRowB()*Window.getHeight2()/Board.numRows,
                Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                }
                if(ptr.getIsShowingR())
                {
                g.setColor(Color.black);
                g.fillRect(Window.getX(0)+ptr.getColumnR()*Window.getWidth2()/Board.numColumns
                ,Window.getY(0)+ptr.getRowR()*Window.getHeight2()/Board.numRows,
                Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                g.setColor(Color.red);
                g.drawRect(Window.getX(0)+ptr.getColumnR()*Window.getWidth2()/Board.numColumns
                ,Window.getY(0)+ptr.getRowR()*Window.getHeight2()/Board.numRows,
                Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                }
            }
            g.setColor(Color.green);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Switch Players Now: " + timeShownBetweenTurns, getWidth()/2-225, getHeight()/2-100);
        }
        else if(betweenTurns == false)
        {
            if(playerRedTurn)
            {
                int i = 1;
                int j = 1;
                int a = 10;
                int s = 10;
                for (Piece ptr : Piece.pieces)
                {
                    if(firstTime&&firstTimeB)
                    {
                        if(ptr.getIsShowingB())
                        {
                            g.setColor(Color.gray);
                            g.fillRect(Window.getX(0)+0*Window.getWidth2()/Board.numColumns,
                            Window.getY(0)+0*Window.getHeight2()/Board.numRows,
                            Window.getWidth2()/Board.numColumns,
                            Window.getHeight2()/Board.numRows);

                            g.setColor(Color.black);
                            g.fillRect(Window.getX(0)+a*Window.getWidth2()/Board.numColumns
                            ,Window.getY(0)+s*Window.getHeight2()/Board.numRows,
                            Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                            g.setColor(Color.red);
                            g.drawRect(Window.getX(0)+a*Window.getWidth2()/Board.numColumns
                            ,Window.getY(0)+s*Window.getHeight2()/Board.numRows,
                            Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                            a--;
                            if(a == 0)
                            {
                                a=10;
                                s--;
                            }
                        }
                    }
                    if(firstTimeT)
                    {
                        Piece.makeT();
                        firstTimeT=false;
                    }
                    if(!Piece.Raltsseen)
                    {
                    g.drawImage(Ralts,Window.getX(0)+Piece.currentColumnT*Window.getWidth2()/Board.numColumns
                    ,Window.getY(0)+Piece.currentRowT*Window.getHeight2()/Board.numRows,
                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                        if(null != ptr.getType())
                        switch (ptr.getType()) {
                            case Flag:
                                ptr.setTurn(false);
                                if(ptr.getIsShowingB())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTime)
                                { 
                                ptr.setTurn(true);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SECR;
                                }
                                   ptr.setTurn(true);
                                   if(ptr.getIsShowingR())
                                   {
                                    g.drawImage(Red,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i++;
                                if(i == 11)
                                {
                                    i=1;
                                    j++;
                                } break;
                            case Bomb:
                               ptr.setTurn(false);
                                if(ptr.getIsShowingB())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTime)
                                { 
                                ptr.setTurn(true);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SECR;
                                }
                                   ptr.setTurn(true);
                                   if(ptr.getIsShowingR())
                                   {
                                    g.drawImage(bomb,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i++;
                                if(i == 11)
                                {
                                    i=1;
                                    j++;
                                } break;
                            case Spy:
                                ptr.setTurn(false);
                                if(ptr.getIsShowingB())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTime)
                                { 
                                ptr.setTurn(true);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SECR;
                                }
                                   ptr.setTurn(true);
                                   if(ptr.getIsShowingR())
                                   {
                                    g.drawImage(Zoroark,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i++;
                                if(i == 11)
                                {
                                    i=1;
                                    j++;
                                }   break;
                            case Scout:
                                ptr.setTurn(false);
                                if(ptr.getIsShowingB())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTime)
                                { 
                                ptr.setTurn(true);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SECR;
                                }
                                   ptr.setTurn(true);
                                   if(ptr.getIsShowingR())
                                   {
                                    g.drawImage(Greninja,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i++;
                                if(i == 11)
                                {
                                    i=1;
                                    j++;
                                }   break;
                            case Miner:
                                ptr.setTurn(false);
                                if(ptr.getIsShowingB())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTime)
                                { 
                                ptr.setTurn(true);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SECR;
                                }
                                   ptr.setTurn(true);
                                   if(ptr.getIsShowingR())
                                   {
                                    g.drawImage(Excadrill,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i++;
                                if(i == 11)
                                {
                                    i=1;
                                    j++;
                                }   break;
                            case Seargent:
                                ptr.setTurn(false);
                                if(ptr.getIsShowingB())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTime)
                                { 
                                ptr.setTurn(true);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SECR;
                                }
                                   ptr.setTurn(true);
                                   if(ptr.getIsShowingR())
                                   {
                                    g.drawImage(Espeon,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i++;
                                if(i == 11)
                                {
                                    i=1;
                                    j++;
                                }   break;
                            case Lieutenant:
                                ptr.setTurn(false);
                                if(ptr.getIsShowingB())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTime)
                                { 
                                ptr.setTurn(true);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SECR;
                                }
                                   ptr.setTurn(true);
                                   if(ptr.getIsShowingR())
                                   {
                                    g.drawImage(Electivire,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i++;
                                if(i == 11)
                                {
                                    i=1;
                                    j++;
                                }   break;
                            case Captain:
                                ptr.setTurn(false);
                                if(ptr.getIsShowingB())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTime)
                                { 
                                ptr.setTurn(true);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SECR;
                                }
                                   ptr.setTurn(true);
                                   if(ptr.getIsShowingR())
                                   {
                                    g.drawImage(Bisharp,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i++;
                                if(i == 11)
                                {
                                    i=1;
                                    j++;
                                }   break;
                            case Major:
                                ptr.setTurn(false);
                               if(ptr.getIsShowingB())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTime)
                                { 
                                ptr.setTurn(true);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SECR;
                                }
                                   ptr.setTurn(true);
                                   if(ptr.getIsShowingR())
                                   {
                                    g.drawImage(Hydreigon,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i++;
                                if(i == 11)
                                {
                                    i=1;
                                    j++;
                                }   break;
                            case Colonel:
                                ptr.setTurn(false);
                                if(ptr.getIsShowingB())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTime)
                                { 
                                ptr.setTurn(true);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SECR;
                                }
                                   ptr.setTurn(true);
                                   if(ptr.getIsShowingR())
                                   {
                                    g.drawImage(PrimalK,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i++;
                                if(i == 11)
                                {
                                    i=1;
                                    j++;
                                }   break;
                            case General:
                                ptr.setTurn(false);
                                if(ptr.getIsShowingB())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTime)
                                { 
                                ptr.setTurn(true);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SECR;
                                }
                                   ptr.setTurn(true);
                                   if(ptr.getIsShowingR())
                                   {
                                    g.drawImage(megaS,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i++;
                                if(i == 11)
                                {
                                    i=1;
                                    j++;
                                }   break;
                            case Marshall:
                                ptr.setTurn(false);
                                if(ptr.getIsShowingB())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTime)
                                { 
                                ptr.setTurn(true);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SECR;
                                }
                                   ptr.setTurn(true);
                                   if(ptr.getIsShowingR())
                                   {
                                    g.drawImage(megaY,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i++;
                                if(i == 11)
                                {
                                    i=1;
                                    j++;
                                }   break;
                            default:
                                break;
                        }

                }
                if(firstTime)
                    {
                        g.setColor(Color.DARK_GRAY);
                        g.fillRect(Window.getX(0)+0*Window.getWidth2()/Board.numColumns,
                        Window.getY(0)+0*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,
                        Window.getHeight2()/Board.numRows);
                        g.drawRect(Window.getX(0)+0*Window.getWidth2()/Board.numColumns,
                        Window.getY(0)+0*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,
                        Window.getHeight2()/Board.numRows);

                    }
            }
            else if(!playerRedTurn)
            {
                int i = 10;
                int j = 10;
                int a = 1;
                int s = 1;
                for (Piece ptr : Piece.pieces)
                {
                    if(firstTimeB&&firstTime)
                    {
                        if(ptr.getIsShowingR())
                        {
                            g.setColor(Color.black);
                            g.fillRect(Window.getX(0)+a*Window.getWidth2()/Board.numColumns
                            ,Window.getY(0)+s*Window.getHeight2()/Board.numRows,
                            Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                            g.setColor(Color.red);
                            g.drawRect(Window.getX(0)+a*Window.getWidth2()/Board.numColumns
                            ,Window.getY(0)+s*Window.getHeight2()/Board.numRows,
                            Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                            a++;
                            if(a == 11)
                            {
                                a=1;
                                s++;
                            }
                        }
                    }
                    if(firstTimeT2)
                    {
                        Piece.makeT2();
                        firstTimeT2=false;
                    }
                    if(!Piece.Raltsseen2)
                    {
                    g.drawImage(Abra,Window.getX(0)+Piece.currentColumnT2*Window.getWidth2()/Board.numColumns
                    ,Window.getY(0)+Piece.currentRowT2*Window.getHeight2()/Board.numRows,
                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                        if(null != ptr.getType())
                        switch (ptr.getType()) {
                            case Flag:
                               ptr.setTurn(true);
                               if(ptr.getIsShowingR())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTimeB)
                                { 
                                ptr.setTurn(false);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SEC2;
                                }
                                   ptr.setTurn(false);
                                   if(ptr.getIsShowingB())
                                   {
                                    g.drawImage(Blue,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }

                                i--;
                                if(i == 0)
                                {
                                    i=10;
                                    j--;
                                }   break;
                            case Bomb:
                                ptr.setTurn(true);
                                if(ptr.getIsShowingR())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTimeB)
                                { 
                                ptr.setTurn(false);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SEC2;
                                }
                                   ptr.setTurn(false);
                                   if(ptr.getIsShowingB())
                                   {
                                    g.drawImage(bomb,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i--;
                                if(i == 0)
                                {
                                    i=10;
                                    j--;
                                }   break;
                            case Spy:
                                ptr.setTurn(true);
                                if(ptr.getIsShowingR())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTimeB)
                                { 
                                ptr.setTurn(false);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SEC2;
                                }
                                   ptr.setTurn(false);
                                   if(ptr.getIsShowingB())
                                   {
                                    g.drawImage(Ditto,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i--;
                                if(i == 0)
                                {
                                    i=10;
                                    j--;
                                }   break;
                            case Scout:
                                ptr.setTurn(true);
                                if(ptr.getIsShowingR())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTimeB)
                                { 
                                ptr.setTurn(false);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SEC2;
                                }
                                   ptr.setTurn(false);
                                   if(ptr.getIsShowingB())
                                   {
                                    g.drawImage(Weavile,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i--;
                                if(i == 0)
                                {
                                    i=10;
                                    j--;
                                }   break;
                            case Miner:                       
                                ptr.setTurn(true);
                                if(ptr.getIsShowingR())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTimeB)
                                { 
                                ptr.setTurn(false);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SEC2;
                                }
                                   ptr.setTurn(false);
                                   if(ptr.getIsShowingB())
                                   {
                                    g.drawImage(Rhydon,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i--;
                                if(i == 0)
                                {
                                    i=10;
                                    j--;
                                }   break;
                            case Seargent:
                                ptr.setTurn(true);
                                if(ptr.getIsShowingR())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTimeB)
                                { 
                                ptr.setTurn(false);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SEC2;
                                }
                                   ptr.setTurn(false);
                                   if(ptr.getIsShowingB())
                                   {
                                    g.drawImage(Umbreon,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i--;
                                if(i == 0)
                                {
                                    i=10;
                                    j--;
                                }   break;
                            case Lieutenant:
                                ptr.setTurn(true);
                                if(ptr.getIsShowingR())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTimeB)
                                { 
                                ptr.setTurn(false);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SEC2;
                                }
                                   ptr.setTurn(false);
                                   if(ptr.getIsShowingB())
                                   {
                                    g.drawImage(Sceptile,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i--;
                                if(i == 0)
                                {
                                    i=10;
                                    j--;
                                }   break;
                            case Captain:
                                ptr.setTurn(true);
                               if(ptr.getIsShowingR())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTimeB)
                                { 
                                ptr.setTurn(false);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SEC2;
                                }
                                   ptr.setTurn(false);
                                   if(ptr.getIsShowingB())
                                   {
                                    g.drawImage(Scizor,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i--;
                                if(i == 0)
                                {
                                    i=10;
                                    j--;
                                }   break;
                            case Major:
                                ptr.setTurn(true);
                                if(ptr.getIsShowingR())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTimeB)
                                { 
                                ptr.setTurn(false);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SEC2;
                                }
                                   ptr.setTurn(false);
                                   if(ptr.getIsShowingB())
                                   {
                                    g.drawImage(Garchomp,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                   i--;
                                if(i == 0)
                                {
                                    i=10;
                                    j--;
                                }   break;
                            case Colonel:
                                ptr.setTurn(true);
                                if(ptr.getIsShowingR())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTimeB)
                                { 
                                ptr.setTurn(false);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SEC2;
                                }
                                   ptr.setTurn(false);
                                   if(ptr.getIsShowingB())
                                   {
                                    g.drawImage(PrimalG,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i--;
                                if(i == 0)
                                {
                                    i=10;
                                    j--;
                                }   break;
                            case General:
                                ptr.setTurn(true);
                                if(ptr.getIsShowingR())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTimeB)
                                { 
                                ptr.setTurn(false);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SEC2;
                                }
                                   ptr.setTurn(false);
                                   if(ptr.getIsShowingB())
                                   {
                                    g.drawImage(megaK,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i--;
                                if(i == 0)
                                {
                                    i=10;
                                    j--;
                                }   break;
                            case Marshall:
                                ptr.setTurn(true);
                                if(ptr.getIsShowingR())
                                {
                                    g.setColor(Color.black);
                                    g.fillRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                    g.setColor(Color.red);
                                    g.drawRect(Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                                }
                                if(firstTimeB)
                                { 
                                ptr.setTurn(false);
//                                ptr.makeCColumn(i);
//                                ptr.makeCRow(j);
                                Board.board[ptr.getCRow()][ptr.getCColumn()]=Board.SEC2;
                                }
                                   ptr.setTurn(false);
                                   if(ptr.getIsShowingB())
                                   {
                                    g.drawImage(megaX,Window.getX(0)+ptr.getCColumn()*Window.getWidth2()/Board.numColumns
                                    ,Window.getY(0)+ptr.getCRow()*Window.getHeight2()/Board.numRows,
                                    Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                                   }
                                i--;
                                if(i == 0)
                                {
                                    i=10;
                                    j--;
                                }   break;


                            default:
                                break;
                        }
                }
            }
        }
            if (Piece.playerRWin)
            {
                g.setColor(Color.red);
                g.setFont(new Font("Monospaced",Font.BOLD,40) );
                g.drawString("Player Red has won!", getWidth()/2-225, getHeight()/2);
            }    
            else if (Piece.playerBWin)
            {
                g.setColor(Color.blue);
                g.setFont(new Font("Monospaced",Font.BOLD,40) );
                g.drawString("Player Blue has won!", getWidth()/2-225, getHeight()/2);
            }    
        }
    else if(state == State.SetUp)
    {
         //battle Field
            g.drawImage(BattleField,Window.getX(0),Window.getY(0),Window.getWidth2(),Window.getHeight2(),this);
            g.setColor(Color.black);
            
    //horizontal lines
            for (int zi=1;zi<Board.numRows;zi++)
            {
                g.drawLine(Window.getX(0) ,Window.getY(0)+zi*Window.getHeight2()/Board.numRows ,
                Window.getX(Window.getWidth2()) ,Window.getY(0)+zi*Window.getHeight2()/Board.numRows );
            }
    //vertical lines
            for (int zi=1;zi<Board.numColumns;zi++)
            {
                g.drawLine(Window.getX(0)+zi*Window.getWidth2()/Board.numColumns ,Window.getY(0) ,
                Window.getX(0)+zi*Window.getWidth2()/Board.numColumns,Window.getY(Window.getHeight2())  );
            }

    //Display the wall.
            for (int zrow=0;zrow<Board.numRows;zrow++)
            {
                for (int zcolumn=0;zcolumn<Board.numColumns;zcolumn++)
                {
                    if (Board.board[zrow][zcolumn] == Board.WALL)
                    {
                          g.setColor(Color.DARK_GRAY);
                        g.fillRect(Window.getX(0)+zcolumn*Window.getWidth2()/Board.numColumns,
                        Window.getY(0)+zrow*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,
                        Window.getHeight2()/Board.numRows);
                         g.drawRect(Window.getX(0)+zcolumn*Window.getWidth2()/Board.numColumns,
                        Window.getY(0)+zrow*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,
                        Window.getHeight2()/Board.numRows);
                    }  
                    if (Board.board[zrow][zcolumn] == Board.ROCK)
                    {
                        g.drawImage(Rock,Window.getX(0)+zcolumn*Window.getWidth2()/Board.numColumns,
                        Window.getY(0)+zrow*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,
                        Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
            
            g.setColor(Color.black);
            g.fillRect(Window.getX(-0)+11*Window.getWidth2()/Board.numColumns,Window.getY(0)+0*Window.getHeight2()/Board.numRows,Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
            g.setColor(Color.blue);
            g.drawRect(Window.getX(-0)+11*Window.getWidth2()/Board.numColumns,Window.getY(0)+0*Window.getHeight2()/Board.numRows,Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
            g.setFont(new Font("Monospaced",Font.BOLD,30));
            g.setColor(Color.blue);
            g.drawString("HELP",Window.getX(0)+Window.getWidth2()-80,Window.getY(0)+0*Window.getHeight2()/Board.numRows+Window.YTITLE);
    if(setUp)
    {
        if(changeInText <= 29)
        {
            int h = 10;
            int f = 10;
            for (Piece ptr : Piece.pieces)
            {
                if(firstTime&&firstTimeB)
                {
                    if(ptr.getIsShowingB())
                    {
                       

                        g.setColor(Color.black);
                        g.fillRect(Window.getX(0)+h*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+f*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                        g.setColor(Color.red);
                        g.drawRect(Window.getX(0)+h*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+f*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                        h--;
                        if(h == 0)
                        {
                            h=10;
                            f--;
                        }
                    }
                }
            }
        }
            if(changeInText == 0)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for your flag",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 1)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for bomb 1",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 2)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for bomb 2",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 3)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for bomb 3",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 4)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for bomb 4",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 5)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for bomb 5",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 6)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for bomb 6",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 7)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for your spy",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 8)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for scout 1",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 9)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for scout 2",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 10)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for scout 3",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 11)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for scout 4",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 12)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for scout 5",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 13)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for scout 6",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 14)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for scout 7",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 15)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for miner 1",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 16)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for miner 2",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 17)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for miner 3",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 18)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for miner 4",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 19)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for miner 5",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 20)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for sergeant 1",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 21)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for sergeant 2",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 22)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for lieutenant 1",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 23)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for lieutenant 2",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 24)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for captain 1",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 25)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for captain 2",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 26)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for your major",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 27)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for your colonel",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 28)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for your general",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
        else if(changeInText == 29)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Red: Select a place for your marshall",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2-100);
        }
            
        
        
        if(BchangeInText == 0 && changeInText > 29)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for your flag",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 1)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for bomb 1",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 2)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for bomb 2",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 3)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for bomb 3",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 4)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for bomb 4",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 5)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for bomb 5",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 6)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for bomb 6",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 7)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for your spy",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 8)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for scout 1",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 9)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for scout 2",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 10)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for scout 3",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 11)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for scout 4",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 12)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for scout 5",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 13)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for scout 6",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 14)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for scout 7",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 15)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for miner 1",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 16)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for miner 2",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 17)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for miner 3",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 18)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for miner 4",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 19)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for miner 5",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 20)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for sergeant 1",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 21)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for sergeant 2",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 22)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for lieutenant 1",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 23)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for lieutenant 2",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 24)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for captain 1",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 25)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for captain 2",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 26)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for your major",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 27)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for your colonel",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 28)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for your general",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        else if(BchangeInText == 29)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Blue: Select a place for your marshall",Window.getX(0)+Window.getWidth2()/2-400,Window.getY(0)+Window.getHeight2()/2+110);
        }
        
        int ydelta = Window.getHeight2()/Board.numRows;
        int xdelta = Window.getWidth2()/Board.numColumns;
        if(mouseClicked >= 1)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (flagClone[zi][zx] != null)
                    { 
                        g.drawImage(Red,Window.getX(0)+flagClone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+flagClone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
        if(mouseClicked >= 2)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (bomb1Clone[zi][zx] != null)
                    { 
                        g.drawImage(bomb,Window.getX(0)+bomb1Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+bomb1Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
        
        if(mouseClicked >= 3)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (bomb2Clone[zi][zx] != null)
                    { 
                        g.drawImage(bomb,Window.getX(0)+bomb2Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+bomb2Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
        if(mouseClicked >= 4)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (bomb3Clone[zi][zx] != null)
                    { 
                        g.drawImage(bomb,Window.getX(0)+bomb3Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+bomb3Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 5)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (bomb4Clone[zi][zx] != null)
                    { 
                        g.drawImage(bomb,Window.getX(0)+bomb4Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+bomb4Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 6)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (bomb5Clone[zi][zx] != null)
                    { 
                        g.drawImage(bomb,Window.getX(0)+bomb5Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+bomb5Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 7)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (bomb6Clone[zi][zx] != null)
                    { 
                        g.drawImage(bomb,Window.getX(0)+bomb6Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+bomb6Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 8)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (spyClone[zi][zx] != null)
                    { 
                        g.drawImage(Zoroark,Window.getX(0)+spyClone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+spyClone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 9)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (scout1Clone[zi][zx] != null)
                    { 
                        g.drawImage(Greninja,Window.getX(0)+scout1Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+scout1Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 10)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (scout2Clone[zi][zx] != null)
                    { 
                        g.drawImage(Greninja,Window.getX(0)+scout2Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+scout2Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 11)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (scout3Clone[zi][zx] != null)
                    { 
                        g.drawImage(Greninja,Window.getX(0)+scout3Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+scout3Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 12)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (scout4Clone[zi][zx] != null)
                    { 
                        g.drawImage(Greninja,Window.getX(0)+scout4Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+scout4Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 13)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (scout5Clone[zi][zx] != null)
                    { 
                        g.drawImage(Greninja,Window.getX(0)+scout5Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+scout5Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 14)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (scout6Clone[zi][zx] != null)
                    { 
                        g.drawImage(Greninja,Window.getX(0)+scout6Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+scout6Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 15)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (scout7Clone[zi][zx] != null)
                    { 
                        g.drawImage(Greninja,Window.getX(0)+scout7Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+scout7Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 16)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (miner1Clone[zi][zx] != null)
                    { 
                        g.drawImage(Excadrill,Window.getX(0)+miner1Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+miner1Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 17)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (miner2Clone[zi][zx] != null)
                    { 
                        g.drawImage(Excadrill,Window.getX(0)+miner2Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+miner2Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 18)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (miner3Clone[zi][zx] != null)
                    { 
                        g.drawImage(Excadrill,Window.getX(0)+miner3Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+miner3Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 19)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (miner4Clone[zi][zx] != null)
                    { 
                        g.drawImage(Excadrill,Window.getX(0)+miner4Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+miner4Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 20)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (miner5Clone[zi][zx] != null)
                    { 
                        g.drawImage(Excadrill,Window.getX(0)+miner5Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+miner5Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 21)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (seargent1Clone[zi][zx] != null)
                    { 
                        g.drawImage(Espeon,Window.getX(0)+seargent1Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+seargent1Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 22)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (seargent2Clone[zi][zx] != null)
                    { 
                        g.drawImage(Espeon,Window.getX(0)+seargent2Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+seargent2Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 23)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (liutenant1Clone[zi][zx] != null)
                    { 
                        g.drawImage(Electivire,Window.getX(0)+liutenant1Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+liutenant1Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 24)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (liutenant2Clone[zi][zx] != null)
                    { 
                        g.drawImage(Electivire,Window.getX(0)+liutenant2Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+liutenant2Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 25)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (captain1Clone[zi][zx] != null)
                    { 
                        g.drawImage(Bisharp,Window.getX(0)+captain1Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+captain1Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 26)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (captain2Clone[zi][zx] != null)
                    { 
                        g.drawImage(Bisharp,Window.getX(0)+captain2Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+captain2Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 27)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (majorClone[zi][zx] != null)
                    { 
                        g.drawImage(Hydreigon,Window.getX(0)+majorClone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+majorClone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 28)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (colonelClone[zi][zx] != null)
                    { 
                        g.drawImage(PrimalK,Window.getX(0)+colonelClone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+colonelClone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(mouseClicked >= 29)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (generalClone[zi][zx] != null)
                    { 
                        g.drawImage(megaS,Window.getX(0)+generalClone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+generalClone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                        
                    }
                }
            }
        }   

    
       if(mouseClicked >= 30)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (marshallClone[zi][zx] != null)
                    { 
                        g.drawImage(megaY,Window.getX(0)+marshallClone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+marshallClone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                        
                    }
                }
            }
        }   
    }
    
    if(BchangeInText <= 29&&changeInText > 29)
        {
            int a = 1;
            int s = 1;
            for (Piece ptr : Piece.pieces)
            {
                if(firstTimeB&&firstTime)
                {
                    if(ptr.getIsShowingR())
                    {
                        g.setColor(Color.black);
                        g.fillRect(Window.getX(0)+a*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+s*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                        g.setColor(Color.red);
                        g.drawRect(Window.getX(0)+a*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+s*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                        a++;
                        if(a == 11)
                        {
                            a=1;
                            s++;
                        }
                    }
                }
            }
        }
    {   
        if(BmouseClicked >= 1)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (BflagClone[zi][zx] != null)
                    { 
                        g.drawImage(Blue,Window.getX(0)+BflagClone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+BflagClone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
        if(BmouseClicked >= 2)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bbomb1Clone[zi][zx] != null)
                    { 
                        g.drawImage(bomb,Window.getX(0)+Bbomb1Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bbomb1Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
        
        if(BmouseClicked >= 3)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bbomb2Clone[zi][zx] != null)
                    { 
                        g.drawImage(bomb,Window.getX(0)+Bbomb2Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bbomb2Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
        if(BmouseClicked >= 4)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bbomb3Clone[zi][zx] != null)
                    { 
                        g.drawImage(bomb,Window.getX(0)+Bbomb3Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bbomb3Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 5)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bbomb4Clone[zi][zx] != null)
                    { 
                        g.drawImage(bomb,Window.getX(0)+Bbomb4Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bbomb4Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 6)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bbomb5Clone[zi][zx] != null)
                    { 
                        g.drawImage(bomb,Window.getX(0)+Bbomb5Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bbomb5Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 7)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bbomb6Clone[zi][zx] != null)
                    { 
                        g.drawImage(bomb,Window.getX(0)+Bbomb6Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bbomb6Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 8)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (BspyClone[zi][zx] != null)
                    { 
                        g.drawImage(Ditto,Window.getX(0)+BspyClone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+BspyClone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 9)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bscout1Clone[zi][zx] != null)
                    { 
                        g.drawImage(Weavile,Window.getX(0)+Bscout1Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bscout1Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 10)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bscout2Clone[zi][zx] != null)
                    { 
                        g.drawImage(Weavile,Window.getX(0)+Bscout2Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bscout2Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 11)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bscout3Clone[zi][zx] != null)
                    { 
                        g.drawImage(Weavile,Window.getX(0)+Bscout3Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bscout3Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 12)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bscout4Clone[zi][zx] != null)
                    { 
                        g.drawImage(Weavile,Window.getX(0)+Bscout4Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bscout4Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 13)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bscout5Clone[zi][zx] != null)
                    { 
                        g.drawImage(Weavile,Window.getX(0)+Bscout5Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bscout5Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 14)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bscout6Clone[zi][zx] != null)
                    { 
                        g.drawImage(Weavile,Window.getX(0)+Bscout6Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bscout6Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 15)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bscout7Clone[zi][zx] != null)
                    { 
                        g.drawImage(Weavile,Window.getX(0)+Bscout7Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bscout7Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 16)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bminer1Clone[zi][zx] != null)
                    { 
                        g.drawImage(Rhydon,Window.getX(0)+Bminer1Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bminer1Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 17)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bminer2Clone[zi][zx] != null)
                    { 
                        g.drawImage(Rhydon,Window.getX(0)+Bminer2Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bminer2Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 18)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bminer3Clone[zi][zx] != null)
                    { 
                        g.drawImage(Rhydon,Window.getX(0)+Bminer3Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bminer3Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 19)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bminer4Clone[zi][zx] != null)
                    { 
                        g.drawImage(Rhydon,Window.getX(0)+Bminer4Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bminer4Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 20)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bminer5Clone[zi][zx] != null)
                    { 
                        g.drawImage(Rhydon,Window.getX(0)+Bminer5Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bminer5Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 21)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bseargent1Clone[zi][zx] != null)
                    { 
                        g.drawImage(Umbreon,Window.getX(0)+Bseargent1Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bseargent1Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 22)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bseargent2Clone[zi][zx] != null)
                    { 
                        g.drawImage(Umbreon,Window.getX(0)+Bseargent2Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bseargent2Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 23)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bliutenant1Clone[zi][zx] != null)
                    { 
                        g.drawImage(Sceptile,Window.getX(0)+Bliutenant1Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bliutenant1Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 24)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bliutenant2Clone[zi][zx] != null)
                    { 
                        g.drawImage(Sceptile,Window.getX(0)+Bliutenant2Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bliutenant2Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 25)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bcaptain1Clone[zi][zx] != null)
                    { 
                        g.drawImage(Scizor,Window.getX(0)+Bcaptain1Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bcaptain1Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
        if(BmouseClicked >= 26)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (Bcaptain2Clone[zi][zx] != null)
                    { 
                        g.drawImage(Scizor,Window.getX(0)+Bcaptain2Clone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+Bcaptain2Clone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 27)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (BmajorClone[zi][zx] != null)
                    { 
                        g.drawImage(Garchomp,Window.getX(0)+BmajorClone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+BmajorClone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 28)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (BcolonelClone[zi][zx] != null)
                    { 
                        g.drawImage(PrimalG,Window.getX(0)+BcolonelClone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+BcolonelClone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 29)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (BgeneralClone[zi][zx] != null)
                    { 
                        g.drawImage(megaK,Window.getX(0)+BgeneralClone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+BgeneralClone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                    }
                }
            }
        }
       if(BmouseClicked >= 30)
        {
            for (int zi = 0;zi<Board.numRows;zi++)
            {
                for (int zx = 0;zx<Board.numColumns;zx++)
                {
                    if (BmarshallClone[zi][zx] != null)
                    { 
                        g.drawImage(megaX,Window.getX(0)+BmarshallClone[zi][zx].getCColumn()*Window.getWidth2()/Board.numColumns
                        ,Window.getY(0)+BmarshallClone[zi][zx].getCRow()*Window.getHeight2()/Board.numRows,
                        Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows,this);
                        setUp = false;
                    }
                }
            }
        }
       
    }  
    if(BchangeInText > 29&&changeInText > 29)
        {
                int a = 1;
                int s = 1;
                for (Piece ptr : Piece.pieces)
                {

                    {
                     
                        {
                            g.setColor(Color.black);
                            g.fillRect(Window.getX(0)+a*Window.getWidth2()/Board.numColumns
                            ,Window.getY(0)+s*Window.getHeight2()/Board.numRows,
                            Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                            g.setColor(Color.red);
                            g.drawRect(Window.getX(0)+a*Window.getWidth2()/Board.numColumns
                            ,Window.getY(0)+s*Window.getHeight2()/Board.numRows,
                            Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                            a++;
                            if(a == 11)
                            {
                                a=1;
                                s++;
                            }
                        }
                    }
                }
                     int h = 10;
                     int f = 10;
                      for (Piece ptr : Piece.pieces)
                {
                         {
                             {
                            g.setColor(Color.black);
                            g.fillRect(Window.getX(0)+h*Window.getWidth2()/Board.numColumns
                            ,Window.getY(0)+f*Window.getHeight2()/Board.numRows,
                            Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                            g.setColor(Color.red);
                            g.drawRect(Window.getX(0)+h*Window.getWidth2()/Board.numColumns
                            ,Window.getY(0)+f*Window.getHeight2()/Board.numRows,
                            Window.getWidth2()/Board.numColumns,Window.getHeight2()/Board.numRows);
                            h--;
                            if(h == 0)
                            {
                                h=10;
                                f--;
                            }
                        }
                    }
                }
            g.setColor(Color.black);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Click to start",Window.getX(0)+Window.getWidth2()/2-150/*-400*/,Window.getY(0)+Window.getHeight2()/2);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Monospaced",Font.BOLD,40) );
            g.drawString("Click to start",Window.getX(0)+Window.getWidth2()/2-147/*-397*/,Window.getY(0)+Window.getHeight2()/2);
            }
        }
        gOld.drawImage(image, 0, 0, null);
    }

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = 0.1;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        count=0;
        boolean keepLooping = true;
        speed=(int)(Math.random()*20+1);
        state = State.Title;
        firstTime=true;
        firstTimeB=true;
        firstTimeT=true;
        firstTimeT2=true;
        playerRedTurn = true;
        printRed=false;
        gameOver = false;
        resetComplete = true;
        miner1selected=false;
        miner2selected=false;
        betweenTurns = false;
        currTimeTillTurn = 0;
        gok=true;
        gok2=0;
        gok3=0;
        mouseClicked = 0;
        BmouseClicked = 0;
        changeInText = 0;
        BchangeInText = 0;
        setUp = true;
        
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {

        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
            // need to finish GMS
            Excadrill = Toolkit.getDefaultToolkit().getImage("./Excadrill.jpg");
            Ditto = Toolkit.getDefaultToolkit().getImage("./Ditto.jpg");
            megaK = Toolkit.getDefaultToolkit().getImage("./Mega Kangaskha.png");
            Sceptile = Toolkit.getDefaultToolkit().getImage("./Sceptile.jpg");
            Rhydon = Toolkit.getDefaultToolkit().getImage("./Rhydon.png");
            Electivire = Toolkit.getDefaultToolkit().getImage("./Electivire.jpg");
            bomb = Toolkit.getDefaultToolkit().getImage("./Electrode.jpg");
            Espeon = Toolkit.getDefaultToolkit().getImage("./Espeon.png");
            Garchomp = Toolkit.getDefaultToolkit().getImage("./Garchomp.jpg");
            Greninja = Toolkit.getDefaultToolkit().getImage("./Greninja.png");
            Hydreigon = Toolkit.getDefaultToolkit().getImage("./Hydreigon.jpg");
            megaX = Toolkit.getDefaultToolkit().getImage("./Mega Mewtwo X.jpg");
            megaY = Toolkit.getDefaultToolkit().getImage("./Mega Mewtwo Y.jpg");
            megaS = Toolkit.getDefaultToolkit().getImage("./Mega Salamence.jpg");
            PrimalG = Toolkit.getDefaultToolkit().getImage("./Primal Goudon.png");
            PrimalK = Toolkit.getDefaultToolkit().getImage("./Primal Kyogre.jpg");
            Ralts = Toolkit.getDefaultToolkit().getImage("./Ralts.jpg");
            Scizor = Toolkit.getDefaultToolkit().getImage("./Scizor.jpg");
            Abra = Toolkit.getDefaultToolkit().getImage("./Abra.png");
            Bisharp = Toolkit.getDefaultToolkit().getImage("./Bisharp.jpg");
            Red = Toolkit.getDefaultToolkit().getImage("./Trainer Red.png");
            Blue = Toolkit.getDefaultToolkit().getImage("./Trainer Blue.jpg");
            Umbreon = Toolkit.getDefaultToolkit().getImage("./Umbreon.jpg");
            Weavile = Toolkit.getDefaultToolkit().getImage("./Weavile.jpg");
            Zoroark = Toolkit.getDefaultToolkit().getImage("./Zoroark.png");
            Title = Toolkit.getDefaultToolkit().getImage("./Title.jpg");
            Help = Toolkit.getDefaultToolkit().getImage("./Help.png");
            HelpBall = Toolkit.getDefaultToolkit().getImage("./Ball3.GIF");
            BattleField = Toolkit.getDefaultToolkit().getImage("./BBB.jpg");
            Rock = Toolkit.getDefaultToolkit().getImage("./rock.png");
            Pokemon = Toolkit.getDefaultToolkit().getImage("./Pokemon.png");
            vs = Toolkit.getDefaultToolkit().getImage("./RVB.png");
            info = Toolkit.getDefaultToolkit().getImage("./Untitled.jpg");
            //gms
            info2 = Toolkit.getDefaultToolkit().getImage("./Untitled2.jpg");
            Help2 = Toolkit.getDefaultToolkit().getImage("./Help2.jpg");
            Char = Toolkit.getDefaultToolkit().getImage("./Char.GIF");
            reset();
            starwarsSound = new Sound("PokemonRBYTheme.wav");
        }
        if (starwarsSound != null && starwarsSound.donePlaying && state == State.Title)
        {
                starwarsSound = new Sound("PokemonRBYTheme.wav");
        }
        else if(starwarsSound != null && starwarsSound.donePlaying && state == State.Game)
        {
            starwarsSound = new Sound("Battle.wav");
        }
        else if(starwarsSound != null && starwarsSound.donePlaying && state == State.Help)
        {
            starwarsSound = new Sound("PokemonCenter.wav");
        }
                    if (gameOver)
                        return;
        if (Piece.playerRWin)
            return; 
        else if (Piece.playerBWin)
            return; 
        rowDir = 0;
        columnDir = 0;
        if(betweenTurns == true)
            currTimeTillTurn++;
        if(betweenTurns == true && currTimeTillTurn % 10 == 0)
        {
           timeShownBetweenTurns--; 
        }
        if(currTimeTillTurn/10 == timeBetweenTurns)
        {
            betweenTurns = false;
            currTimeTillTurn = 0;
            timeShownBetweenTurns = 3;
        }
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }
/////////////////////////////////////////////////////////////////////////

}