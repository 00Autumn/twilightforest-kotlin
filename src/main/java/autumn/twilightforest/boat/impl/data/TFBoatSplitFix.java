package autumn.twilightforest.boat.impl.data;

import com.mojang.datafixers.*;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.Type;
import com.mojang.serialization.Dynamic;
import net.minecraft.datafixer.FixUtil;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.datafixer.schema.IdentifierNormalizingSchema;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class TFBoatSplitFix extends DataFix {
    public TFBoatSplitFix(Schema outputSchema, boolean changesType) {
        super(outputSchema, changesType);
    }

    private static boolean isBoat(String id) {
        return id.equals("tf:boat");
    }

    private static boolean isChestBoat(String id) {
        return id.equals("tf:chest_boat");
    }

    private static boolean isBoatOrChestBoat(String id) {
        return isBoat(id) || isChestBoat(id);
    }

    private static String getNewBoatIdFromOldType(String type) {
        Optional<TFBoatDataImpl> boatData = TFBoatDataImpl.getOptional(Identifier.of(type));
        String newId = null;

        if (boatData.isPresent()) {
            if (boatData.get().boatEntityType() != null) {
                newId = boatData.get().boatId().toString();
            } else if (boatData.get().raftEntityType() != null) {
                newId = boatData.get().raftId().toString();
            }
        }

        if (newId != null && TFBoatDfu.getRegisteredBoats().contains(newId)) {
            return newId;
        }

        return "minecraft:oak_boat";
    }

    private static String getNewChestBoatIdFromOldType(String type) {
        Optional<TFBoatDataImpl> boatData = TFBoatDataImpl.getOptional(Identifier.of(type));
        String newId = null;

        if (boatData.isPresent()) {
            if (boatData.get().chestBoatEntityType() != null) {
                newId = boatData.get().chestBoatId().toString();
            } else if (boatData.get().chestRaftEntityType() != null) {
                newId = boatData.get().chestRaftId().toString();
            }
        }

        if (newId != null && TFBoatDfu.getRegisteredBoats().contains(newId)) {
            return newId;
        }

        return "minecraft:oak_chest_boat";
    }

    @Override
    protected TypeRewriteRule makeRule() {
        OpticFinder<String> opticFinder = DSL.fieldFinder("id", IdentifierNormalizingSchema.getIdentifierType());
        Type<?> type = this.getInputSchema().getType(TypeReferences.ENTITY);
        Type<?> type2 = this.getOutputSchema().getType(TypeReferences.ENTITY);

        return this.fixTypeEverywhereTyped("TFBoatSplitFix", type, type2, typed -> {
            Optional<String> optional = typed.getOptional(opticFinder);

            if (optional.isPresent() && isBoatOrChestBoat(optional.get())) {
                Dynamic<?> dynamic = typed.getOrCreate(DSL.remainderFinder());
                Optional<String> optional2 = dynamic.get("TFBoat").asString().result();

                String string;
                if (isChestBoat(optional.get())) {
                    string = optional2.map(TFBoatSplitFix::getNewChestBoatIdFromOldType).orElse("minecraft:oak_chest_boat");
                } else {
                    string = optional2.map(TFBoatSplitFix::getNewBoatIdFromOldType).orElse("minecraft:oak_boat");
                }

                return FixUtil.withType(type2, typed).update(DSL.remainderFinder(), dynamicx -> dynamicx.remove("TFBoat")).set(opticFinder, string);
            } else {
                return FixUtil.withType(type2, typed);
            }
        });
    }
}
