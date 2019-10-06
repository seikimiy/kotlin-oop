package janken.tactics

import janken.players.Player

class StoneOnlyTactics : Tactics {

    override fun readTactics(): Int {
        return Player.STONE
    }
}