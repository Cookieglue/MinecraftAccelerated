package mari.mcaccel.client;

import mari.mcaccel.initializers.BlockInit;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
public class ClientHudFeatures implements HudRenderCallback {

    private static final Identifier PUMPKIN_BLUR = new Identifier("assets/minecraft","textures/misc/pumpkinblur.png");


    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {

        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null){

            ItemStack itemStack = client.player.getInventory().getArmorStack(3);
            if (itemStack.isOf(BlockInit.CARVED_PUMPKIN_CREEPER.asItem())) {
                //this.renderOverlay(context, PUMPKIN_BLUR, 1.0f);

            }

        }

    }

}
