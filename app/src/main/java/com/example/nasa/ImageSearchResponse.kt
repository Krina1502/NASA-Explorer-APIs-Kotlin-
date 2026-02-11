package com.example.nasa

data class ImageSearchResponse(
    val collection: Collection
) {
    data class Collection(
        val items: List<Item>
    )

    data class Item(
        val links: List<Link>,
        val data: List<Data>
    )

    data class Link(
        val href: String
    )

    data class Data(
        val title: String,
        val description: String
    )
}
