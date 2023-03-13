import java.time.LocalDate
import java.time.Period
import java.time.chrono.ChronoPeriod

fun main() {
    val purchaseAmount: Double = 10040.0 //Введите сумму покупки покупателем
    var regularCustomerLastPurchaseDate: LocalDate? = LocalDate.parse("2023-03-01")//Введите дату последней покупки покупателем
    var period: Int

    println("Сумма покупки " + (purchaseAmount) + " руб.")
    println("Сумма покупки со скидкой " + (purchaseWithDiscount(purchaseAmount)) + " руб.")
//    println("Сумма покупки со скидкой постоянного покупателя " + (regularCustomerDiscount(regularCustomerLastPurchaseDate,
        //purchaseWithDiscount(purchaseAmount))) + " руб.")
    println("Текущая дата покупки $regularCustomerLastPurchaseDate")
    println("Дней с прошлой покупки " + (periodFromLastPurchase(regularCustomerLastPurchaseDate)))
}

fun purchaseWithDiscount(purchaseAmount: Double): Double {
    return when {
        purchaseAmount in (0.0..1000.0) -> purchaseAmount//Если сумма покупки от 0 до 1 000 рублей, то скидка не предоставляется.
        purchaseAmount in (1001.0..10000.0) -> purchaseAmount - 100.0//Если сумма покупки от 1 001 до 10 000 рублей, то скидка составит 100 рублей (как в лекции).
        purchaseAmount >= 10001.0 -> purchaseAmount * 0.95//Если сумма покупки от 10 001 рубля и выше, то скидка составит 5% от суммы.
        else -> 0.0
    }
}

fun periodFromLastPurchase(regularCustomerLastPurchaseDate: LocalDate?): Period? {
    val currentDate = LocalDate.now()     // parse the date with a suitable formatter
    var regularCustomerLastPurchaseDate: LocalDate? = LocalDate.parse("2023-01-01")//Введите дату последней покупки покупателем
    val period = Period.between(regularCustomerLastPurchaseDate, currentDate)
return period
}


fun regularCustomerDiscount(purchaseWithDiscount: Double): Double {

    return when {
        (periodFromLastPurchase()) > 30 -> purchaseWithDiscount * 0.99 //При этом постоянные пользователи, то есть те, кто покупает ежемесячно, дополнительно получают 1% скидки сверху.
        else -> purchaseWithDiscount * 1.0
    }
}

fun ChronoPeriod.compareTo(i: Int) {

}





