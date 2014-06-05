package com.renevo.pcb;

import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.IGuiHandler;

public class PortableCraftBenchGuiHandler implements IGuiHandler {

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if (id == PortableCraftBenchMod.GUI_PORTABLE_CRAFT_BENCH_ID && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == ItemPortableCraftBench.portableCraftBench)
			return new GuiPortableCraftBench(player.inventory, world, x, y, z);
		
		FMLLog.info("No GUI to show");
		return null;
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if (id == PortableCraftBenchMod.GUI_PORTABLE_CRAFT_BENCH_ID && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == ItemPortableCraftBench.portableCraftBench)
			return new ContainerPortableCraftBench(player.inventory, world, x, y, z);
		
		FMLLog.info("No GUI to show");
		
		return null;
	}

}
