package mari.mcaccel.initializers;

import joptsimple.util.KeyValuePair;
import mari.mcaccel.McAccel;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BlockInit {

    public static final Block CARVED_PUMPKIN_CHECK  = new WearableCarvedPumpkinBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CARVED_PUMPKIN_CREEPER  = new WearableCarvedPumpkinBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CARVED_PUMPKIN_DERP  = new WearableCarvedPumpkinBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CARVED_PUMPKIN_EVIL  = new WearableCarvedPumpkinBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CARVED_PUMPKIN_HEART  = new WearableCarvedPumpkinBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CARVED_PUMPKIN_HEROBRINE  = new WearableCarvedPumpkinBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CARVED_PUMPKIN_SHOUT  = new WearableCarvedPumpkinBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CARVED_PUMPKIN_SMILE  = new WearableCarvedPumpkinBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CARVED_PUMPKIN_X  = new WearableCarvedPumpkinBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));

    public static final Block JACK_O_LANTERN_CHECK  = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));
    public static final Block JACK_O_LANTERN_CREEPER  = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));
    public static final Block JACK_O_LANTERN_DERP  = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));
    public static final Block JACK_O_LANTERN_EVIL  = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));
    public static final Block JACK_O_LANTERN_HEART  = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));
    public static final Block JACK_O_LANTERN_HEROBRINE  = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));
    public static final Block JACK_O_LANTERN_SHOUT  = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));
    public static final Block JACK_O_LANTERN_SMILE  = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));
    public static final Block JACK_O_LANTERN_X  = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));

    public static final Block SOUL_JACK_O_LANTERN_CHECK = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));
    public static final Block SOUL_JACK_O_LANTERN_CREEPER = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));
    public static final Block SOUL_JACK_O_LANTERN_DERP = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));
    public static final Block SOUL_JACK_O_LANTERN_EVIL = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));
    public static final Block SOUL_JACK_O_LANTERN_HEART = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));
    public static final Block SOUL_JACK_O_LANTERN_HEROBRINE = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));
    public static final Block SOUL_JACK_O_LANTERN_SHOUT = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));
    public static final Block SOUL_JACK_O_LANTERN_SMILE = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));
    public static final Block SOUL_JACK_O_LANTERN_X = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));

    public static final Block SOUL_JACK_O_LANTERN_NORMAL = new CarvedPumpkinBlock(FabricBlockSettings.create().luminance(14).sounds(BlockSoundGroup.WOOD));

    public static final HashMap<String, Block> STANDARD_BLOCKS;
    static {
        HashMap<String, Block> map = new HashMap<>();
        map.put("carved_pumpkin_x", CARVED_PUMPKIN_X);
        map.put("carved_pumpkin_smile", CARVED_PUMPKIN_SMILE);
        map.put("carved_pumpkin_derp", CARVED_PUMPKIN_DERP);
        map.put("carved_pumpkin_check", CARVED_PUMPKIN_CHECK);
        map.put("carved_pumpkin_creeper", CARVED_PUMPKIN_CREEPER);
        map.put("carved_pumpkin_herobrine", CARVED_PUMPKIN_HEROBRINE);
        map.put("carved_pumpkin_evil", CARVED_PUMPKIN_EVIL);
        map.put("carved_pumpkin_heart", CARVED_PUMPKIN_HEART);
        map.put("carved_pumpkin_shout", CARVED_PUMPKIN_SHOUT);

        map.put("jack_o_lantern_x", JACK_O_LANTERN_X);
        map.put("jack_o_lantern_smile", JACK_O_LANTERN_SMILE);
        map.put("jack_o_lantern_derp", JACK_O_LANTERN_DERP);
        map.put("jack_o_lantern_check", JACK_O_LANTERN_CHECK);
        map.put("jack_o_lantern_creeper", JACK_O_LANTERN_CREEPER);
        map.put("jack_o_lantern_herobrine", JACK_O_LANTERN_HEROBRINE);
        map.put("jack_o_lantern_evil", JACK_O_LANTERN_EVIL);
        map.put("jack_o_lantern_heart", JACK_O_LANTERN_HEART);
        map.put("jack_o_lantern_shout", JACK_O_LANTERN_SHOUT);

        map.put("soul_jack_o_lantern_x", SOUL_JACK_O_LANTERN_X);
        map.put("soul_jack_o_lantern_smile", SOUL_JACK_O_LANTERN_SMILE);
        map.put("soul_jack_o_lantern_derp", SOUL_JACK_O_LANTERN_DERP);
        map.put("soul_jack_o_lantern_check", SOUL_JACK_O_LANTERN_CHECK);
        map.put("soul_jack_o_lantern_creeper", SOUL_JACK_O_LANTERN_CREEPER);
        map.put("soul_jack_o_lantern_herobrine", SOUL_JACK_O_LANTERN_HEROBRINE);
        map.put("soul_jack_o_lantern_evil", SOUL_JACK_O_LANTERN_EVIL);
        map.put("soul_jack_o_lantern_heart", SOUL_JACK_O_LANTERN_HEART);
        map.put("soul_jack_o_lantern_shout", SOUL_JACK_O_LANTERN_SHOUT);
        map.put("soul_jack_o_lantern_normal", SOUL_JACK_O_LANTERN_NORMAL);

        STANDARD_BLOCKS = map;
    }

    public static void InitializeBlocks(){

        SetupBasicBlocks();
        

    }
    private static void SetupBasicBlocks(){

        for (Map.Entry<String, Block> block: STANDARD_BLOCKS.entrySet()) {

            Registry.register(Registries.BLOCK, new Identifier(McAccel.MOD_ID, block.getKey()), block.getValue());
            Registry.register(Registries.ITEM, new Identifier(McAccel.MOD_ID, block.getKey()), new BlockItem(block.getValue(), new FabricItemSettings()));

        }
        
    }

}
