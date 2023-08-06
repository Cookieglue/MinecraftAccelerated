package mari.mcaccel.mixin.entity;

import mari.mcaccel.McAccel;
import mari.mcaccel.access.SnowGolemHeadTypeAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SnowGolemEntity.class)
public abstract class SnowGolemNewHeads extends GolemEntity implements SnowGolemHeadTypeAccessor{

    protected SnowGolemNewHeads(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow public abstract void setHasPumpkin(boolean hasPumpkin);

    private Block headBlock = Blocks.GLASS;
    private static final TrackedData<ItemStack> HEAD_DATA = DataTracker.registerData(SnowGolemEntity.class, TrackedDataHandlerRegistry.ITEM_STACK);

    @Override
    public ItemStack getHeadItemStack() {
        return this.dataTracker.get(HEAD_DATA);
    }

    @Override
    public void setHeadBlock(Block block) {

        McAccel.LOGGER.warn("the block is: " + headBlock.getName());
        this.dataTracker.set(HEAD_DATA, new ItemStack(block));
    }

    @Inject(method = "initDataTracker", at = @At("TAIL"))
    void initDataTrackerInject(CallbackInfo ci){
        this.dataTracker.startTracking(HEAD_DATA, new ItemStack(Blocks.NETHERITE_BLOCK));
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
