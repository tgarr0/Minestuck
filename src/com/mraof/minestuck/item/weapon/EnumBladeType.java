package com.mraof.minestuck.item.weapon;

public enum EnumBladeType 
{

	SORD(59, 3, 5, "sord"),
	NINJA(250, 6, 15, "ninjaSword"),
	KATANA(2200, 8, 20, "katana"),
	CALEDSCRATCH(1561, 7, 30, "caledscratch"),
	REGISWORD(812, 7, 10, "regisword"),
	DERINGER(1561, 8, 30, "royalDeringer"),
	SCARLET(2000, 9, 30, "scarletRibbitar"),
	DOGG(1000, 6, 30, "doggMachete");
	
	private final int maxUses;
	private final int damageVsEntity;
	private final int enchantability;
	private final String name;
	
	private EnumBladeType(int maxUses, int damageVsEntity, int enchantability, String name) 
	{
		this.maxUses = maxUses;
		this.damageVsEntity = damageVsEntity;
		this.enchantability = enchantability;
		this.name = name;
	}
	
	public int getMaxUses()
	{
		return maxUses;
	}
	
	public int getDamageVsEntity()
	{
		return damageVsEntity;
	}
	
	public int getEnchantability()
	{
		return enchantability;
	}
	
	public String getName()
	{
		return name;
	}
}