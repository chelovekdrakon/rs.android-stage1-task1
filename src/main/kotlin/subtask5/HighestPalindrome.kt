package subtask5

import java.lang.StringBuilder

data class ChangedNumber(val index: Int, val minValue: Char)

class HighestPalindrome {

    // TODO: Complete the following function
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        if (digitString.length % 2 != 0) {
            return "-1"
        }

        val result = StringBuilder(digitString)

        var appliedChanges = 0
        val changedNumbers = mutableListOf<ChangedNumber>()

        for (i in 0 until (n / 2)) {
            val j = (n - 1) - i;
            val leadNumber = digitString[i]
            val mirroredNumber = digitString[j]

            if (leadNumber != mirroredNumber) {
                if (leadNumber > mirroredNumber) {
                    changedNumbers.add(ChangedNumber(j, mirroredNumber))
                    result[j] = leadNumber
                } else {
                    changedNumbers.add(ChangedNumber(i, leadNumber))
                    result[i] = mirroredNumber
                }

                appliedChanges++

                if (appliedChanges == k) {
                    break
                }
            }
        }

        if (appliedChanges < k) {
            val diff = k - appliedChanges
            changedNumbers.sortBy { it.minValue }

            for (i in 0 until diff) {
                val changed = changedNumbers[i]
                val j = (n - 1) - changed.index

                result[changed.index] = '9'
                result[j] = '9'
            }
        }

        return result.toString()
    }


}
