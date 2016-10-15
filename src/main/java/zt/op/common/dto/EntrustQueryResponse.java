package zt.op.common.dto;

import java.util.List;

public class EntrustQueryResponse extends BaseDTO{
	private Integer rowCount;
	private List<EntrustQueryDTO> rows;
	
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public List<EntrustQueryDTO> getRows() {
		return rows;
	}
	public void setRows(List<EntrustQueryDTO> rows) {
		this.rows = rows;
	}
	
}
