package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        val sadArraySize = sadArray.size

        if (sadArraySize < 3) {
            return sadArray
        }

        val resultArray = sadArray.toMutableList();

        var index = 1;
        var interation = 1;
        var iterationsAmount = sadArraySize - 1;
//        intArrayOf(56, 32, 5, 11, 43, 62)
        while (interation < iterationsAmount) {
            val value = resultArray[index];
            val neighboursSum =  resultArray[index - 1] + resultArray[index + 1];

            if (value > neighboursSum) {
                resultArray.removeAt(index);

                if (index > 1) {
                    iterationsAmount++;
                    index--;
                }
            } else {
                index++;
            }

            interation++;
        }

        return resultArray.toIntArray()
    }
}
