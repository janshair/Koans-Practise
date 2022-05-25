package builders.product


/**
 * Could not copy other classes
 */
data class Product(val description: String, val price: Int, val popularity: Int)

fun renderProductTable(): String {
    return html {
        table {
            tr(getTitleColor()) {
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            val products = getProducts()
            for(index in products.indices) {
                tr(getCellColor(index, index)){
                    td {
                        text(products[index].description)
                    }
                    td {
                        text(products[index].price)
                    }
                    td {
                        text(products[index].popularity)
                    }
                }
            }
        }
    }.toString()
}

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, column: Int) = if ((index + column) % 2 == 0) "#dce4ff" else "#eff2ff"