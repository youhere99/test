package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.stream.JsonCollectors;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * description:玩转Java8Stream（三、Collectors收集器）
 * 
 * https://blog.csdn.net/qq_29879799/article/details/90682071
 * 
 * @author zhaomingxing 2019年7月23日
 *
 */
public class Java8TesterCollectors {

	@Test
	public void testGroupingByJsonObject() {

		JsonArray expectedStrings = Json.createArrayBuilder().add("string1").add("string2").add("string3").build();

		JsonArray expectedObjects = Json.createArrayBuilder().add(Json.createObjectBuilder().add("1", "value"))
				.add(Json.createObjectBuilder().add("2", "value")).add(Json.createObjectBuilder().add("3", "value"))
				.build();

		JsonArray expectedArrays = Json.createArrayBuilder().add(Json.createArrayBuilder().add("1"))
				.add(Json.createArrayBuilder().add("2")).add(Json.createArrayBuilder().add("3")).build();

		List<JsonValue> source = new ArrayList<>();
		source.add(Json.createValue("string1"));
		source.add(Json.createValue("string2"));
		source.add(Json.createValue("string3"));

		source.add(Json.createObjectBuilder().add("1", "value").build());
		source.add(Json.createObjectBuilder().add("2", "value").build());
		source.add(Json.createObjectBuilder().add("3", "value").build());

		source.add(Json.createArrayBuilder().add("1").build());
		source.add(Json.createArrayBuilder().add("2").build());
		source.add(Json.createArrayBuilder().add("3").build());

		JsonObject jsonObject = source.stream().collect(JsonCollectors.groupingBy(v -> v.getValueType().name()));
		System.err.println(jsonObject);
	}

	@Test
	public void testToJsonObjectCustomKeyAndValueMapper() {

		List<JsonValue> source = new ArrayList<>();
		source.add(Json.createValue("string"));
		source.add(Json.createObjectBuilder().add("key", "value").build());
		source.add(Json.createArrayBuilder().add("c1").add("c2").build());

		JsonObject jsonObject = source.stream()
				.collect(JsonCollectors.toJsonObject(v -> v.getValueType().toString(), Function.identity()));
		System.err.println(jsonObject);

	}

	// http://codingdict.com/sources/java/javax.json/39685.html
	@Test
	public void testToJsonObject() {

		SortedMap<String, JsonValue> source = new TreeMap<>(String::compareTo);
		source.put("a", Json.createValue("string"));
		source.put("c", Json.createObjectBuilder().add("key", "value").build());
		source.put("d", Json.createArrayBuilder().add("c1").add("c2").build());

		source.entrySet().stream().collect(JsonCollectors.toJsonObject()).forEach((x, y) -> {
			System.err.println(x + "---" + y);
		});

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("key1", "value1'");
		jsonObject.put("key2", "value2'");

		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("key2", "value3'");
		jsonObject2.put("key4", "value4'");

		JSONObject jsonObject3 = new JSONObject();
		jsonObject3.put("key2", "value3'");
		jsonObject3.put("key4", "value4'");

		JSONArray jsonArray = new JSONArray();
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject2);
		jsonArray.add(jsonObject3);

		jsonArray.stream().collect(Collectors.groupingBy(x -> {
			JSONObject o = (JSONObject) x;
			return o.getString("key2");
		}, Collectors.counting())).forEach((x, y) -> {
			System.err.println(x + "---" + y);
		});

		jsonArray.stream().collect(Collectors.groupingBy(x -> {
			JSONObject o = (JSONObject) x;
			return o.getString("key2");
		}, Collectors.collectingAndThen(Collectors.toList(), List::listIterator))).forEach(

				(x, y) -> {
					System.err.println(x + "---" + y);
				}

		);

		jsonArray.stream().collect(Collectors.groupingBy(x -> {
			JSONObject o = (JSONObject) x;
			return o.getString("key2");
		}, Collectors.collectingAndThen(Collectors.toList(), List::size))).forEach(

				(x, y) -> {
					System.err.println(x + "---" + y);
				}

		);

	}

	@Test
	public void testToJsonArray() {

		JsonArray array = IntStream.rangeClosed(1, 5)
				.mapToObj(i -> Json.createObjectBuilder().add("key" + i, "value" + i).build())
				.collect(JsonCollectors.toJsonArray());
		array.forEach(i -> {
			System.err.println(i.asJsonObject());
		});
	}

	@Test
	public void testReducing() {

		// sum: 是每次累计计算的结果，b是Function的结果
		System.out.println(Stream.of(1, 3, 4).collect(Collectors.reducing(0, x -> x + 1, (sum, b) -> {
			System.out.println(sum + "-" + b);
			return sum + b;
		})));

		// 下面代码是对reducing函数功能实现的描述，用于理解reducing的功能
		int sum = 0;
		List<Integer> list3 = Arrays.asList(1, 3, 4);
		for (Integer item : list3) {
			int b = item + 1;
			System.out.println(sum + "-" + b);
			sum = sum + b;
		}
		System.out.println(sum);

		// 注意reducing可以用于更复杂的累计计算，加减乘除或者更复杂的操作
		// result = 2 * 4 * 5 = 40
		System.out.println(Stream.of(1, 3, 4).collect(Collectors.reducing(1, x -> x + 1, (result, b) -> {
			System.out.println(result + "-" + b);
			return result * b;
		})));
	}

	@Test
	public void test() {

		LinkedHashMap<String, Set<Integer>> collect9 = Stream.of(-6, -7, -8, -9, 1, 2, 3, 4, 5, 6)
				.collect(Collectors.groupingBy(integer -> {
					if (integer < 0) {
						return "小于";
					} else if (integer == 0) {
						return "等于";
					} else {
						return "大于";
					}
				}, LinkedHashMap::new, Collectors.toSet()));
		System.err.println("collect9---------" + collect9);

		Map<Integer, String> collect8 = Stream.of("aa", "bbb", "cccc", "ddd").collect(Collectors.toMap(String::length,
				Function.identity(), BinaryOperator.maxBy(Comparator.comparing(String::toString))));
		System.err.println("collect8---------" + collect8);

		Map<Integer, Long> collect7 = Stream.of("aa", "bbb", "cccc", "ddd")
				.collect(Collectors.groupingBy(String::length, Collectors.counting()));
		System.err.println("collect7---------" + collect7);

		Map<Integer, List<String>> collect6 = Stream.of("aa", "bbb", "cccc", "ddd")
				.collect(Collectors.groupingBy(s -> s.length()));
		System.err.println("collect6---------" + collect6);

		Map<Boolean, List<Integer>> collect5 = Stream.of(0, 1, 0, 2)
				.collect(Collectors.partitioningBy(integer -> integer == 0));
		System.err.println("collect5---------" + collect5);

		Map<String, List<Integer>> collect4 = Stream.of(-6, -7, -8, -9, 1, 2, 3, 4, 5, 6)
				.collect(Collectors.groupingBy(integer -> {
					if (integer < 0) {
						return "小于";
					} else if (integer == 0) {
						return "等于";
					} else {
						return "大于";
					}
				}));
		System.err.println("collect4----------" + collect4);

		Integer collect3 = Stream.of("aa", "bbb", "ccc").collect(Collectors.reducing(0, s -> s.length(), Integer::sum));
		System.err.println("Collectors.reducing(0, s -> s.length(), Integer::sum)---------" + collect3);

		Optional<Integer> collect2 = Stream.of("aa", "bbb", "ccc").map(s -> s.length())
				.collect(Collectors.reducing(Integer::sum));
		System.err.println("Collectors.reducing(Integer::sum)---------" + collect2);

		Integer collect = Stream.of("aa", "bbb", "ccc").map(s -> s.length())
				.collect(Collectors.reducing(0, (i1, i2) -> i1 + i2));
		System.err.println("Collectors.reducing(0, (i1, i2) -> i1 + i2)---------" + collect);
	}
}
