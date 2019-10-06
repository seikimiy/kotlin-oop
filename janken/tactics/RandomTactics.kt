package janken.tactics

import janken.players.Player

class RandomTactics : Tactics {

    override fun readTactics(): Int {

        var randomNum = Math.random() * 3

        return when {
            randomNum < 1 -> Player.STONE
            randomNum < 2 -> Player.PAPER
            else -> Player.SCISSORS
        }
    }
}