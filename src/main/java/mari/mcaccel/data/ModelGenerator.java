package mari.mcaccel.data;

import mari.mcaccel.McAccel;
import mari.mcaccel.initializers.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        TextureMap pumpkinTextureMap = TextureMap.sideEnd(Blocks.PUMPKIN);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(BlockInit.JACK_O_LANTERN_CHECK,pumpkinTextureMap);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(BlockInit.JACK_O_LANTERN_CREEPER,pumpkinTextureMap);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(BlockInit.JACK_O_LANTERN_DERP,pumpkinTextureMap);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(BlockInit.JACK_O_LANTERN_EVIL,pumpkinTextureMap);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(BlockInit.JACK_O_LANTERN_HEART,pumpkinTextureMap);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(BlockInit.JACK_O_LANTERN_HEROBRINE,pumpkinTextureMap);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(BlockInit.JACK_O_LANTERN_SMILE,pumpkinTextureMap);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(BlockInit.JACK_O_LANTERN_SHOUT,pumpkinTextureMap);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(BlockInit.JACK_O_LANTERN_X,pumpkinTextureMap);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {


    }


}
