import java.util.*

fun MyDate.followingDate(): MyDate {
    val c = Calendar.getInstance()
    c.set(year,month,dayOfMonth)
    val millisInDay = 24*60*60*1000L
    val timeInMillis= c.timeInMillis + millisInDay
    val result = Calendar.getInstance()
    result.timeInMillis = timeInMillis
    return MyDate(result.get(Calendar.YEAR), result.get(Calendar.MONTH), result.get(Calendar.DATE))
}