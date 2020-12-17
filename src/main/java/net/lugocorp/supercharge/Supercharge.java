package net.lugocorp.supercharge;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("supercharge")
public class Supercharge{
  private final Logger logger=LogManager.getLogger();
  private final OreGenerator ore=new OreGenerator();
  private final SpawnBuff spawn=new SpawnBuff();
  private final ExpBoost exp=new ExpBoost();

  public Supercharge(){
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    MinecraftForge.EVENT_BUS.register(spawn);
    MinecraftForge.EVENT_BUS.register(ore);
    MinecraftForge.EVENT_BUS.register(exp);
    logger.info("Supercharge mod was initialized");
  }

  // Hooks
  private void setup(final FMLCommonSetupEvent event){
    ore.setup();
  }
}
