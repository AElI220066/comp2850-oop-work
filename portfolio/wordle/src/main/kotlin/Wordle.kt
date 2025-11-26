import java.io.File
const val VALID = 5
const val WORDLOOP = 4
// isValid function checks that word length is 5 and string is not int
fun isValid(word: String): Boolean {
    if (word.length == VALID && word.toIntOrNull() == null) {
        return true
    } else {
        return false
    }
}

// reads file and puts to mutablelist
fun readWordList(filename: String): MutableList<String>{

   val file = File(filename)
    if (file.exists() == false) {
        return mutableListOf("No")
    } else {
        val lines = file.readLines()
        val words = lines.toMutableList()
        return words
    }
}
fun pickRandomWord(words: MutableList<String>): String {

    val word = words.random()
    words.remove(word)
    return word
}
//prints the num of attempt and takes the guess or asks to try again if word is not valid
fun obtainGuess(attempt: Int): String {
    val n = "Attempt $attempt:"
    println(n)
    var nu = readln()



    while (isValid(nu) == false) {
        println("Try again, $n")
        nu = readln()
    }

    return nu
}

// takes both guess and random word, and retuns list of integers
fun evaluateGuess(guess: String, target: String): List<Int> {

    val g = guess.lowercase()
    val t = target.lowercase()
    val list = mutableListOf<Int>()
    for (word in 0..WORDLOOP) {
        if (g[word] == t[word]) {
            list.add(1)
        } else {
            list.add(0)
        }
    }
    return list
}

// takes guess and list, and returns result ? or letter
fun displayGuess(guess: String, matches: List<Int>) {
    val g = guess
    val list = matches
    for (word in 0..WORDLOOP) {
        if (list[word] == 1) {
            print(guess[word])
            print(" ")
        } else {
            print("? ")
        }
    }
}
