package forloop

import java.util.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if(year != other.year) return year- other.year
        if(month != other.month) return month- other.month
        return dayOfMonth- other.dayOfMonth
    }
}

operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

fun MyDate.toMillis(): Long {
    val c = Calendar.getInstance()
    c.set(year,month,dayOfMonth)
    return c.timeInMillis
}
fun Long.toDate(): MyDate {
    val c = Calendar.getInstance()
    c.timeInMillis = this
    return MyDate(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH))
}