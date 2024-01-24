package mari.mcaccel.data;

import mari.mcaccel.initializers.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    int counter;

    List<Map.Entry<Block, String>> pumpkinList;
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        pumpkinList = new ArrayList<Map.Entry<Block, String>>(BlockInit.PUMPKIN_BLOCKS.entrySet());


        for (int i = 0; i < 9; i++) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, pumpkinList.get(i+9).getKey())
                    .pattern("P")
                    .pattern("T")
                    .input('P', pumpkinList.get(i).getKey().asItem())
                    .input('T', Items.TORCH)
                    .criterion(FabricRecipeProvider.hasItem(pumpkinList.get(i).getKey()),
                            FabricRecipeProvider.conditionsFromItem(Items.TORCH))
                    .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(pumpkinList.get(i+9).getKey())));

            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, pumpkinList.get(i+18).getKey())
                    .pattern("P")
                    .pattern("T")
                    .input('P', pumpkinList.get(i).getKey().asItem())
                    .input('T', Items.SOUL_TORCH)
                    .criterion(FabricRecipeProvider.hasItem(pumpkinList.get(i).getKey()),
                            FabricRecipeProvider.conditionsFromItem(Items.SOUL_TORCH))
                    .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(pumpkinList.get(i+18).getKey())));
        }

    }

}
