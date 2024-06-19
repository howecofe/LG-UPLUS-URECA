package builder;

// builder pattern - original 버전 !!
public class Board {
	private String title;
	private String content;
	private String category;
	
	private Board(Builder builder) { // 생성자 private
		this.title = builder.title;
		this.content = builder.content;
		this.category = builder.category;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	// Board 를 사용하는 쪽에 먼저 노출되어서 가짜 set 작업 수행 후, 마지막에 build() 호출되면 진짜 Board 객체를 생성해서 return 한다.
	public static class Builder {
		private String title;
		private String content;
		private String category;
		
		public Builder title(String title) {
			this.title = title;
			return this;
		}
		
		public Builder content(String content) {
			this.content = content;
			return this;
		}
		
		public Builder category(String category) {
			this.category = category;
			return this;
		}
		
		public Board build() {
			return new Board(this);
		}
	}

	@Override
	public String toString() {
		return "Board [title=" + title + ", content=" + content + ", category=" + category + "]";
	}
	
}
