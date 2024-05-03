package br.com.alura.AluGames.model

import org.example.br.com.alura.AluGames.model.Game
import java.util.*
import kotlin.random.Random

data class Gamer(val name: String, var email: String) {
    var idInterno: String? = null
    var user: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                createId()
            }
        }
    var birthDate: String? = null
    val searchdedGames = mutableListOf<Game?>()

    constructor(name: String, email: String, birthDate: String, user: String) : this(name, email) {
        this.birthDate = birthDate
        this.user = user
        createId()
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', idInterno=$idInterno, user=$user, birthDate=$birthDate)"
    }

    fun createId() {
        val num = Random.nextInt(10000)
        val tag = String.format("%04d", num)
        idInterno = "$user#$tag"
    }

    fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Invalid email")
        }
    }

    init {
        if (name.isNullOrBlank()) {
            throw IllegalArgumentException("Name is empty")
        }
        this.email = validarEmail()
    }

    companion object {
        fun createGamer(scan: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val name = scan.nextLine()
            println("Digite seu e-mail:")
            val email = scan.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val option = scan.nextLine()

            if (option.lowercase(Locale.getDefault()).equals("s",true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = scan.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = scan.nextLine()

                return Gamer(name, email, nascimento, usuario)
            } else {
                return Gamer(name, email)
            }
        }
    }

}