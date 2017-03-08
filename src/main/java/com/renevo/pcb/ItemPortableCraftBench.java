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
import net.minecraftforge.oredict.OreDictionary;

public class ItemPortableCraftBench extends Item {

    public static Item portableCraftBench;

    public static void create() {
        portableCraftBench = new ItemPortableCraftBench();
        portableCraftBench.setRegistryName("portable_craft_bench");
        GameRegistry.register(portableCraftBench);
        GameRegistry.addShapelessRecipe(
                new ItemStack(portableCraftBench),
                Blocks.CRAFTING_TABLE,
                Items.STRING);

        // adds the pcb as a workbench in the Ore Dictionary
        OreDictionary.registerOre("workbench", portableCraftBench);
    }

    public ItemPortableCraftBench() {
        super();

        super.setMaxStackSize(1);
        super.setUnlocalizedName("portable_craft_bench");
        super.setCreativeTab(CreativeTabs.TOOLS);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack item = player.getHeldItem(hand);

        if (!world.isRemote && item.getItem() == this) {
            player.openGui(PortableCraftBenchMod.instance, PortableCraftBenchMod.GUI_PORTABLE_CRAFT_BENCH_ID, world, 0, 0, 0);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }
}
