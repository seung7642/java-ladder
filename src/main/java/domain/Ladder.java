package domain;

import java.util.List;

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

    public Rewards play(Player player) {
        if (player.isName("all")) {
            return gameBoard.rewardAll();
        }
        return new Rewards(List.of(gameBoard.reward(players.position(player))));
    }

    public void display(LadderVisitor visitor) {
        players.display(visitor);
        gameBoard.display(visitor);
    }

    public void displayResult(LadderVisitor visitor) {

    }
}
