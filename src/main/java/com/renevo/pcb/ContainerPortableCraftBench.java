package com.renevo.pcb;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerPortableCraftBench extends net.minecraft.inventory.ContainerWorkbench {

    public ContainerPortableCraftBench(InventoryPlayer inventoryPlayer, World world, BlockPos pos) {
        super(inventoryPlayer, world, pos);
    }

    /**
     * Called to transfer a stack from one inventory to the other eg. when shift
     * clicking.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        ItemStack stack = null;
        Slot slot = this.inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack()) {
            ItemStack slotStack = slot.getStack();
            stack = slotStack.copy();

            if (slotIndex == 0) {
                if (!this.mergeItemStack(slotStack, 10, 46, true)) {
                    return null;
                }

                slot.onSlotChange(slotStack, stack);
            } else if (slotIndex >= 10 && slotIndex < 37) {
                if (!this.mergeItemStack(slotStack, 1, 10, false)) {
                    return null;
                }
            } else if (slotIndex >= 37 && slotIndex < 46) {
                if (!this.mergeItemStack(slotStack, 1, 10, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(slotStack, 10, 46, false)) {
                return null;
            }

            if (slotStack.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (slotStack.getCount() == stack.getCount()) {
                return null;
            }

            slot.onTake(player, slotStack);
        }

        return stack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer arg0) {
        return true;
    }

}
