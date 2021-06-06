package proj.vo;

public class Subject {
	private String id;
	private String name;
	private int count;
	private String prof;
	
	public Subject() {}
	public Subject(String tid,String tname,int tcount)
	{
		this.id=tid;
		this.name=tname;
		this.count=tcount;
		this.prof=getProf();
	}
	public String getId() {
		return id;
	}
	public void setId(String tid) {
		this.id = tid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String tname) {
		this.name = tname;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int tcount) {
		this.count = tcount;
	}
	
	public String getProf() {
		return prof;
	}
	public void setProf(String tprof) {
		this.prof = tprof;
	}

}
