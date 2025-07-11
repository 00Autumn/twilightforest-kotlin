package autumn.twilightforest.boat.impl.client;

import autumn.twilightforest.boat.impl.data.TFBoatDataImpl;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.TexturedModelDataProvider;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.RaftEntityRenderer;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.RaftEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public final class TFBoatClientHelperImpl {
    private TFBoatClientHelperImpl() {
        return;
    }

    private static <T extends Entity> void registerEntityRenderer(EntityType<? extends T> entityType, EntityModelLayer modelLayer, TexturedModelDataProvider texturedModelDataProvider, EntityRendererFactory<T> entityRendererFactory) {
        EntityModelLayerRegistry.registerModelLayer(modelLayer, texturedModelDataProvider);
        EntityRendererRegistry.register(entityType, entityRendererFactory);
    }

    public static void registerModelLayers(Identifier id) {
        TFBoatDataImpl boatData = TFBoatDataImpl.get(id);

        if (boatData.boatEntityType() != null) {
            registerEntityRenderer(boatData.boatEntityType(), boatData.boatModelLayer(),
                    BoatEntityModel::getTexturedModelData,
                    context -> new BoatEntityRenderer(context, boatData.boatModelLayer()));
        }
        if (boatData.chestBoatEntityType() != null) {
            registerEntityRenderer(boatData.chestBoatEntityType(), boatData.chestBoatModelLayer(),
                    BoatEntityModel::getChestTexturedModelData,
                    context -> new BoatEntityRenderer(context, boatData.chestBoatModelLayer()));
        }
        if (boatData.raftEntityType() != null) {
            registerEntityRenderer(boatData.raftEntityType(), boatData.raftModelLayer(),
                    RaftEntityModel::getTexturedModelData,
                    context -> new RaftEntityRenderer(context, boatData.raftModelLayer()));
        }
        if (boatData.chestRaftEntityType() != null) {
            registerEntityRenderer(boatData.chestRaftEntityType(), boatData.chestRaftModelLayer(),
                    RaftEntityModel::getChestTexturedModelData,
                    context -> new RaftEntityRenderer(context, boatData.chestRaftModelLayer()));
        }
    }
}