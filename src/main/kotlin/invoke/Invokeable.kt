package invoke
class Invokable {
    var numberOfInvocations: Int = 0
        private set

    operator fun invoke(): Invokable {
        val count = numberOfInvocations+1
        return Invokable().apply {
            numberOfInvocations = count
        }
    }
}

fun invokeTwice(invokable: Invokable) = invokable()()