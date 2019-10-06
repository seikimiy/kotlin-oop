package babanuki.master

import babanuki.card.Card

class Table {
    private val disposedCards = mutableListOf<Card>()

    fun disposeCard(card: MutableList<Card>) {
        for (index in 0 until card.size) {
            print(card[index].toString() + " ")
            this.disposedCards.add(card[index])
        }

        println("were thrown away.")

    }
}