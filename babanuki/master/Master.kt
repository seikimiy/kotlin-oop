package babanuki.master

import babanuki.player.Hand
import babanuki.player.Player

class Master {
    private val players_ = mutableListOf<Player>()

    fun prepareGame(cards: Hand) {
        println("Distributing Cards...")

        cards.shuffle()

        val numberOfCards = cards.getNumberOfCards()

        val numberOfPlayers = players_.size

        for (index in 0 until numberOfCards - 1) {
            val card = cards.pickCard()

            val player = this.players_.get(index % numberOfPlayers)
            player.receiveCard(card)
        }
    }

    fun startGame() {
        println("Starting game...")

        var count = 0
        while(players_.size > 1) {
            val playerIndex = count % players_.size
            val nextPlayerIndex = (count+1) % players_.size

            val player = players_.get(playerIndex)
            val nextPlayer = players_.get(nextPlayerIndex)

            println("\n" + player.toString() + "'s turn")
            player.play(nextPlayer)

            count++
        }

        println("End babanuki")
    }

    fun declareWin(winner: Player) {
        println(winner.toString() + " is done!")

        players_.removeAt(players_.indexOf(winner))

        if (players_.size == 1) {
            val loser = players_.get(0)
            println(loser.toString() + " is the loser.")
        }
    }

    fun registerPlayer(player: Player) = players_.add(player)
}