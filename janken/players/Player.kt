package janken.players

import janken.tactics.Tactics

open class Player {

    constructor(name: String) {
        this.name_ = name
    }

    companion object {
        val STONE = 0
        val SCISSORS = 1
        val PAPER = 2
    }

    private var name_ : String? = null

    private var winCount_ : Int = 0

    private var tactics_ : Tactics? = null

    open fun showHand(): Int {
        return tactics_!!.readTactics()
    }

    fun notifyResult() {
        this.winCount_ ++
    }

    fun getWinCount(): Int {
        return this.winCount_
    }

    fun getName(): String {
        return this.name_ ?: "No name"
    }

    fun setTactics(tactics: Tactics) {
        this.tactics_ = tactics
    }

}