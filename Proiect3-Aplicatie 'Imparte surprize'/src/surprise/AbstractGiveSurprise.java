package surprise;

import java.util.concurrent.TimeUnit;

import bag.IBag;
import bag.MyBagFactory;

public abstract class AbstractGiveSurprise {

	protected IBag bag;
	protected int waitTime;

	public AbstractGiveSurprise(String bagType, int waitTime) {
		this.bag = MyBagFactory.getInstance().makeBag(bagType);
		this.waitTime = waitTime;
	}
    
	public void put(ISurprise newSurprise) {
			this.bag.put(newSurprise); //delegare
	}

	public void put(IBag bagOfSurprises) {
		this.bag.put(bagOfSurprises); //delegare
	}

	public void put(ISurprise[] surprises) {
		this.bag.put(surprises); //delegare
	}

	public void give() {
		ISurprise surprise = this.bag.takeOut(); //delegare
		if (surprise != null) {
			System.out.print("Give: ");
			surprise.enjoy();
			this.giveWithPassion();
		} else {
			System.out.println("Tolba este goala.");
		}
	}

	public void giveAll() {
		while (!this.bag.isEmpty()) {
			ISurprise surprise = this.bag.takeOut(); 
			System.out.print("Give: ");
			surprise.enjoy();
			this.giveWithPassion();
			try {
				TimeUnit.SECONDS.sleep(waitTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Tolba este goala.");
	}

	public boolean isEmpty() {
		return this.bag.isEmpty();
	}

	protected abstract void giveWithPassion();

	public IBag getBag() {
		return this.bag;
	}

}
