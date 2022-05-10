/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Owen Huber 
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for (int i = start; i < size + start; i++){
			myWords[i - start] = source[i];
		}
		myToString = myWords.toString();
		myHash = myWords.hashCode();

		// DONE: initialize myWords - leave myToString/myHash alone.
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		// DONE: change this
		int theLength = myWords.length;
		return theLength;
	}


	/**
	 * Complete appropriate comment here
	 * @param other
	 * @return
	 */
	@Override
	public boolean equals(Object other) {
		if (! (other instanceof WordGram) || other == null){
			return false;
		}
		WordGram wg = (WordGram) other;
		if (this.toString().equals(wg.toString())){
			return true;
		}

		return false;
	}

	@Override
	public int hashCode(){
		// DONE: complete this method: assign to myHash as needed
		int theHashYeaaaaaah = this.toString().hashCode();
		myHash = theHashYeaaaaaah;
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		// DONE: Complete this method
		WordGram newOne = new WordGram(myWords, 0, myWords.length);
		for (int i = 0; i < myWords.length - 1; i++){
			newOne.myWords[i] = myWords[i + 1];
		}
		newOne.myWords[myWords.length - 1] = last;
		return newOne;
	}
 
	@Override
	public String toString(){
		if (String.join(" ", myWords).equals(myToString)){
			return myToString;
		}
		else {
			String theString = String.join(" ", myWords);
			myToString = theString;
			return myToString;
		}
		
	}

/*
String theString = String.join(" ", myWords);
myToString = theString;
return theString;
	}
*/
}
