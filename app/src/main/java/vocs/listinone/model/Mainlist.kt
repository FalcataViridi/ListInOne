package vocs.listinone.model
import java.util.*


data class MainListItemData(val id: String = time("A")) {
    var name: String? = ""
    val listType: String? = ""
    var description: String? = ""
    val status: String? = ""
}

data class ShoppingListItemData(val id: String = time("S")) {
    var name: String = ""
    var cantidad: String = ""
    val status: String = ""
}

fun time(type: String): String {
    return type + Date()
}

