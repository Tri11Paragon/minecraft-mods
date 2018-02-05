package com.brett.nimbix.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayer.EnumChatVisibility;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class teleporterMemory extends Item {
	
	@Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
		if(stack.getTagCompound() != null){
			return stack.getTagCompound().hasKey("Cords");
		}
		return false;
    }
	
	@Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		if(!playerIn.isSneaking()){
			if(stack.getTagCompound() == null){
				stack.setTagCompound(new NBTTagCompound());
			}
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setInteger("dim", playerIn.dimension);
			nbt.setInteger("PosX", pos.getX());
			nbt.setInteger("PosY", pos.getY());
			nbt.setInteger("PosZ", pos.getZ());
			stack.getTagCompound().setTag("Cords", nbt);
			stack.setStackDisplayName(TextFormatting.AQUA + "Teleporter Memory");
		}
        return EnumActionResult.PASS;
    }
	
	@Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
		if(playerIn.isSneaking()){
			if(stack.getTagCompound() != null){
				stack.getTagCompound().removeTag("Cords");
				stack.clearCustomName();
			}
		}
		
        return new ActionResult(EnumActionResult.PASS, stack);
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
		if(stack.getTagCompound() != null){
			if(stack.getTagCompound().hasKey("Cords")){
				NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("Cords");
				int dim = nbt.getInteger("dim");
				int posX = nbt.getInteger("PosX");
				int posY = nbt.getInteger("PosY");
				int posZ = nbt.getInteger("PosZ");
				tooltip.add("X: " + posX + " Y: " + posY + " Z: " + posZ);
				tooltip.add("Dimension: " + dim);
			}
		}
    }
	
}
