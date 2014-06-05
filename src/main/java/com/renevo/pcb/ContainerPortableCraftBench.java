package com.renevo.pcb;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

public class ContainerPortableCraftBench extends net.minecraft.inventory.ContainerWorkbench {

	public ContainerPortableCraftBench(InventoryPlayer inventoryPlayer, World world, int x, int y, int z) {
		super(inventoryPlayer, world, x, y, z);
	}

	/**
	 * Called to transfer a stack from one inventory to the other eg. when shift
	 * clicking.
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
		ItemStack var2 = null;
		Slot var3 = (Slot) this.inventorySlots.get(slotIndex);

		if (var3 != null && var3.getHasStack()) {
			ItemStack var4 = var3.getStack();
			var2 = var4.copy();

			if (slotIndex == 0) {
				if (!this.mergeItemStack(var4, 10, 46, true)) {
					return null;
				}

				var3.onSlotChange(var4, var2);
			} else if (slotIndex >= 10 && slotIndex < 37) {
				if (!this.mergeItemStack(var4, 1, 10, false)) {
					return null;
				}
			} else if (slotIndex >= 37 && slotIndex < 46) {
				if (!this.mergeItemStack(var4, 1, 10, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(var4, 10, 46, false)) {
				return null;
			}

			if (var4.stackSize == 0) {
				var3.putStack((ItemStack) null);
			} else {
				var3.onSlotChanged();
			}

			if (var4.stackSize == var2.stackSize) {
				return null;
			}

			var3.onPickupFromSlot(player, var4);
		}

		return var2;
	}

	@Override
	public boolean canInteractWith(EntityPlayer arg0) {
		return true;
	}

}
