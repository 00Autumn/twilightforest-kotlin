package autumn.twilightforest.sign.api.block;

import autumn.twilightforest.sign.api.TFSign;
import autumn.twilightforest.sign.impl.BlockSettingsLock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;

public class TFWallSignBlock extends WallSignBlock implements TFSign {
    private final Identifier texture;

    public TFWallSignBlock(Identifier texture, WoodType woodType, Settings settings) {
        super(woodType, BlockSettingsLock.lock(settings));
        this.texture = texture;
    }

    public TFWallSignBlock(Identifier texture, Settings settings) {
        this(texture, WoodType.OAK, settings);
    }

    @Override
    public Identifier getTexture() {
        return texture;
    }
}
