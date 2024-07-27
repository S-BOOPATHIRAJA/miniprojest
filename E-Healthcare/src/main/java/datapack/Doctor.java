package datapack;

public class Doctor {

	private String name;
	private String special;
	private String gender;
	private long mobile;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "DoctorsDetails [name=" + name + ", special=" + special + ", gender=" + gender + ", mobile=" + mobile
				+ "]";
	}
	
	
}
