package com.renevo.pcb;

import net.minecraft.stats.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraftforge.fml.common.network.*;

@Mod(modid = PortableCraftBenchMod.MODID, version = PortableCraftBenchMod.VERSION)
public class PortableCraftBenchMod {
	
    public static final String MODID = "pcb";
    public static final String VERSION = "1.4";
    
    public static Achievement achievementPcb = null;
    
    public static final int GUI_PORTABLE_CRAFT_BENCH_ID = 1;
    
    @Instance(PortableCraftBenchMod.MODID)
    public static PortableCraftBenchMod instance;
    
    @SidedProxy(clientSide = "com.renevo.pcb.ClientProxy", serverSide = "com.renevo.pcb.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	ItemPortableCraftBench.create();
    	
    	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new PortableCraftBenchGuiHandler());
    	
    	MinecraftForge.EVENT_BUS.register(this);
    	FMLCommonHandler.instance().bus().register(this);
    	
    	// 6 left, 0 up/down - since we are just adding a new achievement, we don't need an achievement page, this somehow just works...
    	achievementPcb = new Achievement("achievement.pcb", "pcb", 6, 0, ItemPortableCraftBench.portableCraftBench, net.minecraft.stats.AchievementList.buildWorkBench);
    	achievementPcb.registerStat();
    	
    	proxy.initialization();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	proxy.postInitialization();
    }
    
    @SubscribeEvent
    public void onCraftItem(PlayerEvent.ItemCraftedEvent event) {
    	if (event.crafting.getItem() == ItemPortableCraftBench.portableCraftBench) {
    		event.player.addStat(achievementPcb, 1);
    	}
    }
}
