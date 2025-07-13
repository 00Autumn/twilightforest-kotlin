package autumn.twilightforest.init.entity.custom.tiny_bird

enum class TinyBirdVariant(val id: Int) {
    BLUE(0),
    RED(1),
    GOLD(2),
    BROWN(3);

    companion object {
        private val BY_ID = TinyBirdVariant.entries.sortedBy { it.id }.toTypedArray()

        fun byId(id: Int): TinyBirdVariant {
            return BY_ID[id % BY_ID.size]
        }
    }
}