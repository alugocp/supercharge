package net.lugocorp.supercharge;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ExpBoost{
  private static final int FACTOR=8;

  @SubscribeEvent(priority=EventPriority.HIGH)
  public void multiplyExperience(LivingExperienceDropEvent evt){
    int exp=evt.getDroppedExperience();
    evt.setDroppedExperience(FACTOR*exp);
  }
}
