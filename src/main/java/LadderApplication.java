import domain.*;
import view.InputView;
import view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        Players players = InputView.promptForPlayers();
        Rewards rewards = InputView.promptForRewards();
        Height height = InputView.promptForHeight();
        Ladder ladder = Ladder.of(players, rewards, height);

        ResultView resultView = new ResultView();
        ladder.display(resultView);

        Player player = InputView.promptForResult();
        Rewards resultRewards = ladder.play(player);

        resultView.result(resultRewards.findByIndex(players.position(player)));
    }
}
