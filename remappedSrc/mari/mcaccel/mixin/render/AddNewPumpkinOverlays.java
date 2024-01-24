package mari.mcaccel.mixin.render;

import mari.mcaccel.PumpkinsAccelerated;
import mari.mcaccel.initializers.BlockInit;
import mari.mcaccel.mixin.RenderOverlayAccesor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class AddNewPumpkinOverlays {

    private static final Identifier PUMPKIN_BLUR_CREEPER = new Identifier(PumpkinsAccelerated.MOD_ID,"textures/misc/pumpkin_blur_creeper.png");
    private static final Identifier PUMPKIN_BLUR_DERP = new Identifier(PumpkinsAccelerated.MOD_ID,"textures/misc/pumpkin_blur_derp.png");
    private static final Identifier PUMPKIN_BLUR_EVIL = new Identifier(PumpkinsAccelerated.MOD_ID,"textures/misc/pumpkin_blur_evil.png");
    private static final Identifier PUMPKIN_BLUR_HEART = new Identifier(PumpkinsAccelerated.MOD_ID,"textures/misc/pumpkin_blur_heart.png");
    private static final Identifier PUMPKIN_BLUR_HEROBRINE = new Identifier(PumpkinsAccelerated.MOD_ID,"textures/misc/pumpkin_blur_herobrine.png");
    private static final Identifier PUMPKIN_BLUR_SHOUT = new Identifier(PumpkinsAccelerated.MOD_ID,"textures/misc/pumpkin_blur_shout.png");
    private static final Identifier PUMPKIN_BLUR_SMILE = new Identifier(PumpkinsAccelerated.MOD_ID,"textures/misc/pumpkin_blur_smile.png");
    private static final Identifier PUMPKIN_BLUR_X = new Identifier(PumpkinsAccelerated.MOD_ID,"textures/misc/pumpkin_blur_x.png");
    private static final Identifier PUMPKIN_BLUR_CHECK = new Identifier(PumpkinsAccelerated.MOD_ID,"textures/misc/pumpkin_blur_check.png");
    @Shadow @Final private MinecraftClient client;
    @Inject(method = "render", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/entity/player/PlayerInventory;getArmorStack(I)Lnet/minecraft/item/ItemStack;",
            shift = At.Shift.AFTER), cancellable = true)

    void addNewPumpkinOverlays(MatrixStack matrices, float tickDelta, CallbackInfo ci) {

        RenderOverlayAccesor overlayAccesor = ((RenderOverlayAccesor) this);

        ItemStack itemStack = this.client.player.getInventory().getArmorStack(3) ;
        if (itemStack.isOf(BlockInit.CARVED_PUMPKIN_CREEPER.asItem()))
            overlayAccesor.invokeAccessOverlay(PUMPKIN_BLUR_CREEPER, 1.0f);

        else if (itemStack.isOf(BlockInit.CARVED_PUMPKIN_DERP.asItem()))
            overlayAccesor.invokeAccessOverlay( PUMPKIN_BLUR_DERP, 1.0f);

        else if (itemStack.isOf(BlockInit.CARVED_PUMPKIN_EVIL.asItem()))
            overlayAccesor.invokeAccessOverlay(PUMPKIN_BLUR_EVIL, 1.0f);

        else if (itemStack.isOf(BlockInit.CARVED_PUMPKIN_HEART.asItem()))
            overlayAccesor.invokeAccessOverlay(PUMPKIN_BLUR_HEART, 1.0f);

        else if (itemStack.isOf(BlockInit.CARVED_PUMPKIN_HEROBRINE.asItem()))
            overlayAccesor.invokeAccessOverlay(PUMPKIN_BLUR_HEROBRINE, 1.0f);

        else if (itemStack.isOf(BlockInit.CARVED_PUMPKIN_SHOUT.asItem()))
            overlayAccesor.invokeAccessOverlay(PUMPKIN_BLUR_SHOUT, 1.0f);

        else if (itemStack.isOf(BlockInit.CARVED_PUMPKIN_SMILE.asItem()))
            overlayAccesor.invokeAccessOverlay(PUMPKIN_BLUR_SMILE, 1.0f);

        else if (itemStack.isOf(BlockInit.CARVED_PUMPKIN_CHECK.asItem()))
            overlayAccesor.invokeAccessOverlay( PUMPKIN_BLUR_CHECK, 1.0f);

        else if (itemStack.isOf(BlockInit.CARVED_PUMPKIN_X.asItem()))
            overlayAccesor.invokeAccessOverlay( PUMPKIN_BLUR_X, 1.0f);


    }




}
