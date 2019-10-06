package babanuki.player

import babanuki.card.Card

class Hand {

    constructor() {
        this.hand_ = mutableListOf()
    }

    private var hand_: MutableList<Card>

    fun addCard(card: Card) {
        this.hand_.add(card)
    }

    fun pickCard(): Card {
        val pickedCard = hand_.removeAt(0)

        return pickedCard
    }

    fun shuffle() {
        val number = this.hand_.size


        for (i in 1..(number * 2)) {
            var pos = (Math.random() * number.toDouble()).toInt()
            val pickedCard = hand_.removeAt(pos)

            this.hand_.add(pickedCard)
        }
    }

    fun getNumberOfCards(): Int = this.hand_.size

    fun findSameNumberCard(): MutableList<Card>? {
        val numberOfCards = this.hand_.size
        var sameCards: MutableList<Card> = mutableListOf()

        if (numberOfCards > 0) {
            val lastIndex = numberOfCards - 1
            val lastAddedCard = this.hand_.get(lastIndex)

            val lastAddedCardNum = lastAddedCard.getNumber()

            for (index in 0 until lastIndex-1) {
                var card = this.hand_.get(index)
                if(card.getNumber() == lastAddedCardNum) {
                    sameCards.add(this.hand_.removeAt(lastIndex))
                    sameCards.add(this.hand_.removeAt(index))

                    break
                }
            }
        }

        return sameCards
    }

    override fun toString(): String {
        var string = StringBuffer()

        val size = this.hand_.size
        if (size > 0) {
            for (index in 0 until size-1) {
                var card = this.hand_.get(index)
                string.append(card)
                string.append(" ")
            }
        }

        return string.toString()
    }
}