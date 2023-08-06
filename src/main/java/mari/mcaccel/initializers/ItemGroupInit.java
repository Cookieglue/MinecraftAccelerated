package mari.mcaccel.initializers;

import mari.mcaccel.McAccel;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ItemGroupInit {


    public static final ItemGroup TEST_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(McAccel.MOD_ID, "pumpkin"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup_testing"))
                    .icon(()->new ItemStack(BlockInit.CARVED_PUMPKIN_CREEPER.asItem())).entries((displayContext, entries) -> {
                        entries.add(BlockInit.CARVED_PUMPKIN_CREEPER);
                    })
                    .build());
    public static void RegisterItemGroups(){

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            for (Map.Entry<Block, String> block: BlockInit.PUMPKIN_BLOCKS.entrySet()) {
                content.addAfter(Blocks.CARVED_PUMPKIN, block.getKey().asItem());
            }
        });

    }

}
