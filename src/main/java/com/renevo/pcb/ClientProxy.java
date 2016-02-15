package com.renevo.pcb;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void postInitialization() {
    	// NeiIntegration.registerCraftingContainers(GuiPortableCraftBench.class); // TODO: re-enable once NEI is available again
    	
	}
	
	@Override
	public void initialization() {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ItemPortableCraftBench.portableCraftBench, 0, new ModelResourceLocation(PortableCraftBenchMod.MODID + ":" + "portableCraftBench", "inventory"));
	}
}
