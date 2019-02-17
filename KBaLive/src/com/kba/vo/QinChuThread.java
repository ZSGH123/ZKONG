package com.kba.vo;

import com.kba.entity.BarrageInfo;

public class QinChuThread extends Thread{
	
	@Override
	public void run() {
		//暂停0.3秒
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("线程启动了");
	}
	
	public void barrageInfoClear(BarrageInfo barrageInfo) {
		QinChuThread qinChuThread=new QinChuThread();
		qinChuThread.start();
		barrageInfo=new BarrageInfo();
		System.out.println("清楚了");
	}

}
