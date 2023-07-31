package mari.mcaccel.data;

import mari.mcaccel.McAccel;
import mari.mcaccel.initializers.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.data.client.*;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.HashMap;
import java.util.Map;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        TextureMap pumpkinTextureMap = TextureMap.sideEnd(Blocks.PUMPKIN);

        GeneratePumpkins(blockStateModelGenerator);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {


    }


    private void GeneratePumpkins(BlockStateModelGenerator blockStateModelGenerator){

        TextureMap pumpkinTextureMap = TextureMap.sideEnd(Blocks.PUMPKIN);
        TextureMap greyPumpkinTextureMap = new TextureMap();

        for (Map.Entry<String, Block> block: BlockInit.STANDARD_BLOCKS.entrySet()) {

            //hopefully this string check will prevent any errors8
            if(block.getKey().contains("soul_jack_o_lantern")){

            }
            else if(block.getKey().contains("jack_o_lantern")||block.getKey().contains("carved_pumpkin")){
                blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(block.getValue(),pumpkinTextureMap);
            }

        }

    }
}
