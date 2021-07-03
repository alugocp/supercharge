package net.lugocorp.supercharge;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import java.util.ArrayList;
import java.util.List;

public class OreGenerator{
  private final List<ConfiguredFeature<?,?>> features=new ArrayList<>();

  @SubscribeEvent(priority=EventPriority.HIGH)
  public void registerOreGeneration(BiomeLoadingEvent evt){
    for(ConfiguredFeature<?,?> feature:features){
      evt.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,feature);
    }
  }

  // Generate ores
  void setup(){
    generate("minecraft:ore_redstone",Blocks.REDSTONE_ORE,20,0,20,50,10);
    generate("minecraft:ore_lapis",Blocks.LAPIS_ORE,20,0,20,50,10);
    generate("minecraft:ore_iron",Blocks.IRON_ORE,20,30,0,100,30);
    generate("minecraft:ore_gold",Blocks.GOLD_ORE,20,20,20,50,20);
    generate("minecraft:ore_emerald",Blocks.EMERALD_ORE,20,0,20,50,20);
    generate("minecraft:ore_diamond",Blocks.DIAMOND_ORE,20,0,30,50,20);
    generate("minecraft:ore_coal",Blocks.COAL_ORE,20,30,0,100,30);
  }
  private void generate(String location,Block block,int size,int min,int offset,int max,int count){
    ConfiguredFeature<?,?> feature=Feature.ORE.configured(new OreFeatureConfig(
      OreFeatureConfig.FillerBlockType.NATURAL_STONE,
      block.defaultBlockState(),
      size
    ))
    .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(min,offset,max)))
    .count(count)
    .squared();

    Registry<ConfiguredFeature<?,?>> registry=WorldGenRegistries.CONFIGURED_FEATURE;
    Registry.register(registry,new ResourceLocation(location),feature);
    features.add(feature);
  }
}
