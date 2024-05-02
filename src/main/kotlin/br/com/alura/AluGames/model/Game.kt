package org.example.br.com.alura.AluGames.model

data class Game(val title: String, val thumb: String) {

    var description: String? = null

    override fun toString(): String {
        return "title: '$title'\nthumb:'$thumb'\ndescription: '$description'"
    }


}