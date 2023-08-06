package mari.mcaccel.mixin.entity;

import mari.mcaccel.McAccel;
import mari.mcaccel.access.SnowGolemHeadTypeAccessor;
import mari.mcaccel.initializers.BlockInit;
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
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

@Mixin(SnowGolemEntity.class)
public abstract class SnowGolemNewHeads extends GolemEntity implements SnowGolemHeadTypeAccessor{

    @Shadow public abstract void setHasPumpkin(boolean hasPumpkin);

    private Block headBlock = Blocks.GLASS;
    private static final TrackedData<ItemStack> HEAD_DATA = DataTracker.registerData(SnowGolemEntity.class, TrackedDataHandlerRegistry.ITEM_STACK);

    private static  Map<String, ItemStack> PUMPKIN_TYPES;
    ItemStack getPumpkin(String pumpkinType) {

        if (PUMPKIN_TYPES != null) {
            if(PUMPKIN_TYPES.containsKey(pumpkinType)){
                return PUMPKIN_TYPES.get(pumpkinType);
            }
            else {
                return new ItemStack(Blocks.CARVED_PUMPKIN);
            }
        }


        Map<String, ItemStack> map = new HashMap<>();

        map.put("block.minecraft.carved_pumpkin", new ItemStack(Blocks.CARVED_PUMPKIN));
        map.put("block.mcaccel.carved_pumpkin_x", new ItemStack(BlockInit.CARVED_PUMPKIN_X));
        map.put("block.mcaccel.carved_pumpkin_smile", new ItemStack(BlockInit.CARVED_PUMPKIN_SMILE));
        map.put("block.mcaccel.carved_pumpkin_derp", new ItemStack(BlockInit.CARVED_PUMPKIN_DERP));
        map.put("block.mcaccel.carved_pumpkin_check", new ItemStack(BlockInit.CARVED_PUMPKIN_CHECK));
        map.put("block.mcaccel.carved_pumpkin_creeper", new ItemStack(BlockInit.CARVED_PUMPKIN_CREEPER));
        map.put("block.mcaccel.carved_pumpkin_herobrine", new ItemStack(BlockInit.CARVED_PUMPKIN_HEROBRINE));
        map.put("block.mcaccel.carved_pumpkin_evil", new ItemStack(BlockInit.CARVED_PUMPKIN_EVIL));
        map.put("block.mcaccel.carved_pumpkin_heart", new ItemStack(BlockInit.CARVED_PUMPKIN_HEART));
        map.put("block.mcaccel.carved_pumpkin_shout", new ItemStack(BlockInit.CARVED_PUMPKIN_SHOUT));

        map.put("block.minecraft.jack_o_lantern", new ItemStack(Blocks.JACK_O_LANTERN));
        map.put("block.mcaccel.jack_o_lantern_x", new ItemStack(BlockInit.JACK_O_LANTERN_X));
        map.put("block.mcaccel.jack_o_lantern_smile", new ItemStack(BlockInit.JACK_O_LANTERN_SMILE));
        map.put("block.mcaccel.jack_o_lantern_derp", new ItemStack(BlockInit.JACK_O_LANTERN_DERP));
        map.put("block.mcaccel.jack_o_lantern_check", new ItemStack(BlockInit.JACK_O_LANTERN_CHECK));
        map.put("block.mcaccel.jack_o_lantern_creeper", new ItemStack(BlockInit.JACK_O_LANTERN_CREEPER));
        map.put("block.mcaccel.jack_o_lantern_herobrine", new ItemStack(BlockInit.JACK_O_LANTERN_HEROBRINE));
        map.put("block.mcaccel.jack_o_lantern_evil", new ItemStack(BlockInit.JACK_O_LANTERN_EVIL));
        map.put("block.mcaccel.jack_o_lantern_heart", new ItemStack(BlockInit.JACK_O_LANTERN_HEART));
        map.put("block.mcaccel.jack_o_lantern_shout", new ItemStack(BlockInit.JACK_O_LANTERN_SHOUT));

        map.put("block.mcaccel.soul_jack_o_lantern_x", new ItemStack(BlockInit.SOUL_JACK_O_LANTERN_X));
        map.put("block.mcaccel.soul_jack_o_lantern_smile", new ItemStack(BlockInit.SOUL_JACK_O_LANTERN_SMILE));
        map.put("block.mcaccel.soul_jack_o_lantern_derp", new ItemStack(BlockInit.SOUL_JACK_O_LANTERN_DERP));
        map.put("block.mcaccel.soul_jack_o_lantern_check", new ItemStack(BlockInit.SOUL_JACK_O_LANTERN_CHECK));
        map.put("block.mcaccel.soul_jack_o_lantern_creeper", new ItemStack(BlockInit.SOUL_JACK_O_LANTERN_CREEPER));
        map.put("block.mcaccel.soul_jack_o_lantern_herobrine", new ItemStack(BlockInit.SOUL_JACK_O_LANTERN_HEROBRINE));
        map.put("block.mcaccel.soul_jack_o_lantern_evil", new ItemStack(BlockInit.SOUL_JACK_O_LANTERN_EVIL));
        map.put("block.mcaccel.soul_jack_o_lantern_heart", new ItemStack(BlockInit.SOUL_JACK_O_LANTERN_HEART));
        map.put("block.mcaccel.soul_jack_o_lantern_shout", new ItemStack(BlockInit.SOUL_JACK_O_LANTERN_SHOUT));
        map.put("block.mcaccel.soul_jack_o_lantern_normal", new ItemStack(BlockInit.SOUL_JACK_O_LANTERN_NORMAL));

        PUMPKIN_TYPES = map;
        if(PUMPKIN_TYPES.containsKey(pumpkinType)){
            return PUMPKIN_TYPES.get(pumpkinType);
        }
        else {
            return new ItemStack(Blocks.CARVED_PUMPKIN);
        }

    }
    protected SnowGolemNewHeads(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }
    @Inject(method = "initDataTracker", at = @At("TAIL"))
    void initDataTrackerInject(CallbackInfo ci){
        this.dataTracker.startTracking(HEAD_DATA, new ItemStack(Blocks.CARVED_PUMPKIN));
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    private void writeCustomDataToNbtInject(NbtCompound nbt, CallbackInfo ci){
        McAccel.LOGGER.warn(this.dataTracker.get(HEAD_DATA).getTranslationKey());
        nbt.putString("pumpkin_type", getHeadItemStack().getTranslationKey());
    }
    @Inject(method = "readCustomDataFromNbt", at= @At("TAIL"))
    private void readCustomDataFromNbtInject(NbtCompound nbt, CallbackInfo ci){
        if (nbt.contains("pumpkin_type")){
            McAccel.LOGGER.warn(nbt.getString("pumpkin_type"));
            this.dataTracker.set(HEAD_DATA, getPumpkin(nbt.getString("pumpkin_type")));

        }
    }
    @ModifyArg(method = "sheared", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/SnowGolemEntity;dropStack(Lnet/minecraft/item/ItemStack;F)Lnet/minecraft/entity/ItemEntity;"))
    ItemStack itemStack(ItemStack par1){
        return getHeadItemStack();
    }


    @Override
    public ItemStack getHeadItemStack() {
        return this.dataTracker.get(HEAD_DATA);
    }

    @Override
    public void setHeadBlock(Block block) {

        McAccel.LOGGER.warn("the block is: " + headBlock.getName());
        this.dataTracker.set(HEAD_DATA, new ItemStack(block));
    }
}
