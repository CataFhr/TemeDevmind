package tema5CompunereAgregare;

public class Dimensions {

	private final int width;
	private final int length;
	private final int depth;

	public Dimensions(int width, int length, int depth) {
		this.width = width;
		this.length = length;
		this.depth = depth;
	}

	@Override
	public String toString() {
		return this.width + " x " + this.length + " x " + this.depth;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		Dimensions other = (Dimensions) obj;

		return this.width == other.width && this.length == other.length && this.depth == other.depth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.depth;
		result = prime * result + this.length;
		result = prime * result + this.width;
		return result;
	}

}
