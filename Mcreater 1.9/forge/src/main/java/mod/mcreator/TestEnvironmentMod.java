

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.model.obj.OBJLoader;

import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;

import java.util.Random;

@Mod(modid = TestEnvironmentMod.MODID, version = TestEnvironmentMod.VERSION)
public class TestEnvironmentMod implements IFuelHandler, IWorldGenerator {

	public static final String MODID = "TestEnvironmentMod";
	public static final String VERSION = "1.0";

	@SidedProxy(clientSide = "mod.mcreator.ClientProxyTestEnvironmentMod", serverSide = "mod.mcreator.CommonProxyTestEnvironmentMod")
	public static CommonProxyTestEnvironmentMod proxy;

	@Instance(MODID)
	public static TestEnvironmentMod instance;

	mcreator_wADAWDAWD mcreator_0 = new mcreator_wADAWDAWD();
	mcreator_bLOCK mcreator_1 = new mcreator_bLOCK();

	@Override
	public int getBurnTime(ItemStack fuel) {
		if (mcreator_0.addFuel(fuel) != 0)
			return mcreator_0.addFuel(fuel);
		if (mcreator_1.addFuel(fuel) != 0)
			return mcreator_1.addFuel(fuel);
		return 0;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

		chunkX = chunkX * 16;
		chunkZ = chunkZ * 16;
		if (world.provider.getDimension() == -1)
			mcreator_0.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_0.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_1.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_1.generateSurface(world, random, chunkX, chunkZ);

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

		GameRegistry.registerFuelHandler(this);
		GameRegistry.registerWorldGenerator(this, 1);
		if (event.getSide() == Side.CLIENT) {
			OBJLoader.INSTANCE.addDomain("TestEnvironmentMod");
		}
		MinecraftForge.EVENT_BUS.register(new mcreator_GlobalEventsTestEnvironmentMod());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		mcreator_0.load(event);
		mcreator_1.load(event);
		proxy.registerRenderers(this);

	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		mcreator_0.serverLoad(event);
		mcreator_1.serverLoad(event);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		mcreator_0.instance = this.instance;
		mcreator_1.instance = this.instance;
		mcreator_0.preInit(event);
		mcreator_1.preInit(event);

	}

	public static class GuiHandler implements IGuiHandler {
		@Override
		public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			return null;
		}

		@Override
		public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			return null;
		}
	}

}
