package com.gson;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2017年12月6日 上午9:42:22
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class TestGson {

	@Test
	public void assembleGson() {
		JsonObject obj = new JsonObject();
		Gson gson = new Gson();

		JsonObject businessObj = new JsonObject();
		List<String> cate1 = new ArrayList<String>();
		cate1.add("Local Flavor");
		cate1.add("localflavor");

		List<String> cate2 = new ArrayList<String>();
		cate2.add("Mass Media");
		cate2.add("massmedia");

		List<List<String>> cates = new ArrayList<List<String>>();
		cates.add(cate1);
		cates.add(cate2);
		JsonElement categoriesElement = gson.toJsonTree(cates);
		businessObj.add("categories", categoriesElement);

		businessObj.addProperty("is_claimed", true);
		businessObj.addProperty("is_closed", false);
		businessObj.addProperty("name", "Yelp");
		businessObj.addProperty("phone", "4159083801");
		businessObj.addProperty("menu_date_updated", 1317414369);

		JsonObject userBaseObj1 = new JsonObject();
		userBaseObj1.addProperty("name", "yuan");
		userBaseObj1.addProperty("sex", "male");

		JsonObject userBaseObj2 = new JsonObject();
		userBaseObj2.addProperty("name", "wang");
		userBaseObj2.addProperty("sex", "female");

		JsonArray userBaseArray = new JsonArray();
		userBaseArray.add(userBaseObj1);
		userBaseArray.add(userBaseObj2);

		JsonObject userBaseObj = new JsonObject();
		userBaseObj.add("user_base", userBaseArray);

		businessObj.add("users", userBaseObj);

		JsonObject centerObj = new JsonObject();
		centerObj.addProperty("latitude", 37.7861386);
		centerObj.addProperty("longitude", -122.4026213);

		JsonObject spanObj = new JsonObject();
		spanObj.addProperty("latitude_delta", 0);
		spanObj.addProperty("longitude_delta", 0);

		JsonObject regionObj = new JsonObject();
		regionObj.add("center", centerObj);
		regionObj.add("span", spanObj);

		JsonArray businessesArray = new JsonArray();
		businessesArray.add(businessObj);

		obj.add("businesses", businessesArray);
		obj.add("region", regionObj);
		obj.addProperty("total", 10651);
		String gsonStr = gson.toJson(obj);
		System.out.println(gsonStr);
		System.out.println(obj);

		String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
		String[] strings = gson.fromJson(jsonArray, String[].class);
		System.out.println(strings);
		List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>() {
		}.getType());
		System.out.println(stringList);

	}
}
