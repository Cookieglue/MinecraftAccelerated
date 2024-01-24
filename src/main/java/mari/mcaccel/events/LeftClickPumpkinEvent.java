package mari.mcaccel.events;

import mari.mcaccel.initializers.BlockInit;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.LinkedHashMap;

public class LeftClickPumpkinEvent implements AttackBlockCallback{

    private static LinkedHashMap<Block, Block> reversedPumpkinMap = new LinkedHashMap<Block,Block>();
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, BlockPos pos, Direction direction) {
        Block key = world.getBlockState(pos).getBlock();
        Direction blockDir = direction.getAxis() == Direction.Axis.Y ? player.getHorizontalFacing().getOpposite() : direction;
        ItemStack itemStack = player.getStackInHand(hand);
        if(itemStack.isOf(Items.SHEARS)){
            if(reversedPumpkinMap.containsKey(key)) {
                world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_PUMPKIN_CARVE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.setBlockState(pos,reversedPumpkinMap.get(key).getDefaultState().with(CarvedPumpkinBlock.FACING, blockDir));
            }
        }
        return ActionResult.PASS;
    }

    public static void GenerateReversedPumpkinLookupMap(){


        LinkedHashMap<Block, Block> reversed = new LinkedHashMap<Block,Block>();
        reversed.put(BlockInit.CARVED_PUMPKIN_X, Blocks.CARVED_PUMPKIN);
        reversed.put(BlockInit.CARVED_PUMPKIN_SMILE, BlockInit.CARVED_PUMPKIN_X);
        reversed.put(BlockInit.CARVED_PUMPKIN_DERP, BlockInit.CARVED_PUMPKIN_SMILE);
        reversed.put(BlockInit.CARVED_PUMPKIN_CHECK, BlockInit.CARVED_PUMPKIN_DERP);
        reversed.put(BlockInit.CARVED_PUMPKIN_CREEPER, BlockInit.CARVED_PUMPKIN_CHECK);
        reversed.put(BlockInit.CARVED_PUMPKIN_HEROBRINE, BlockInit.CARVED_PUMPKIN_CREEPER);
        reversed.put(BlockInit.CARVED_PUMPKIN_EVIL, BlockInit.CARVED_PUMPKIN_HEROBRINE);
        reversed.put(BlockInit.CARVED_PUMPKIN_HEART, BlockInit.CARVED_PUMPKIN_EVIL);
        reversed.put(BlockInit.CARVED_PUMPKIN_SHOUT, BlockInit.CARVED_PUMPKIN_HEART);
        reversed.put(Blocks.CARVED_PUMPKIN, BlockInit.CARVED_PUMPKIN_SHOUT);

        reversed.put(BlockInit.JACK_O_LANTERN_X, Blocks.JACK_O_LANTERN);
        reversed.put(BlockInit.JACK_O_LANTERN_SMILE, BlockInit.JACK_O_LANTERN_X);
        reversed.put(BlockInit.JACK_O_LANTERN_DERP, BlockInit.JACK_O_LANTERN_SMILE);
        reversed.put(BlockInit.JACK_O_LANTERN_CHECK, BlockInit.JACK_O_LANTERN_DERP);
        reversed.put(BlockInit.JACK_O_LANTERN_CREEPER, BlockInit.JACK_O_LANTERN_CHECK);
        reversed.put(BlockInit.JACK_O_LANTERN_HEROBRINE, BlockInit.JACK_O_LANTERN_CREEPER);
        reversed.put(BlockInit.JACK_O_LANTERN_EVIL, BlockInit.JACK_O_LANTERN_HEROBRINE);
        reversed.put(BlockInit.JACK_O_LANTERN_HEART, BlockInit.JACK_O_LANTERN_EVIL);
        reversed.put(BlockInit.JACK_O_LANTERN_SHOUT, BlockInit.JACK_O_LANTERN_HEART);
        reversed.put(Blocks.JACK_O_LANTERN, BlockInit.JACK_O_LANTERN_SHOUT);

        reversed.put(BlockInit.SOUL_JACK_O_LANTERN_X, BlockInit.SOUL_JACK_O_LANTERN_NORMAL);
        reversed.put(BlockInit.SOUL_JACK_O_LANTERN_SMILE, BlockInit.SOUL_JACK_O_LANTERN_X);
        reversed.put(BlockInit.SOUL_JACK_O_LANTERN_DERP, BlockInit.SOUL_JACK_O_LANTERN_SMILE);
        reversed.put(BlockInit.SOUL_JACK_O_LANTERN_CHECK, BlockInit.SOUL_JACK_O_LANTERN_DERP);
        reversed.put(BlockInit.SOUL_JACK_O_LANTERN_CREEPER, BlockInit.SOUL_JACK_O_LANTERN_CHECK);
        reversed.put(BlockInit.SOUL_JACK_O_LANTERN_HEROBRINE, BlockInit.SOUL_JACK_O_LANTERN_CREEPER);
        reversed.put(BlockInit.SOUL_JACK_O_LANTERN_EVIL, BlockInit.SOUL_JACK_O_LANTERN_HEROBRINE);
        reversed.put(BlockInit.SOUL_JACK_O_LANTERN_HEART, BlockInit.SOUL_JACK_O_LANTERN_EVIL);
        reversed.put(BlockInit.SOUL_JACK_O_LANTERN_SHOUT, BlockInit.SOUL_JACK_O_LANTERN_HEART);
        reversed.put(BlockInit.SOUL_JACK_O_LANTERN_NORMAL, BlockInit.SOUL_JACK_O_LANTERN_SHOUT);

        reversedPumpkinMap = reversed;
    }

}
