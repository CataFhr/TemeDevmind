package tema5CompunereAgregare;

public class TestDevices {

	public static void main(String[] args) {

		Screen aPhoneScreen = new Screen(130, 5, 10, 1);
		Screen aPhoneScreen1 = new Screen(250, 5, 10, 1);
		Case aPhoneCase = new Case();
		Speaker aPhoneSpeaker = new Speaker(100);
		Microphone aPhoneMicrophone = new Microphone(100);

		Smartphone smartphone = new Smartphone(aPhoneScreen, aPhoneCase, aPhoneSpeaker, aPhoneMicrophone,
				"Samsung S10");
		Smartphone smartphone1 = new Smartphone(aPhoneScreen1, aPhoneCase, aPhoneSpeaker, aPhoneMicrophone,
				"Samsung S10");
		System.out.println(smartphone.equals(smartphone1));

		Smartphone smartphone3 = new Smartphone(120, 6, 11, 1, 100, 100, 100, 100, "Samsung S8");
		System.out.println(smartphone3);
		smartphone3.pressVolumeUp();
		smartphone3.pressVolumeDown();
		smartphone3.pressVolumeDown();
		smartphone3.pressVolumeUp();
		smartphone3.setPixel(4, "rosu");
		// System.out.println(smartphone3.theScreen.pixels.get(4));
		smartphone3.colorScreen("albastru");
		// System.out.println(smartphone3.theScreen.pixels.get(10));
		smartphone3.setSilenceMode();
		smartphone3.pressVolumeDown();
		smartphone3.pressVolumeUp();

		smartphone3.muteMicrophone();
		smartphone3.decreaseMicrophoneVolume();
		smartphone3.increaseMicrophoneVolume();
		smartphone3.increaseMicrophoneVolume();

	}

}
