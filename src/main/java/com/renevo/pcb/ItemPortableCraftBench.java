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
							Blocks.crafting_table,
							Items.string
						});
	}
	
	public ItemPortableCraftBench() {
		super();
		
		setMaxStackSize(1);
		setUnlocalizedName("portableCraftBench");
		setCreativeTab(CreativeTabs.tabTools);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand) {
		if (world.isRemote) {
			return ActionResult.newResult(EnumActionResult.PASS, itemStack);
		} else {
			player.openGui(PortableCraftBenchMod.instance, PortableCraftBenchMod.GUI_PORTABLE_CRAFT_BENCH_ID, world, 0, 0, 0);
			return ActionResult.newResult(EnumActionResult.SUCCESS, itemStack);
		}
	}
}
