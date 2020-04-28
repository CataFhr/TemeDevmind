package tema5CompunereAgregare;

public class Smartphone {

	private Screen theScreen;
	private Case theCase;
	private Speaker theSpeaker;
	private Microphone theMicrophone;
	private String model;

	public Smartphone(int pixelsNo, int width, int length, int depth, int speakerMaxVol, int microMaxVol,
			String model) {
		this.theScreen = new Screen(pixelsNo, width, length, depth);
		this.theCase = new Case();
		this.theSpeaker = new Speaker(speakerMaxVol);
		this.theMicrophone = new Microphone(microMaxVol);
		this.model = model;
	}

	public Smartphone(int pixelsNo, int width, int length, int depth, int speakerMaxVol, int speakerCrtVol,
			int microMaxVol, int microCrtVol, String model) {
		this.theScreen = new Screen(pixelsNo, width, length, depth);
		this.theCase = new Case();
		this.theSpeaker = new Speaker(speakerMaxVol, speakerCrtVol);
		this.theMicrophone = new Microphone(microMaxVol, speakerCrtVol);
		this.model = model;
	}

	public Smartphone(Screen theScreen, Case theCase, Speaker theSpeaker, Microphone theMicrophone, String model) {
		this.theScreen = theScreen;
		this.theCase = theCase;
		this.theSpeaker = theSpeaker;
		this.theMicrophone = theMicrophone;
		this.model = model;
	}

	public void pressVolumeUp() {
		this.theCase.pressVolumeUp();
		this.theSpeaker.increaseVolume();
	}

	public boolean pressVolumeDown() {
		this.theCase.pressVolumeDown();
		return this.theSpeaker.decreaseVolume();
	}

	public void pressPowerButton() {
		this.theCase.pressPowerButton();
	}

	public void setPixel(int index, String color) {
		this.theScreen.setPixel(index, color);
	}

	public void colorScreen(String color) {
		this.theScreen.colorScreen(color);
	}

	public boolean increaseMicrophoneVolume() {
		return this.theMicrophone.increaseVolume();
	}

	public boolean decreaseMicrophoneVolume() {
		return this.theMicrophone.decreaseVolume();
	}

	public void muteMicrophone() {
		this.theMicrophone.muteMicrophone();
	}

	public void setSilenceMode() {
		this.theSpeaker.setSilenceMode();
	}

	@Override
	public String toString() {
		return "Smartphone:\n\t" + "Model: " + this.model + "\n\t" + this.theScreen.toString();
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

		Smartphone other = (Smartphone) obj;

		return this.model.equals(other.model) && this.theScreen.equals(other.theScreen);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.model == null) ? 0 : this.model.hashCode());
		result = prime * result + ((this.theScreen == null) ? 0 : this.theScreen.hashCode());
		return result;
	}

}
