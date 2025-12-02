import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeOneOf
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({
    // Write your tests here
    "check that length is 5" {
        isValid("Hello") shouldBe true
        isValid("Fork") shouldBe false
        isValid("12345") shouldBe false
    }
    "check if file exists" {
        readWordList("word.txt") shouldBe mutableListOf("No")
    }

    "pick random word" {
        pickRandomWord(mutableListOf("Hello", "knife")) shouldBeOneOf mutableListOf("Hello", "knife")
    }

    "compare a guess" {
        evaluateGuess("night", "HELLO") shouldBe listOf(0, 0, 0, 0, 0)
        evaluateGuess("hello", "HELLO") shouldBe listOf(1, 1, 1, 1, 1)
        evaluateGuess("James", "juked") shouldBe listOf(1, 0, 0, 1, 0)
        evaluateGuess("clear", "check") shouldBe listOf(1, 0, 1, 0, 0)
        evaluateGuess("pizza", "zippy") shouldBe listOf(0, 1, 0, 0, 0)
    }
})
