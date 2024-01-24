package mari.mcaccel.mixin.block;

import mari.mcaccel.accessors.SnowGolemHeadTypeAccessor;
import mari.mcaccel.initializers.BlockInit;
import net.fabricmc.fabric.api.event.EventFactory;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Mixin(CarvedPumpkinBlock.class)
public class CarvedPumpkinModifier extends HorizontalFacingBlock{

    private static LinkedHashMap<Block, Block> PumpkinMapForward;
    @Shadow
    @Mutable
    private static @Final Predicate<BlockState> IS_GOLEM_HEAD_PREDICATE = state -> state != null && (
            state.isOf(Blocks.CARVED_PUMPKIN) ||
                    state.isOf(Blocks.JACK_O_LANTERN)||
                    BlockInit.PUMPKIN_BLOCKS.containsKey(state.getBlock()));

    private Block getPumpkinBlock(Block block) {

        if (PumpkinMapForward == null){GeneratePumpkinLookupMap();}

        return PumpkinMapForward.get(block);

    }
    @ModifyArg(method = "trySpawnEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;spawnEntity(Lnet/minecraft/entity/Entity;)Z"),index = 0)
    Entity modifySnowGolem(Entity entity){

        SnowGolemEntity snowGolem = (SnowGolemEntity) entity;
        ((SnowGolemHeadTypeAccessor)(SnowGolemEntity) entity).setHeadBlock(this);
        return snowGolem;
    }
    protected CarvedPumpkinModifier(Settings settings) {
        super(settings);
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.SHEARS)) {
            if (!world.isClient) {
                Direction direction = hit.getSide();
                Direction direction2 = direction.getAxis() == Direction.Axis.Y ? player.getHorizontalFacing().getOpposite() : direction;
                world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_PUMPKIN_CARVE, SoundCategory.BLOCKS, 1.0F, 1.0F);

                world.setBlockState(pos, (BlockState) getPumpkinBlock(this).getDefaultState().with(CarvedPumpkinBlock.FACING, direction2), 11);

                itemStack.damage(1, player, (playerx) -> {
                    playerx.sendToolBreakStatus(hand);
                });
                world.emitGameEvent(player, GameEvent.SHEAR, pos);
                player.incrementStat(Stats.USED.getOrCreateStat(Items.SHEARS));
            }

            return ActionResult.SUCCESS;
        } else {

            return super.onUse(state, world, pos, player, hand, hit);
        }
    }


    private static void GeneratePumpkinLookupMap(){

        LinkedHashMap<Block, Block> forward = new LinkedHashMap<Block,Block>();

        forward.put(Blocks.CARVED_PUMPKIN, BlockInit.CARVED_PUMPKIN_X);
        forward.put(BlockInit.CARVED_PUMPKIN_X, BlockInit.CARVED_PUMPKIN_SMILE);
        forward.put(BlockInit.CARVED_PUMPKIN_SMILE, BlockInit.CARVED_PUMPKIN_DERP);
        forward.put(BlockInit.CARVED_PUMPKIN_DERP, BlockInit.CARVED_PUMPKIN_CHECK);
        forward.put(BlockInit.CARVED_PUMPKIN_CHECK, BlockInit.CARVED_PUMPKIN_CREEPER);
        forward.put(BlockInit.CARVED_PUMPKIN_CREEPER, BlockInit.CARVED_PUMPKIN_HEROBRINE);
        forward.put(BlockInit.CARVED_PUMPKIN_HEROBRINE, BlockInit.CARVED_PUMPKIN_EVIL);
        forward.put(BlockInit.CARVED_PUMPKIN_EVIL, BlockInit.CARVED_PUMPKIN_HEART);
        forward.put(BlockInit.CARVED_PUMPKIN_HEART, BlockInit.CARVED_PUMPKIN_SHOUT);
        forward.put(BlockInit.CARVED_PUMPKIN_SHOUT, Blocks.CARVED_PUMPKIN);

        forward.put(Blocks.JACK_O_LANTERN, BlockInit.JACK_O_LANTERN_X);
        forward.put(BlockInit.JACK_O_LANTERN_X, BlockInit.JACK_O_LANTERN_SMILE);
        forward.put(BlockInit.JACK_O_LANTERN_SMILE, BlockInit.JACK_O_LANTERN_DERP);
        forward.put(BlockInit.JACK_O_LANTERN_DERP, BlockInit.JACK_O_LANTERN_CHECK);
        forward.put(BlockInit.JACK_O_LANTERN_CHECK, BlockInit.JACK_O_LANTERN_CREEPER);
        forward.put(BlockInit.JACK_O_LANTERN_CREEPER, BlockInit.JACK_O_LANTERN_HEROBRINE);
        forward.put(BlockInit.JACK_O_LANTERN_HEROBRINE, BlockInit.JACK_O_LANTERN_EVIL);
        forward.put(BlockInit.JACK_O_LANTERN_EVIL, BlockInit.JACK_O_LANTERN_HEART);
        forward.put(BlockInit.JACK_O_LANTERN_HEART, BlockInit.JACK_O_LANTERN_SHOUT);
        forward.put(BlockInit.JACK_O_LANTERN_SHOUT, Blocks.JACK_O_LANTERN);

        forward.put(BlockInit.SOUL_JACK_O_LANTERN_NORMAL, BlockInit.SOUL_JACK_O_LANTERN_X);
        forward.put(BlockInit.SOUL_JACK_O_LANTERN_X, BlockInit.SOUL_JACK_O_LANTERN_SMILE);
        forward.put(BlockInit.SOUL_JACK_O_LANTERN_SMILE, BlockInit.SOUL_JACK_O_LANTERN_DERP);
        forward.put(BlockInit.SOUL_JACK_O_LANTERN_DERP, BlockInit.SOUL_JACK_O_LANTERN_CHECK);
        forward.put(BlockInit.SOUL_JACK_O_LANTERN_CHECK, BlockInit.SOUL_JACK_O_LANTERN_CREEPER);
        forward.put(BlockInit.SOUL_JACK_O_LANTERN_CREEPER, BlockInit.SOUL_JACK_O_LANTERN_HEROBRINE);
        forward.put(BlockInit.SOUL_JACK_O_LANTERN_HEROBRINE, BlockInit.SOUL_JACK_O_LANTERN_EVIL);
        forward.put(BlockInit.SOUL_JACK_O_LANTERN_EVIL, BlockInit.SOUL_JACK_O_LANTERN_HEART);
        forward.put(BlockInit.SOUL_JACK_O_LANTERN_HEART, BlockInit.SOUL_JACK_O_LANTERN_SHOUT);
        forward.put(BlockInit.SOUL_JACK_O_LANTERN_SHOUT, BlockInit.SOUL_JACK_O_LANTERN_NORMAL);

        PumpkinMapForward = forward;
    }

}
