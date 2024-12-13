
package GameTheory.Strategies;

public class TitForTat extends Strategy {

/**
     * This strategy (Tit-For-Tat) copies the previous move of the opposing player.
     * This is generally known as a fairly good strategy, as it is simultaneously
     * nice, forgiving, and revengeful.
     *
     * This requires adding opponent move history after each battle
     */

    public TitForTat() {
        super();
    }

    @Override
    public int makeMove(boolean player) {
        int move = 0;
        int s1;
        int s2;
        //int sP1 = opponentMoveHistoryPlayer1.get(opponentMoveHistoryPlayer1.size() - 1);
        //int sP2 = opponentMoveHistoryPlayer2.get(opponentMoveHistoryPlayer2.size() - 1);
        
        if(player){
            if(opponentMoveHistoryPlayer2.isEmpty()){
                opponentMoveHistoryPlayer1.add(1);
                move = 1;
            }
            else if(!opponentMoveHistoryPlayer2.isEmpty()){
                s1 = opponentMoveHistoryPlayer1.get(opponentMoveHistoryPlayer1.size() - 1);
                s2 = opponentMoveHistoryPlayer2.get(opponentMoveHistoryPlayer2.size() - 1); 
                if(s1 == 1 && s2 == 5){
                    move = 1;
                }
                else{
                    move = 2;
                }
            }
        }
          if(!player){
            if(opponentMoveHistoryPlayer1.isEmpty()){
                opponentMoveHistoryPlayer2.add(5);
                move = 5;
            }
            else if(!opponentMoveHistoryPlayer1.isEmpty()){
                s1 = opponentMoveHistoryPlayer1.get(opponentMoveHistoryPlayer1.size() - 1);
                s2 = opponentMoveHistoryPlayer2.get(opponentMoveHistoryPlayer2.size() - 1); 
                if(s1 == 1 && s2 == 5){
                    move = 5;
                }
                else{
                    move = 6;
                }
            }
          
        }
          return move;
    }
        


    @Override
    public String getStrategyName() {
        return "TitForTat";
    }
}

