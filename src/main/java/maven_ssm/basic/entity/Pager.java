package maven_ssm.basic.entity;

import java.util.List;

public class Pager<T> {

	private Pagination pagination;
	
	//结果集
	private List<T> datas;
	
	//总页数
	private int totalPage;
	
	//页码列表的开始索引
	private int beginPageIndex;
	
	//页码列表的结束索引
	private int endPageIndex;

	public Pager(Pagination pagination, List<T> datas) {
		super();

		this.datas = datas;
		
		this.totalPage = pagination.getPageCount() % pagination.getPageSize() != 0 ? 	//
					pagination.getPageCount() / pagination.getPageSize() + 1 : 			//
					pagination.getPageCount() / pagination.getPageSize(); 
		
		if(this.totalPage < 10) {
			beginPageIndex = 1;
			endPageIndex = this.totalPage;
		} else {
			beginPageIndex = pagination.getCurrentIndex() -4;
			endPageIndex = pagination.getCurrentIndex() + 5;
			
			if(beginPageIndex < 1) {
				beginPageIndex = 1;
				endPageIndex = 10;
			} else if(endPageIndex > this.totalPage) {
				endPageIndex = this.totalPage;
				beginPageIndex = this.totalPage - 9;
			}
		}
		

		if(pagination.getCurrentIndex() <= 1)
			pagination.setCurrentIndex(1);
		if(pagination.getCurrentIndex() >= this.totalPage)
			pagination.setCurrentIndex(this.totalPage);
	}

	public Pagination getPagination() {
		return pagination;
	}



	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}



	public int getBeginPageIndex() {
		
		return beginPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
}
