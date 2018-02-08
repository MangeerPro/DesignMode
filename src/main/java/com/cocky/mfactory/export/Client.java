package com.cocky.mfactory.export;

public class Client {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExportOperate export = new ExportTextFileOperate();
		export.export("测试数据");
	}
}
