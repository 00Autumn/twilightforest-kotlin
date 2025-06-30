package autumn.twilightforest.sign.api.block;

import autumn.twilightforest.sign.api.TFHangingSign;
import autumn.twilightforest.sign.impl.BlockSettingsLock;
import net.minecraft.block.WallHangingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;

public class TFWallHangingSignBlock extends WallHangingSignBlock implements TFHangingSign {
    private final Identifier texture;
    private final Identifier guiTexture;

    public TFWallHangingSignBlock(Identifier texture, Identifier guiTexture, WoodType woodType, Settings settings) {
        super(woodType, BlockSettingsLock.lock(settings));
        this.texture = texture;
        this.guiTexture = guiTexture;
    }

    public TFWallHangingSignBlock(Identifier texture, Identifier guiTexture, Settings settings) {
        this(texture, guiTexture, WoodType.OAK, settings);
    }

    @Override
    public Identifier getTexture() {
        return texture;
    }

    @Override
    public Identifier getGuiTexture() {
        return guiTexture;
    }
}
