
public class TennisGame2 implements TennisGame
{
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
		if (player1points2 == player2points2 && player1points2 < 4)
        {
            if (player1points2==0)
                score = "Love";
            if (player1points2==1)
                score = "Fifteen";
            if (player1points2==2)
                score = "Thirty";
            score += "-All";
        }
        if (player1points2==player2points2 && player1points2>=3)
            score = "Deuce";
        
        if (player1points2 > 0 && player2points2==0)
        {
            if (player1points2==1)
                literalPlayer1Score = "Fifteen";
            if (player1points2==2)
                literalPlayer1Score = "Thirty";
            if (player1points2==3)
                literalPlayer1Score = "Forty";
            
            literalPlayer2Score = "Love";
            score = literalPlayer1Score + "-" + literalPlayer2Score;
        }
        if (player2points2 > 0 && player1points2==0)
        {
            if (player2points2==1)
                literalPlayer2Score = "Fifteen";
            if (player2points2==2)
                literalPlayer2Score = "Thirty";
            if (player2points2==3)
                literalPlayer2Score = "Forty";
            
            literalPlayer1Score = "Love";
            score = literalPlayer1Score + "-" + literalPlayer2Score;
        }
        
        if (player1points2>player2points2 && player1points2 < 4)
        {
            if (player1points2==2)
                literalPlayer1Score="Thirty";
            if (player1points2==3)
                literalPlayer1Score="Forty";
            if (player2points2==1)
                literalPlayer2Score="Fifteen";
            if (player2points2==2)
                literalPlayer2Score="Thirty";
            score = literalPlayer1Score + "-" + literalPlayer2Score;
        }
        if (player2points2>player1points2 && player2points2 < 4)
        {
            if (player2points2==2)
                literalPlayer2Score="Thirty";
            if (player2points2==3)
                literalPlayer2Score="Forty";
            if (player1points2==1)
                literalPlayer1Score="Fifteen";
            if (player1points2==2)
                literalPlayer1Score="Thirty";
            score = literalPlayer1Score + "-" + literalPlayer2Score;
        }
        
        if (player1points2 > player2points2 && player2points2 >= 3)
        {
            score = "Advantage player1";
        }
        
        if (player2points2 > player1points2 && player1points2 >= 3)
        {
            score = "Advantage player2";
        }
        
        if (player1points2>=4 && player2points2>=0 && (player1points2-player2points2)>=2)
        {
            score = "Win for player1";
        }
        if (player2points2>=4 && player1points2>=0 && (player2points2-player1points2)>=2)
        {
            score = "Win for player2";
        }
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