package app.foodOrder.dto;

public class StoreDto {
	
	private int storeId;
	private int categoryId;
	private String categoryName;
	private String storeName;
	private String location;
	private String tell;
	private int minPrice;
	
	public StoreDto(){}
	public StoreDto(int storeId, int categoryId, String storeName, String tell, int minPrice) {
		super();
		this.storeId = storeId;
		this.categoryId = categoryId;
		this.storeName = storeName;
		this.tell = tell;
		this.minPrice = minPrice;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	
	@Override
	public String toString() {
		return "StoreDto [storeId=" + storeId + ", categoryId=" + categoryId + ", categoryName=" + categoryName
				+ ", storeName=" + storeName + ", location=" + location + ", tell=" + tell + ", minPrice=" + minPrice
				+ "]";
	}

	
}
