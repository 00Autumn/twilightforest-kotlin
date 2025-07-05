package autumn.twilightforest.boat.impl.data;

import com.mojang.datafixers.DSL;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.templates.TypeTemplate;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.datafixer.schema.IdentifierNormalizingSchema;

import java.util.Map;
import java.util.function.Supplier;

public class TFAddBoatsSchema extends IdentifierNormalizingSchema {
    public TFAddBoatsSchema(int versionKey, Schema parent) {
        super(versionKey, parent);
    }

    @Override
    public Map<String, Supplier<TypeTemplate>> registerEntities(Schema schema) {
        Map<String, Supplier<TypeTemplate>> map = super.registerEntities(schema);

        schema.registerSimple(map, "tf:boat");
        schema.register(map, "tf:chest_boat", string -> DSL.optionalFields("Items", DSL.list(TypeReferences.ITEM_STACK.in(schema))));

        return map;
    }
}
