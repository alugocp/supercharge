package net.lugocorp.fortress;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

@Mod("examplemod")
public class OreGen{
  private final Logger logger=LogManager.getLogger();
  private final OreGenerator generator=new OreGenerator();

  public OreGen(){
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    MinecraftForge.EVENT_BUS.register(generator);
    logger.info("Supercharged: mod initialized");
  }

  private void setup(final FMLCommonSetupEvent event){
    generateOre("minecraft:ore_redstone",Blocks.REDSTONE_ORE,20,0,20,50,10);
    generateOre("minecraft:ore_lapis",Blocks.LAPIS_ORE,20,0,20,50,10);
    generateOre("minecraft:ore_iron",Blocks.IRON_ORE,20,30,0,100,30);
    generateOre("minecraft:ore_gold",Blocks.GOLD_ORE,20,20,20,50,20);
    generateOre("minecraft:ore_emerald",Blocks.EMERALD_ORE,20,0,20,50,20);
    generateOre("minecraft:ore_diamond",Blocks.DIAMOND_ORE,20,0,30,50,20);
    generateOre("minecraft:ore_coal",Blocks.COAL_ORE,20,30,0,100,30);
  }
  private void generateOre(String location,Block block,int size,int min,int offset,int max,int count){
    ConfiguredFeature<?,?> feature=Feature.ORE.withConfiguration(new OreFeatureConfig(
      OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
      block.getDefaultState(),
      size
    ))
    .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(min,offset,max)))
    .square()
    .func_242731_b(count);

    Registry<ConfiguredFeature<?, ?>> registry=WorldGenRegistries.CONFIGURED_FEATURE;
    Registry.register(registry,new ResourceLocation(location),feature);
    generator.addOre(feature);
  }

  /*@SubscribeEvent
  public static void generateOres(FMLLoadCompleteEvent e){
    for(Biome biome:ForgeRegistries.BIOMES){
      if(biome.getCategory()==Biome.Category.THEEND){ // The End

      }else if(biome.getCategory()==Biome.Category.NETHER){ // The Nether

      }else{ // Overworld
        genOre(biome,30,30,0,100,OreFeatureConfig.FillerBlockType.NATURAL_STONE,RegistryHandler.DIAMOND_ORE.get().getDefaultState(),20);
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
