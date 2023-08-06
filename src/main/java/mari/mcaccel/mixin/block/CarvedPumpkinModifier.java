package mari.mcaccel.mixin.block;

import mari.mcaccel.initializers.BlockInit;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.HashMap;

@Mixin(CarvedPumpkinBlock.class)
public class CarvedPumpkinModifier extends HorizontalFacingBlock{

    private static HashMap<Block, Block> PUMPKIN_CHANGE_MAP;
    private Block getPumpkinBlocks(Block block) {

        if(PUMPKIN_CHANGE_MAP != null) PUMPKIN_CHANGE_MAP.get(block);

        HashMap<Block, Block> map = new HashMap<Block, Block>();

        map.put(Blocks.CARVED_PUMPKIN, BlockInit.CARVED_PUMPKIN_X);
        map.put(BlockInit.CARVED_PUMPKIN_X, BlockInit.CARVED_PUMPKIN_SMILE);
        map.put(BlockInit.CARVED_PUMPKIN_SMILE, BlockInit.CARVED_PUMPKIN_DERP);
        map.put(BlockInit.CARVED_PUMPKIN_DERP, BlockInit.CARVED_PUMPKIN_CHECK);
        map.put(BlockInit.CARVED_PUMPKIN_CHECK, BlockInit.CARVED_PUMPKIN_CREEPER);
        map.put(BlockInit.CARVED_PUMPKIN_CREEPER, BlockInit.CARVED_PUMPKIN_HEROBRINE);
        map.put(BlockInit.CARVED_PUMPKIN_HEROBRINE, BlockInit.CARVED_PUMPKIN_EVIL);
        map.put(BlockInit.CARVED_PUMPKIN_EVIL, BlockInit.CARVED_PUMPKIN_HEART);
        map.put(BlockInit.CARVED_PUMPKIN_HEART, BlockInit.CARVED_PUMPKIN_SHOUT);
        map.put(BlockInit.CARVED_PUMPKIN_SHOUT, Blocks.CARVED_PUMPKIN);

        map.put(Blocks.JACK_O_LANTERN, BlockInit.JACK_O_LANTERN_X);
        map.put(BlockInit.JACK_O_LANTERN_X, BlockInit.JACK_O_LANTERN_SMILE);
        map.put(BlockInit.JACK_O_LANTERN_SMILE, BlockInit.JACK_O_LANTERN_DERP);
        map.put(BlockInit.JACK_O_LANTERN_DERP, BlockInit.JACK_O_LANTERN_CHECK);
        map.put(BlockInit.JACK_O_LANTERN_CHECK, BlockInit.JACK_O_LANTERN_CREEPER);
        map.put(BlockInit.JACK_O_LANTERN_CREEPER, BlockInit.JACK_O_LANTERN_HEROBRINE);
        map.put(BlockInit.JACK_O_LANTERN_HEROBRINE, BlockInit.JACK_O_LANTERN_EVIL);
        map.put(BlockInit.JACK_O_LANTERN_EVIL, BlockInit.JACK_O_LANTERN_HEART);
        map.put(BlockInit.JACK_O_LANTERN_HEART, BlockInit.JACK_O_LANTERN_SHOUT);
        map.put(BlockInit.JACK_O_LANTERN_SHOUT, Blocks.JACK_O_LANTERN);

        map.put(BlockInit.SOUL_JACK_O_LANTERN_X, BlockInit.SOUL_JACK_O_LANTERN_SMILE);
        map.put(BlockInit.SOUL_JACK_O_LANTERN_SMILE, BlockInit.SOUL_JACK_O_LANTERN_DERP);
        map.put(BlockInit.SOUL_JACK_O_LANTERN_DERP, BlockInit.SOUL_JACK_O_LANTERN_CHECK);
        map.put(BlockInit.SOUL_JACK_O_LANTERN_CHECK, BlockInit.SOUL_JACK_O_LANTERN_CREEPER);
        map.put(BlockInit.SOUL_JACK_O_LANTERN_CREEPER, BlockInit.SOUL_JACK_O_LANTERN_HEROBRINE);
        map.put(BlockInit.SOUL_JACK_O_LANTERN_HEROBRINE, BlockInit.SOUL_JACK_O_LANTERN_EVIL);
        map.put(BlockInit.SOUL_JACK_O_LANTERN_EVIL, BlockInit.SOUL_JACK_O_LANTERN_HEART);
        map.put(BlockInit.SOUL_JACK_O_LANTERN_HEART, BlockInit.SOUL_JACK_O_LANTERN_SHOUT);
        map.put(BlockInit.SOUL_JACK_O_LANTERN_SHOUT, BlockInit.SOUL_JACK_O_LANTERN_X);

        PUMPKIN_CHANGE_MAP = map;
        return PUMPKIN_CHANGE_MAP.get(block);
    }


    /**@ModifyArg(method = "trySpawnEntity", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/block/CarvedPumpkinBlock;spawnEntity(Lnet/minecraft/world/World;Lnet/minecraft/block/pattern/BlockPattern$Result;Lnet/minecraft/entity/Entity;Lnet/minecraft/util/math/BlockPos;)V"),
            index = 2)
    private Entity foo(Entity entity){
        NbtCompound nbtCompound = new NbtCompound();
                nbtCompound.put("pumpkin_type", (NbtElement) this);
        SnowGolemEntity snowMan = (SnowGolemEntity) entity;
        snowMan.writeNbt(nbtCompound);

        return entity;
    }
    **/

    protected CarvedPumpkinModifier(Settings settings) {
        super(settings);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        SnowGolemEntity snowMan = new SnowGolemEntity(EntityType.SNOW_GOLEM, world);
        snowMan.setPos(hit.getBlockPos().getX(),hit.getBlockPos().getY(),hit.getBlockPos().getZ());
        world.spawnEntity(snowMan);

        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.SHEARS)) {
            if (!world.isClient) {
                Direction direction = hit.getSide();
                Direction direction2 = direction.getAxis() == Direction.Axis.Y ? player.getHorizontalFacing().getOpposite() : direction;
                world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_PUMPKIN_CARVE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.setBlockState(pos, (BlockState) getPumpkinBlocks(this).getDefaultState().with(CarvedPumpkinBlock.FACING, direction2), 11);

                itemStack.damage(1, player, (playerx) -> {
                    playerx.sendToolBreakStatus(hand);
                });
                world.emitGameEvent(player, GameEvent.SHEAR, pos);
                player.incrementStat(Stats.USED.getOrCreateStat(Items.SHEARS));
            }

            return ActionResult.success(world.isClient);
        } else {

            return super.onUse(state, world, pos, player, hand, hit);
        }
    }


}
