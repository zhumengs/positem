package cn.nhsoft.amazoncloud.apitest.positem;

import java.util.HashMap;
import java.util.Map;

import org.databene.benerator.anno.Source;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import cn.nhsoft.amazoncloud.apitest.AmazoncloudTestBase;
import cn.nhsoft.amazoncloud.apitest.dao.ama5.model.AddPosItem;
import cn.nhsoft.amazoncloud.apitest.utils.HttpUtil;
import junit.framework.Assert;

public class PosItemNew extends AmazoncloudTestBase{

	private static Logger logger = LoggerFactory.getLogger(PosItemNew.class);
	private final String APIURL = "http://csp.nhsoft.cn/amazonCloud/nhsoft.amazon.pos.branch.item.saveorupdate";

	@Test(dataProvider = "feeder")
	@Source("positem_4.xls")
	public void testPosItemAdd(String order_num_1, String app_user_name_1, String branch_num_1, String item_barcode_1,
			String item_category_1, String item_category_code_1, String item_name_1, String item_num_1,
			String item_regular_price_1, String item_unit_1, String item_weight_flag_1, String code_1) {

		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Book-Code", "2072");

		AddPosItem api = new AddPosItem();
		api.setOrder_num(order_num_1);
		api.setApp_user_name(app_user_name_1);
		api.setBranch_num(branch_num_1);
		api.setItem_barcode(item_barcode_1);
		api.setItem_category(item_category_1);
		api.setItem_category_code(item_category_code_1);
		api.setItem_name(item_name_1);
		api.setItem_num(item_num_1);
		api.setItem_regular_price(item_regular_price_1);
		api.setItem_unit(item_unit_1);
		if ("#null#".equals(item_weight_flag_1)) {
			api.setItem_weight_flag(null);
		}else {
			api.setItem_weight_flag(""+Boolean.parseBoolean(  item_weight_flag_1));
		}
		
		if("新增商品".equals(item_name_1)) {
			api.setItem_name("新增商品" + Math.random());
		}else if("#null#".equals(item_name_1)){
			api.setItem_name(null);
		}
		else{
			api.setItem_name(item_name_1);
		}

		Gson g = new Gson();
		String body = g.toJson(api);
		System.err.println(body);
		// 向服务端发起请求
		String respStr = HttpUtil.postJson(APIURL, body, headerMap);
		logger.info("server response:" + respStr);

		// 响应Json字符串解析成JsonObject
		String json = g.toJson(api);
		JsonObject respJson = g.fromJson(respStr, JsonObject.class);

		// code等于0表示成功
		String apiRespCode = respJson.get("code").getAsString();
		Assert.assertEquals(code_1, apiRespCode);

//		if (apiRespCode.equals("0")) {
//			String apiItemName = respJson.get("result").getAsJsonObject().get("item").getAsString();
//
//			Assert.assertEquals(item_name_1, apiItemName);
//		}
	}
}
