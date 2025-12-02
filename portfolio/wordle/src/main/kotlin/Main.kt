const val FINISH = 10
fun main() {
    val words = readWordList("data/words.txt")
    if (mutableListOf<String>("No") == words) {
        println("file does not exists")
    }
    else {
        val random = pickRandomWord(words).lowercase()
        val startAttempt = 1

        for (attempt in startAttempt..FINISH) {
            val guess = obtainGuess(attempt)
            val evalite = evaluateGuess(guess, random)
            displayGuess(guess, evalite)
            if (evalite == listOf(1, 1, 1, 1, 1)) {
                println("Correct")
                break
            }
            if (attempt == FINISH && evalite != listOf(1, 1, 1, 1, 1)) {
                print("You lost ")
                println(random.uppercase())
            }
        }
    }
}
