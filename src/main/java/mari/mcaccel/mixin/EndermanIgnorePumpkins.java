package mari.mcaccel.mixin;

import mari.mcaccel.initializers.BlockInit;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EndermanEntity.class)
public class EndermanIgnorePumpkins {

	@Inject(method = "isPlayerStaring", at = @At("HEAD"), cancellable = true)
    void isStaring(PlayerEntity player, CallbackInfoReturnable<Boolean> cir){

        ItemStack itemStack = player.getInventory().armor.get(3);

        if (itemStack.isOf(BlockInit.CARVED_PUMPKIN_CHECK.asItem()) ||
                        itemStack.isOf(BlockInit.CARVED_PUMPKIN_CREEPER.asItem()) ||
                        itemStack.isOf(BlockInit.CARVED_PUMPKIN_DERP.asItem()) ||
                        itemStack.isOf(BlockInit.CARVED_PUMPKIN_EVIL.asItem()) ||
                        itemStack.isOf(BlockInit.CARVED_PUMPKIN_HEART.asItem()) ||
                        itemStack.isOf(BlockInit.CARVED_PUMPKIN_HEROBRINE.asItem()) ||
                        itemStack.isOf(BlockInit.CARVED_PUMPKIN_SHOUT.asItem()) ||
                        itemStack.isOf(BlockInit.CARVED_PUMPKIN_SMILE.asItem()) ||
                        itemStack.isOf(BlockInit.CARVED_PUMPKIN_X.asItem())) {
            cir.setReturnValue(false);
        }

    }



}