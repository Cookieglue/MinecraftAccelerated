package mari.mcaccel;

import mari.mcaccel.initializers.BlockInit;
import mari.mcaccel.initializers.ItemGroupInit;
import net.fabricmc.api.ModInitializer;

import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class McAccel implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("mcaccel");

	public static String MOD_ID = "mcaccel";
	public static Identifier MOD_IDENTIFIER = new Identifier(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		BlockInit.InitializeBlocks();
		ItemGroupInit.RegisterItemGroups();

	}
}