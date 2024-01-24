package mari.mcaccel.initializers;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.Map;

public class ItemGroupInit {

    public static void RegisterItemGroups(){

        
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            for (Map.Entry<Block, String> block: BlockInit.PUMPKIN_BLOCKS.entrySet()) {
                content.addAfter(Blocks.CARVED_PUMPKIN, block.getKey().asItem());
            }
        });

    }

}
