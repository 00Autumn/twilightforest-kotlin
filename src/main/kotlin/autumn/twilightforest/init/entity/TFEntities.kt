package autumn.twilightforest.init.entity

import autumn.twilightforest.TwilightForest
import autumn.twilightforest.init.entity.client.skeleton_druid.projectile.NatureBolt
import autumn.twilightforest.init.entity.custom.dwarf_rabbit.DwarfRabbitEntity
import autumn.twilightforest.init.entity.custom.squirrel.SquirrelEntity
import autumn.twilightforest.init.entity.custom.tiny_bird.TinyBirdEntity
import autumn.twilightforest.init.entity.custom.tiny_bird.TinyEggEntity
import autumn.twilightforest.init.entity.custom.wild_boar.WildBoarEntity
import autumn.twilightforest.init.entity.custom.wild_deer.WildDeerEntity
import autumn.twilightforest.init.entity.vanilla.bighorn_sheep.BighornSheepEntity
import autumn.twilightforest.init.entity.vanilla.carminite_broodling.CarminiteBroodlingEntity
import autumn.twilightforest.init.entity.vanilla.carminite_ghast_guard.CarminiteGhastGuardEntity
import autumn.twilightforest.init.entity.vanilla.carminite_ghastling.CarminiteGhastlingEntity
import autumn.twilightforest.init.entity.vanilla.hedge_spider.HedgeSpiderEntity
import autumn.twilightforest.init.entity.vanilla.king_spider.KingSpiderEntity
import autumn.twilightforest.init.entity.vanilla.knight_phantom.KnightPhantomEntity
import autumn.twilightforest.init.entity.vanilla.maze_slime.MazeSlimeEntity
import autumn.twilightforest.init.entity.vanilla.mist_wolf.MistWolfEntity
import autumn.twilightforest.init.entity.vanilla.skeleton_druid.SkeletonDruidEntity
import autumn.twilightforest.init.entity.vanilla.swarm_spider.SwarmSpiderEntity
import autumn.twilightforest.init.entity.vanilla.towerwood_borer.TowerwoodBorerEntity
import autumn.twilightforest.init.entity.vanilla.winter_wolf.WinterWolfEntity
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.util.math.Vec3d

object TFEntities {

    val DWARF_RABBIT_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "dwarf_rabbit"))
    val DWARF_RABBIT = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "dwarf_rabbit"),
        EntityType.Builder.create(::DwarfRabbitEntity, SpawnGroup.CREATURE)
            .dimensions(0.5F, 0.5F).build(DWARF_RABBIT_KEY))

    val TINY_BIRD_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "tiny_bird"))
    val TINY_BIRD = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "tiny_bird"),
        EntityType.Builder.create(::TinyBirdEntity, SpawnGroup.CREATURE)
            .dimensions(0.5F, 0.5F).build(TINY_BIRD_KEY))

    val TINY_EGG_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "tiny_egg"))
    val TINY_EGG = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "tiny_egg"),
        EntityType.Builder.create({ type, world -> TinyEggEntity(type, world) }, SpawnGroup.MISC)
            .dimensions(0.1f, 0.1f)
            .maxTrackingRange(4)
            .build(TINY_EGG_KEY)
    )

    val WILD_DEER_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "wild_deer"))
    val WILD_DEER = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "wild_deer"),
        EntityType.Builder.create(::WildDeerEntity, SpawnGroup.CREATURE)
            .dimensions(1.25F, 1.5F).build(WILD_DEER_KEY))

    val TOWERWOOD_BORER_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "towerwood_borer"))
    val TOWERWOOD_BORER = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "towerwood_borer"),
        EntityType.Builder.create(::TowerwoodBorerEntity, SpawnGroup.MONSTER)
            .dimensions(0.4F, 0.3F)
            .eyeHeight(0.13F)
            .passengerAttachments(0.2375F)
            .maxTrackingRange(8)
            .build(TOWERWOOD_BORER_KEY))

    val SQUIRREL_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "squirrel"))
    val SQUIRREL = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "squirrel"),
        EntityType.Builder.create(::SquirrelEntity, SpawnGroup.CREATURE)
            .dimensions(0.5F, 0.5F).build(SQUIRREL_KEY))

    val MAZE_SLIME_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "maze_slime"))
    val MAZE_SLIME = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "maze_slime"),
        EntityType.Builder.create(::MazeSlimeEntity, SpawnGroup.MONSTER)
            .dimensions(0.52F, 0.52F)
            .eyeHeight(0.325F)
            .spawnBoxScale(4.0F)
            .maxTrackingRange(10)
            .build(MAZE_SLIME_KEY))

    val CARMINITE_BROODLING_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "carminite_brooddling"))
    val CARMINITE_BROODLING = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "carminite_broodling"),
        EntityType.Builder.create(::CarminiteBroodlingEntity, SpawnGroup.MONSTER)
            .dimensions(1.4F, 0.9F)
            .eyeHeight(0.65F)
            .passengerAttachments(0.765F)
            .maxTrackingRange(8)
            .build(CARMINITE_BROODLING_KEY))

    val KING_SPIDER_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "king_spider"))
    val KING_SPIDER = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "king_spider"),
        EntityType.Builder.create(::KingSpiderEntity, SpawnGroup.MONSTER)
            .dimensions(1.4F, 0.9F)
            .eyeHeight(0.65F)
            .passengerAttachments(0.85F)
            .maxTrackingRange(8)
            .build(KING_SPIDER_KEY))

    val SKELETON_DRUID_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "skeleton_druid"))
    val SKELETON_DRUID = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "skeleton_druid"),
        EntityType.Builder.create(::SkeletonDruidEntity, SpawnGroup.MONSTER)
            .dimensions(0.6F, 1.99F)
            .eyeHeight(1.74F)
            .vehicleAttachment(0.0F)
            .maxTrackingRange(8)
            .build(SKELETON_DRUID_KEY))

    val NATURE_BOLT_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "nature_bolt"))
    val NATURE_BOLT = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "nature_bolt"),
        EntityType.Builder.create(::NatureBolt, SpawnGroup.MISC)
            .build(NATURE_BOLT_KEY))

    val HEDGE_SPIDER_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "hedge_spider"))
    val HEDGE_SPIDER = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "hedge_spider"),
        EntityType.Builder.create(::HedgeSpiderEntity, SpawnGroup.MONSTER)
            .dimensions(1.4F, 0.9F)
            .eyeHeight(0.65F)
            .passengerAttachments(0.4225F)
            .maxTrackingRange(8)
            .build(HEDGE_SPIDER_KEY))

    val SWARM_SPIDER_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "swarm_spider"))
    val SWARM_SPIDER = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "swarm_spider"),
        EntityType.Builder.create(::SwarmSpiderEntity, SpawnGroup.MONSTER)
            .dimensions(1.4F, 0.9F)
            .eyeHeight(0.65F)
            .passengerAttachments(0.0F)
            .maxTrackingRange(8)
            .build(SWARM_SPIDER_KEY))

    val MIST_WOLF_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "mist_wolf"))
    val MIST_WOLF = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "mist_wolf"),
        EntityType.Builder.create(::MistWolfEntity, SpawnGroup.CREATURE)
            .dimensions(0.6F, 0.85F)
            .eyeHeight(0.68F)
            .passengerAttachments(Vec3d(0.0, 0.81875, -0.0625))
            .maxTrackingRange(10)
            .build(MIST_WOLF_KEY))

    val WINTER_WOLF_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "winter_wolf"))
    val WINTER_WOLF = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "winter_wolf"),
        EntityType.Builder.create(::WinterWolfEntity, SpawnGroup.CREATURE)
            .dimensions(0.6F, 0.85F)
            .eyeHeight(0.68F)
            .passengerAttachments(Vec3d(0.0, 0.81875, -0.0625))
            .maxTrackingRange(10)
            .build(WINTER_WOLF_KEY))

    val CARMINITE_GHAST_GUARD_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "carminite_ghast_guard"))
    val CARMINITE_GHAST_GUARD = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "carminite_ghast_guard"),
        EntityType.Builder.create(::CarminiteGhastGuardEntity, SpawnGroup.MONSTER)
            .makeFireImmune()
            .dimensions(4.0F, 4.0F)
            .eyeHeight(2.6F)
            .passengerAttachments(4.0625F)
            .vehicleAttachment(0.5F)
            .maxTrackingRange(10)
            .build(CARMINITE_GHAST_GUARD_KEY))

    val CARMINITE_GHASTLING_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "carminite_ghastling"))
    val CARMINITE_GHASTLING = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "carminite_ghastling"),
        EntityType.Builder.create(::CarminiteGhastlingEntity, SpawnGroup.MONSTER)
            .makeFireImmune()
            .dimensions(4.0F, 4.0F)
            .eyeHeight(2.6F)
            .passengerAttachments(4.0625F)
            .vehicleAttachment(0.5F)
            .maxTrackingRange(10)
            .build(CARMINITE_GHASTLING_KEY))

    val KNIGHT_PHANTOM_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "knight_phantom"))
    val KNIGHT_PHANTOM = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "knight_phantom"),
        EntityType.Builder.create(::KnightPhantomEntity, SpawnGroup.MONSTER)
            .dimensions(0.6F, 1.99F)
            .eyeHeight(1.74F)
            .vehicleAttachment(0.0F)
            .maxTrackingRange(8)
            .build(KNIGHT_PHANTOM_KEY))

    val BIGHORN_SHEEP_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "bighorn_sheep"))
    val BIGHORN_SHEEP = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "bighorn_sheep"),
        EntityType.Builder.create(::BighornSheepEntity, SpawnGroup.CREATURE)
            .dimensions(0.9F, 1.3F)
            .eyeHeight(1.235F)
            .passengerAttachments(1.2375F)
            .maxTrackingRange(10)
            .build(BIGHORN_SHEEP_KEY))

    val WILD_BOAR_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TwilightForest.MOD_ID, "wild_boar"))
    val WILD_BOAR = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(TwilightForest.MOD_ID, "wild_boar"),
        EntityType.Builder.create(::WildBoarEntity, SpawnGroup.CREATURE)
            .dimensions(0.9F, 0.9F)
            .passengerAttachments(0.86875F)
            .maxTrackingRange(10)
            .build(WILD_BOAR_KEY))

    fun registerEntities() {
        TwilightForest.logger?.info("Registering entities for " + TwilightForest.MOD_ID)
    }
}