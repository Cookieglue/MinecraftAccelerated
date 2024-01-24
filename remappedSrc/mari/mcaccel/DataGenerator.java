package mari.mcaccel;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        /**
         * datagen doesnt work for 1.19, but its okay since data was already generated in 1.20
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModelGenerator::new);
        pack.addProvider(LootTableGenerator::new);
        pack.addProvider(RecipeGenerator::new);
         **/
    }
}
