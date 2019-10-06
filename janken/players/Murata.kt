package janken.players

class Murata: Player {

    constructor(name: String) : super(name)


    override fun showHand(): Int {
        return STONE
    }
}