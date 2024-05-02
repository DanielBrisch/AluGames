package br.com.alura.AluGames.model

data class Gamer(val name: String, val email: String) {
    var idInterno: String? = null
    var user: String? = null
    var birthDate: String? = null

    constructor(name: String, email: String, birthDate:String, user:String): this(name, email) {
        this.birthDate = birthDate
        this.user = user
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', idInterno=$idInterno, user=$user, birthDate=$birthDate)"
    }


}