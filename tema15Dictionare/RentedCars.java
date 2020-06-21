package tema15Dictionare;

import java.util.ArrayList;
import java.util.List;

public class RentedCars {

	private String owner;
	private List<String> cars;

	public RentedCars(String owner) {
		this.owner = owner;
		this.cars = new ArrayList<>();
	}

	public void rentCar(String plateNo) {
		this.cars.add(plateNo);
	}

	public void returnCar(String plateNo) {
		this.cars.remove(plateNo);
	}

	public List<String> getCars() {
		return this.cars;
	}

	public int getCarsNo() {
		return this.cars.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.cars == null) ? 0 : this.cars.hashCode());
		result = prime * result + ((this.owner == null) ? 0 : this.owner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		RentedCars other = (RentedCars) obj;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!this.cars.equals(other.cars))
			return false;
		if (this.owner == null) {
			if (other.owner != null)
				return false;
		} else if (!this.owner.equals(other.owner))
			return false;
		return true;
	}

}
