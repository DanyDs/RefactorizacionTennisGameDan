
public class TennisGame2 implements TennisGame
{
    private static final int _love = 0;
	private static final int _matchPoint = 4;
	private static final int _Forty = 3;
	private static final int _Fifteen = 1;
	private static final int _Thirty = 2;
	public int player1points = 0;
    public int player2points = 0;
    
    public String literalPlayer1Score = "";
    public String literalPlayer2Score = "";    

    public TennisGame2(String player1Name, String player2Name) {        
    }

    public String getScore(){
        String score = "";
        int player1points2 = player1points;
		int player2points2 = player2points;
		score = playersAreTiedAndIsNotDeuce(score, player1points2, player2points2);
        score = isDeuce(score, player1points2, player2points2);        
        score = player1IsOn_Fifteen_Thrity_Forty(score, player1points2, player2points2);
        score = player2IsOn_Fifteen_Thirty_Forty(score, player1points2, player2points2);        
        score = playerIsWinningAndIsNotMatchPoint(score, player1points2, player2points2);        
        score = playerInAdvantage(score, player1points2, player2points2);        
        score = winForPlayer1OrPlayer2(score, player1points2, player2points2);
        return score;
    }

	private String playerIsWinningAndIsNotMatchPoint(String score, int player1points2, int player2points2) {
		if (playerWinningOver(player1points2, player2points2) && isNotMatchPoint(player1points2))
        {
            isOnThirty(player1points2);
            isOnForty(player1points2);
            isFifteen(player2points2);
            if (player2points2==_Thirty)
                literalPlayer2Score="Thirty";
            score = literalPlayer1Score + "-" + literalPlayer2Score;
        }
        if (playerWinningOver(player2points2, player1points2) && isNotMatchPoint(player2points2))
        {
            if (player2points2==_Thirty)
                literalPlayer2Score="Thirty";
            if (player2points2==_Forty)
                literalPlayer2Score="Forty";
            if (player1points2==_Fifteen)
                literalPlayer1Score="Fifteen";
            isOnThirty(player1points2);
            score = literalPlayer1Score + "-" + literalPlayer2Score;
        }
		return score;
	}

	private void isFifteen(int player2points2) {
		if (player2points2==_Fifteen)
		    literalPlayer2Score="Fifteen";
	}

	private void isOnForty(int player1points2) {
		if (player1points2==_Forty)
		    literalPlayer1Score="Forty";
	}

	private void isOnThirty(int player1points2) {
		if (player1points2==_Thirty)
		    literalPlayer1Score="Thirty";
	}

	private boolean playerWinningOver(int player1points2, int player2points2) {
		return player1points2>player2points2;
	}

	private boolean isNotMatchPoint(int player1points2) {
		return player1points2 < _matchPoint;
	}

	private String playersAreTiedAndIsNotDeuce(String score, int player1points2, int player2points2) {
		if (playersTied(player1points2, player2points2) && isNotMatchPoint(player1points2))
        {
            if (playerInLove(player1points2))
                score = "Love";
            if (player1points2==_Fifteen)
                score = "Fifteen";
            if (player1points2==_Thirty)
                score = "Thirty";
            score += "-All";
        }
		return score;
	}

	private boolean playersTied(int player1points2, int player2points2) {
		return player1points2 == player2points2;
	}

	private String player1IsOn_Fifteen_Thrity_Forty(String score, int player1points2, int player2points2) {
		if (playerMoreThanLove(player1points2) && playerInLove(player2points2))
        {
            if (player1points2==_Fifteen)
                literalPlayer1Score = "Fifteen";
            isOnThirty(player1points2);
            isOnForty(player1points2);
            
            literalPlayer2Score = "Love";
            score = literalPlayer1Score + "-" + literalPlayer2Score;
        }
		return score;
	}

	private boolean playerMoreThanLove(int player1points2) {
		return player1points2 > _love;
	}

	private boolean playerInLove(int player2points2) {
		return player2points2==_love;
	}

	private String player2IsOn_Fifteen_Thirty_Forty(String score, int player1points2, int player2points2) {
		if (playerMoreThanLove(player2points2) && playerInLove(player1points2))
        {
            isFifteen(player2points2);
            if (player2points2==_Thirty)
                literalPlayer2Score = "Thirty";
            if (player2points2==_Forty)
                literalPlayer2Score = "Forty";            
            literalPlayer1Score = "Love";
            score = literalPlayer1Score + "-" + literalPlayer2Score;
        }
		return score;
	}

	private String playerInAdvantage(String score, int player1points2, int player2points2) {
		if (playerWinningOver(player1points2, player2points2) && playerMoreOrEqualToForty(player2points2))        
            score = "Advantage player1";        
        
        if (playerWinningOver(player2points2, player1points2) && playerMoreOrEqualToForty(player1points2))
            score = "Advantage player2";        
		return score;
	}

	private boolean playerMoreOrEqualToForty(int player2points2) {
		return player2points2 >= _Forty;
	}

	private String winForPlayer1OrPlayer2(String score, int player1points2, int player2points2) {
		if (moreThanMatchPoint(player1points2) && moreOrEqualToLove(player2points2) && differenceIsMoreOrEqualToThirty(player1points2, player2points2))
        {
            score = "Win for player1";
        }
        if (moreThanMatchPoint(player2points2) && moreOrEqualToLove(player1points2) && differenceIsMoreOrEqualToThirty(player2points2, player1points2))
        {
            score = "Win for player2";
        }
		return score;
	}

	private boolean differenceIsMoreOrEqualToThirty(int player1points2, int player2points2) {
		return (player1points2-player2points2)>=_Thirty;
	}

	private boolean moreOrEqualToLove(int player2points2) {
		return player2points2>=_love;
	}

	private boolean moreThanMatchPoint(int player1points2) {
		return player1points2>=_matchPoint;
	}

	private String isDeuce(String score, int player1points2, int player2points2) {
		if (playersTied(player1points2, player2points2) && playerMoreOrEqualToForty(player1points2))
            score = "Deuce";
		return score;
	}
    
    public void setPlayer1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            player1Scores();
        }
            
    }
    
    public void setPlayer2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            player2Scores();
        }
            
    }
    
    public void player1Scores(){
        player1points++;
    }
    
    public void player2Scores(){
        player2points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            player1Scores();
        else
            player2Scores();
    }
}