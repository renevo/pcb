package com.renevo.pcb.integration;

import java.lang.reflect.Method;

import org.apache.logging.log4j.Level;

import net.minecraftforge.fml.common.FMLLog;

public final class NeiIntegration
{
    private NeiIntegration() {}

	public static void registerCraftingContainers(Class<?> craftingContainer) {
		try {
            Class<?> API = Class.forName("codechicken.nei.api.API");
            Class<?> IOverlayHandler = Class.forName("codechicken.nei.api.IOverlayHandler");
            Class<?> defaultOverlayHandler = Class.forName("codechicken.nei.recipe.DefaultOverlayHandler");
            
            Method registerGuiOverlayMethod = API.getMethod("registerGuiOverlay", new Class[] { Class.class, String.class });
            Method registerGuiOverlayHandlerMethod = API.getMethod("registerGuiOverlayHandler", new Class[] { Class.class, IOverlayHandler, String.class });
            
            registerGuiOverlayMethod.invoke((Object)null, new Object[]{ craftingContainer, "crafting" });
            registerGuiOverlayHandlerMethod.invoke((Object)null, new Object[]{ craftingContainer, defaultOverlayHandler.newInstance(), "crafting" });
            FMLLog.log(Level.INFO, "NEI integration of " + craftingContainer.getName() + " was successful");
        }
        catch (Throwable ex) {
        	FMLLog.log(Level.WARN, "NEI integration of " + craftingContainer.getName() + " failed:" + ex.getMessage() + " missing");
        }
	}
}
