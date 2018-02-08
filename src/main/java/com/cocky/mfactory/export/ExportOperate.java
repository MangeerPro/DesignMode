package com.cocky.mfactory.export;

public abstract class ExportOperate {
	/**
	 * 导出文件
	 * @param data 需要保存的数据
	 * @return 是否导出成功
	 */
	public boolean export (String data) {
		//使用工厂方法
		ExportFileApi exportFile = factoryMethod();
		return exportFile.export(data);
	}
	/**
	 * 工厂方法，导出文件对象的接口
	 * @return 返回导出文件接口
	 */
	protected abstract ExportFileApi factoryMethod() ;
}
