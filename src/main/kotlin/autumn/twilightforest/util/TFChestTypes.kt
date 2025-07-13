package autumn.twilightforest.util

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.minecraft.block.Block
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.enums.ChestType
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.client.render.entity.model.EntityModelLayers
import net.minecraft.client.util.SpriteIdentifier
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier

enum class TFChestTypes(
    val blockId: Identifier,
    private val folder: String, // folder for textures, e.g. "lockless" or ""
    private val singleTexture: String,
    private val leftTexture: String,
    private val rightTexture: String
) {
    TWILIGHT_OAK(
        Identifier.of("twilightforest", "twilight_oak_chest"),
        "",
        "twilight_oak",
        "twilight_oak_left",
        "twilight_oak_right",
    ),
    TRAPPED_TWILIGHT_OAK(
        Identifier.of("twilightforest", "trapped_twilight_oak_chest"),
        "",
        "trapped_twilight_oak",
        "trapped_twilight_oak_left",
        "trapped_twilight_oak_right",
    ),
    CANOPY(
        Identifier.of("twilightforest", "canopy_chest"),
        "lockless", // texture is in lockless subfolder
        "canopy",
        "canopy_left",
        "canopy_right",
    ),
    TRAPPED_CANOPY(
        Identifier.of("twilightforest", "trapped_canopy_chest"),
        "lockless",
        "trapped_canopy",
        "trapped_canopy_left",
        "trapped_canopy_right",
    ),
    TWILIGHT_MANGROVE(
        Identifier.of("twilightforest", "twilight_mangrove_chest"),
        "",
        "twilight_mangrove",
        "twilight_mangrove_left",
        "twilight_mangrove_right",
    ),
    TRAPPED_TWILIGHT_MANGROVE(
        Identifier.of("twilightforest", "trapped_twilight_mangrove_chest"),
        "",
        "trapped_twilight_mangrove",
        "trapped_twilight_mangrove_left",
        "trapped_twilight_mangrove_right",
    ),
    DARK(
        Identifier.of("twilightforest", "dark_chest"),
        "",
        "dark",
        "dark_left",
        "dark_right",
    ),
    TRAPPED_DARK(
        Identifier.of("twilightforest", "trapped_dark_chest"),
        "",
        "trapped_dark",
        "trapped_dark_left",
        "trapped_dark_right",
    ),
    TIME(
        Identifier.of("twilightforest", "time_chest"),
        "",
        "time",
        "time_left",
        "time_right",
    ),
    TRAPPED_TIME(
        Identifier.of("twilightforest", "trapped_time_chest"),
        "",
        "trapped_time",
        "trapped_time_left",
        "trapped_time_right",
    ),
    TRANSFORMATION(
        Identifier.of("twilightforest", "transformation_chest"),
        "",
        "transformation",
        "transformation_left",
        "transformation_right",
    ),
    TRAPPED_TRANSFORMATION(
        Identifier.of("twilightforest", "trapped_transformation_chest"),
        "",
        "trapped_transformation",
        "trapped_transformation_left",
        "trapped_transformation_right",
    ),
    MINING(
        Identifier.of("twilightforest", "mining_chest"),
        "",
        "mining",
        "mining_left",
        "mining_right",
    ),
    TRAPPED_MINING(
        Identifier.of("twilightforest", "trapped_mining_chest"),
        "",
        "trapped_mining",
        "trapped_mining_left",
        "trapped_mining_right",
    ),
    SORTING(
        Identifier.of("twilightforest", "sorting_chest"),
        "",
        "sorting",
        "sorting_left",
        "sorting_right",
    ),
    TRAPPED_SORTING(
        Identifier.of("twilightforest", "trapped_sorting_chest"),
        "",
        "trapped_sorting",
        "trapped_sorting_left",
        "trapped_sorting_right",
    );

    val single: SpriteIdentifier = map(singleTexture)
    val left: SpriteIdentifier = map(leftTexture)
    val right: SpriteIdentifier = map(rightTexture)

    private fun map(name: String): SpriteIdentifier {
        val texturePath = if (folder.isEmpty()) name else "$folder/$name"
        return SpriteIdentifier(
            Identifier.ofVanilla("textures/atlas/chest.png"),
            Identifier.of("twilightforest", "entity/chest/$texturePath")
        )
    }

    fun getSprite(type: ChestType): SpriteIdentifier = when (type) {
        ChestType.LEFT -> left
        ChestType.RIGHT -> right
        ChestType.SINGLE -> single
    }

    companion object {
        @JvmStatic
        fun from(entity: BlockEntity): TFChestTypes? {
            val block: Block = entity.cachedState.block
            val id = Registries.BLOCK.getId(block)
            return entries.firstOrNull { it.blockId == id }
        }
    }
}
