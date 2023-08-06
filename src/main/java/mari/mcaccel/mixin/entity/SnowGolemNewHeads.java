package mari.mcaccel.mixin.entity;

import mari.mcaccel.access.SnowGolemHeadTypeAccessor;
import mari.mcaccel.initializers.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SnowGolemEntity.class)
public class SnowGolemNewHeads implements SnowGolemHeadTypeAccessor{

    private Block headBlock = BlockInit.CARVED_PUMPKIN_CREEPER;

    @Override
    public Block getHeadBlock() {
        return headBlock;
    }
    public void setPumpkinHeadType(NbtCompound nbt, Block block){
        nbt.put("pumpkin_type", (NbtElement) block);
    }
    @Inject(method = "readCustomDataFromNbt", at= @At("TAIL"))
    private void readCustomDataFromNbtInject(NbtCompound nbt, CallbackInfo ci){
        if (nbt.contains("pumpkin_type")){
            headBlock = (Block) nbt.get("pumpkin_type");
        }
    }
    public void writeNewCustomDataToNbtInject(NbtCompound nbt, Block block){
        nbt.put("pumpkin_type", (NbtElement) block);
    }
}
