package utility;

public class Paging {
	private int number=0;
	private int totalCount=0;
	private int totalPage=0;
	private int pageNumber=0;
	private int pageSize=0;
	private int startRow=0;
	private int endRow=0;
	private int pageCount=3;
	private int startPage=0;
	private int endPage=0;
	private int offset=0;
	private int limit=0;
	private String url="";
	private String pagingHtml="";
	private String whatColumn="";
	private String keyword="";

	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}
	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}
	public String getWhatColumn() {
		return whatColumn;
	}
	public void setWhatColumn(String whatColumn) {
		this.whatColumn = whatColumn;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Paging(String pageNumber, 
			String pageSize,int totalCount,  String url, String whatColumn,
			String keyword) {

		if(pageNumber == null || pageNumber.equals("null") || pageNumber.equals("")) {
			pageNumber = "1";
		}
		this.pageNumber = Integer.parseInt(pageNumber);
		
		if(pageSize == null || pageSize.equals("null") || pageSize.equals("")) {
			pageSize = "5";
		}
		this.pageSize = Integer.parseInt(pageSize);

		this.totalCount = totalCount;
		this.totalPage = (int)Math.ceil((double)this.totalCount / this.pageSize) ;
		// 전체 레코드 갯수를 페이지에 출력될 레코드 개수로 나누어 소수점까지 가져온뒤 소수점은
		// 올림하고 그뒤 정수형으로 바꾸면 총 페이지 수가 된다.
		
		this.startRow = ( this.pageNumber - 1 )  * this.pageSize  + 1 ;
		this.endRow =  this.pageNumber * this.pageSize ;
		 
		if( this.pageNumber > this.totalPage ){
			this.pageNumber = this.totalPage ;
		}
		// 레코드 삭제시 페이지수가 줄어들때 페이지 이전위치로 이동
		
		this.limit = this.pageSize;
		this.offset = startRow-1 ; // 건너뛸 갯수 offset / startRow ~ end Row 까지 가져옴
		this.url = url ; 
		this.whatColumn = whatColumn ;
		this.keyword = keyword ;
		;
		this.startPage = ( this.pageNumber - 1 ) / this.pageCount * this.pageCount + 1  ;
		//startRow와 같은 형식으로 맨처음을 생각하여 -1 후 1더하기를하고 나누었다 곱하는과정에서 나머지를 버리면서 현재페이지의 첫페이지가 나온다.  
		this.endPage = this.startPage -1 + this.pageCount  ;	
		
		if( this.endPage > this.totalPage ){
			this.endPage = this.totalPage ;
		}
		this.pagingHtml = getPagingHtml(url) ;
		//System.out.println("startPage1:"+startPage);
		// 마지막페이지가 총 페이지 갯수를 넘치지 안토록
		this.number =this.totalCount - (this.pageNumber-1)*this.pageSize;
	}
	private String getPagingHtml(String url) {
		String result = "" ;
		String added_param = "&whatColumn=" + whatColumn + "&keyword=" + keyword ;
		//System.out.println("startPage2:"+startPage);
		if (this.startPage != 1) { 
			result += "&nbsp;<a href='" + url  
					+ "?pageNumber=" + ( 1 ) + "&pageSize=" + this.pageSize 
					+ added_param + "'>맨 처음</a>&nbsp;" ;
			result += "&nbsp;<a href='" + url 
					+ "?pageNumber=" + (this.startPage - 1 ) + "&pageSize=" + this.pageSize 
					+ added_param + "'>이전</a>&nbsp;" ;
		}
		
		//가운데
		for (int i = this.startPage; i <= this.endPage ; i++) {
			if ( i == this.pageNumber ) {
				result += "&nbsp;<font color='green'>" + i + "</font>&nbsp;"	;
						
			} else {
				result += "&nbsp;<a href='" + url   
						+ "?pageNumber=" + i + "&pageSize=" + this.pageSize 
						+ added_param + "'>" + i + "</a>&nbsp;" ;
				
			}
		}
		
		
		if ( this.endPage != this.totalPage) { 
			
			result += "&nbsp;<a href='" + url  
					+ "?pageNumber=" + (this.endPage + 1 ) + "&pageSize=" + this.pageSize 
					+ added_param + "'>다음</a>&nbsp;" ;
			
			result += "&nbsp;<a href='" + url  
					+ "?pageNumber=" + (this.totalPage ) + "&pageSize=" + this.pageSize 
					+ added_param + "'>맨 끝</a>&nbsp;" ;
		}		
		
		return result ;
	}
	
	
	
	
	
	
}

