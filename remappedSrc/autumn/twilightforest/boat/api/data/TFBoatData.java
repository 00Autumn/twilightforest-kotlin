package autumn.twilightforest.boat.api.data;

import autumn.twilightforest.boat.impl.data.TFBoatDataImpl;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.entity.vehicle.ChestRaftEntity;
import net.minecraft.entity.vehicle.RaftEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

@SuppressWarnings("unused")
public interface TFBoatData {

    static TFBoatDataImpl get(Identifier id) {
        return TFBoatDataImpl.get(id);
    }

    static Optional<TFBoatData> getOptional(Identifier id) {
        return TFBoatDataImpl.getOptional(id).map(data -> data);
    }

    Identifier boatId();

    Identifier chestBoatId();

    RegistryKey<Item> boatKey();

    RegistryKey<Item> chestBoatKey();

    Identifier boatEntityTypeId();

    Identifier chestBoatEntityTypeId();

    RegistryKey<EntityType<?>> boatEntityTypeKey();

    RegistryKey<EntityType<?>> chestBoatEntityTypeKey();

    EntityType<BoatEntity> boatEntityType();

    EntityType<ChestBoatEntity> chestBoatEntityType();

    EntityModelLayer boatModelLayer();

    EntityModelLayer chestBoatModelLayer();

    Identifier raftId();

    Identifier chestRaftId();

    RegistryKey<Item> raftKey();

    RegistryKey<Item> chestRaftKey();

    Identifier raftEntityTypeId();

    Identifier chestRaftEntityTypeId();

    RegistryKey<EntityType<?>> raftEntityTypeKey();

    RegistryKey<EntityType<?>> chestRaftEntityTypeKey();

    EntityType<RaftEntity> raftEntityType();

    EntityType<ChestRaftEntity> chestRaftEntityType();

    EntityModelLayer raftModelLayer();

    EntityModelLayer chestRaftModelLayer();
}
