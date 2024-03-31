package domain;

public class Ladder {

    private final Players players;
    private final GameBoard gameBoard;

    public Ladder(Lines lines, Players players, Rewards rewards) {
        this.gameBoard = new GameBoard(lines, rewards);
        this.players = players;
    }

    public static Ladder of(Players players, Rewards rewards, Height height) {
        Lines lines = Lines.of(players.totalNumber(), height, new RandomBridgeCreationStrategy());
        return new Ladder(lines, players, rewards);
    }

    public void display(LadderVisitor visitor) {
        players.display(visitor);
        gameBoard.display(visitor);
    }
}
