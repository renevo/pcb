package com.renevo.pcb;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class ItemPortableCraftBench extends Item {

	public static Item portableCraftBench;
	
	public static void create() {
		portableCraftBench = new ItemPortableCraftBench();
		GameRegistry.registerItem(portableCraftBench, "portableCraftBench");
		GameRegistry.addShapelessRecipe(
				new ItemStack(portableCraftBench), 
				new Object[] { 
							Blocks.crafting_table, 
							Items.string 
						});
	}
	
	public ItemPortableCraftBench() {
		super();
		
		setMaxStackSize(1);
		setUnlocalizedName("portableCraftBench");
		setCreativeTab(CreativeTabs.tabTools);
		setTextureName(PortableCraftBenchMod.MODID + ":" + "portableCraftBench");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		
		if (world.isRemote){
			return player.getCurrentEquippedItem();
		} else {
			player.openGui(PortableCraftBenchMod.instance, PortableCraftBenchMod.GUI_PORTABLE_CRAFT_BENCH_ID, world, 0, 0, 0);
			return player.getCurrentEquippedItem();
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(PortableCraftBenchMod.MODID + ":" + "portableCraftBench");
	}
}
