package mari.mcaccel.accessors;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public interface SnowGolemHeadTypeAccessor {
    ItemStack getHeadItemStack();

    void setHeadBlock(Block block);

}
