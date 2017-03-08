package com.renevo.pcb;

import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class PortableCraftBenchGuiHandler implements IGuiHandler {

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == PortableCraftBenchMod.GUI_PORTABLE_CRAFT_BENCH_ID && player.getHeldItemMainhand().getItem() == ItemPortableCraftBench.portableCraftBench)
            return new GuiPortableCraftBench(player.inventory, world, new BlockPos(x, y, z));

        if (id == PortableCraftBenchMod.GUI_PORTABLE_CRAFT_BENCH_ID && player.getHeldItemOffhand().getItem() == ItemPortableCraftBench.portableCraftBench)
            return new GuiPortableCraftBench(player.inventory, world, new BlockPos(x, y, z));

        return null;
    }

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == PortableCraftBenchMod.GUI_PORTABLE_CRAFT_BENCH_ID && player.getHeldItemMainhand().getItem() == ItemPortableCraftBench.portableCraftBench)
            return new ContainerPortableCraftBench(player.inventory, world, new BlockPos(x, y, z));

        if (id == PortableCraftBenchMod.GUI_PORTABLE_CRAFT_BENCH_ID && player.getHeldItemOffhand().getItem() == ItemPortableCraftBench.portableCraftBench)
            return new ContainerPortableCraftBench(player.inventory, world, new BlockPos(x, y, z));

        return null;
    }
}
