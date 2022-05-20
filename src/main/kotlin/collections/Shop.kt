package collections

fun Shop.getCustomersSortedByOrders(): List<Customer> =
    customers.sortedByDescending { it.orders.count() }

// Find all the different cities the customers are from
fun Shop.getCustomerCities(): Set<City> = customers.map { it.city }.toSet()

// Find the customers living in a given city
fun Shop.getCustomersFrom(city: City): List<Customer> = customers.filter { it.city.name ==  city.name}

// Return true if all customers are from a given city
fun Shop.checkAllCustomersAreFrom(city: City): Boolean = customers.all {
    it.city ==city
}

// Build a map from the customer name to the customer
fun Shop.nameToCustomerMap(): Map<String, Customer> = customers.associateBy { it.name }


// Build a map from the customer to their city
fun Shop.customerToCityMap(): Map<Customer, City> = customers.associateWith { it.city }


// Build a map from the customer name to their city
fun Shop.customerNameToCityMap(): Map<String, City> = customers.associate { it.name to it.city }

// Return true if there is at least one customer from a given city
fun Shop.hasCustomerFrom(city: City): Boolean = customers.any {
    it.city == city
}

// Build a map that stores the customers living in a given city
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> = customers.groupBy { it.city }

// Return the number of customers from a given city
fun Shop.countCustomersFrom(city: City): Int = customers.count {
    it.city == city
}

// Return a customer who lives in a given city, or null if there is none
fun Shop.findCustomerFrom(city: City): Customer? = customers.find {
    it.city == city
}
// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> = customers.filter {
    val (delivered, undelivered) = it.orders.partition { it.isDelivered }
    undelivered.size > delivered.size
}.toSet()

// Return all products the given customer has ordered
fun Customer.getOrderedProducts(): List<Product> = orders.flatMap { it.products }


// Return all products that were ordered by at least one customer
fun Shop.getOrderedProducts(): Set<Product> = customers.flatMap { it.orders }.flatMap { it.products }.toSet()

data class Shop(val name: String, val customers: List<Customer>)

data class Customer(val name: String, val city: City, val orders: List<Order>) {
    override fun toString(): String {
        return "$name from ${city.name}"
    }
}

data class Order(val products: List<Product>, val isDelivered: Boolean)

data class Product(val name:String, val price:Double){
    override fun toString(): String = "$name for $price"
}
data class City(val name:String)

