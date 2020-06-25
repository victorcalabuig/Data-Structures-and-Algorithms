package P3;

public class ElementNotFoundException extends Exception {
	public ElementNotFoundException(String errorMessage){
		super(errorMessage);
	}
	
	public ElementNotFoundException(){
		super("Element not found");
	}
}

