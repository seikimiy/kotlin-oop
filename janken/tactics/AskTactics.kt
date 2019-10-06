package janken.tactics

import janken.players.Player
import java.io.BufferedReader
import java.io.InputStreamReader

class AskTactics : Tactics {

    override fun readTactics(): Int {
        val br = BufferedReader(InputStreamReader(System.`in`))

        println("Input the hand you want to show")
        println("0: ROCK")
        println("1: SCISSORS")
        println("2: PAPER")
        println("? ")

        var hand = 0

        while (true) {
            try {
                val inputStr = br.readLine()

                hand = Integer.parseInt(inputStr)

                if ( hand == Player.STONE
                        || hand == Player.PAPER
                        || hand == Player.SCISSORS) {
                    break
                } else {
                    println("Invalid input. Try again.")
                    println("? ")
                }
            }
            catch (e: Exception) {
                println("Invalid input. Try again.....")
                println("? ")
            }
        }

        return hand
    }
}