package pokemon;
import java.util.ArrayList;
public class Piece {
    public enum Type
    {
        Flag,Bomb,Spy,Scout,Miner,Seargent,Lieutenant,Captain,Major,Colonel,General,Marshall
    }
    public enum Direction
    {
        Up,Down,Left,Right
    }
    
    public final int NUM_FLAGS = 1;
    public final int NUM_BOMBS = 6;
    public final int NUM_SPY = 1;
    public final int NUM_SCOUT = 7;
    public final int NUM_MINER = 5;
    public final int NUM_SEARGENT = 2;
    public final int NUM_LIEUTENANT = 2;
    public final int NUM_CAPTAIN = 2;
    public final int NUM_MAJOR = 1;
    public final int NUM_COLONEL = 1;
    public final int NUM_GENERAL = 1;
    public final int NUM_MARSHALL = 1;
    ////////////////////////////////////////////////////
    static final int FLAG_RANK = 0;
    static final int BOMB_RANK = 0;
    static final int SPY_RANK = 1;
    static final int SCOUT_RANK = 2;
    static final int MINER_RANK = 3;
    static final int SEARGENT_RANK = 4;
    static final int LIEUTENANT_RANK = 5;
    static final int CAPTAIN_RANK = 6;
    static final int MAJOR_RANK = 7;
    static final int COLONEL_RANK = 8;
    static final int GENERAL_RANK = 9;
    static final int MARSHALL_RANK = 10;
    ///////////////////////////////////////////////////////
    private Type type;
    private Direction directionR;
    private Direction directionB;
    private int rank;
    private int currentRowR;
    private int currentColumnR;
    private int currentRowB;
    private int currentColumnB;
    private boolean isShowingR;
    private boolean isShowingB;
    private boolean selected;
    private boolean powerUpActiveR;
    private boolean powerUpActiveB;
    private int numTillPowerUpR = 3;
    private int numTillPowerUpB = 3;
    static public int currentRowT;
    static public int currentColumnT;
    static public boolean Raltsseen;
    static public int currentRowT2;
    static public int currentColumnT2;
    static public boolean Raltsseen2;
    static public boolean playerRWin = false;
    static public boolean playerBWin = false;
    boolean playerTurn;
    boolean turn;
    static ArrayList<Piece> pieces = new ArrayList<Piece>();
    ///////////////////////////////////////////////////////
    public static Piece addPiece(Type _type)
    {
        Piece tpr = new Piece(_type);
        pieces.add(tpr);
        return tpr;
    }
    Piece()
    {
        boolean keepLooping = true;
        while (keepLooping)
        {
            currentRowR = (int)(Math.random()*Board.numRows);
            currentColumnR = (int)(Math.random()*Board.numColumns);
            if (Board.board[currentRowR][currentColumnR] == Board.PATH)
            {
                keepLooping = false;
            }
        }
        type = null;
        rank = 0;
        isShowingR = true;
        isShowingB = true;
    }
    Piece(Type _type)
    {
        boolean keepLooping = true;
        while (keepLooping)
        {
            currentRowR = (int)(Math.random()*Board.numRows);
            currentColumnR = (int)(Math.random()*Board.numColumns);
            if (Board.board[currentRowR][currentColumnR] == Board.PATH)
            {
                keepLooping = false;
            }
        }
        type = _type;
        isShowingR = true;
        isShowingB = true;
        if(null != type)
        switch (type) {
            case Flag:
                rank = FLAG_RANK;
                break;
            case Bomb:
                rank = BOMB_RANK;
                break;
            case Spy:
                rank = SPY_RANK;
                break;
            case Scout:
                rank = SCOUT_RANK;
                break;
            case Miner:
                rank = MINER_RANK;
                break;
            case Seargent:
                rank = SEARGENT_RANK;
                break;
            case Lieutenant:
                rank = LIEUTENANT_RANK;
                break;
            case Captain:
                rank = CAPTAIN_RANK;
                break;
            case Major:
                rank = MAJOR_RANK;
                break;
            case Colonel:
                rank = COLONEL_RANK;
                break;
            case General:
                rank = GENERAL_RANK;
                break;
            case Marshall:
                rank = MARSHALL_RANK;
                break;
            default:
                break;
                
        }
    }
    public void movePiece(Piece curPiece,int X, int Y){
        

            if((X)>curPiece.getCColumn()&&Board.board[curPiece.getCRow()][curPiece.getCColumn()+1]==Board.PATH) 
            {
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.PATH;  
            curPiece.setCColumn(1);
            if(playerTurn)
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.SECR;
            }
            else if((X)<curPiece.getCColumn()&&Board.board[curPiece.getCRow()][curPiece.getCColumn()-1]==Board.PATH) 
            { 
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.PATH;
            curPiece.setCColumn(-1);
            if(playerTurn)
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.SECR;
            }
            else if((Y)-1>curPiece.getCRow()&&Board.board[curPiece.getCRow()+1][curPiece.getCColumn()]==Board.PATH) 
            {
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.PATH;
            curPiece.setCRow(1);
            if(playerTurn)
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.SECR;
            }
            else if((Y)-1<curPiece.getCRow()&&Board.board[curPiece.getCRow()-1][curPiece.getCColumn()]==Board.PATH) 
            {
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.PATH;
            curPiece.setCRow(-1);
            if(playerTurn)
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.SECR;
            else
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.SEC2;   
            }
if(playerTurn)
            {
                if(!Raltsseen)
                {
                    if(Board.board[curPiece.getCRow()][curPiece.getCColumn()]==Board.board[currentRowT][currentColumnT])
                    {
                        Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.PATH;
                        boolean keepLooping = true;
                        while (keepLooping)
                        {
                            int i=(int)(Math.random()*Board.numRows);
                            int j=(int)(Math.random()*Board.numColumns);
                            curPiece.makeCRow(i);
                            curPiece.makeCColumn(j);
                            if (Board.board[curPiece.getCRow()][curPiece.getCColumn()] == Board.PATH&&curPiece.getCRow()<8&&curPiece.getCRow()>3)
                            {
                                keepLooping = false;
                                Raltsseen=true;
                            }
                        }
                    }
                }
            }
            else
                if(!Raltsseen2)
            {
                if(Board.board[curPiece.getCRow()][curPiece.getCColumn()]==Board.board[currentRowT2][currentColumnT2])
                {
                    Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.PATH;
                    boolean keepLooping = true;
                    while (keepLooping)
                    {
                        int i=(int)(Math.random()*Board.numRows);
                        int j=(int)(Math.random()*Board.numColumns);
                        curPiece.makeCRow(i);
                        curPiece.makeCColumn(j);
                        if (Board.board[curPiece.getCRow()][curPiece.getCColumn()] == Board.PATH&&curPiece.getCRow()<8&&curPiece.getCRow()>3)
                        {
                            keepLooping = false;
                            Raltsseen2=true;
                        }
                    }
                }
            }
        

    }
    public void moveScout(Piece curPiece,int X, int Y){
            if((X)>curPiece.getCColumn()&&Board.board[curPiece.getCRow()][curPiece.getCColumn()+1]==Board.PATH) 
            {
            for(int i=1; i<X;)
                if(Board.board[curPiece.getCRow()][X]<=Board.board[curPiece.getCRow()][curPiece.getCColumn()+i]&&Board.board[curPiece.getCRow()][curPiece.getCColumn()+i]==Board.PATH)
                {
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.PATH;
            curPiece.setCColumn(+1);
            if(playerTurn)
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.SECR;
            else
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.SEC2;  
                }
                else
                    break;
            
            }
            else if((X)<curPiece.getCColumn()&&Board.board[curPiece.getCRow()][curPiece.getCColumn()-1]==Board.PATH) 
            { 
            for(int i=1; i<X;)
                if(Board.board[curPiece.getCRow()][X]<=Board.board[curPiece.getCRow()][curPiece.getCColumn()-i]&&Board.board[curPiece.getCRow()][curPiece.getCColumn()-i]==Board.PATH)
                {
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.PATH;
            curPiece.setCColumn(-1);
            if(playerTurn)
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.SECR;
            else
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.SEC2;  
                }
                else
                    break;
            
            }
            else if((Y)-1>curPiece.getCRow()&&Board.board[curPiece.getCRow()+1][curPiece.getCColumn()]==Board.PATH) 
            {
             for(int i=1; i<Y-1;)
                if(Board.board[Y-1][curPiece.getCColumn()]<=Board.board[curPiece.getCRow()+i][curPiece.getCColumn()]&&Board.board[curPiece.getCRow()+i][curPiece.getCColumn()]==Board.PATH)
                {
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.PATH;
            curPiece.setCRow(1);
            if(playerTurn)
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.SECR;
            else
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.SEC2;  
                }
                else
                    break;
             
            }
            else if((Y)-1<curPiece.getCRow()&&Board.board[curPiece.getCRow()-1][curPiece.getCColumn()]==Board.PATH) 
            {
                for(int i=1; i<Y-1;)
                if(Board.board[Y-1][curPiece.getCColumn()]<=Board.board[curPiece.getCRow()-i][curPiece.getCColumn()]&&Board.board[curPiece.getCRow()-i][curPiece.getCColumn()]==Board.PATH)
                {
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.PATH;
            curPiece.setCRow(-1);
            if(playerTurn)
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.SECR;
            else
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.SEC2;  
                }
                else
                    break;
            }
            if(playerTurn)
            {
                if(!Raltsseen)
                {
                    if(Board.board[curPiece.getCRow()][curPiece.getCColumn()]==Board.board[currentRowT-1][currentColumnT])
                    {
                        Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.PATH;
                        boolean keepLooping = true;
                        while (keepLooping)
                        {
                            int i=(int)(Math.random()*Board.numRows);
                            int j=(int)(Math.random()*Board.numColumns);
                            curPiece.makeCRow(i);
                            curPiece.makeCColumn(j);
                            if (Board.board[curPiece.getCRow()][curPiece.getCColumn()] == Board.PATH&&curPiece.getCRow()<8&&curPiece.getCRow()>3)
                            {
                                keepLooping = false;
                                Raltsseen=true;
                            }
                        }
                    }
                }
            }
            else
                if(!Raltsseen2)
            {
                if(Board.board[curPiece.getCRow()][curPiece.getCColumn()]==Board.board[currentRowT2-1][currentColumnT2])
                {
                    Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.PATH;
                    boolean keepLooping = true;
                    while (keepLooping)
                    {
                        int i=(int)(Math.random()*Board.numRows);
                        int j=(int)(Math.random()*Board.numColumns);
                        curPiece.makeCRow(i);
                        curPiece.makeCColumn(j);
                        if (Board.board[curPiece.getCRow()][curPiece.getCColumn()] == Board.PATH&&curPiece.getCRow()<8&&curPiece.getCRow()>3)
                        {
                            keepLooping = false;
                            Raltsseen2=true;
                        }
                    }
                }
            }
    }
     public void setSelected(boolean _select)
    {
        selected=_select;
    }
      public void setTurn(boolean _turn)
    {
        playerTurn=_turn;
    }
      public boolean getSelected()
    {
        return(selected);
    }
    public int getCRow()
    {
        if(playerTurn)
        return(currentRowR);
        else
        return(currentRowB);
    }
     public int getCColumn()
    {
         if(playerTurn)
         return(currentColumnR);
        else
         return(currentColumnB);
    }
      public void makeCColumn(int v)
    {
         if(playerTurn)
        currentColumnR=v;
        else
        currentColumnB=v;
    }
     public void makeCRow(int v)
    {
        if(playerTurn)
        currentRowR=v;
        else
        currentRowB=v;
        
    }
     public void setCRow(int v)
    {
         if(playerTurn)
         currentRowR+=v;
        else
         currentRowB+=v;

    }
     public void setCColumn(int v)
    {
         if(playerTurn)
         currentColumnR+=v;
        else
        currentColumnB+=v;
    }
    public Type getType()
    {
        return type;
    }
    public Direction getDirectionR()
    {
        return directionR;
    }
    public void setDirectionR(Direction _direction)
    {
        directionR = _direction;
    }
    public Direction getDirectionB()
    {
        return directionB;
    }
    public void setDirectionB(Direction _direction)
    {
        directionB = _direction;
    }
    public int getRank()
    {
        return rank;
    }
    public int getNumTillPowerUpR()
    {
        return numTillPowerUpR;
    }
    public int getNumTillPowerUpB()
    {
        return numTillPowerUpB;
    }
    public boolean getIsShowingR()
    {
        return isShowingR;
    }
    public boolean getIsShowingB()
    {
        return isShowingB;
    }
    public boolean getPowerUpActiveR()
    {
        return powerUpActiveR;
    }
    public boolean getPowerUpActiveB()
    {
        return powerUpActiveB;
    }
    public int getRowR()
    {
        return(currentRowR);
    }
     public int getColumnR()
    {
         return(currentColumnR);
    }
     public int getRowB()
    {
        return(currentRowB);
    }
     public int getColumnB()
    {
         return(currentColumnB);
    }
     static public void makeT()
    {
        boolean keepLooping = true;
        while (keepLooping)
        {
            currentRowT = (int)(Math.random()*Board.numRows);
            currentColumnT = (int)(Math.random()*Board.numColumns);
            if (Board.board[currentRowT][currentColumnT] == Board.PATH&&currentRowT<8&&currentRowT>3)
            {
                keepLooping = false;
            }
        }
    }
     static public void makeT2()
    {
        boolean keepLooping = true;
        while (keepLooping)
        {
            currentRowT2 = (int)(Math.random()*Board.numRows);
            currentColumnT2 = (int)(Math.random()*Board.numColumns);
            if (Board.board[currentRowT2][currentColumnT2] == Board.PATH&&currentRowT2<8&&currentRowT2>3)
            {
                keepLooping = false;
            }
        }
    }
     public boolean checkspot(Piece curPiece,int X, int Y)
    {
        if((X)>curPiece.getCColumn()&&Board.board[curPiece.getCRow()][curPiece.getCColumn()]==Board.PATH) 
            {
            if(playerTurn)
            {
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.SECR;
            }
            else
            {
            Board.board[curPiece.getCRow()][curPiece.getCColumn()]=Board.SEC2; 
            }
            return(false);
            }
        return(true);
    }
    public static void checkFight(Piece currPiece)
    {
        for(Piece ptr : Piece.pieces)
        {
            if(ptr != currPiece)
            {
                if(ptr != null && currPiece != null)
                {
                    if(currPiece.getType() == Type.Spy)
                    {
                        if(currPiece.playerTurn)
                        {       
                            if(currPiece.directionR == Direction.Down)
                            {  
                                if(ptr.currentRowB == currPiece.currentRowR+1 && ptr.currentColumnB == currPiece.currentColumnR)
                                {
                                    if(ptr.getType() == Type.Marshall)
                                    {
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                    }
                                    else if(ptr.getType() == Type.Flag)
                                    {
                                        playerRWin = true;
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                    }
                                    else if(ptr.getType() != Type.Marshall)
                                    {
                                        currPiece.isShowingR = false;
                                        Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                        currPiece.currentColumnR = 0;
                                        currPiece.currentRowR = 0;
                                    }
                                    else if(ptr.getRank() == currPiece.getRank())
                                    {
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                        currPiece.isShowingR = false;
                                        Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                        currPiece.currentColumnR = 0;
                                        currPiece.currentRowR = 0;
                                    }
                                }
                            }
                            else if(currPiece.directionR == Direction.Up)
                            {
                                if(ptr.currentRowB == currPiece.currentRowR-1 && ptr.currentColumnB == currPiece.currentColumnR)
                                {
                                    if(ptr.getType() == Type.General)
                                    {
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                    }
                                    else if(ptr.getType() == Type.Flag)
                                    {
                                        playerRWin = true;
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                    }
                                    else if(ptr.getType() != Type.General)
                                    {
                                        currPiece.isShowingR = false;
                                        Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                        currPiece.currentColumnR = 0;
                                        currPiece.currentRowR = 0;
                                    }
                                    else if(ptr.getRank() == currPiece.getRank())
                                    {
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                        currPiece.isShowingR = false;
                                        Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                        currPiece.currentColumnR = 0;
                                        currPiece.currentRowR = 0;
                                    }
                                }
                            }
                            else if(currPiece.directionR == Direction.Left)
                            {
                                if(ptr.currentRowB == currPiece.currentRowR && ptr.currentColumnB == currPiece.currentColumnR-1)
                                {
                                    if(ptr.getType() == Type.General)
                                    {
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                    }
                                    else if(ptr.getType() == Type.Flag)
                                    {
                                        playerRWin = true;
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                    }
                                    else if(ptr.getType() != Type.General)
                                    {
                                        currPiece.isShowingR = false;
                                        Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                        currPiece.currentColumnR = 0;
                                        currPiece.currentRowR = 0;
                                    }
                                    else if(ptr.getRank() == currPiece.getRank())
                                    {
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                        currPiece.isShowingR = false;
                                        Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                        currPiece.currentColumnR = 0;
                                        currPiece.currentRowR = 0;
                                    }
                                }
                            }
                            else if(currPiece.directionR == Direction.Right)
                            {
                                if(ptr.currentRowB == currPiece.currentRowR && ptr.currentColumnB == currPiece.currentColumnR+1)
                                {
                                    if(ptr.getType() == Type.General)
                                    {
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                    }
                                    else if(ptr.getType() == Type.Flag)
                                    {
                                        playerRWin = true;
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                    }
                                    else if(ptr.getType() != Type.General)
                                    {
                                        currPiece.isShowingR = false;
                                        Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                        currPiece.currentColumnR = 0;
                                        currPiece.currentRowR = 0;
                                    }
                                    else if(ptr.getRank() == currPiece.getRank())
                                    {
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                        currPiece.isShowingR = false;
                                        Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                        currPiece.currentColumnR = 0;
                                        currPiece.currentRowR = 0;
                                    }
                                }
                            }
                        }
                        else
                        {
                            if(currPiece.directionB == Direction.Down)
                            {
                                if(ptr.currentRowR == currPiece.currentRowB+1 && ptr.currentColumnR == currPiece.currentColumnB)
                                {
                                    if(ptr.getType() == Type.General)
                                    {
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                    }
                                    else if(ptr.getType() == Type.Flag)
                                    {
                                        playerBWin = true;
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                    }
                                    else if(ptr.getType() != Type.General)
                                    {
                                        currPiece.isShowingB = false;
                                        Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                        currPiece.currentColumnB = 0;
                                        currPiece.currentRowB = 0;
                                    }
                                    else if(ptr.getRank() == currPiece.getRank())
                                    {
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                        currPiece.isShowingB = false;
                                        Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                        currPiece.currentColumnB = 0;
                                        currPiece.currentRowB = 0;
                                    }
                                }
                            }
                            else if(currPiece.directionB == Direction.Up)
                            {
                                if(ptr.currentRowR == currPiece.currentRowB-1 && ptr.currentColumnR == currPiece.currentColumnB)
                                {
                                    if(ptr.getType() == Type.General)
                                    {
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                    }
                                    else if(ptr.getType() == Type.Flag)
                                    {
                                        playerBWin = true;
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                    }
                                    else if(ptr.getType() != Type.General)
                                    {
                                        currPiece.isShowingB = false;
                                        Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                        currPiece.currentColumnB = 0;
                                        currPiece.currentRowB = 0;
                                    }
                                    else if(ptr.getRank() == currPiece.getRank())
                                    {
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                        currPiece.isShowingB = false;
                                        Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                        currPiece.currentColumnB = 0;
                                        currPiece.currentRowB = 0;
                                    }
                                }
                            }
                            else if(currPiece.directionB == Direction.Right)
                            {
                                if(ptr.currentRowR == currPiece.currentRowB && ptr.currentColumnR == currPiece.currentColumnB+1)
                                {
                                    if(ptr.getType() == Type.General)
                                    {
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                    }
                                    else if(ptr.getType() == Type.Flag)
                                    {
                                        playerBWin = true;
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                    }
                                    else if(ptr.getType() != Type.General)
                                    {
                                        currPiece.isShowingB = false;
                                        Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                        currPiece.currentColumnB = 0;
                                        currPiece.currentRowB = 0;
                                    }
                                    else if(ptr.getRank() == currPiece.getRank())
                                    {
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                        currPiece.isShowingB = false;
                                        Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                        currPiece.currentColumnB = 0;
                                        currPiece.currentRowB = 0;
                                    }
                                }
                            }
                            else if(currPiece.directionB == Direction.Left)
                            {
                                if(ptr.currentRowR == currPiece.currentRowB && ptr.currentColumnR == currPiece.currentColumnB-1)
                                {
                                    if(ptr.getType() == Type.General)
                                    {
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                    }
                                    else if(ptr.getType() == Type.Flag)
                                    {
                                        playerBWin = true;
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                    }
                                    else if(ptr.getType() != Type.General)
                                    {
                                        currPiece.isShowingB = false;
                                        Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                        currPiece.currentColumnB = 0;
                                        currPiece.currentRowB = 0;
                                    }
                                    else if(ptr.getRank() == currPiece.getRank())
                                    {
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                        currPiece.isShowingB = false;
                                        Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                        currPiece.currentColumnB = 0;
                                        currPiece.currentRowB = 0;
                                    }
                                }
                            }
                        }
                    }
                    else 
                    {
                        if(currPiece.playerTurn)
                        {
                            if(currPiece.directionR == Direction.Down)
                            {  
                                if(ptr.currentRowB == currPiece.currentRowR+1 && ptr.currentColumnB == currPiece.currentColumnR)
                                {
                                    if(ptr.getType() == Type.Bomb)
                                    {
                                        if(currPiece.getType() == Type.Miner)
                                        {
                                            ptr.isShowingB = false;
                                            Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                            ptr.currentColumnB = 0;
                                            ptr.currentRowB = 0;
                                        }
                                        else
                                        {
                                            currPiece.isShowingR = false;
                                            Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                            currPiece.currentColumnR = 0;
                                            currPiece.currentRowR = 0;
                                        }
                                    }
                                    else if(ptr.getType() == Type.Flag)
                                    {
                                        playerRWin = true;
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                    }
                                    else if(ptr.getRank() > currPiece.getRank())
                                    {
                                        currPiece.isShowingR = false;
                                        Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                        currPiece.currentColumnR = 0;
                                        currPiece.currentRowR = 0;
                                        ptr.numTillPowerUpB--;
                                        if(ptr.numTillPowerUpB == 0)
                                        {
                                            ptr.powerUpActiveB = true;
                                            ptr.numTillPowerUpB = 3;
                                        }
                                    }
                                    else if(ptr.getRank() == currPiece.getRank())
                                    {
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                        currPiece.isShowingR = false;
                                        Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                        currPiece.currentColumnR = 0;
                                        currPiece.currentRowR = 0;
                                    }
                                    else 
                                    {
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                        currPiece.numTillPowerUpR--;
                                        if(currPiece.numTillPowerUpR == 0)
                                        {
                                            currPiece.powerUpActiveR = true;
                                            currPiece.numTillPowerUpR = 3;
                                        }
                                    }
                                }
                            }
                            else if(currPiece.directionR == Direction.Up)
                            {
                                if(ptr.currentRowB == currPiece.currentRowR-1 && ptr.currentColumnB == currPiece.currentColumnR)
                                {
                                    if(ptr.getType() == Type.Bomb)
                                    {
                                        if(currPiece.getType() == Type.Miner)
                                        {
                                            ptr.isShowingB = false;
                                            Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                            ptr.currentColumnB = 0;
                                            ptr.currentRowB = 0;
                                        }
                                        else
                                        {
                                            currPiece.isShowingR = false;
                                            Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                            currPiece.currentColumnR = 0;
                                            currPiece.currentRowR = 0;
                                        }
                                    }
                                    else if(ptr.getType() == Type.Flag)
                                    {
                                        playerRWin = true;
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                    }
                                    else if(ptr.getRank() > currPiece.getRank())
                                    {
                                        currPiece.isShowingR = false;
                                        Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                        currPiece.currentColumnR = 0;
                                        currPiece.currentRowR = 0;
                                        ptr.numTillPowerUpB--;
                                        if(ptr.numTillPowerUpB == 0)
                                        {
                                            ptr.powerUpActiveB = true;
                                            ptr.numTillPowerUpB = 3;
                                        }
                                    }
                                    else if(ptr.getRank() == currPiece.getRank())
                                    {
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                        currPiece.isShowingR = false;
                                        Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                        currPiece.currentColumnR = 0;
                                        currPiece.currentRowR = 0;
                                    }
                                    else 
                                    {
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                        currPiece.numTillPowerUpR--;
                                        if(currPiece.numTillPowerUpR == 0)
                                        {
                                            currPiece.powerUpActiveR = true;
                                            currPiece.numTillPowerUpR = 3;
                                        }
                                    }
                                }
                            }
                            else if(currPiece.directionR == Direction.Left)
                            {
                                if(ptr.currentRowB == currPiece.currentRowR && ptr.currentColumnB == currPiece.currentColumnR-1)
                                {
                                    if(ptr.getType() == Type.Bomb)
                                    {
                                        if(currPiece.getType() == Type.Miner)
                                        {
                                            ptr.isShowingB = false;
                                            Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                            ptr.currentColumnB = 0;
                                            ptr.currentRowB = 0;
                                        }
                                        else
                                        {
                                            currPiece.isShowingR = false;
                                            Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                            currPiece.currentColumnR = 0;
                                            currPiece.currentRowR = 0;
                                        }
                                    }
                                    else if(ptr.getType() == Type.Flag)
                                    {
                                        playerRWin = true;
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                    }
                                    else if(ptr.getRank() > currPiece.getRank())
                                    {
                                        currPiece.isShowingR = false;
                                        Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                        currPiece.currentColumnR = 0;
                                        currPiece.currentRowR = 0;
                                        ptr.numTillPowerUpB--;
                                        if(ptr.numTillPowerUpB == 0)
                                        {
                                            ptr.powerUpActiveB = true;
                                            ptr.numTillPowerUpB = 3;
                                        }
                                    }
                                    else if(ptr.getRank() == currPiece.getRank())
                                    {
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                        currPiece.isShowingR = false;
                                        Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                        currPiece.currentColumnR = 0;
                                        currPiece.currentRowR = 0;
                                    }
                                    else 
                                    {
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                        currPiece.numTillPowerUpR--;
                                        if(currPiece.numTillPowerUpR == 0)
                                        {
                                            currPiece.powerUpActiveR = true;
                                            currPiece.numTillPowerUpR = 3;
                                        }
                                    }
                                }
                            }
                            else if(currPiece.directionR == Direction.Right)
                            {
                                if(ptr.currentRowB == currPiece.currentRowR && ptr.currentColumnB == currPiece.currentColumnR+1)
                                {
                                    if(ptr.getType() == Type.Bomb)
                                    {
                                        if(currPiece.getType() == Type.Miner)
                                        {
                                            ptr.isShowingB = false;
                                            Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                            ptr.currentColumnB = 0;
                                            ptr.currentRowB = 0;
                                        }
                                        else
                                        {
                                            currPiece.isShowingR = false;
                                            Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                            currPiece.currentColumnR = 0;
                                            currPiece.currentRowR = 0;
                                        }
                                    }
                                    else if(ptr.getType() == Type.Flag)
                                    {
                                        playerRWin = true;
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                    }
                                    else if(ptr.getRank() > currPiece.getRank())
                                    {
                                        currPiece.isShowingR = false;
                                        Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                        currPiece.currentColumnR = 0;
                                        currPiece.currentRowR = 0;
                                        ptr.numTillPowerUpB--;
                                        if(ptr.numTillPowerUpB == 0)
                                        {
                                            ptr.powerUpActiveB = true;
                                            ptr.numTillPowerUpB = 3;
                                        }
                                    }
                                    else if(ptr.getRank() == currPiece.getRank())
                                    {
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                        currPiece.isShowingR = false;
                                        Board.board[currPiece.currentRowR][currPiece.currentColumnR] = Board.PATH;
                                        currPiece.currentColumnR = 0;
                                        currPiece.currentRowR = 0;
                                    }
                                    else 
                                    {
                                        ptr.isShowingB = false;
                                        Board.board[ptr.currentRowB][ptr.currentColumnB] = Board.PATH;
                                        ptr.currentColumnB = 0;
                                        ptr.currentRowB = 0;
                                        currPiece.numTillPowerUpR--;
                                        if(currPiece.numTillPowerUpR == 0)
                                        {
                                            currPiece.powerUpActiveR = true;
                                            currPiece.numTillPowerUpR = 3;
                                        }
                                    }
                                }
                            }
                        }
                        else
                        {
                            if(currPiece.directionB == Direction.Down)
                            {
                                if(ptr.currentRowR == currPiece.currentRowB+1 && ptr.currentColumnR == currPiece.currentColumnB)
                                {
                                    if(ptr.getType() == Type.Bomb)
                                    {
                                        if(currPiece.getType() == Type.Miner)
                                        {
                                            ptr.isShowingR = false;
                                            Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                            ptr.currentColumnR = 0;
                                            ptr.currentRowR = 0;
                                        }
                                        else
                                        {
                                            currPiece.isShowingB = false;
                                            Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                            currPiece.currentColumnB = 0;
                                            currPiece.currentRowB = 0;
                                        }
                                    }
                                    else if(ptr.getType() == Type.Flag)
                                    {
                                        playerBWin = true;
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                    }
                                    else if(ptr.getRank() > currPiece.getRank())
                                    {
                                        currPiece.isShowingB = false;
                                        Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                        currPiece.currentColumnB = 0;
                                        currPiece.currentRowB = 0;
                                        ptr.numTillPowerUpR--;
                                        if(ptr.numTillPowerUpR == 0)
                                        {
                                            ptr.powerUpActiveR = true;
                                            ptr.numTillPowerUpR = 3;
                                        }
                                    }
                                    else if(ptr.getRank() == currPiece.getRank())
                                    {
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                        currPiece.isShowingB = false;
                                        Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                        currPiece.currentColumnB = 0;
                                        currPiece.currentRowB = 0;
                                    }
                                    else 
                                    {
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                        currPiece.numTillPowerUpB--;
                                        if(currPiece.numTillPowerUpB == 0)
                                        {
                                            currPiece.powerUpActiveB = true;
                                            currPiece.numTillPowerUpB = 3;
                                        }
                                    }
                                }
                            }
                            else if(currPiece.directionB == Direction.Up)
                            {
                                if(ptr.currentRowR == currPiece.currentRowB-1 && ptr.currentColumnR == currPiece.currentColumnB)
                                {
                                    if(ptr.getType() == Type.Bomb)
                                    {
                                        if(currPiece.getType() == Type.Miner)
                                        {
                                            ptr.isShowingR = false;
                                            Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                            ptr.currentColumnR = 0;
                                            ptr.currentRowR = 0;
                                        }
                                        else
                                        {
                                            currPiece.isShowingB = false;
                                            Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                            currPiece.currentColumnB = 0;
                                            currPiece.currentRowB = 0;
                                        }
                                    }
                                    else if(ptr.getType() == Type.Flag)
                                    {
                                        playerBWin = true;
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                    }
                                    else if(ptr.getRank() > currPiece.getRank())
                                    {
                                        currPiece.isShowingB = false;
                                        Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                        currPiece.currentColumnB = 0;
                                        currPiece.currentRowB = 0;
                                        ptr.numTillPowerUpR--;
                                        if(ptr.numTillPowerUpR == 0)
                                        {
                                            ptr.powerUpActiveR = true;
                                            ptr.numTillPowerUpR = 3;
                                        }
                                    }
                                    else if(ptr.getRank() == currPiece.getRank())
                                    {
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                        currPiece.isShowingB = false;
                                        Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                        currPiece.currentColumnB = 0;
                                        currPiece.currentRowB = 0;
                                    }
                                    else 
                                    {
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                        currPiece.numTillPowerUpB--;
                                        if(currPiece.numTillPowerUpB == 0)
                                        {
                                            currPiece.powerUpActiveB = true;
                                            currPiece.numTillPowerUpB = 3;
                                        }
                                    }
                                }
                            }
                            else if(currPiece.directionB == Direction.Right)
                            {
                                if(ptr.currentRowR == currPiece.currentRowB && ptr.currentColumnR == currPiece.currentColumnB+1)
                                {
                                    if(ptr.getType() == Type.Bomb)
                                    {
                                        if(currPiece.getType() == Type.Miner)
                                        {
                                            ptr.isShowingR = false;
                                            Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                            ptr.currentColumnR = 0;
                                            ptr.currentRowR = 0;
                                        }
                                        else
                                        {
                                            currPiece.isShowingB = false;
                                            Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                            currPiece.currentColumnB = 0;
                                            currPiece.currentRowB = 0;
                                        }
                                    }
                                    else if(ptr.getType() == Type.Flag)
                                    {
                                        playerBWin = true;
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                    }
                                    else if(ptr.getRank() > currPiece.getRank())
                                    {
                                        currPiece.isShowingB = false;
                                        Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                        currPiece.currentColumnB = 0;
                                        currPiece.currentRowB = 0;
                                        ptr.numTillPowerUpR--;
                                        if(ptr.numTillPowerUpR == 0)
                                        {
                                            ptr.powerUpActiveR = true;
                                            ptr.numTillPowerUpR = 3;
                                        }
                                    }
                                    else if(ptr.getRank() == currPiece.getRank())
                                    {
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                        currPiece.isShowingB = false;
                                        Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                        currPiece.currentColumnB = 0;
                                        currPiece.currentRowB = 0;
                                    }
                                    else 
                                    {
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                        currPiece.numTillPowerUpB--;
                                        if(currPiece.numTillPowerUpB == 0)
                                        {
                                            currPiece.powerUpActiveB = true;
                                            currPiece.numTillPowerUpB = 3;
                                        }
                                    }
                                }
                            }
                            else if(currPiece.directionB == Direction.Left)
                            {
                                if(ptr.currentRowR == currPiece.currentRowB && ptr.currentColumnR == currPiece.currentColumnB-1)
                                {
                                    if(ptr.getType() == Type.Bomb)
                                    {
                                        if(currPiece.getType() == Type.Miner)
                                        {
                                            ptr.isShowingR = false;
                                            Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                            ptr.currentColumnR = 0;
                                            ptr.currentRowR = 0;
                                        }
                                        else
                                        {
                                            currPiece.isShowingB = false;
                                            Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                            currPiece.currentColumnB = 0;
                                            currPiece.currentRowB = 0;
                                        }
                                    }
                                    else if(ptr.getType() == Type.Flag)
                                    {
                                        playerBWin = true;
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                    }
                                    else if(ptr.getRank() > currPiece.getRank())
                                    {
                                        currPiece.isShowingB = false;
                                        Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                        currPiece.currentColumnB = 0;
                                        currPiece.currentRowB = 0;
                                        ptr.numTillPowerUpR--;
                                        if(ptr.numTillPowerUpR == 0)
                                        {
                                            ptr.powerUpActiveR = true;
                                            ptr.numTillPowerUpR = 3;
                                        }
                                    }
                                    else if(ptr.getRank() == currPiece.getRank())
                                    {
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                        currPiece.isShowingB = false;
                                        Board.board[currPiece.currentRowB][currPiece.currentColumnB] = Board.PATH;
                                        currPiece.currentColumnB = 0;
                                        currPiece.currentRowB = 0;
                                    }
                                    else 
                                    {
                                        ptr.isShowingR = false;
                                        Board.board[ptr.currentRowR][ptr.currentColumnR] = Board.PATH;
                                        ptr.currentColumnR = 0;
                                        ptr.currentRowR = 0;
                                        currPiece.numTillPowerUpB--;
                                        if(currPiece.numTillPowerUpB == 0)
                                        {
                                            currPiece.powerUpActiveB = true;
                                            currPiece.numTillPowerUpB = 3;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
