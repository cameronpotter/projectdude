
public class Driver {

	public static void main(String[] args) {
		
		// Edit number to control size of pack
		PlayCards player = new PlayCards(10);
		
		player.testTotal();	// Remove comments to test each method
		
		// Edit string for a different suit
		player.testSuit("Hearts");
	
		player.testLargest();
		
	    player.testDuplicate();

	}

}
