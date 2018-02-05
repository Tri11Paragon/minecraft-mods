

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.util.EnumHelper;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.Minecraft;

import java.util.Random;

public class mcreator_wADAWDAWD {

	public mcreator_wADAWDAWD() {
	}

	public static Item helmet;
	public static Item body;
	public static Item legs;
	public static Item boots;
	public static Object instance;

	public void load(FMLInitializationEvent event) {
		if (event.getSide() == Side.CLIENT) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(helmet, 0, new ModelResourceLocation("TestEnvironmentMod:WADWA_head", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(body, 0, new ModelResourceLocation("TestEnvironmentMod:WADWA_body", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(legs, 0, new ModelResourceLocation("TestEnvironmentMod:WADWA_leggins", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(boots, 0, new ModelResourceLocation("TestEnvironmentMod:WADWA_boots", "inventory"));
		}
		helmet.setCreativeTab(CreativeTabs.COMBAT);
		body.setCreativeTab(CreativeTabs.COMBAT);
		legs.setCreativeTab(CreativeTabs.COMBAT);
		boots.setCreativeTab(CreativeTabs.COMBAT);
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
	}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
	}

	public int addFuel(ItemStack fuel) {
		return 0;
	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
	}

	public void registerRenderers() {
	}

	static {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("WADAWDAWD", "WADWA", 25, new int[]{2, 7, 5, 3}, 9, null, 0.0f);

		int armorPreffix = 0;
		helmet = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.HEAD) {
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
				int i = (int) entity.posX;
				int j = (int) entity.posY;
				int k = (int) entity.posZ;
			}
		}).setUnlocalizedName("WADWA_head");
		helmet.setMaxStackSize(1);
		body = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.CHEST) {
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
				int i = (int) entity.posX;
				int j = (int) entity.posY;
				int k = (int) entity.posZ;
			}
		}).setUnlocalizedName("WADWA_body");
		body.setMaxStackSize(1);
		legs = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.LEGS) {
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
				int i = (int) entity.posX;
				int j = (int) entity.posY;
				int k = (int) entity.posZ;
			}
		}).setUnlocalizedName("WADWA_leggins");
		legs.setMaxStackSize(1);
		boots = (new ItemArmor(enuma, armorPreffix, EntityEquipmentSlot.FEET) {
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
				int i = (int) entity.posX;
				int j = (int) entity.posY;
				int k = (int) entity.posZ;
			}
		}).setUnlocalizedName("WADWA_boots");
		boots.setMaxStackSize(1);

		GameRegistry.registerItem(helmet, "WADWA_head");
		GameRegistry.registerItem(body, "WADWA_body");
		GameRegistry.registerItem(legs, "WADWA_leggins");
		GameRegistry.registerItem(boots, "WADWA_boots");

	}

}
