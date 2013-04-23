package vn.edu.rmit.sadi;

public class GameHandler implements Runnable {
    private Communicator client1;
    private Communicator client2;
    private GameBoard gameboard = new GameBoard();
    private Player currentTurn = Player.Player1;

    public void add(Communicator client) {
        if (client1 == null) {
            client1 = client;
        } else {
            client2 = client;
        }
    }

    public void run() {
        client1.write(Status.Continue);
        while (true) {
            Communicator current = currentTurn == Player.Player1 ? client1 : client2;
            Communicator other = current == client1 ? client2 : client1;
            Move move = (Move)current.read();
            Status status = gameboard.move(currentTurn, move);
            other.write(move);
            switch (status) {
                case Continue:
                    other.write(Status.Continue);
                    currentTurn = currentTurn == Player.Player1 ? Player.Player2 : Player.Player1;
                    break;
                case Win:
                    current.write(Status.Win);
                    other.write(Status.Lose);
                    current.close();
                    other.close();
                    return;
                case Tie:
                    current.write(Status.Tie);
                    other.write(Status.Tie);
                    current.close();
                    other.close();
                    return;
                default:
                    throw new RuntimeException("Illegal state");
            }
        }
    }

}
