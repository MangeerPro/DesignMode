package com.cocky.mfactory.export;

public class ExportDBOperate extends ExportOperate {

	@Override
	protected ExportFileApi factoryMethod() {
		// 创建数据库备份文件形式对象
		return new ExportDB();
	}

}
