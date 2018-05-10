package pokemon;
public class Piece {
    public enum Type
    {
        Flag,Bomb,Spy,Scout,Miner,Seargent,Lieutenant,Captain,Major,Colonel,General,Marshall
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
    private int rank;
    ///////////////////////////////////////////////////////
    Piece()
    {
        type = null;
        rank = 0;
    }
    Piece(Type _type)
    {
        type = _type;
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
    public Type getType()
    {
        return type;
    }
    public int getRank()
    {
        return rank;
    }
}
