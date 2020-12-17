package net.lugocorp.supercharge;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import java.util.ArrayList;
import java.util.List;

public class SpawnBuff{

  @SubscribeEvent(priority=EventPriority.HIGH)
  public void onBiomeLoadingEvent(BiomeLoadingEvent evt){
    List<MobSpawnInfo.Spawners> spawns=evt.getSpawns().getSpawner(EntityClassification.MONSTER);
    List<EntityType<?>> editedTypes=getEditedTypes();
    spawns.removeIf(e -> editedTypes.contains(e.type));
    spawns.add(new MobSpawnInfo.Spawners(EntityType.ZOMBIE,80,1,6));
    spawns.add(new MobSpawnInfo.Spawners(EntityType.CREEPER,60,1,6));
    spawns.add(new MobSpawnInfo.Spawners(EntityType.SPIDER,60,1,6));
    spawns.add(new MobSpawnInfo.Spawners(EntityType.SKELETON,40,1,6));
    spawns.add(new MobSpawnInfo.Spawners(EntityType.ENDERMAN,40,1,4));
    spawns.add(new MobSpawnInfo.Spawners(EntityType.SLIME,40,1,4));
    spawns.add(new MobSpawnInfo.Spawners(EntityType.VINDICATOR,40,1,4));
    spawns.add(new MobSpawnInfo.Spawners(EntityType.IRON_GOLEM,20,1,4));
    spawns.add(new MobSpawnInfo.Spawners(EntityType.RAVAGER,20,1,4));
    spawns.add(new MobSpawnInfo.Spawners(EntityType.BLAZE,20,1,4));
  }
  private List<EntityType<?>> getEditedTypes(){
    List<EntityType<?>> types=new ArrayList<>();
    types.add(EntityType.ZOMBIE);
    types.add(EntityType.CREEPER);
    types.add(EntityType.SPIDER);
    types.add(EntityType.SKELETON);
    types.add(EntityType.ENDERMAN);
    types.add(EntityType.SLIME);
    types.add(EntityType.VINDICATOR);
    types.add(EntityType.IRON_GOLEM);
    types.add(EntityType.RAVAGER);
    types.add(EntityType.BLAZE);
    return types;
  }
}
