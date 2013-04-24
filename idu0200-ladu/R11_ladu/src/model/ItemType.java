package model;

import java.util.Set;

public class ItemType {

	private int ItemType;
	private String TypeName;
	private int Level;
	private int SuperType;
	private Set<ItemType> SubItemTypes;

	public Set<ItemType> getSubItemTypes() {
		return SubItemTypes;
	}

	public void setSubItemTypes(Set<ItemType> subItemTypes) {
		SubItemTypes = subItemTypes;
	}

	public int getItemType() {
		return ItemType;
	}

	public void setItemType(int itemType) {
		ItemType = itemType;
	}

	public String getTypeName() {
		return TypeName;
	}

	public void setTypeName(String typeName) {
		TypeName = typeName;
	}

	public int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		Level = level;
	}

	public int getSuperType() {
		return SuperType;
	}

	public void setSuperType(int superType) {
		SuperType = superType;
	}

}
