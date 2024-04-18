package com.dyablonskyi.mycityapp.presentation

interface CityDestination {
    val route: String
}

object Categories: CityDestination{
    override val route: String
        get() = "categories"
}

object Coffee : CityDestination{
    override val route: String
        get() = "coffee"
}

object Restaurant: CityDestination{
    override val route: String
        get() = "restaurant"
}

object Park: CityDestination{
    override val route: String
        get() = "park"
}

object ShoppingCenter: CityDestination{
    override val route: String
        get() = "shopping_center"
}