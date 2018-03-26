package com.renevo.pcb;

import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.Logger;

@Mod(modid = PortableCraftBenchMod.MODID, version = PortableCraftBenchMod.VERSION)
public class PortableCraftBenchMod {
    public static final String MODID = "pcb";
    public static final String VERSION = "1.5.0";

    public static final int GUI_PORTABLE_CRAFT_BENCH_ID = 1;

    @Instance(PortableCraftBenchMod.MODID)
    public static PortableCraftBenchMod instance;

    @SidedProxy(clientSide = "com.renevo.pcb.ClientProxy", serverSide = "com.renevo.pcb.CommonProxy")
    public static CommonProxy proxy;

    public static Logger logger;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInitialization();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.initialization();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInitialization();
    }
}
