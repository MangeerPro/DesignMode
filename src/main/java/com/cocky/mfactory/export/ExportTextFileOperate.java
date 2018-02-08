package com.cocky.mfactory.export;

public class ExportTextFileOperate extends ExportOperate {

	@Override
	protected ExportFileApi factoryMethod() {
		// 创建导出成文本格式的对象
		return new ExportTextFile();
	}

}
