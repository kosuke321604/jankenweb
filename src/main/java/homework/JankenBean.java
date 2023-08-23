package homework;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;


public class JankenBean implements Serializable{
	private int myselfResult;
	private int pcResult;
	private String result;
	private String myselfResultName;
	private String pcResultName;
	
//	 List<String>resultPast = new ArrayList<String>();
	
	public JankenBean() {}
	public JankenBean(String myselfResultName,String pcResultName,String result) {
		;
		this.myselfResultName = myselfResultName;
		this.pcResultName = pcResultName;
		this.result = result;
	}
	
	
	public String getMyselfResultName() {return myselfResultName;	}
	public void setMyselfResultName(String myselfResultName) {this.myselfResultName = myselfResultName;}
	public String getPcResultName() {return pcResultName;	}
	public void setPcResultName(String pcResultName) {this.pcResultName = pcResultName;}
	public int getMyselfResult() {return myselfResult;}
	public void setMyselfResult(int myselfResult) {this.myselfResult = myselfResult;}
	public int getPcResult() {return pcResult;}
	public void setPcResult(int pcResult) {this.pcResult = pcResult;}
	public String getResult() {return result;}
	public void setResult(String result) {this.result = result;	}
	
//	public List<String> getResultPast() {return resultPast;	}
//	public void addResultPast(List<String> resultPast) {this.resultPast = resultPast;}


}
