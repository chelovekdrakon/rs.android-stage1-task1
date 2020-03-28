package subtask3

class BillCounter {

    // TODO: Complete the following function
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, allergicIndex: Int, annaPaid: Int): String {
        val excludedAllergicBill = bill.toMutableList();
        excludedAllergicBill.removeAt(allergicIndex);

        val sumToSplit = excludedAllergicBill.reduce { acc, price -> acc + price };

        val annaShouldPay = sumToSplit / 2;

        return if (annaPaid === annaShouldPay) {
            "Bon Appetit"
        } else {
            val annaOverpaid = annaPaid - annaShouldPay;
            "$annaOverpaid"
        }
    }
}
