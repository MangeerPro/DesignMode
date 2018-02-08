package com.cocky.mfactory.export;

/**
 * @author haohao
 *
 */
public class ExportTextFile implements ExportFileApi {

	@Override
	public boolean export(String data) {
		//简单示意
		System.out.println("导出数据" + data + "到文本文件中");
		return true;
	}

}
