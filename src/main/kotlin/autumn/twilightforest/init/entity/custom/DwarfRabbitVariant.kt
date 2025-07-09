package autumn.twilightforest.init.entity.custom

enum class DwarfRabbitVariant(val id: Int) {
   MOCHA(0),
    DUTCH(1),
    CREAM(2);

    companion object {
        private val BY_ID = entries.sortedBy { it.id }.toTypedArray()

        fun byId(id: Int): DwarfRabbitVariant {
            return BY_ID[id % BY_ID.size]
        }
    }
}