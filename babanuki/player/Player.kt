package babanuki.player

import babanuki.master.Master
import babanuki.master.Table
import babanuki.card.Card

class Player {
    private val master_: Master

    private val table_: Table

    private val myHand_: Hand = Hand()

    private val name_: String

    constructor(name: String,
                master: Master,
                table: Table) {
        this.name_ = name
        this.master_ = master
        this.table_ = table
    }

    fun play(nextPlayer: Player) {
        val nextHand = nextPlayer.showHand()

        val pickedCard = nextHand.pickCard()

        println(this.toString() + ":" + "Picked" +
                pickedCard.toString() +
                " from " + nextPlayer.toString())

        dealCard(pickedCard)

        if (myHand_.getNumberOfCards() == 0) {
            master_.declareWin(this)
        }

        else {
            println(this.toString() + ": Remaining " +
            myHand_.toString() + " cards")
        }
    }

    fun showHand(): Hand {
        if (myHand_.getNumberOfCards() == 1) {
            master_.declareWin(this)
        }

        myHand_.shuffle()

        return myHand_
    }

    fun receiveCard(card: Card) = dealCard(card)

    fun dealCard(card: Card) {
        myHand_.addCard(card)

        val sameCards = myHand_.findSameNumberCard()

        if (sameCards != null) {
            print(this .toString()+ ":")
            table_.disposeCard(sameCards)
        }
    }

    override fun toString(): String = name_
}