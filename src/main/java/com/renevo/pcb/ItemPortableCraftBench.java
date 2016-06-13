package com.renevo.pcb;

import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.registry.GameRegistry;
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
        portableCraftBench.setRegistryName("portableCraftBench");
        GameRegistry.register(portableCraftBench);
		GameRegistry.addShapelessRecipe(
				new ItemStack(portableCraftBench),
				new Object[] {
							Blocks.CRAFTING_TABLE,
							Items.STRING
						});
	}
	
	public ItemPortableCraftBench() {
		super();
		
		super.setMaxStackSize(1);
		super.setUnlocalizedName("portableCraftBench");
		super.setCreativeTab(CreativeTabs.TOOLS);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand) {
		if (world.isRemote) {
			return ActionResult.newResult(EnumActionResult.SUCCESS, itemStack);
		} else {
			player.openGui(PortableCraftBenchMod.instance, PortableCraftBenchMod.GUI_PORTABLE_CRAFT_BENCH_ID, world, 0, 0, 0);
			return ActionResult.newResult(EnumActionResult.SUCCESS, itemStack);
		}
	}
}
