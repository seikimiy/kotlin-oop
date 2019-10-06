package babanuki.master

import babanuki.card.Card
import babanuki.player.Hand
import babanuki.player.Player

class OldMaid {

    fun main() {
        val master = Master()

        val field = Table()

        val murata = Player("murata", master, field)
        val yamada = Player("yamada", master, field)
        val saito  = Player("saito", master, field)

        master.registerPlayer(murata)
        master.registerPlayer(yamada)
        master.registerPlayer(saito)


        val trump = createTrump()

        master.prepareGame(trump)

        master.startGame()
    }

    private fun createTrump(): Hand {
        var trump = Hand()

        for (number in 1..13) {
            trump.addCard(Card(Card.SUIT_HEART, number))
            trump.addCard(Card(Card.SUIT_SPADE, number))
            trump.addCard(Card(Card.SUIT_CLUB, number))
            trump.addCard(Card(Card.SUIT_DIAMOND, number))
        }

        trump.addCard(Card(0, Card.JOKER))

        return trump
    }
}