package tppitweaks.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class TPPIMaterial extends Item {

	public Icon uncookedIcon;
	
	public TPPIMaterial(int par1) {
		super(par1);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("tppimaterial");
		setHasSubtypes(true);
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon("tppitweaks:tppiProcessor");
		uncookedIcon = par1IconRegister.registerIcon("tppitweaks:tppiProcessorUncooked");
	}
	
	@Override
	public String getItemDisplayName(ItemStack par1ItemStack)
	{
		if(par1ItemStack.getItemDamage() == 1) {
			return "Multi-Core Processor Assembly";
		}
		return "ME Multi-Core Processor";
	}
	
	@Override
	public Icon getIconFromDamage(int dmg) {
		switch(dmg) {
		case 1:
			return uncookedIcon;
		default:
			return itemIcon;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < 2; i++)
			list.add(new ItemStack(this.itemID, 1, i));
	}
}