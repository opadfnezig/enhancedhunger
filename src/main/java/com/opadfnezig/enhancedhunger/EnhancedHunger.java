package com.opadfnezig.enhancedhunger;

import com.opadfnezig.enhancedhunger.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.fixes.MinecartEntityTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Entity;

import java.lang.reflect.Field;

// The value here should match an entry in the META-INF/mods.toml file

@Mod("enhancedhunger")
public class EnhancedHunger
{
    public static final String MOD_ID = "enhancedhunger";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public EnhancedHunger() {

        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);

        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);


       try {
            Item item = ForgeRegistries.ITEMS.getValue(ForgeRegistries.ITEMS.getKey(Items.APPLE));
            Field a = item.getClass().getDeclaredField("maxStackSize");
            a.setAccessible(true);
            a.set(item,1);

        }catch (Exception e){}

        // Register ourselves for server and other game events we are interested in
        VanillaModifier.modify();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("enhancedhunger", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {

    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }




    @SubscribeEvent
    public void onLivingEntityUseItemStart(final LivingEntityUseItemEvent.Start ev) {
        if(ev.getItem().getItem() == Items.CARROT || ev.getItem().getItem() == Items.POTATO || ev.getItem().getItem() == Items.SWEET_BERRIES) {
            ev.setCanceled(true);
        }
    }
                    //ev.getItem().grow(1);
    /*
    @SubscribeEvent
    public void onLivingEntityUseItemFinish(final LivingEntityUseItemEvent.Stop ev){
        if(ev.getItem().isFood())
        {

        }
    }







    @SubscribeEvent
    public void onLivingEntityUseItemFinish(final LivingEntityUseItemEvent ev){
        if(ev.getItem().isFood())
        {

        }
    }
*/
    @SubscribeEvent
    public void onItemCrafted(PlayerEvent.ItemCraftedEvent event)
    {

       /* ItemStack stack = event.getCrafting();
        CompoundNBT nbt = stack.serializeNBT();

        stack.setDamage(nbt.getInt("dumb"));*/

    }

    @SubscribeEvent
    public void registerItemColors(ColorHandlerEvent.Item event){

    }
    @SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event){

    }



    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");


        }
    }

}
