/*
 * Models a pack of cards with methods to discover 'interesting' things about the pack.
 */
import java.util.ArrayList;

public class PackCards {
	private Card douplicate;
	
	private ArrayList<Card> pack;

	/*
	 * Create a random pack of size n
	 */
	
	public PackCards(int n) {
		Card c;
		pack = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			c = new Card();
			pack.add(c);
		}
	}

	public void printPack() {
		for (Card c : pack) {
			System.out.println(c.cardString());
		}
	}

	/*
	 * Total the numerical value of all the cards in the pack
	 */
	public int totalPack() {
		// create local variable c to represent pack
		Card c;
		// intalise total = 0
	    int sumOfPack =0;
	    // loop through whole pack and add to sumOfPack to create running total
	    for(int i = 0; i < pack.size(); i++) {
	       c = pack.get(i);
		   sumOfPack = c.getNumber() + sumOfPack;
	    }
		return sumOfPack;
    }

	/*
	 * Find all the cards of a suit specified by String e.g. "Spades"
	 */
	public ArrayList<Card> findSuit(String suit) {
		//ArrayList of type Card for cards of desired suit
	   ArrayList<Card> selectedCards = new ArrayList<Card>();
	   
	   for (int i =0; i < pack.size(); i++){
		   //compare suit of card to desired suit
		  String cardSuit = pack.get(i).getSuit();
		  if(cardSuit.equals(suit)){
			 //add to list
		     selectedCards.add(pack.get(i));
	      }
	  }
	  return selectedCards;
	}

	/*
	 * Find largest card in pack taking into account numerical value and suit
	 * Diamonds is lowest, then Clubs, then Hearts, then Spades is largest.
	 */
	public Card findLargest() {
		//initalize largest as first card in pack
		int largest = pack.get(0).getNumber(); 
		//set up index for largest card
		int largestIndex =0;
		//loop through pack
		for(int i = 1; i < pack.size(); i++) {
			// if new value > than old largest set new card to largest
			// and change index to point to new largest
			if(pack.get(i).getNumber() > largest) {
				largest = pack.get(i).getNumber();
				largestIndex = i;
			}
			//compare suits to find highest value
			if(pack.get(i).getNumber() == largest) {
				if(pack.get(largestIndex).getSuit().equals("Spades")) {
					return pack.get(largestIndex);
				}
				if(pack.get(largestIndex).getSuit().equals("Diamonds") && pack.get(i).getSuit().equals("Spades")) {
					largestIndex = i;
				}
				if(pack.get(largestIndex).getSuit().equals("Clubs") && (pack.get(i).getSuit().equals("Spades")) ||pack.get(i).getSuit() .equals("Diamonds")) {
					largestIndex = i;
				}
				if(pack.get(largestIndex).getSuit().equals("Clubs")) {
					largestIndex = i;
				}
			}
		}
		return pack.get(largestIndex);
	}

	/*
	 * Return true if there is a duplicate card in the pack
	 */
	 public boolean hasDuplicate() {
		Card temp = null;
		//Iterators for Hearts,Diamonds,Clubs and Spades
		int iHearts =0;
		int iDiamonds =0;
		int iClubs =0;
		int iSpades =0;
		//Large array size to ensure don't run out of space in array
		Card hearts[] = new Card[1000];
		Card diamonds[] = new Card[1000];
		Card clubs[] = new Card[1000];
		Card spades[] = new Card[1000];
		// loop through pack to sort all card objects into their suits
		for(int i =0; i < pack.size(); i++) {
			if(pack.get(i).getSuit().equals("Hearts")) {
				//if suit matches desired suit add to array and increase 
				// iterator by one
				hearts[iHearts] = pack.get(i);
				iHearts += 1;
			}
			if(pack.get(i).getSuit().equals("Spades")) {
					spades[iSpades] = pack.get(i);
					iSpades += 1;
				}
			if(pack.get(i).getSuit().equals("Diamonds")) {
				diamonds[iDiamonds] = pack.get(i);
				iDiamonds += 1;
			}
			if(pack.get(i).getSuit().equals("Clubs")) {
				clubs[iClubs] = pack.get(i);
				iClubs += 1;
			}
		}
			/*compare each number value to the entire list of its suit
			 if any matches occur set global variable douplicate of type card
			 to the card that is a douplicate.... how do you spell that??
			*/
			for(int i = 0; i < iHearts; i++) {
				temp = hearts[i];
				for(int j = i+1; j < iHearts; j++) {
					if(temp.getNumber() == hearts[j].getNumber()){
						douplicate = hearts[i];
						return true;
					}
				}
			}
			for(int i = 0; i < iSpades; i++) {
				temp = spades[i];
				for(int j = i+1; j < iSpades; j++) {
					if(temp.getNumber() == spades[j].getNumber()){
						douplicate = spades[i];
						return true;
					}
				}
			}
			for(int i = 0; i < iDiamonds; i++) {
				temp = diamonds[i];
				for(int j = i+1; j < iDiamonds; j++) {
					if(temp.getNumber() == diamonds[j].getNumber()){
						douplicate = diamonds[i];
						return true;
					}
				}
			}
			for(int i = 0; i< iClubs; i++) {
				temp = clubs[i];
				for(int j = i+1; j < iClubs;  j++) {
					if(temp.getNumber() == clubs[j].getNumber()){
						douplicate = clubs[i];
						return true;
					}
				}
			}
		//if no matches occur return false
		return false;
	}

	/*
	 * Return any duplicate card, 'null otherwise
	 */
	public Card getDuplicate() {  
		//return value of douplicate, if none occur value will be null
		return douplicate;
	} 

}
