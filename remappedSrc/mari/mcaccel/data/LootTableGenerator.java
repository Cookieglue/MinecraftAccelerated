package mari.mcaccel.data;

import mari.mcaccel.initializers.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;

import java.util.Map;

public class LootTableGenerator extends FabricBlockLootTableProvider {



    public LootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        for (Map.Entry<Block, String> block: BlockInit.PUMPKIN_BLOCKS.entrySet()) {

            addDrop(block.getKey());

        }
    }


}
