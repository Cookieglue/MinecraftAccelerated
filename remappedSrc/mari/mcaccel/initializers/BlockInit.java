package mari.mcaccel.initializers;

import mari.mcaccel.PumpkinsAccelerated;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Wearable;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class BlockInit {

    private static final FabricBlockSettings BASIC_PUMPKIN_SETTINGS = FabricBlockSettings.copyOf(Blocks.CARVED_PUMPKIN);
    public static final Block CARVED_PUMPKIN_CHECK  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS);
    public static final Block CARVED_PUMPKIN_CREEPER  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS);
    public static final Block CARVED_PUMPKIN_DERP  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS);
    public static final Block CARVED_PUMPKIN_EVIL  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS);
    public static final Block CARVED_PUMPKIN_HEART  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS);
    public static final Block CARVED_PUMPKIN_HEROBRINE  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS);
    public static final Block CARVED_PUMPKIN_SHOUT  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS);
    public static final Block CARVED_PUMPKIN_SMILE  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS);
    public static final Block CARVED_PUMPKIN_X  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS);

    public static final Block JACK_O_LANTERN_CHECK  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));
    public static final Block JACK_O_LANTERN_CREEPER  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));
    public static final Block JACK_O_LANTERN_DERP  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));
    public static final Block JACK_O_LANTERN_EVIL  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));
    public static final Block JACK_O_LANTERN_HEART  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));
    public static final Block JACK_O_LANTERN_HEROBRINE  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));
    public static final Block JACK_O_LANTERN_SHOUT  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));
    public static final Block JACK_O_LANTERN_SMILE  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));
    public static final Block JACK_O_LANTERN_X  = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));

    public static final Block SOUL_JACK_O_LANTERN_CHECK = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));
    public static final Block SOUL_JACK_O_LANTERN_CREEPER = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));
    public static final Block SOUL_JACK_O_LANTERN_DERP = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));
    public static final Block SOUL_JACK_O_LANTERN_EVIL = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));
    public static final Block SOUL_JACK_O_LANTERN_HEART = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));
    public static final Block SOUL_JACK_O_LANTERN_HEROBRINE = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));
    public static final Block SOUL_JACK_O_LANTERN_SHOUT = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));
    public static final Block SOUL_JACK_O_LANTERN_SMILE = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));
    public static final Block SOUL_JACK_O_LANTERN_X = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));
    public static final Block SOUL_JACK_O_LANTERN_NORMAL = new CarvedPumpkinBlock(BASIC_PUMPKIN_SETTINGS.luminance(15));

    public static final LinkedHashMap<Block, String> PUMPKIN_BLOCKS;
    static {
        LinkedHashMap<Block, String> map = new LinkedHashMap<>();
        map.put(CARVED_PUMPKIN_X, "carved_pumpkin_x");
        map.put(CARVED_PUMPKIN_SMILE, "carved_pumpkin_smile");
        map.put(CARVED_PUMPKIN_DERP, "carved_pumpkin_derp");
        map.put(CARVED_PUMPKIN_CHECK, "carved_pumpkin_check");
        map.put(CARVED_PUMPKIN_CREEPER, "carved_pumpkin_creeper");
        map.put(CARVED_PUMPKIN_HEROBRINE, "carved_pumpkin_herobrine");
        map.put(CARVED_PUMPKIN_EVIL, "carved_pumpkin_evil");
        map.put(CARVED_PUMPKIN_HEART, "carved_pumpkin_heart");
        map.put(CARVED_PUMPKIN_SHOUT, "carved_pumpkin_shout");

        map.put(JACK_O_LANTERN_X, "jack_o_lantern_x");
        map.put(JACK_O_LANTERN_SMILE, "jack_o_lantern_smile");
        map.put(JACK_O_LANTERN_DERP, "jack_o_lantern_derp");
        map.put(JACK_O_LANTERN_CHECK, "jack_o_lantern_check");
        map.put(JACK_O_LANTERN_CREEPER, "jack_o_lantern_creeper");
        map.put(JACK_O_LANTERN_HEROBRINE, "jack_o_lantern_herobrine");
        map.put(JACK_O_LANTERN_EVIL, "jack_o_lantern_evil");
        map.put(JACK_O_LANTERN_HEART, "jack_o_lantern_heart");
        map.put(JACK_O_LANTERN_SHOUT, "jack_o_lantern_shout");

        map.put(SOUL_JACK_O_LANTERN_X, "soul_jack_o_lantern_x");
        map.put(SOUL_JACK_O_LANTERN_SMILE, "soul_jack_o_lantern_smile");
        map.put(SOUL_JACK_O_LANTERN_DERP, "soul_jack_o_lantern_derp");
        map.put(SOUL_JACK_O_LANTERN_CHECK, "soul_jack_o_lantern_check");
        map.put(SOUL_JACK_O_LANTERN_CREEPER, "soul_jack_o_lantern_creeper");
        map.put(SOUL_JACK_O_LANTERN_HEROBRINE, "soul_jack_o_lantern_herobrine");
        map.put(SOUL_JACK_O_LANTERN_EVIL, "soul_jack_o_lantern_evil");
        map.put(SOUL_JACK_O_LANTERN_HEART, "soul_jack_o_lantern_heart");
        map.put(SOUL_JACK_O_LANTERN_SHOUT, "soul_jack_o_lantern_shout");
        map.put(SOUL_JACK_O_LANTERN_NORMAL, "soul_jack_o_lantern_normal");

        PUMPKIN_BLOCKS = map;
    }
    public static void InitializeBlocks(){

        SetupBasicBlocks();
        

    }
    private static void SetupBasicBlocks(){

        for (Map.Entry<Block, String> block: PUMPKIN_BLOCKS.entrySet()) {


            Registry.register(Registry.BLOCK, new Identifier(PumpkinsAccelerated.MOD_ID, block.getValue()), block.getKey());
            Registry.register(Registry.ITEM, new Identifier(PumpkinsAccelerated.MOD_ID, block.getValue()), new BlockItem(block.getKey(), new FabricItemSettings()));

        }
        
    }

}
