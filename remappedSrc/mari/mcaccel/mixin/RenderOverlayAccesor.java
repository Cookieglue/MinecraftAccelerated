package mari.mcaccel.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(InGameHud.class)
public interface RenderOverlayAccesor {

    @Invoker("renderOverlay")
    public abstract void invokeAccessOverlay(Identifier texture, float opacity);


}
