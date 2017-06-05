package maven_ssm.basic.entity;

public class Pagination {

	//当前显示的条数,默认显示10条
	private int pageSize = 10;
	
	//当前显示的页数
	private int currentIndex = 1;
	
	//查询结果总条数
	private int pageCount;
	
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStartPage() {
		return (currentIndex - 1) * pageSize;
	}

	public Pagination(int pageSize, int currentIndex) {
		this.pageSize = pageSize;
		this.currentIndex = currentIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

}
