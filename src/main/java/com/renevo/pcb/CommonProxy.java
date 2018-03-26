package com.renevo.pcb;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInitialization() {
        
    }

    public void initialization() {
        NetworkRegistry.INSTANCE.registerGuiHandler(PortableCraftBenchMod.instance, new PortableCraftBenchGuiHandler());
    }

    public void postInitialization() {

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemPortableCraftBench());
    }
}
