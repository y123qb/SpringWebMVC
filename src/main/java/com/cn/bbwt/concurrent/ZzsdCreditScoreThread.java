package com.cn.bbwt.concurrent;

import com.cn.bbwt.utils.HttpClientOp;


public class ZzsdCreditScoreThread implements Runnable{
	private int num;
	String param="";
	String param1 = "{\"flowNo\": \"";
//	String param3 = "\",\"reqTime\": \"20180613 17:05:54\",\"accessToken\": \"000003\",\"content\": [{\"businessNo\": \"10000000293138\","+
//	"\"custName\": \"胡爱连\",\"idNo\": \"360724199001082020\",\"idType\": \"0\",\"phoneNo\": \"15060745992\",\"projNo\": \"31133\",\"prdtNo\": \"102014\","+
//			"\"pactNo\": \"4825722\",\"pactAmt\": \"15000\",\"termMon\": 12,\"termDay\": 365,\"endDate\": \"20180930\",\"lnRate\": 0.00500000000000001,\"czPactNo\":"+
//	"\"2016092700000610820094\",\"acctList\": [{\"acUse\": \"2\",\"acType\": \"11\",\"acNo\": \"6217000180015904034\",\"phoneNo\": \"15060745992\"}] }] }";
	
//	String param3 = "\",\"reqTime\": \"20180613 17:05:54\",\"accessToken\": \"000003\",\"content\": [{\"businessNo\": \"10000000293138\","+
//	"\"custName\": \"陈瑶\",\"idNo\": \"32118219930418052X\",\"idType\": \"0\",\"phoneNo\": \"15060745992\",\"projNo\": \"31133\",\"prdtNo\": \"102014\","+
//			"\"pactNo\": \"4825722\",\"pactAmt\": \"15000\",\"termMon\": 12,\"termDay\": 365,\"endDate\": \"20180930\",\"lnRate\": 0.00500000000000001,\"czPactNo\":"+
//	"\"2016092700000610820094\",\"acctList\": [{\"acUse\": \"2\",\"acType\": \"11\",\"acNo\": \"6217000180015904034\",\"phoneNo\": \"15060745992\"}] }] }";
	
	//测试生产环境bug=null
	String param3 = "\",\"reqTime\": \"20180613 17:05:54\",\"accessToken\": \"000003\",\"content\": [{\"businessNo\": \"10000000293138\","+
			"\"custName\": \"陈云飞\",\"idNo\": \"320422197310172331\",\"idType\": \"0\",\"phoneNo\": \"13814797797\",\"projNo\": \"31133\",\"prdtNo\": \"150001\","+
					"\"pactNo\": \"4825722\",\"pactAmt\": \"19000\",\"termMon\": 18,\"termDay\": 18,\"endDate\": \"20180930\",\"lnRate\": 3,\"czPactNo\":"+
			"\"2016092700000610820094\",\"acctList\": [{\"acUse\": \"2\",\"acType\": \"11\",\"acNo\": \"6217000180015904034\",\"phoneNo\": \"15060745992\"}] }] }";
	
	String param4 = "{\"accessToken\" : \"000003\",\"content\" : [ {\"acctList\" : [{\"acNo\" : \"111111000000\",\"acType\" : \"10\",\"acUse\" : \"2\",\"phoneNo\" : \"15812345678\"},{\"acNo\" : \"123123123000\",\"acType\" : \"11\","+
			"\"acUse\" : \"1\",\"phoneNo\" : \"15812345678\"}],\"businessNo\" : \"10002303678941\",\"custName\" : \"陈国lao\",\"idNo\" : \"350121199107294714\",\"idType\" : \"0\",\"pactAmt\" : 20000,\"pactNo\" : \"201808231104111\",\"phoneNo\" : \"15812345678\","+
					"\"prdtNo\" : \"200002\"} ],\"flowNo\" : \"1000230367894101\",\"reqTime\" : \"20180823 16:59:53\"}";
	
	@Override
	public   void run() {
		for (int i = 0; i < CountDownLatchTest.requestNum; i++) {
			synchronized (this) {//加锁，确保线程安全（缺点：不能中断，线程没有获得索前一直请求，影响性能
				num++;
				String param2 = "eeeeeeee"+num;
				param =param1+param2+param3;
				String doPost = HttpClientOp.doPost(CountDownLatchTest.url, param);
				System.out.println("纳秒时间"+System.nanoTime()+"["+Thread.currentThread().getName()+"] num="+num);
			}
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
