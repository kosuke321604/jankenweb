package homework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import dao.ResultDAO;


public class JankenLogic {
	public JankenBean getJankenResult(String myChoice) {
		
		int myselfResult = Integer.parseInt(myChoice);

		Random random = new Random();
	    int randomvalue = random.nextInt(3);
	    int pcResult= randomvalue;
	    
	    //じゃんけんの手のコードに対応する名称をhashmapで格納
	    Map<Integer,String>pattern = new HashMap<Integer,String>();
	    pattern.put(0, "グー");
	    pattern.put(1, "チョキ");
	    pattern.put(2, "パー");
	    
		//じゃんけん結果を判定
	    //0:グー、1:チョキ、2：パー
	    String result;
	    
	    int jankenResult = myselfResult - pcResult;  
	    if(jankenResult ==-1||jankenResult==2) {
	    	result = "勝ち";
	    	
	    }else if(jankenResult ==1||jankenResult==-2){
	    	result = "負け";	    	
	    	
	    }else {
	    	result = "引き分け";
	    		    	
	    	
	    }
	    
	    String myselfResultName=pattern.get(myselfResult);
    	String pcResultName=pattern.get(pcResult);
    	

		JankenBean jankenBean = new JankenBean(myselfResultName,pcResultName,result);
	
		
	    return jankenBean;	   
	} 
	
	public void create(JankenBean jankenBean) {
		ResultDAO dao = new ResultDAO();
		dao.create(jankenBean);
		
		
	}
	
	public List<JankenBean> findAll(){
		ResultDAO dao = new ResultDAO();
		return dao.findAll();
		
	}
	
	public void creatememo(JankenBean jankenBean) {
		ResultDAO dao = new ResultDAO();
		dao.creatememo(jankenBean);
		
		
	}

}
