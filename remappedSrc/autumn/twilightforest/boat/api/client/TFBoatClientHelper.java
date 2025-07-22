package autumn.twilightforest.boat.api.client;

import autumn.twilightforest.boat.impl.client.TFBoatClientHelperImpl;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
@SuppressWarnings("unused")
public final class TFBoatClientHelper {
    private TFBoatClientHelper() {
        return;
    }

    public static void registerModelLayers(Identifier id) {
        TFBoatClientHelperImpl.registerModelLayers(id);
    }
}
