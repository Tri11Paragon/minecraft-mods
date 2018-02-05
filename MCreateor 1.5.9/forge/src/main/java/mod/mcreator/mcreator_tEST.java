package mod.mcreator;//based on master condiguration

import cpw.mods.fml.client.*;
import cpw.mods.fml.client.registry.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.asm.*;
import cpw.mods.fml.common.asm.transformers.*;
import cpw.mods.fml.common.discovery.*;
import cpw.mods.fml.common.discovery.asm.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.functions.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.registry.*;
import cpw.mods.fml.common.toposort.*;
import cpw.mods.fml.common.versioning.*;
import cpw.mods.fml.relauncher.*;
import cpw.mods.fml.server.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.*;
import net.minecraft.client.audio.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.achievement.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.client.model.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.culling.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.client.settings.*;
import net.minecraft.command.*;
import net.minecraft.crash.*;
import net.minecraft.creativetab.*;
import net.minecraft.dispenser.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.rcon.*;
import net.minecraft.pathfinding.*;
import net.minecraft.potion.*;
import net.minecraft.profiler.*;
import net.minecraft.server.*;
import net.minecraft.server.dedicated.*;
import net.minecraft.server.gui.*;
import net.minecraft.server.integrated.*;
import net.minecraft.server.management.*;
import net.minecraft.src.*;
import net.minecraft.stats.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.village.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.world.demo.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.layer.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.world.storage.*;
import net.minecraftforge.classloading.*;
import net.minecraftforge.client.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.client.event.sound.*;
import net.minecraftforge.common.*;
import net.minecraftforge.event.*;
import net.minecraftforge.event.entity.*;
import net.minecraftforge.event.entity.item.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.minecart.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.terraingen.*;
import net.minecraftforge.event.world.*;
import net.minecraftforge.oredict.*;
import net.minecraftforge.transformers.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraftforge.common.util.*;

import org.lwjgl.opengl.GL11;



@SuppressWarnings("unchecked")
public class mcreator_tEST{

public mcreator_tEST(){}

public static Item block;public static Object instance;public void load(){
}
public void generateNether(World world, Random random, int chunkX, int chunkZ){}
public void generateSurface(World world, Random random, int chunkX, int chunkZ){}
public int addFuel(ItemStack fuel){return 0;}
public void serverLoad(FMLServerStartingEvent event){}
public void preInit(FMLPreInitializationEvent event){}
public void registerRenderers(){
}


static{
block = (new ItemtEST(425));
Item.itemRegistry.addObject(425, "TEST", block);

}

static class ItemtEST extends Item{

public ItemtEST(int par1){
setMaxDamage(0);
maxStackSize = 64;
setUnlocalizedName("TEST");
setTextureName("sda");
setCreativeTab(CreativeTabs.tabBlock);
setContainerItem(this);
}
public int getItemEnchantability()
{
    return 0;
}
public int getMaxItemUseDuration(ItemStack par1ItemStack)
{
    return 0;
}
public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
{
    return 1.0F;
}
public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity){
float var4 = 1.0F;
int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);

if(true){
world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
}

return itemstack;
}
public boolean onItemUse(ItemStack itemStack, EntityPlayer entity, World world, int i, int j, int k, int l, float a, float b, float c){
float var4 = 1.0F;

if(true){
if(entity instanceof EntityPlayer)((EntityPlayer)entity).inventory.addItemStackToInventory(new ItemStack(Blocks.sandstone, 42));
}

if(entity.inventory.hasItem(new ItemStack(Blocks.gold_block).getItem())){
if(entity instanceof EntityPlayer)((EntityPlayer)entity).inventory.consumeInventoryItem(Items.gold_ingot);
}

if(true){
MinecraftServer.getServer().addChatMessage(new ChatComponentText("HELLO PEOPLE"));
}

if(true){
EntityItem var14 = new EntityItem(world,(double)(i),(double)(j),(double)(k),new ItemStack(Blocks.obsidian, 1, 0));
var14.delayBeforeCanPickup = 10;
world.spawnEntityInWorld(var14);
}

if(true){
world.getBlock(i, j, k).dropBlockAsItem(world, i, j, k, 1, 1);
world.setBlockToAir(i, j, k);

}

return true;
}
public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
{
list.add("HI MAN");
}




}}
