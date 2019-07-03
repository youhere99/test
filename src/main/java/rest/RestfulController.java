package rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

import jodd.PropertyConstans;

@RestController
@RequestMapping(value = "/springrestexample")
public class RestfulController {
	/**
	 * 
	 * @return 2018年11月7日 zhaomingxing
	 */
	@RequestMapping("/hello.do")
	public String hello() {
		Properties jdbcProperties = PropertyConstans.getProperty();
		System.err.println(jdbcProperties);

		return "Hello World!";
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Map> updateEmployee(@PathVariable("id") int id, @RequestBody Map<String, Object> map) {
		System.out.println(id);
		// 直接将json信息打印出来
		System.out.println(map);
		return new ResponseEntity<Map>(map, HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT) public
	 * ResponseEntity<JSONObject> updateEmployee(@PathVariable("id") int id,
	 * HttpServletRequest request) { System.out.println(id); //获取到JSONObject
	 * JSONObject jsonParam = this.getJSONParam(request);
	 * 
	 * // 直接将json信息打印出来 System.out.println(jsonParam.toJSONString()); return new
	 * ResponseEntity<JSONObject>(jsonParam, HttpStatus.OK); }
	 */

	/**
	 * 创建日期:2018年4月6日<br/>
	 * 代码创建:黄聪<br/>
	 * 功能描述:通过request来获取到json数据<br/>
	 * 
	 * @param request
	 * @return
	 */
	public JSONObject getJSONParam(HttpServletRequest request) {
		JSONObject jsonParam = null;
		try {
			// 获取输入流
			BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

			// 写入数据到Stringbuilder
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = streamReader.readLine()) != null) {
				sb.append(line);
			}
			jsonParam = JSONObject.parseObject(sb.toString());
			// 直接将json信息打印出来
			System.out.println(jsonParam.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonParam;
	}
	/*
	 * @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT) public
	 * ResponseEntity<JSONObject> updateEmployee(@PathVariable("id") int
	 * id, @RequestBody JSONObject jsonParam) { System.out.println(id); //
	 * 直接将json信息打印出来 System.out.println(jsonParam.toJSONString()); return new
	 * ResponseEntity<JSONObject>(jsonParam, HttpStatus.OK); }
	 */
	/*
	 * @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT) public
	 * ResponseEntity<EmployeeVO> updateEmployee(@PathVariable("id") int
	 * id, @RequestBody EmployeeVO employee) { System.out.println(id);
	 * System.out.println(employee); return new ResponseEntity<EmployeeVO>(employee,
	 * HttpStatus.OK); }
	 */

	/*
	 * @Test public void updateEmployee() { final String uri =
	 * "http://localhost:8080/springrestexample/employees/{id}"; Map<String, String>
	 * params = new HashMap<String, String>(); params.put("id", "2");
	 * 
	 * EmployeeVO updatedEmployee = new EmployeeVO(2, "New Name", "Gilly",
	 * "test@email.com");
	 * 
	 * RestTemplate restTemplate = new RestTemplate(); restTemplate.put ( uri,
	 * updatedEmployee, params); }
	 */
	@Test
	public void updateEmployee() {
		final String uri = "http://localhost:8080/test/springrestexample/employees/{id}";
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "2");
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("age", "20");
		map.put("name", "New Name");
		map.put("ident", "Gilly");
		map.put("email", "test@email.com");

		Map<String, String> address = new HashMap<String, String>();
		address.put("street", "星光大道");

		map.put("address", address);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uri, map, params);
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getEmployeeById(@PathVariable("id") String id,
			@RequestParam Map<String, Object> params, HttpServletRequest request) {
		System.err.println(request.getParameter("name"));
		System.err.println(params);
		HashMap<String, Object> map = Maps.newHashMap();
		map.put("id", id);
		// map.put("name", name);
		map.put("email", "test@email.com");
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		// return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@Test
	public void getEmployeeById() {
		final String uri = "http://localhost:8080/test/springrestexample/employees/{id}.do?name=name..";

		// Map<String, String> params = new HashMap<String, String>();
		// params.put("id", "1");
		// params.put("name", "name..");

		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> result = restTemplate.getForObject(uri, Map.class, "1");

		System.out.println(result);
	}
	/// **
	// *
	// *
	// * 2019年6月20日 zhaomingxing
	// */
	// @Test
	// public void getEmployeeById1() {
	// final String uri =
	/// "http://localhost:8080/test/springrestexample/employees/{id}.do";
	// Map<String, Object> map = new HashMap<>();
	// map.put("name", "name..");
	// RestTemplate restTemplate = new RestTemplate();
	// ResponseEntity<Map> responseEntity = restTemplate.exchange(uri,
	/// HttpMethod.POST, new HttpEntity<>(map),
	// Map.class, "1");
	//
	// System.out.println(responseEntity);
	// }

}
