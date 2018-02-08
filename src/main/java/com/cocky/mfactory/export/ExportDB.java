package com.cocky.mfactory.export;

public class ExportDB implements ExportFileApi {

	@Override
	public boolean export(String data) {
		System.out.println("导出数据" + data +"到数据库中");
		return true;
	}

}
