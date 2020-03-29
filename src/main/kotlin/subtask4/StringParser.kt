package subtask4

class StringParser {
    private val mapOpenBracketToClosed = hashMapOf(
        "(" to ")",
        "[" to "]",
        "<" to ">"
    )

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val result = mutableListOf<String>()

        val string = StringBuilder(inputString)

        for (i in (string.length - 1) downTo 0) {
            val closedBracketMatch = mapOpenBracketToClosed[string[i].toString()];

            if (closedBracketMatch != null) {
                var lastBracketIndex = 0

                for (j in i until string.length) {
                    if (string[j].toString() == closedBracketMatch) {
                        lastBracketIndex = j
                        string[i] = '_'
                        string[lastBracketIndex] = '_'
                        break
                    }
                }

                result.add(inputString.slice(IntRange(i + 1, lastBracketIndex - 1)))
            }
        }

        return result.toTypedArray().reversedArray()
    }
}
