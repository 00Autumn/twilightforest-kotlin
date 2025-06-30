package autumn.twilightforest.sign.api.block;

import autumn.twilightforest.sign.api.TFSign;
import autumn.twilightforest.sign.impl.BlockSettingsLock;
import net.minecraft.block.SignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;

public class TFSignBlock extends SignBlock implements TFSign {
    private final Identifier texture;

    public TFSignBlock(Identifier texture, WoodType woodType, Settings settings) {
        super(woodType, BlockSettingsLock.lock(settings));
        this.texture = texture;
    }

    public TFSignBlock(Identifier texture, Settings settings) {
        this(texture, WoodType.OAK, settings);
    }

    @Override
    public Identifier getTexture() {
        return texture;
    }
}
