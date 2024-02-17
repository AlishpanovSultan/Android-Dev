package com.example.dodosimplified.model

import com.example.dodosimplified.R

object MenuDataSource {
    val menuList = arrayListOf<Menu>(
        Pizza(
            title = "Баварская",
            description = "Острая чоризо из цыпленка, маринованные огурчики, красный лук, томаты, соус медово-горчичный, моцарелла, фирменный томатный соус",
            size = 30,
            imageRes = R.drawable.bavarian_pizza,
            price = 2700,

        ),
        Pizza(
            title = "Сырная",
            description = "Моцарелла, сыры чеддер и пармезан, соус альфредо",
            size = 30,
            imageRes = R.drawable.cheeze_pizza,
            price = 1900,

            ),
        Dodster(
            title = "Запечатанный Додстер",
            description = "Горячая закуска с цыпленком, ананасами, моцареллой и соусом терияки в тонкой пшеничной лепешке",
            weight = 170,
            imageRes = R.drawable.dodster_jump,
            price = 1600,
            ),
        Pizza(
            title = "Ветчина и сыр",
            description = "Ветчина из цыпленка, моцарелла, соус альфредо",
            size = 30,
            imageRes = R.drawable.ham_mushrooms_pizza,
            price = 2000,
            ),
        PizzaCombo(
            title = "Миксик",
            description = "Пицца четвертинками с ветчиной, цыпленком, томатами, брынзой, моцареллой, фирменным соусом альфредо и набор юного садовода в подарок",
            size = 25,
            imageRes = R.drawable.mixic_pizza,
            price = 2200,

        ),
        Pizza(
            title = "Наруто Пицца",
            description = "Куриные кусочки, моцарелла, ананасы, фирменный соус альфредо, соус терияки",
            size = 30,
            imageRes = R.drawable.naruto_picca,
            price = 3900,
            ),
        Pizza(
            title = "Пепперони с грибами",
            description = "Пикантная пепперони из цыпленка, моцарелла, шампиньоны, фирменный соус альфредо",
            size = 30,
            imageRes = R.drawable.pepperoni_s_gribami,
            price = 2000,
        ),
        PizzaCombo(
            title = "Комбо от Смешариков",
            description = "Одобрено героями мультфильма: маленькая пицца любого вкуса и набор юного садовода. Цена комбо зависит от выбранных пицц и может быть увеличена",
            size = 25,
            imageRes = R.drawable.smewariki_combo,
            price = 2300,

        )

    )
}