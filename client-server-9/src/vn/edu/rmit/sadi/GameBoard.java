package vn.edu.rmit.sadi;

public class GameBoard {

    public Player[][] board = new Player[3][];

    public GameBoard() {
        for(int i=0; i<3; i++) {
            board[i] = new Player[3];
            for(int j=0; j<3; j++) {
                board[i][j] = Player.None;
            }
        }
    }

    public Status move(Player player, Move move) {
        board[move.x][move.y] = player;
        return getStatusFor(player);
    }

    private Status getStatusFor(Player player) {
        return isWon(player)
                ? Status.Win
                : isFull()
                ? Status.Tie
                : Status.Continue;
    }

    private boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Player.None) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWon(Player player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player) && (board[i][1] == player) && (board[i][2] == player)) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if ((board[0][j] == player) && (board[1][j] == player) && (board[2][j] == player)) {
                return true;
            }
        }

        if ((board[0][0] == player) && (board[1][1] == player) && (board[2][2] == player)) {
            return true;
        }

        if ((board[0][2] == player) && (board[1][1] == player) && (board[2][0] == player)) {
            return true;
        }

        return false;
    }


}
