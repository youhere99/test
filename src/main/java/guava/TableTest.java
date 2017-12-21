package guava;

import org.junit.Test;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2017年5月17日 下午3:53:12
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class TableTest {

	@Test
	public void tableTest() {
		Table<String, Integer, String> aTable = HashBasedTable.create();

		for (char a = 'A'; a <= 'C'; ++a) {
			for (Integer b = 1; b <= 3; ++b) {
				aTable.put(Character.toString(a), b, String.format("%c%d", a, b));
			}
		}

		System.out.println(aTable);
		System.out.println(aTable.column(2));
		System.out.println(aTable.row("B"));
		System.out.println(aTable.get("B", 2));

		System.out.println(aTable.contains("D", 1));
		System.out.println(aTable.containsColumn(3));
		System.out.println(aTable.containsRow("C"));
		System.out.println(aTable.columnMap());
		System.out.println(aTable.rowMap());

		System.out.println(aTable.remove("B", 3));
	}
}
