package net.lugocorp.fortress;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import java.util.ArrayList;
import java.util.List;

public class OreGenerator{
  private final List<ConfiguredFeature<?,?>> features=new ArrayList<>();

  void addOre(ConfiguredFeature<?,?> feature){
    features.add(feature);
  }

  @SubscribeEvent(priority=EventPriority.HIGH)
  public void registerOreGen(BiomeLoadingEvent event){
    for(ConfiguredFeature<?,?> feature:features){
      event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,feature);
    }
  }
}
