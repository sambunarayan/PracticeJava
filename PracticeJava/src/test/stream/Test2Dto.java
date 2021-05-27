package test.stream;

public class Test2Dto {

	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[id=" + id + ",name=" + name + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Test2Dto) {
			Test2Dto target = (Test2Dto) obj;
			return this.id.equals(target.getId());
		} else {
			return false;
		}
	}
}
