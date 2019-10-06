package babanuki.card

class Card {

    companion object {
        val JOKER = 0
        val SUIT_SPADE = 1
        val SUIT_DIAMOND = 2
        val SUIT_CLUB = 3
        val SUIT_HEART = 4
    }

    constructor(suit: Int, number: Int) {
        this.suit_ = suit
        this.number_ = number
    }

    private var suit_: Int
    private var number_: Int

    fun getNumber(): Int = number_

    override fun toString(): String {
        var string = StringBuffer()

        if (number_ > 0) {
            when (suit_) {
                SUIT_SPADE -> string.append("S")
                SUIT_CLUB -> string.append("C")
                SUIT_DIAMOND -> string.append("D")
                SUIT_HEART -> string.append("H")
            }

            when (number_) {
                1 -> string.append("A")
                10 -> string.append("T")
                11 -> string.append("J")
                12 -> string.append("Q")
                13 -> string.append("K")
                else -> string.append(number_)
            }
        }

        else {
            string.append("JK")
        }

        return string.toString()
    }
}
