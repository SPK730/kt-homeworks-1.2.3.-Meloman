import java.time.LocalDate
import java.time.LocalDate.*
import java.time.Period
import java.time.chrono.ChronoPeriod

public fun main() {
    val purchaseAmount: Double = 10040.0 //Введите сумму покупки покупателем
    var regularCustomerLastPurchaseDate: LocalDate? = parse("2023-03-03")//Введите дату последней покупки покупателем

    println("Сумма покупки " + (purchaseAmount) + " руб.")
    println("Сумма покупки со скидкой " + (purchaseWithDiscount(purchaseAmount)) + " руб.")
    println("Дата последней покупки $regularCustomerLastPurchaseDate")
    println("Дней с прошлой покупки " + (periodFromLastPurchase()))
    println("Сумма покупки со скидкой постоянного покупателя " + (regularCustomerDiscount(purchaseWithDiscount(purchaseAmount))) + " руб.")

}

fun purchaseWithDiscount(purchaseAmount: Double): Double {
    return when {
        purchaseAmount in (0.0..1000.0) -> purchaseAmount//Если сумма покупки от 0 до 1 000 рублей, то скидка не предоставляется.
        purchaseAmount in (1001.0..10000.0) -> purchaseAmount - 100.0//Если сумма покупки от 1 001 до 10 000 рублей, то скидка составит 100 рублей (как в лекции).
        purchaseAmount >= 10001.0 -> purchaseAmount * 0.95//Если сумма покупки от 10 001 рубля и выше, то скидка составит 5% от суммы.
        else -> 0.0
    }
}

fun periodFromLastPurchase(): Int {
    val currentDate = LocalDate.now()     // parse the date with a suitable formatter
    var regularCustomerLastPurchaseDate: LocalDate? = parse("2023-03-03")//Введите дату последней покупки покупателем
    val period = Period.between(regularCustomerLastPurchaseDate, currentDate)
    return period.days + period.months * 30
}

fun regularCustomerDiscount(purchaseWithDiscount: Double): Double {
    return when {
        periodFromLastPurchase() < 30.0 -> purchaseWithDiscount * 0.99 //При этом постоянные пользователи, то есть те, кто покупает ежемесячно, дополнительно получают 1% скидки сверху.
        else -> purchaseWithDiscount * 1.0 //скидки нет
    }
}

fun ChronoPeriod.compareTo(i: Int) {

}





