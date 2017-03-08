package com.renevo.pcb.integration;

import com.renevo.pcb.ContainerPortableCraftBench;
import com.renevo.pcb.GuiPortableCraftBench;

import mezz.jei.api.*;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;

@JEIPlugin
public class PortableCraftBenchPlugin implements IModPlugin {
    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {

    }

    @Override
    public void registerIngredients(IModIngredientRegistration registry) {

    }

    @Override
    public void register(IModRegistry registry) {
        registry.addRecipeClickArea(GuiPortableCraftBench.class, 88, 32, 28, 23, VanillaRecipeCategoryUid.CRAFTING);

        IRecipeTransferRegistry recipeTransferRegistry = registry.getRecipeTransferRegistry();
        recipeTransferRegistry.addRecipeTransferHandler(ContainerPortableCraftBench.class, VanillaRecipeCategoryUid.CRAFTING, 1, 9, 10, 36);
    }
}
