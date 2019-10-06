package janken

import janken.judge.Judge
import janken.players.Player
import janken.tactics.AskTactics
import janken.tactics.StoneOnlyTactics

fun main() {
    val player1 = Player("MURATA")
    val murataTactics = StoneOnlyTactics()
    player1.setTactics(murataTactics)

    val player2 = Player("SECOND PLAYER")
    val yamadaTactics = AskTactics()
    player2.setTactics(yamadaTactics)

    val judge = Judge()
    judge.startJanken(player1, player2)
}
