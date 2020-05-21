package bag;

//Interfata comuna pentru orice builder de containere
public interface IBagFactory {
	
	IBag makeBag(String type);
	
}
