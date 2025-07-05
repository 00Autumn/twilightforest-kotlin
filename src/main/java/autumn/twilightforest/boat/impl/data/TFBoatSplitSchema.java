package autumn.twilightforest.boat.impl.data;

import com.mojang.datafixers.DSL;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.templates.TypeTemplate;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.datafixer.schema.IdentifierNormalizingSchema;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

public class TFBoatSplitSchema extends IdentifierNormalizingSchema {
    public TFBoatSplitSchema(int versionKey, Schema parent) {
        super(versionKey, parent);
    }

    @Override
    public Map<String, Supplier<TypeTemplate>> registerEntities(Schema schema) {
        Map<String, Supplier<TypeTemplate>> map = super.registerEntities(schema);

        map.remove("tf:boat");
        map.remove("tf:chest_boat");

        Collection<String> registeredBoats = TFBoatDfu.getRegisteredBoats();
        for (String boat : registeredBoats) {
            if (boat.contains("_chest") || boat.contains("chest_")) {
                schema.register(map, boat, string -> DSL.optionalFields("Items", DSL.list(TypeReferences.ITEM_STACK.in(schema))));
            } else {
                schema.registerSimple(map, boat);
            }
        }

        return map;
    }
}
