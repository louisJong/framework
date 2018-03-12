package com.song.framework.gen;

import cn.org.rapid_framework.generator.GeneratorFacade;

public class GeneratorMain {
	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) throws Exception {
	    System.out.println(System.getProperty("user.dir"));
	    generate("hepet_admin_user");
//	    generate("tb_repay_makeloan_order_detail");
	}
	
	private static void generate(String table) throws Exception{
	    GeneratorFacade g = new GeneratorFacade();
        g.getGenerator().setOutRootDir("D:\\gen"); //生成的文件存放目录
        g.getGenerator().addTemplateRootDir("classpath:template"); //模板目录
        g.deleteByTable(table); //删除生成的文件
        g.generateByTable(table);   //通过数据库表生成文件
	}
}
