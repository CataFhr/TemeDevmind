package tema5CompunereAgregare;

public class Speaker {

	private int maxVolume;
	int crtVolume;

	public Speaker(int maxVolume) {
		this.maxVolume = maxVolume;
		this.crtVolume = (25 * maxVolume / 100);
	}

	public Speaker(int maxVolume, int crtVolume) {
		this.maxVolume = maxVolume;
		this.crtVolume = crtVolume;
	}

	public boolean increaseVolume() {
		if (this.crtVolume < this.maxVolume) {
			this.crtVolume++;
			System.out.println("Volumul speaker-ului a crescut la nivelul : " + this.crtVolume);
			return true;
		}
		System.out.println("Speaker: Volum maxim");
		return false;
	}

	public boolean decreaseVolume() {
		if (this.crtVolume > 0) {
			this.crtVolume--;
			System.out.println("Volumul speaker-ului a scazut la nivelul : " + this.crtVolume);
			return true;
		}
		System.out.println("Speaker: Volum minim");
		return false;
	}

	public void setSilenceMode() {
		this.crtVolume = 0;
		System.out.println("Speaker: Silence mode");
	}

}
