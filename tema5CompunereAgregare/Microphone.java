package tema5CompunereAgregare;

public class Microphone {

	private int maxVolume;
	private int crtVolume;

	public Microphone(int maxVolume) {
		this.maxVolume = maxVolume;
		this.crtVolume = (25 * maxVolume / 100);
	}

	public Microphone(int maxVolume, int crtVolume) {
		this.maxVolume = maxVolume;
		this.crtVolume = crtVolume;
	}

	public boolean increaseVolume() {
		if (this.crtVolume < this.maxVolume) {
			this.crtVolume++;
			System.out.println("Volumul microfonului a crescut la nivelul : " + this.crtVolume);
			return true;
		}
		System.out.println("Microphone: Volum maxim");
		return false;
	}

	public boolean decreaseVolume() {
		if (this.crtVolume > 0) {
			this.crtVolume--;
			System.out.println("Volumul microfonului a scazut la nivelul : " + this.crtVolume);
			return true;
		}
		System.out.println("Microphone: Volum minim");
		return false;
	}

	public void muteMicrophone() {
		this.crtVolume = 0;
		System.out.println("Microphone: Mute");
	}

}
