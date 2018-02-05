package com.brett.direop.guns;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class gun extends Item{

	public static boolean rapidfire = false;
		public gun(){
		super();
		setMaxDamage(115);
		maxStackSize = 1;
		setFull3D();
		setUnlocalizedName("g");
		setTextureName("d");
		setCreativeTab(CreativeTabs.tabCombat);
		}

		public int getMaxItemUseDuration(ItemStack par1ItemStack)
		    {
		        return 72000;
		    }

		public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, final EntityPlayer par3EntityPlayer){

	        boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;
	        
	        for(int p = 0; p < 10; p++){
		        if (flag || par3EntityPlayer.inventory.hasItem(Items.coal))
		        {
		            float f = 1.5F;

		            EntityBullet entityarrow = new EntityBullet(par2World, par3EntityPlayer, f * 2.0F)
		            {

						public void onCollideWithPlayer(EntityPlayer entity){
							super.onCollideWithPlayer(entity);
							int i = MathHelper.floor_double(this.boundingBox.minX + 0.001D);
							int j = MathHelper.floor_double(this.boundingBox.minY + 0.001D);
							int k = MathHelper.floor_double(this.boundingBox.minZ + 0.001D);
							World world = this.worldObj;
							
						}

		            	public void onUpdate(){
						     super.onUpdate();
						     int i = MathHelper.floor_double(this.boundingBox.minX + 0.001D);
						     int j = MathHelper.floor_double(this.boundingBox.minY + 0.001D);
						     int k = MathHelper.floor_double(this.boundingBox.minZ + 0.001D);
						     World world = this.worldObj;
						     Entity entity = (Entity)par3EntityPlayer;
						     
						     if (this.worldObj.getBlock(i, j, k) != Blocks.air || this.worldObj.getBlock(i, j-1, k) != Blocks.air ||
						     this.worldObj.getBlock(i, j+1, k) != Blocks.air ||
						     this.worldObj.getBlock(i+1, j, k) != Blocks.air || this.worldObj.getBlock(i-1, j, k) != Blocks.air
						     || this.worldObj.getBlock(i, j, k+1) != Blocks.air || this.worldObj.getBlock(i, j, k-1) != Blocks.air){
						       	
						       	this.kill();
						     }

		            	}

		            	};

		                entityarrow.setIsCritical(false);
		                entityarrow.setDamage(0.5);
		                entityarrow.setKnockbackStrength(4);

		                if(false){
		                	entityarrow.setFire(100);
						}

		            	par1ItemStack.damageItem(1, par3EntityPlayer);
		            	par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

		            if (flag)
		            {
		                entityarrow.canBePickedUp = 2;
		            }
		            else
		            {
		                par3EntityPlayer.inventory.consumeInventoryItem(Items.coal);
		            }

		            if (!par2World.isRemote)
		            {
		                par2World.spawnEntityInWorld(entityarrow);
		            }
		            World world = par2World;
		            EntityPlayer entity = par3EntityPlayer;
					int i = (int)entity.posX;
					int j = (int)entity.posY;
					int k = (int)entity.posZ;
		            
		        }
	        }
	        if (flag || par3EntityPlayer.inventory.hasItem(Items.coal))
	        {
	            float f = 1.5F;

	            EntityBullet entityarrow = new EntityBullet(par2World, par3EntityPlayer, f * 2.0F)
	            {

					public void onCollideWithPlayer(EntityPlayer entity){
						super.onCollideWithPlayer(entity);
						int i = MathHelper.floor_double(this.boundingBox.minX + 0.001D);
						int j = MathHelper.floor_double(this.boundingBox.minY + 0.001D);
						int k = MathHelper.floor_double(this.boundingBox.minZ + 0.001D);
						World world = this.worldObj;
						
					}

	            	public void onUpdate(){
					     super.onUpdate();
					     int i = MathHelper.floor_double(this.boundingBox.minX + 0.001D);
					     int j = MathHelper.floor_double(this.boundingBox.minY + 0.001D);
					     int k = MathHelper.floor_double(this.boundingBox.minZ + 0.001D);
					     World world = this.worldObj;
					     Entity entity = (Entity)par3EntityPlayer;
					     
					     if (this.worldObj.getBlock(i, j, k) != Blocks.air || this.worldObj.getBlock(i, j-1, k) != Blocks.air ||
					     this.worldObj.getBlock(i, j+1, k) != Blocks.air ||
					     this.worldObj.getBlock(i+1, j, k) != Blocks.air || this.worldObj.getBlock(i-1, j, k) != Blocks.air
					     || this.worldObj.getBlock(i, j, k+1) != Blocks.air || this.worldObj.getBlock(i, j, k-1) != Blocks.air){
					       	
					       	this.kill();
					     }

	            	}

	            	};

	                entityarrow.setIsCritical(false);
	                entityarrow.setDamage(5.6);
	                entityarrow.setKnockbackStrength(4);

	                if(false){
	                	entityarrow.setFire(100);
					}

	            	par1ItemStack.damageItem(1, par3EntityPlayer);
	            	par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

	            if (flag)
	            {
	                entityarrow.canBePickedUp = 2;
	            }
	            else
	            {
	                par3EntityPlayer.inventory.consumeInventoryItem(Items.coal);
	            }

	            if (!par2World.isRemote)
	            {
	                par2World.spawnEntityInWorld(entityarrow);
	            }
	            World world = par2World;
	            EntityPlayer entity = par3EntityPlayer;
				int i = (int)entity.posX;
				int j = (int)entity.posY;
				int k = (int)entity.posZ;
	            
	        }

	        return par1ItemStack;
	    }



		    /**
		     * returns the action that specifies what animation to play when the items is being used
		     */
		    public EnumAction getItemUseAction(ItemStack par1ItemStack)
		    {
		        return EnumAction.bow;
		    }


		}