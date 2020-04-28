package tema5CompunereAgregare;

public class Pixel {

	private String color;

	public Pixel() {
		this.color = "#FFFFFF";
	}

	public Pixel(String color) {
		this.color = color;
	}

	public void setPixel(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Pixel [color=" + this.color + "]";
	}

}
