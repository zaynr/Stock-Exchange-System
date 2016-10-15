package zt.op.common.dto;

public class EntrustQueryRequest extends BaseDTO {
	private String beginDate;
	private String endDate;
	private String undone;
	private String done;
	private String cancelled;
	private String abandoned;
	private String pageSize;
	private String startRow;
	private String tableName;
	private String capitalAccountId;

	public String getCapitalAccountId() {
		return capitalAccountId;
	}

	public void setCapitalAccountId(String capitalAccountId) {
		this.capitalAccountId = capitalAccountId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getStartRow() {
		return startRow;
	}

	public void setStartRow(String startRow) {
		this.startRow = startRow;
	}

	public String getUndone() {
		return undone;
	}

	public void setUndone(String undone) {
		this.undone = undone;
	}

	public String getDone() {
		return done;
	}

	public void setDone(String done) {
		this.done = done;
	}

	public String getCancelled() {
		return cancelled;
	}

	public void setCancelled(String cancelled) {
		this.cancelled = cancelled;
	}

	public String getAbandoned() {
		return abandoned;
	}

	public void setAbandoned(String abandoned) {
		this.abandoned = abandoned;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
