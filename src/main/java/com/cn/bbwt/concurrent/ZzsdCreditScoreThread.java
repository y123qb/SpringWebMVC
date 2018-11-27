package com.cn.bbwt.concurrent;

import com.cn.bbwt.utils.HttpClientOp;


public class ZzsdCreditScoreThread implements Runnable{
	private int num;
	String param="";
	String param1 = "{\"flowNo\": \"";
	String param3;
	String param4;
//	String param3 = "\",\"reqTime\": \"20180613 17:05:54\",\"accessToken\": \"000003\",\"content\": [{\"businessNo\": \"10000000293138\","+
//	"\"custName\": \"胡爱连\",\"idNo\": \"360724199001082020\",\"idType\": \"0\",\"phoneNo\": \"15060745992\",\"projNo\": \"31133\",\"prdtNo\": \"102014\","+
//			"\"pactNo\": \"4825722\",\"pactAmt\": \"15000\",\"termMon\": 12,\"termDay\": 365,\"endDate\": \"20180930\",\"lnRate\": 0.00500000000000001,\"czPactNo\":"+
//	"\"2016092700000610820094\",\"acctList\": [{\"acUse\": \"2\",\"acType\": \"11\",\"acNo\": \"6217000180015904034\",\"phoneNo\": \"15060745992\"}] }] }";
	
//	String param3 = "\",\"reqTime\": \"20180613 17:05:54\",\"accessToken\": \"000003\",\"content\": [{\"businessNo\": \"10000000293138\","+
//	"\"custName\": \"陈瑶\",\"idNo\": \"32118219930418052X\",\"idType\": \"0\",\"phoneNo\": \"15060745992\",\"projNo\": \"31133\",\"prdtNo\": \"102014\","+
//			"\"pactNo\": \"4825722\",\"pactAmt\": \"15000\",\"termMon\": 12,\"termDay\": 365,\"endDate\": \"20180930\",\"lnRate\": 0.00500000000000001,\"czPactNo\":"+
//	"\"2016092700000610820094\",\"acctList\": [{\"acUse\": \"2\",\"acType\": \"11\",\"acNo\": \"6217000180015904034\",\"phoneNo\": \"15060745992\"}] }] }";
	
	@Override
	public   void run() {
		for (int i = 0; i < CountDownLatchTest.requestNum; i++) {
			synchronized (this) {//加锁，确保线程安全（缺点：不能中断，线程没有获得索前一直请求，影响性能
				num++;
//				String param2 = "eeeeeeee"+num;
//				param =param1+param2+param3;
				param3 = getFraudParam(param3,i);//反欺诈测试数据
				param4 = getScoreParam(param4,num);//征信分测试数据
				
				String doPost = HttpClientOp.doPost(CountDownLatchTest.url, param3);
				HttpClientOp.doPost(CountDownLatchTest.url2, param4);
				System.out.println("纳秒时间"+System.nanoTime()+"["+Thread.currentThread().getName()+"] num="+num);
			}
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private String getFraudParam(String param,int i){
		switch (i%10){
		case 1:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"15812345678\"},{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"15812345678\"}],\"businessNo\":\"10000000352755\",\"custName\":\"曹祯\",\"idNo\":\"330419198101050619\",\"idType\":\"0\",\"pactAmt\":10000,\"pactNo\":\"20181030131010\",\"phoneNo\":\"15812345678\",\"prdtNo\":\"110001\",\"projNo\":\"879\"}],\"flowNo\":\"1000000035275501\",\"reqTime\":\"20181030 08:53:21\"}";
			break;
		case 2:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"15851573432\"},{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"15851573432\"}],\"businessNo\":\"10000000352756\",\"custName\":\"包敏强\",\"idNo\":\"320581198407163116\",\"idType\":\"0\",\"pactAmt\":10000,\"pactNo\":\"20181030131011\",\"phoneNo\":\"15851573432\",\"prdtNo\":\"110001\",\"projNo\":\"879\"}],\"flowNo\":\"1000000035275601\",\"reqTime\":\"20181030 08:53:22\"}";
			break;
		case 3:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"15861268808\"},{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"15861268808\"}],\"businessNo\":\"10000000352757\",\"custName\":\"陈禹伯\",\"idNo\":\"32072319820303001X\",\"idType\":\"0\",\"pactAmt\":10000,\"pactNo\":\"20181030131012\",\"phoneNo\":\"15861268808\",\"prdtNo\":\"110001\",\"projNo\":\"879\"}],\"flowNo\":\"1000000035275701\",\"reqTime\":\"20181030 08:53:21\"}";
			break;
		case 4:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"15812345678\"},{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"15812345678\"}],\"businessNo\":\"10000000352758\",\"custName\":\"陈之偲\",\"idNo\":\"320125199510265825\",\"idType\":\"0\",\"pactAmt\":10000,\"pactNo\":\"20181030131013\",\"phoneNo\":\"15812345678\",\"prdtNo\":\"110001\",\"projNo\":\"879\"}],\"flowNo\":\"1000000035275801\",\"reqTime\":\"20181030 08:53:22\"}";
			break;		
		case 5:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"15017512136\"},{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"15017512136\"}],\"businessNo\":\"10000000352760\",\"custName\":\"仇至杰\",\"idNo\":\"440103198812101812\",\"idType\":\"0\",\"pactAmt\":10000,\"pactNo\":\"20181030131015\",\"phoneNo\":\"15017512136\",\"prdtNo\":\"110001\",\"projNo\":\"879\"}],\"flowNo\":\"1000000035276001\",\"reqTime\":\"20181030 08:53:21\"}";
			break;
		case 6:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"15812345678\"},{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"15812345678\"}],\"businessNo\":\"10000000352761\",\"custName\":\"楚天楼\",\"idNo\":\"430624199608074011\",\"idType\":\"0\",\"pactAmt\":10000,\"pactNo\":\"20181030131016\",\"phoneNo\":\"15812345678\",\"prdtNo\":\"110001\",\"projNo\":\"879\"}],\"flowNo\":\"1000000035276101\",\"reqTime\":\"20181030 08:53:22\"}";
			break;		
		case 7:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"18803415200\"},{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"18803415200\"}],\"businessNo\":\"10000000352762\",\"custName\":\"白雪\",\"idNo\":\"140107199002093944\",\"idType\":\"0\",\"pactAmt\":10000,\"pactNo\":\"20181030131017\",\"phoneNo\":\"18803415200\",\"prdtNo\":\"110001\",\"projNo\":\"879\"}],\"flowNo\":\"1000000035276201\",\"reqTime\":\"20181030 08:53:22\"}";
			break;
		case 8:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"13967011736\"},{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"13967011736\"}],\"businessNo\":\"10000000352763\",\"custName\":\"陈炜\",\"idNo\":\"330825198810020139\",\"idType\":\"0\",\"pactAmt\":10000,\"pactNo\":\"20181030131018\",\"phoneNo\":\"13967011736\",\"prdtNo\":\"110001\",\"projNo\":\"879\"}],\"flowNo\":\"1000000035276301\",\"reqTime\":\"20181030 08:53:22\"}";
			break;
		case 9:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"15874849499\"},{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"15874849499\"}],\"businessNo\":\"10000000352764\",\"custName\":\"邓周文吉\",\"idNo\":\"430102199010044015\",\"idType\":\"0\",\"pactAmt\":10000,\"pactNo\":\"20181030131019\",\"phoneNo\":\"15874849499\",\"prdtNo\":\"110001\",\"projNo\":\"879\"}],\"flowNo\":\"1000000035276401\",\"reqTime\":\"20181030 08:53:22\"}";
			break;
		default:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"15812345678\"},{\"acNo\":\"6217003810047766160\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"15812345678\"}],\"businessNo\":\"10000000352765\",\"custName\":\"曹鸣\",\"idNo\":\"320581198901161714\",\"idType\":\"0\",\"pactAmt\":10000,\"pactNo\":\"201810301310110\",\"phoneNo\":\"15812345678\",\"prdtNo\":\"110001\",\"projNo\":\"879\"}],\"flowNo\":\"1000000035276501\",\"reqTime\":\"20181030 08:53:22\"}";	
		}
		return param;
	}
	private String getScoreParam(String param,int i){
		switch (i%10){//取个位数字
		case 0:
			param="{\"flowNo\": \""+Thread.currentThread()+i+"\",\"reqTime\": \"20180613 17:05:54\",\"accessToken\": \"000003\",\"content\": [{\"businessNo\": \"10000000293138\",\"custName\": \"陈瑶\",\"idNo\": \"32118219930418052X\",\"idType\": \"0\",\"phoneNo\": \"13222619931\",\"projNo\": \"31133\",\"prdtNo\": \"102014\",\"pactNo\": \"PPDfaa1f28bdf45499d951b35e52f10d24e\",\"pactAmt\": \"5000\",\"termMon\": 12,\"termDay\": 365,\"endDate\": \"20180930\",\"lnRate\": 0.00834489736918185,\"czPactNo\": \"\",\"acctList\": [{\"acUse\": \"2\",\"acType\": \"11\",\"acNo\": \"6217000180015904034\",\"phoneNo\": \"15288827189\"}]}]}";
			break;
		case 1:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"13555362321\"},{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"13555362321\"}],\"businessNo\":\"10000004225590\",\"custName\":\"李泓余\",\"flag\":\"2\",\"idNo\":\"232301199009171518\",\"idType\":\"0\",\"lnRate\":3,\"pactAmt\":2377,\"pactNo\":\"PPD00000000134146552\",\"phoneNo\":\"13555362321\",\"prdtNo\":\"150001\",\"projNo\":\"34205\",\"termDay\":0,\"termMon\":12}],\"flowNo\":\""+Thread.currentThread()+i+"\",\"reqTime\":\"20181101 03:58:06\"}";
			break;	
		case 2:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"13555362321\"},{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"13555362321\"}],\"businessNo\":\"10000004225590\",\"custName\":\"周海波\",\"flag\":\"2\",\"idNo\":\"612002199108172173\",\"idType\":\"0\",\"lnRate\":3,\"pactAmt\":2377,\"pactNo\":\"PPD00000000134146552\",\"phoneNo\":\"13555362321\",\"prdtNo\":\"150001\",\"projNo\":\"34205\",\"termDay\":0,\"termMon\":12}],\"flowNo\":\""+Thread.currentThread()+i+"\",\"reqTime\":\"20181101 03:58:06\"}";
			break;	
		case 3:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"13555362321\"},{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"13555362321\"}],\"businessNo\":\"10000004225590\",\"custName\":\"陈春福\",\"flag\":\"2\",\"idNo\":\"352122197311253732\",\"idType\":\"0\",\"lnRate\":3,\"pactAmt\":2377,\"pactNo\":\"PPD00000000134146552\",\"phoneNo\":\"13555362321\",\"prdtNo\":\"150001\",\"projNo\":\"34205\",\"termDay\":0,\"termMon\":12}],\"flowNo\":\""+Thread.currentThread()+i+"\",\"reqTime\":\"20181101 03:58:06\"}";
			break;	
		case 4:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"13555362321\"},{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"13555362321\"}],\"businessNo\":\"10000004225590\",\"custName\":\"李强\",\"flag\":\"2\",\"idNo\":\"340204198604052612\",\"idType\":\"0\",\"lnRate\":3,\"pactAmt\":2377,\"pactNo\":\"PPD00000000134146552\",\"phoneNo\":\"13555362321\",\"prdtNo\":\"150001\",\"projNo\":\"34205\",\"termDay\":0,\"termMon\":12}],\"flowNo\":\""+Thread.currentThread()+i+"\",\"reqTime\":\"20181101 03:58:06\"}";
			break;	
		case 5:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"13555362321\"},{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"13555362321\"}],\"businessNo\":\"10000004225590\",\"custName\":\"姚宁\",\"flag\":\"2\",\"idNo\":\"370681199603291819\",\"idType\":\"0\",\"lnRate\":3,\"pactAmt\":2377,\"pactNo\":\"PPD00000000134146552\",\"phoneNo\":\"13555362321\",\"prdtNo\":\"150001\",\"projNo\":\"34205\",\"termDay\":0,\"termMon\":12}],\"flowNo\":\""+Thread.currentThread()+i+"\",\"reqTime\":\"20181101 03:58:06\"}";
			break;	
		case 6:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"13555362321\"},{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"13555362321\"}],\"businessNo\":\"10000004225590\",\"custName\":\"李泓余\",\"flag\":\"2\",\"idNo\":\"232301199009171518\",\"idType\":\"0\",\"lnRate\":3,\"pactAmt\":2377,\"pactNo\":\"PPD00000000134146552\",\"phoneNo\":\"13555362321\",\"prdtNo\":\"150001\",\"projNo\":\"34205\",\"termDay\":0,\"termMon\":12}],\"flowNo\":\""+Thread.currentThread()+i+"\",\"reqTime\":\"20181101 03:58:06\"}";
			break;	
		case 7:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"13555362321\"},{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"13555362321\"}],\"businessNo\":\"10000004225590\",\"custName\":\"2李余\",\"flag\":\"2\",\"idNo\":\"232301199009171518\",\"idType\":\"0\",\"lnRate\":3,\"pactAmt\":2377,\"pactNo\":\"PPD00000000134146552\",\"phoneNo\":\"13555362321\",\"prdtNo\":\"150001\",\"projNo\":\"34205\",\"termDay\":0,\"termMon\":12}],\"flowNo\":\""+Thread.currentThread()+i+"\",\"reqTime\":\"20181101 03:58:06\"}";
			break;	
		case 8:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"13555362321\"},{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"13555362321\"}],\"businessNo\":\"10000004225590\",\"custName\":\"3泓余\",\"flag\":\"2\",\"idNo\":\"232301199009171518\",\"idType\":\"0\",\"lnRate\":3,\"pactAmt\":2377,\"pactNo\":\"PPD00000000134146552\",\"phoneNo\":\"13555362321\",\"prdtNo\":\"150001\",\"projNo\":\"34205\",\"termDay\":0,\"termMon\":12}],\"flowNo\":\""+Thread.currentThread()+i+"\",\"reqTime\":\"20181101 03:58:06\"}";
			break;	
		case 9:
			param="{\"accessToken\":\"000003\",\"content\":[{\"acctList\":[{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"2\",\"phoneNo\":\"13555362321\"},{\"acNo\":\"6217001070001551833\",\"acType\":\"11\",\"acUse\":\"1\",\"phoneNo\":\"13555362321\"}],\"businessNo\":\"10000004225590\",\"custName\":\"游陵花\",\"flag\":\"2\",\"idNo\":\"430219197301282308\",\"idType\":\"0\",\"lnRate\":3,\"pactAmt\":2377,\"pactNo\":\"PPD00000000134146552\",\"phoneNo\":\"13555362321\",\"prdtNo\":\"150001\",\"projNo\":\"34205\",\"termDay\":0,\"termMon\":12}],\"flowNo\":\""+Thread.currentThread()+i+"\",\"reqTime\":\"20181101 03:58:06\"}";
			break;	
		}
		return param;
	}
}
