import br.com.alura.AluGames.model.Gamer

fun main() {
    val gamer1 = Gamer("Daniel", "daniel@gmail.com")

    println(gamer1)

    val gamer2 = Gamer("Daniel", "daniel@gmail.com", "28/11/2003", "mrdarobw")

    println(gamer2)

    gamer1.let {
        it.birthDate = "18/09/2000"
        it.user = "JackSkyWalker"
        it.idInterno = "1"
    }

    println(gamer1)
}