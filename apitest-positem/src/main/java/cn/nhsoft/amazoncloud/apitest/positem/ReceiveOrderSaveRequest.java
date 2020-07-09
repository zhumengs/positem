package cn.nhsoft.amazoncloud.apitest.positem;

import java.util.List;

public class ReceiveOrderSaveRequest {
	
	 private Boolean audit;
	 private String branch_name;
	 private Integer branch_num;
	 private List<Details> details;	//收货明细
	 private Integer order_state;
	 private String order_state_name;
	 private String purchase_order_fid;
	 private String receive_order_auditor;
	 private String receive_order_creator;
	 private String receive_order_fid;
	 private String receive_order_memo;	 
	 private String receive_order_out_bill_no;
	 private float receive_order_total_money;
	 private String storehouse_name;
	 private Integer storehouse_num;
	 private Integer supplier_num;
	 private String system_book_code;
	 
	 
	public Boolean getAudit() {
		return audit;
	}
	public void setAudit(Boolean audit) {
		this.audit = audit;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public Integer getBranch_num() {
		return branch_num;
	}
	public void setBranch_num(Integer branch_num) {
		this.branch_num = branch_num;
	}
	public List<Details> getDetails(){
		return details;
	}
	public void setDetails(List<Details> details) {
		this.details = details;
	}
	public Integer getOrder_state() {
		return order_state;
	}
	public void setOrder_state(Integer order_state) {
		this.order_state = order_state;
	}
	public String getOrder_state_name() {
		return order_state_name;
	}
	public void setOrder_state_name(String order_state_name) {
		this.order_state_name = order_state_name;
	}
	public String getPurchase_order_fid() {
		return purchase_order_fid;
	}
	public void setPurchase_order_fid(String purchase_order_fid) {
		this.purchase_order_fid = purchase_order_fid;
	}
	public String getReceive_order_auditor() {
		return receive_order_auditor;
	}
	public void setReceive_order_auditor(String receive_order_auditor) {
		this.receive_order_auditor = receive_order_auditor;
	}
	public String getReceive_order_creator() {
		return receive_order_creator;
	}
	public void setReceive_order_creator(String receive_order_creator) {
		this.receive_order_creator = receive_order_creator;
	}
	public String getReceive_order_fid() {
		return receive_order_fid;
	}
	public void setReceive_order_fid(String receive_order_fid) {
		this.receive_order_fid = receive_order_fid;
	}
	public String getReceive_order_memo() {
		return receive_order_memo;
	}
	public void setReceive_order_memo(String receive_order_memo) {
		this.receive_order_memo = receive_order_memo;
	}
	public String getReceive_order_out_bill_no() {
		return receive_order_out_bill_no;
	}
	public void setReceive_order_out_bill_no(String receive_order_out_bill_no) {
		this.receive_order_out_bill_no = receive_order_out_bill_no;
	}
	public float getReceive_order_total_money() {
		return receive_order_total_money;
	}
	public void setReceive_order_total_money(float receive_order_total_money) {
		this.receive_order_total_money = receive_order_total_money;
	}
	public String getStorehouse_name() {
		return storehouse_name;
	}
	public void setStorehouse_name(String storehouse_name) {
		this.storehouse_name = storehouse_name;
	}
	public Integer getStorehouse_num() {
		return storehouse_num;
	}
	public void setStorehouse_num(Integer storehouse_num) {
		this.storehouse_num = storehouse_num;
	}
	public Integer getSupplier_num() {
		return supplier_num;
	}
	public void setSupplier_num(Integer supplier_num) {
		this.supplier_num = supplier_num;
	}
	public String getSystem_book_code() {
		return system_book_code;
	}
	public void setSystem_book_code(String system_book_code) {
		this.system_book_code = system_book_code;
	}
	 
	static class Details{
		
		private String item_lot_number;
		private String item_memo;
		private float item_money;
		private String item_name;
		private Integer item_num;
		private float item_price;
		private float item_qty;	 
		private String item_unit;
		private Integer receive_order_detail_num;
		private String receive_order_fid;
		
		public String getItem_lot_number() {
			return item_lot_number;
		}
		public void setItem_lot_number(String item_lot_number) {
			this.item_lot_number = item_lot_number;
		}
		public String getItem_memo() {
			return item_memo;
		}
		public void setItem_memo(String item_memo) {
			this.item_memo = item_memo;
		}
		public float getItem_money() {
			return item_money;
		}
		public void setItem_money(float item_money) {
			this.item_money = item_money;
		}
		public String getItem_name() {
			return item_name;
		}
		public void setItem_name(String item_name) {
			this.item_name = item_name;
		}
		public Integer getItem_num() {
			return item_num;
		}
		public void setItem_num(Integer item_num) {
			this.item_num = item_num;
		}
		public float getItem_price() {
			return item_price;
		}
		public void setItem_price(float item_price) {
			this.item_price = item_price;
		}
		public float getItem_qty() {
			return item_qty;
		}
		public void setItem_qty(float item_qty) {
			this.item_qty = item_qty;
		}
		public String getItem_unit() {
			return item_unit;
		}
		public void setItem_unit(String item_unit) {
			this.item_unit = item_unit;
		}
		public Integer getReceive_order_detail_num() {
			return receive_order_detail_num;
		}
		public void setReceive_order_detail_num(Integer receive_order_detail_num) {
			this.receive_order_detail_num = receive_order_detail_num;
		}
		public String getReceive_order_fid() {
			return receive_order_fid;
		}
		public void setReceive_order_fid(String receive_order_fid) {
			this.receive_order_fid = receive_order_fid;
		}
	}
	 


}
