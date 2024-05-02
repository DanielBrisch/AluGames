package br.com.alura.AluGames.services

import com.google.gson.Gson
import org.example.br.com.alura.AluGames.model.InfoGame
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsumptionApi() {

    fun seachGame(idGame: String): InfoGame {
        val gson = Gson()
        val address = "https://www.cheapshark.com/api/1.0/games?id=$idGame"
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(address)).build()

        val respose = client.send(request, BodyHandlers.ofString())

        val myInfoGame = gson.fromJson(respose.body() , InfoGame::class.java)
        return myInfoGame
    }

}