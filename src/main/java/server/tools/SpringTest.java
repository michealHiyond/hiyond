package server.tools;

import java.util.List;
import java.util.Map;

import server.entity.User;

@SuppressWarnings("rawtypes")
public class SpringTest {

	private User user;
	
	private int number;
	
	private Map<String,Object> map;
	
	private List list;
	
	private boolean flag;
	
	private double dou;
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public double getDou() {
		return dou;
	}

	public void setDou(double dou) {
		this.dou = dou;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map<String,Object> map) {
		this.map = map;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public SpringTest() {
	}

	public SpringTest(User user, int number) {
		this.user = user;
		this.number = number;
	}
	
	public SpringTest(User user, int number, Map<String,Object> map, List list) {
		this.user = user;
		this.number = number;
		this.map = map;
		this.list = list;
	}
	
	public void test(){
		System.out.println("user:"+user);
		System.out.println("number:"+number);
		for(Map.Entry<String, Object> entry : map.entrySet()){
			System.out.println("map-key:"+entry.getKey()+"\t"+"map-value:"+entry.getValue().toString());
		}
		System.out.println("list:"+list.toString());
	}
	
	public SpringTest(boolean flag, double dou) {
		this.flag = flag;
		this.dou = dou;
	}
	
	public void test1(){
		System.out.println("flag:"+flag);
		System.out.println("dou:"+dou);
	}
}
