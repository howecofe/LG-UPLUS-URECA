package app.foodOrder.dto;

public class MenuDto {

	private int menuId;
	private int storeId;
	private String storeName;
	private String menuName;
	private int price;
	
	public MenuDto(){}
	public MenuDto(int menuId, int storeId, String menuName, int price) {
		super();
		this.menuId = menuId;
		this.storeId = storeId;
		this.menuName = menuName;
		this.price = price;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	@Override
	public String toString() {
		return "MenuDto [menuId=" + menuId + ", storeId=" + storeId + ", storeName=" + storeName + ", menuName="
				+ menuName + ", price=" + price + "]";
	}

}
