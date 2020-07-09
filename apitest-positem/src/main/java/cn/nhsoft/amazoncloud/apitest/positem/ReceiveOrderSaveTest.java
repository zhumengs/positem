package cn.nhsoft.amazoncloud.apitest.positem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.databene.benerator.anno.Source;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import cn.nhsoft.amazoncloud.apitest.AmazoncloudTestBase;
import cn.nhsoft.amazoncloud.apitest.positem.ReceiveOrderSaveRequest.Details;
import cn.nhsoft.amazoncloud.apitest.utils.HttpUtil;

public class ReceiveOrderSaveTest extends AmazoncloudTestBase {
	
	private static Logger logger = LoggerFactory.getLogger(ReceiveOrderSaveTest.class);
	//
	private final String APIURL = "http://csp.nhsoft.cn/amazonCloud/nhsoft.amazon.purchase.receive.order.save";

	@Test(dataProvider = "feeder")

	@Source("receiveordersave.xls")

	public void test_feed_1(String index,Boolean audit,String branch_name,Integer branch_num,String item_lot_number,
			String item_memo,float item_money,String item_name,Integer item_num,float item_price,float item_qty,String item_unit,
			Integer receive_order_detail_num,String receive_order_fid,Integer order_state,String order_state_name,String purchase_order_fid,
			String receive_order_auditor,String receive_order_creator,String receive_order_memo,String receive_order_out_bill_no,
			float receive_order_total_money,String storehouse_name,Integer storehouse_num,Integer supplier_num,String system_book_code,String code) {
		
		Map<String,String>headerMap = new HashMap<String,String>();
		//Map<String,String>headerMap = new HashMap<String,String>();
		headerMap.put("Book-code","4344");
		
		ReceiveOrderSaveRequest dto = new ReceiveOrderSaveRequest();
		dto.setAudit(audit);
		dto.setBranch_name(branch_name);
		dto.setBranch_num(branch_num);
		
		List<Details> listDetails = new ArrayList<Details>();
		Details details = new Details();
		details.setItem_lot_number(item_lot_number);
		details.setItem_memo(item_memo);
		details.setItem_money(item_money);
		//details.setItem_name(item_name);
		//logger.info("item_name:" + item_name); 
		if ("#null#".equals(item_name)) {
			details.setItem_name(null);
			logger.info("item_name:" + item_name); 
		}else {
			details.setItem_name(item_name);
		}
		details.setItem_num(item_num);
		details.setItem_price(item_price);
		details.setItem_qty(item_qty);
		//details.setItem_unit(item_unit);
		if ("#null#".equals(item_unit)) {
			details.setItem_unit(null);
			logger.info("item_unit:" + item_unit); 
		}else {
			details.setItem_unit(item_unit);
		}
		details.setReceive_order_detail_num(receive_order_detail_num);
		details.setReceive_order_fid(receive_order_fid);
		listDetails.add(details);
		dto.setDetails(listDetails);
		
		dto.setOrder_state(order_state);
		dto.setOrder_state_name(order_state_name);
		dto.setPurchase_order_fid(purchase_order_fid);
		dto.setReceive_order_auditor(receive_order_auditor);
		dto.setReceive_order_creator(receive_order_creator);
		dto.setReceive_order_fid(receive_order_fid);
		dto.setReceive_order_memo(receive_order_memo);
		dto.setReceive_order_out_bill_no(receive_order_out_bill_no);
		dto.setReceive_order_total_money(receive_order_total_money);
		dto.setStorehouse_name(storehouse_name);
		dto.setStorehouse_num(storehouse_num);
		dto.setSupplier_num(supplier_num);
		dto.setSystem_book_code(system_book_code);
		
		Gson g = new Gson();
		String body_1 = g.toJson(dto);
		System.err.println(body_1);
		
		String respStr = HttpUtil.postJson(APIURL,body_1,headerMap);
		logger.info("respose:" + respStr); 
		
		String json = g.toJson(dto);
		JsonObject resJson = g.fromJson(respStr, JsonObject.class);
		
		String apirespCode = resJson.get("code").getAsString();
		
		AssertJUnit.assertEquals(code, apirespCode);

				
	} 
}
