package com.renevo.pcb;

import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.*;

public class ItemPortableCraftBench extends Item {

    @GameRegistry.ObjectHolder("pcb:portable_craft_bench")
    public static ItemPortableCraftBench item;

    public ItemPortableCraftBench() {
        super();

        super.setMaxStackSize(1);
        super.setRegistryName("portable_craft_bench");
        super.setUnlocalizedName(PortableCraftBenchMod.MODID+".portable_craft_bench");
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
