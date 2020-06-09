package tema12LinkedList;

public class Town implements Comparable<Town> {

	private String name;
	private int kmNo;

	public Town(String name, int kmNo) {
		this.name = name;
		this.kmNo = kmNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKmNo() {
		return kmNo;
	}

	public void setKmNo(int kmNo) {
		this.kmNo = kmNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + kmNo;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Town other = (Town) obj;
		if (kmNo != other.kmNo)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name + "-" + kmNo;
	}

	@Override
	public int compareTo(Town o) {
		return this.kmNo - o.kmNo;
	}

}
