package net.lugocorp.supercharge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityLeaveWorldEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.CheckSpawn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.Event;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.EntityType;

public class PigSpawnCap{
  private final static int MAX_PIGS=30;
  private int pigs=0;

  // Keep track of pigs
  @SubscribeEvent(priority=EventPriority.HIGH)
  public void pigSpawnHandler(EntityJoinWorldEvent evt){
    if(evt.getEntity().getType()==EntityType.PIG){
      pigs++;
    }
  }
  @SubscribeEvent(priority=EventPriority.HIGH)
  public void pigDespawnHandler(EntityLeaveWorldEvent evt){
    if(evt.getEntity().getType()==EntityType.PIG){
      pigs--;
    }
  }

  // Check whether to naturally spawn more
  @SubscribeEvent(priority=EventPriority.HIGH)
  public void canPigSpawnHandler(LivingSpawnEvent.CheckSpawn evt){
    if(evt.getEntity().getType()==EntityType.PIG && evt.getSpawnReason()==SpawnReason.NATURAL){
      evt.setResult(pigs<30?Event.Result.ALLOW:Event.Result.DENY);
    }
  }
}
