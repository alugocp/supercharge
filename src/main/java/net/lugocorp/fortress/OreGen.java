package net.lugocorp.fortress;
/*import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.block.BlockState;*/

//@Mod.EventBusSubscriber(modid="examplemod",bus=Mod.EventBusSubscriber.Bus.MOD)
public class OreGen{

  /*@SubscribeEvent
  public static void generateOres(FMLLoadCompleteEvent e){
    for(Biome biome:ForgeRegistries.BIOMES){
      if(biome.getCategory()==Biome.Category.THEEND){ // The End

      }else if(biome.getCategory()==Biome.Category.NETHER){ // The Nether

      }else{ // Overworld
        genOre(biome,20,8,5,50,OreFeatureConfig.FillerBlockType.NATURAL_STONE,RegistryHandler.GOLD_ORE.get().getDefaultState(),12);
      }
    }
  }

  private static void genOre(Biome biome,int count,int bottomOffset,int topOffset,int max,OreFeatureConfig.FillerBlockType filler,BlockState defaultState,int size){
    CountRangeConfig range=new CountRangeConfig(count,bottomOffset,topOffset,max);
    OreFeatureConfig feature=new OreFeatureConfig(filler,defaultState,size);
    ConfiguredPlacement config=Placement.COUNT_RANGE.configure(range);
    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Feature.ORE.withConfiguration(feature).withPlacement(config));
  }*/

}
