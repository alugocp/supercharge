package net.lugocorp.supercharge;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;

public class ExpBoost{
  private static final int FACTOR=4;

  @SubscribeEvent(priority=EventPriority.HIGH)
  public void multiplyExperience(LivingExperienceDropEvent evt){
    int exp=evt.getDroppedExperience();
    evt.setDroppedExperience(FACTOR*exp);
  }
}
