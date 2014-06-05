package com.renevo.pcb;

import org.apache.logging.log4j.Level;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = PortableCraftBenchMod.MODID, version = PortableCraftBenchMod.VERSION)
public class PortableCraftBenchMod
{
    public static final String MODID = "pcb";
    public static final String VERSION = "${version}";
    
    public static final int GUI_PORTABLE_CRAFT_BENCH_ID = 1;
    
    @Instance(PortableCraftBenchMod.MODID)
    public static PortableCraftBenchMod instance;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ItemPortableCraftBench.create();
    	
    	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new PortableCraftBenchGuiHandler());
    	
    	MinecraftForge.EVENT_BUS.register(this);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	NeiIntegration.registerCraftingContainers(GuiPortableCraftBench.class);
    	
    	// probably remove these at some point, dunno....
    	
    	// tinkers
    	NeiIntegration.registerCraftingContainers("tconstruct.client.gui.CraftingStationGui");

    	// BC
    	NeiIntegration.registerCraftingContainers("buildcraft.factory.gui.GuiAutoCrafting");
    	
    	// doesn't work
    	//NeiIntegration.registerCraftingContainers("buildcraft.silicon.gui.GuiAdvancedCraftingTable");
    	
    	// Forestry is dumb...
    	// NeiIntegration.registerCraftingContainers("forestry.factory.gui.GuiWorktable");
    	
    	// Bibliocraft
    	NeiIntegration.registerCraftingContainers("jds.bibliocraft.gui.GuiFancyWorkbench");
    	
    	// Railcraft
    	NeiIntegration.registerCraftingContainers("mods.railcraft.client.gui.GuiCartWork");
    }
}
