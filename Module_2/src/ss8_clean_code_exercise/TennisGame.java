package ss8_clean_code_exercise;

public class TennisGame {

    public static final int BOTH_ARE_ZERO = 0;
    public static final int BOTH_ARE_FIFTEEN = 1;
    public static final int BOTH_ARE_THIRTY = 2;
    public static final int BOTH_ARE_FORTY = 3;
    public static final int SCORE_IS_ZERO = 0;
    public static final int SCORE_IS_FIFTEEN = 1;
    public static final int SCORE_IS_THIRTY = 2;
    public static final int SCORE_IS_FORTY = 3;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String score = "";
        if (player1Score == player2Score) {
            score = getScoreWhenDrawing(player1Score);
        } else if (player1Score >= 4 || player2Score >= 4) {
            score = getScoreSpecialCase(player1Score, player2Score);
        } else {
            score = getScoreWhen1PlayerTakeLead(player1Score, player2Score, score);
        }
        return score;
    }

    private static String getScoreWhen1PlayerTakeLead(int player1Score, int player2Score, String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                score += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case SCORE_IS_ZERO:
                    score += "Love";
                    break;
                case SCORE_IS_FIFTEEN:
                    score += "Fifteen";
                    break;
                case SCORE_IS_THIRTY:
                    score += "Thirty";
                    break;
                case SCORE_IS_FORTY:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }

    private static String getScoreSpecialCase(int player1Score, int player2Score) {
        String score;
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private static String getScoreWhenDrawing(int player1Score) {
        String score;
        switch (player1Score) {
            case BOTH_ARE_ZERO:
                score = "Love-All";
                break;
            case BOTH_ARE_FIFTEEN:
                score = "Fifteen-All";
                break;
            case BOTH_ARE_THIRTY:
                score = "Thirty-All";
                break;
            case BOTH_ARE_FORTY:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }
}
