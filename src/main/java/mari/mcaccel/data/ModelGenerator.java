package mari.mcaccel.data;

import mari.mcaccel.initializers.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;

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

        for (Map.Entry<Block, String> block: BlockInit.PUMPKIN_BLOCKS.entrySet()) {

            //hopefully this string check will prevent any errors8
            if(block.getValue().contains("soul_jack_o_lantern")){

            }
            else if(block.getValue().contains("jack_o_lantern")||block.getValue().contains("carved_pumpkin")){
                blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(block.getKey(),pumpkinTextureMap);
            }

        }

    }
}
