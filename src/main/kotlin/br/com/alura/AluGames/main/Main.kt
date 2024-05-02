package org.example.br.com.alura.AluGames.main

import br.com.alura.AluGames.services.ConsumptionApi
import org.example.br.com.alura.AluGames.model.Game
import java.util.*

fun main() {

    val scan = Scanner(System.`in`)
    println("Write a code game for search")

    val idGame = scan.nextLine()

    var myGame: Game?

    val result = runCatching {
        val seachAPI = ConsumptionApi()
        val infoGame = seachAPI.seachGame(idGame)
        myGame = Game(infoGame.info.title, infoGame.info.thumb)
        myGame
    }

    result.onFailure {
        println("error 404: game not found")
    }

    result.onSuccess { game ->
        println("you want insert a description? S/N")
        val option = scan.nextLine()
        if (option.lowercase(Locale.getDefault()).equals("s", true)) {
            println("insert a description for a custom game")
            val description = scan.nextLine()
            game?.description = description
        } else {
            game?.description = game?.title
        }
        println(game)
    }
}

