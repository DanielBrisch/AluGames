package org.example.br.com.alura.AluGames.model

data class InfoGame(val info: InfoApiShark) {

    override fun toString(): String {
        return info.toString()
    }
}