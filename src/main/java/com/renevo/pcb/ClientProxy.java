package com.renevo.pcb;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void postInitialization() {
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
	
	@Override
	public void initialization() {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ItemPortableCraftBench.portableCraftBench, 0, new ModelResourceLocation(PortableCraftBenchMod.MODID + ":" + "portableCraftBench", "inventory"));
	}
}
