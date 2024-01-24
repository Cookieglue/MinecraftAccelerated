package mari.mcaccel.mixin.entity;

import mari.mcaccel.PumpkinsAccelerated;
import mari.mcaccel.accessors.SnowGolemHeadTypeAccessor;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.SnowmanPumpkinFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SnowmanPumpkinFeatureRenderer.class)
public class SnowmanPumpkinFeatureRendererMixin{

    private ItemStack HEAD_TYPE = new ItemStack(Blocks.GLASS);


    @ModifyVariable(method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/passive/SnowGolemEntity;FFFFFF)V",
    at = @At("STORE"))
    private ItemStack itemStack(ItemStack itemStack){
        return HEAD_TYPE;
    }

    @Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/passive/SnowGolemEntity;FFFFFF)V",
    at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;<init>(Lnet/minecraft/item/ItemConvertible;)V", ordinal = 0))
    void itemStackInject(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, SnowGolemEntity snowGolemEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci){

        if (snowGolemEntity instanceof SnowGolemHeadTypeAccessor) {
            HEAD_TYPE = ((SnowGolemHeadTypeAccessor) snowGolemEntity).getHeadItemStack();
        } else {
            PumpkinsAccelerated.LOGGER.warn("Error: snowGolemEntity cannot be cast to SnowGolemHeadTypeAccessor.");
        }


    }

}
