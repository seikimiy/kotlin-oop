package janken.judge

import janken.players.Player

class Judge {
    fun startJanken(player1: Player, player2: Player) {
        print("----Starting janken----\n")
        print("Battle of " +
                "${player1.getName()} TO " +
                "${player2.getName()}\n")


        for (i in 1..3) {
            print("Battle $i")

            val winner: Player? = judgeJunken(player1, player2)
            val winnerName = winner?.getName()
            if (winner != null) {
                print("\nWinner is $winnerName!\n")
                winner.notifyResult()
            }
            else print("\nDraw\n")
        }

        print("End of Janken\n")

        val finalWinner: Player? = judgeFinalWinner(player1, player2)

        print("Result of Janken is " +
                "${player1.getName()}: ${player1.getWinCount()} win TO " +
                "${player2.getName()}: ${player2.getWinCount()} win\n")

        if (finalWinner != null) print("${finalWinner.getName()} is the winner!\n")
        else print("DRAW\n")
    }

    private fun judgeJunken(player1: Player, player2: Player): Player? {
        val player1hand = player1.showHand()
        val player2hand = player2.showHand()
        var winner: Player? = null

        printHand(player1hand)
        print(" vs. ")
        printHand(player2hand)
        print("\n")

        if ( (player1hand == Player.STONE && player2hand == Player.SCISSORS)
                || (player1hand == Player.SCISSORS && player2hand == Player.PAPER)
                || (player1hand == Player.PAPER && player2hand == Player.STONE)) {
            winner = player1
        }
        else if (
        ( player1hand == Player.STONE && player2hand == Player.PAPER)
                     || (player1hand == Player.PAPER && player2hand == Player.SCISSORS)
                     || (player1hand == Player.SCISSORS && player2hand == Player.STONE)) {
            winner = player2
        }

        return winner
    }

    private fun printHand(hand: Int) {
        when(hand) {
            Player.STONE -> print("ROCK")
            Player.SCISSORS -> print("SCISSORS")
            Player.PAPER -> print("PAPER")
        }
    }

    private fun judgeFinalWinner(player1: Player, player2: Player): Player? {
        var winner: Player? = null

        if (player1.getWinCount() > player2.getWinCount()) {
            winner = player1
        }
        else if (player2.getWinCount() > player1.getWinCount()) {
            winner = player2
        }

        return winner

    }
}