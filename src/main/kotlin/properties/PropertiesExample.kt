package properties

class PropertyExample() {
    var counter = 0
    var propertyWithCounter: Int? = null
        set(prop) {
            field = prop
            counter++
        }
}