package tema5CompunereAgregare;

import java.util.ArrayList;

public class Screen {

	private ArrayList<Pixel> pixels;
	private Dimensions dimensions;

	public Screen(int pixelsNo, int width, int length, int depth) {
		this.pixels = new ArrayList<Pixel>(pixelsNo);
		for (int i = 0; i < pixelsNo; i++) {
			this.pixels.add(new Pixel());
		}
		this.dimensions = new Dimensions(width, length, depth);
	}

	public void setPixel(int index, String color) {
		if (index >= 0 && index < this.pixels.size()) {
			this.pixels.get(index).setPixel(color);
		}
	}

	public void colorScreen(String color) {
		for (int i = 0; i < this.pixels.size(); i++) {
			this.setPixel(i, color);
		}
		System.out.println("Noua culoare a ecranului este: " + color);
	}

	@Override
	public String toString() {
		return "Screen: [pixels number = " + this.pixels.size() + ", dimensions = " + this.dimensions.toString() + "]";
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

		Screen other = (Screen) obj;

		return this.pixels.size() == other.pixels.size() && this.dimensions.equals(other.dimensions);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.dimensions == null) ? 0 : this.dimensions.hashCode());
		result = prime * result + this.pixels.size();
		return result;
	}

}
