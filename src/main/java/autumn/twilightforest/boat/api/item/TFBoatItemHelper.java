package autumn.twilightforest.boat.api.item;

import autumn.twilightforest.boat.impl.item.TFBoatItemHelperImpl;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.AbstractBoatEntity;
import net.minecraft.item.BoatItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public final class TFBoatItemHelper {
    private TFBoatItemHelper() {
        return;
    }

    public static BoatItem registerBoatItem(Identifier id, boolean chest) {
        return registerBoatItem(id, chest, false);
    }

    public static BoatItem registerBoatItem(Identifier id, boolean chest, boolean raft) {
        return registerBoatItem(id, new Item.Settings().maxCount(1), chest, raft);
    }

    public static BoatItem registerBoatItem(Identifier id, Item.Settings settings, boolean chest, boolean raft) {
        return TFBoatItemHelperImpl.registerBoatItem(id, settings, chest, raft);
    }

    public static void registerBoatDispenserBehavior(ItemConvertible item, EntityType<? extends AbstractBoatEntity> boatEntity) {
        TFBoatItemHelperImpl.registerBoatDispenserBehavior(item, boatEntity);
    }
}