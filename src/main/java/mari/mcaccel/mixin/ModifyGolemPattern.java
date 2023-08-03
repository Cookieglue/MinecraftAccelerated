package mari.mcaccel.mixin;


import mari.mcaccel.McAccel;
import mari.mcaccel.initializers.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.pattern.BlockPattern;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Predicate;

@Mixin(CarvedPumpkinBlock.class)
public class ModifyGolemPattern {

    @Shadow
    @Mutable
    private static @Final Predicate<BlockState>IS_GOLEM_HEAD_PREDICATE = state -> state != null && (
            state.isOf(Blocks.CARVED_PUMPKIN) ||
                    state.isOf(Blocks.JACK_O_LANTERN)||
                    BlockInit.PUMPKIN_BLOCKS.containsKey(state.getBlock()));;

    /**
     * Keep old code here in case this breaks
     *
     * @Inject(method = "getSnowGolemPattern", at= @At("HEAD") )
    void modifyGolemPattern(CallbackInfoReturnable<BlockPattern> cir){
        McAccel.LOGGER.debug("FUCK");
        IS_GOLEM_HEAD_PREDICATE = state -> state != null && (
                state.isOf(Blocks.CARVED_PUMPKIN) ||
                state.isOf(Blocks.JACK_O_LANTERN)||
                BlockInit.PUMPKIN_BLOCKS.containsKey(state.getBlock()));
    };

    **/
}
