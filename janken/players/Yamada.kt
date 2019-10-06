package janken.players

class Yamada: Player {

    constructor(name: String) : super(name)

    override fun showHand(): Int {
        return PAPER
    }
}