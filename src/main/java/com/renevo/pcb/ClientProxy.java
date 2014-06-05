package com.renevo.pcb;

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
}
