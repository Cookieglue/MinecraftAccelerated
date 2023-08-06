package mari.mcaccel.access;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public interface SnowGolemHeadTypeAccessor {
    ItemStack getHeadItemStack();

    void setHeadBlock(Block block);

}
