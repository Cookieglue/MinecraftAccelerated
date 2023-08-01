package mari.mcaccel.mixin;

import mari.mcaccel.initializers.BlockInit;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class ClientMixins {

    private static final Identifier PUMPKIN_BLUR = new Identifier("minecraft","textures/misc/pumpkinblur.png");
    @Shadow @Final private MinecraftClient client;

    @Inject(method = "render", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/entity/player/PlayerInventory;getArmorStack(I)Lnet/minecraft/item/ItemStack;",
            shift = At.Shift.AFTER), cancellable = true)

    void addNewPumpkinOverlays(DrawContext context, float tickDelta, CallbackInfo ci) {


        ItemStack itemStack = this.client.player.getInventory().getArmorStack(3);
        if (itemStack.isOf(BlockInit.CARVED_PUMPKIN_CREEPER.asItem()) ||
                itemStack.isOf(BlockInit.CARVED_PUMPKIN_CREEPER.asItem()) ||
                itemStack.isOf(BlockInit.CARVED_PUMPKIN_DERP.asItem()) ||
                itemStack.isOf(BlockInit.CARVED_PUMPKIN_EVIL.asItem()) ||
                itemStack.isOf(BlockInit.CARVED_PUMPKIN_HEART.asItem()) ||
                itemStack.isOf(BlockInit.CARVED_PUMPKIN_HEROBRINE.asItem()) ||
                itemStack.isOf(BlockInit.CARVED_PUMPKIN_SHOUT.asItem()) ||
                itemStack.isOf(BlockInit.CARVED_PUMPKIN_SMILE.asItem()) ||
                itemStack.isOf(BlockInit.CARVED_PUMPKIN_X.asItem()))
        {

            ((RenderOverlayAccesor) this).invokeAccessOverlay(context, PUMPKIN_BLUR, 1.0f);

        }

    }



}
