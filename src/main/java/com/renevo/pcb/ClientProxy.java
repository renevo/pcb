package com.renevo.pcb;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class ClientProxy extends CommonProxy {

    @Override
    public void initialization() {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ItemPortableCraftBench.portableCraftBench, 0, new ModelResourceLocation(PortableCraftBenchMod.MODID + ":" + "portable_craft_bench", "inventory"));
    }
}
