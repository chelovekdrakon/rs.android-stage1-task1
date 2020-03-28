package subtask2

class MiniMaxSum {

    // TODO: Complete the following function
    fun getResult(input: IntArray): IntArray {
        var maxValIndex = 0;
        var maxVal = input[0];

        var minValIndex = 0;
        var minVal = input[0];

        val inputSize = input.size;
        var iteration = 0;

        while (iteration < inputSize) {
            val value = input[iteration];

            if (value > maxVal) {
                maxValIndex = iteration;
                maxVal = value;
            }

            if (value < minVal) {
                minValIndex = iteration;
                minVal = value;
            }

            iteration++;
        }

        val minArray = input.toMutableList();
        minArray.removeAt(maxValIndex);
        val minSum = minArray.fold(0) { acc, value -> acc + value }

        val maxArray = input.toMutableList();
        maxArray.removeAt(minValIndex);
        val maxSum = maxArray.fold(0) { acc, value -> acc + value }


        return intArrayOf(minSum, maxSum);
    }
}
