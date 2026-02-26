package be.howest.annaudenaert.sweetdroiddelights.data.fake

import be.howest.annaudenaert.sweetdroiddelights.R
import be.howest.annaudenaert.sweetdroiddelights.domain.model.Dessert

class FakeDataSource() {
    fun loadDesserts(): List<Dessert> {
        return listOf(
            Dessert(
                0,
                R.drawable.cupcake,
                "Cupcake",
                "A tiny, fluffy cake baked in a cup, topped with sweet frosting and sprinkles. A bite-sized delight!",
                500,
                5.0
            ),
            Dessert(
                1,
                R.drawable.donut,
                "Donut",
                "A soft, ring-shaped pastry, deep-fried to perfection and often glazed or sprinkled. A classic treat!",
                250,
                10.0
            ),
            Dessert(
                2,
                R.drawable.eclair,
                "Eclair",
                "A light, elongated pastry filled with creamy custard and topped with rich chocolate. Fancy and delicious!",
                250,
                15.0
            ),
            Dessert(
                3,
                R.drawable.froyo,
                "Froyo",
                "A cool, tangy frozen yogurt treat, healthier than ice cream but just as fun with endless toppings!",
                50,
                20.50
            ),
            Dessert(
                4,
                R.drawable.gingerbread,
                "Gingerbread",
                "A spiced cookie or cake with warm flavors of ginger, cinnamon, and molasses—perfect for cozy days!",
                50,
                24.50
            ),
            Dessert(
                5,
                R.drawable.honeycomb,
                "Honeycomb",
                "A crunchy, airy candy made from caramelized sugar and honey. Sweet, golden, and full of tiny bubbles!",
                50,
                24.50
            ),
            Dessert(
                6,
                R.drawable.icecreamsandwich,
                "Ice cream sandwich",
                "Creamy ice cream hugged between two soft cookies or wafers. The perfect cold and chewy combo!",
                50,
                24.50
            ),
            Dessert(
                7,
                R.drawable.jellybean,
                "Jelly bean",
                "A tiny, chewy candy with a sugary shell and a burst of fruity flavor inside. Small but packed with sweetness!",
                5000,
                1.50
            ),
            Dessert(
                8,
                R.drawable.kitkat,
                "Kitkat",
                "A crispy wafer coated in chocolate, perfect for breaking apart and sharing... or keeping all to yourself!",
                500,
                4.50
            ),
            Dessert(
                9,
                R.drawable.lollipop,
                "Lollipop",
                "A colorful, hard candy on a stick that lasts for ages—lick by lick, a sweet adventure!",
                100,
                5.50
            ),
            Dessert(
                10,
                R.drawable.marshmallow,
                "Marshmallow",
                "A soft, fluffy treat that melts in your mouth—or in hot chocolate! Light as a cloud and oh-so-sweet.",
                500,
                5.0
            ),
            Dessert(
                11,
                R.drawable.nougat,
                "Nougat",
                "A chewy blend of nuts, honey, and sugar, often wrapped in chocolate. A rich and nutty delight!",
                250,
                10.0
            ),
            Dessert(
                12,
                R.drawable.oreo,
                "Oreo",
                "Two crunchy chocolate cookies with a creamy filling inside. Dunk it, twist it, or eat it whole—your choice!",
                250,
                15.0
            )
        )
    }

    fun getDessertById(dessertId: Int): Dessert? {
        return loadDesserts().find { it.id == dessertId }
    }
}