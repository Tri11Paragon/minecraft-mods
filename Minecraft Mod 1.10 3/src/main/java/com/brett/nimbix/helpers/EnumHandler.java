package com.brett.nimbix.helpers;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {
	
	public static enum OreTypes implements IStringSerializable {
		IRIDIUM("iridium",0),
		THALLIUM("thallium", 1);
		
		private int id;
		private String name;
		
		private OreTypes(String name, int id) {
			this.name=name;
			this.id=id;
		}
		
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return name;
		}
		
		public int getId() {
			return id;
		}
		
		public String toString() {
			return getName();
		}
		
	}
	
	public static enum ChipTypes implements IStringSerializable {
		BASIC("basic", 0),
		ADVANCED("advanced", 1);

		private int ID;
		private String name;
		
		private ChipTypes(String name, int ID) {
			this.ID = ID;
			this.name = name;
		}
		
		@Override
		public String getName() {
			return this.name;
		}
		
		public int getID() {
			return ID;
		}
		
		@Override
		public String toString() {
			return getName();
		}
		
	}
	
	/**
	 * This is used by {@link BlockTinOre}
	 * @author CJMinecraft
	 *
	 */
	public static enum OreType implements IStringSerializable {
		OVERWORLD("overworld", 0),
		NETHER("nether", 1),
		END("end", 2);
		
		private int ID;
		private String name;
		
		private OreType(String name, int ID) {
			this.ID = ID;
			this.name = name;
		}
		
		@Override
		public String getName() {
			return this.name;
		}
		
		public int getID() {
			return ID;
		}
		
		@Override
		public String toString() {
			return getName();
		}
	}
	
	public static enum EnergyConnectionType implements IStringSerializable {
		NONE("none", 0),
		NORMAL("normal", 1),
		IN("in", 2),
		OUT("out", 3);
		
		private int ID;
		private String name;
		
		private EnergyConnectionType(String name, int ID) {
			this.ID = ID;
			this.name = name;
		}
		
		@Override
		public String getName() {
			return this.name;
		}
		
		public int getID() {
			return ID;
		}
		
		@Override
		public String toString() {
			return getName();
		}
	}
	
}
