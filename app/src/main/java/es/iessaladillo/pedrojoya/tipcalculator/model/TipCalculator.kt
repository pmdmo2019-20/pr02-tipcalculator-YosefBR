package es.iessaladillo.pedrojoya.tipcalculator.model


// TipCalculator class. Its constructor receives bill, percentage and diners

class TipCalculator(val bill:Float, val tip:Float, val diners:Float) {

    fun validateData() {
        if (bill<0) {
            throw IllegalArgumentException("Bill can'ts be negative")
        }
        if (tip<0) {
            throw IllegalArgumentException("Tip can`ts be negative")
        }
        if (diners<=0) {
            throw IllegalArgumentException("Diners can`ts be negative")
        }
    }

    fun calculateTip(): Float {
        return bill*(tip/100)
    }

    fun calculateTotal(): Float {
        return bill + (bill*(tip/100))
    }

    fun calculatePerDiner(): Float {
        return calculateTotal()/diners
    }

    fun calculatePerDinerRounded(): Float {
        return calculatePerDiner()*diners
    }

}