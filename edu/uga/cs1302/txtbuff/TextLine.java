package edu.uga.cs1302.txtbuff;

/**
 * This class contains constructors and methods for a class intended to handle
 * a line of text, store it as an character array, and represent this data 
 * in certain ways.
 * @author Dylan Diener
 *
 */
public class TextLine {
    
    /**
     * This is a constant that represents the generic size of each of the arrays. If arrays
     * need to be expanded, it is done so by this interval. It is a constant so it can constantly be referenced.
     */
    public static final int DEFAULT_SIZE = 80;
    
    /**
     * The capacity variable represents the size of the array that each TextLine object creates.
     */
    public int capacity;
    /**
     * This is the internal charArray of each of the TextLine objects. This is where
     * all of the text is stored.
     */
    char[] charArray;
    
    /**
     * This constructs an empty TextLine object with the default size
     * constant as the capacity of the object's internal charArray.
     */
    public TextLine() {
	capacity = DEFAULT_SIZE;
	charArray = new char[capacity];
    }
    
    /**
     * This constructs a TextLine object that contains the string given in the
     * parameter individually within the object's internal charArray.
     * @param line The line parameter is the string that is to be placed at the 
     * beginning of the TextLine's charArray.
     */
    public TextLine(String line) {
	capacity = DEFAULT_SIZE;
	if(line.length() > DEFAULT_SIZE) {
	    while(capacity < line.length())
		capacity += DEFAULT_SIZE;
	}
	charArray = new char[capacity];
	
	for(int i = 0; i < line.length(); i++) {
	    charArray[i] = line.charAt(i);
	}
    }
    
    /**
     * This method locates the first occurance of the fragment given in the parameters of the 
     * method within the TextLine object itself. If no match is foud, then a -1 is returned.
     * @param fragment This is the string that is searched for within the TextLine for this method.
     * @return This returns the first instance of the fragment within the TextLine. If
     * the fragment is not found within the TextLine, then a -1 value is returned.
     */
    public int indexOf(String fragment) {
	for(int n = 0; n < this.length(); n++) {
	    int nTemp = n;
	    int p = 0;
	    
	    while(fragment.charAt(p) == charArray[n]) {
		if(p == fragment.length() - 1) {
		    return nTemp;
		}
		p++;
		n++;
	    }
	    p = 0;
	    n = nTemp;
	}
	return -1;
    }
    
    /**
     * This method does the same as the other overloaded method with the same name in this class, 
     * but instead of looking for the fragment starting from charArray[0], the method begins its
     * search from charArray[index] from within the object.
     * @param fragment This is the string that is searched for within the TextLine object.
     * @param fromIndex This is the index from which the search for the fragment begins.
     * @return This method returns an integer value of the first occurance of the fragment from
     * the starting index. If no match is found, then a -1 is returned.
     */
    public int indexOf(String fragment, int fromIndex) {
	for(int n = fromIndex; n < this.length(); n++) {
	    int nTemp = n;
	    int p = 0;
	    
	    while(fragment.charAt(p) == charArray[n]) {
		if(p == fragment.length() - 1) {
		    return nTemp;
		}
		p++;
		n++;
	    }
	    p = 0;
	    n = nTemp;
	}
	return -1;
    }
    
    /**
     * This method returns the length of the TextLine object by counting things that are not 
     * null character instances.
     * @return This returns the length of the TextLine object.
     */
    public int length() {
	int charCount = 0;
	for(int i = 0; i < capacity; i++) {
	    if(charArray[i] != '\u0000' && charArray[i + 1] == '\u0000' && charArray[i + 2] == '\u0000')
		charCount = i;
	}
	return charCount + 1;
    }
    
    /**
     * This simply returns the value of the capacity variable of the TextLine object.
     * @return This returns the value of the capacity variable of the TextLine object.
     */
    public int capacity() {
	return capacity;
    }
    
    /**
     * This method simply returns true if all of the characters in the character array of
     * one object equals the characters in the character array of another. The method
     * returns false otherwise.
     */
    public boolean equals(Object anObject) {
	if(anObject instanceof TextLine) {
	    String testString = anObject.toString();
	    
	    for(int i = 0; i < testString.length(); i++) {
		if(testString.charAt(i) != this.charArray[i])
		    return false;
	    }
	    return true;
	}
	else
	    return false;
	
    }
    
    /**
     * This method returns a string representing the values stored within the 
     * TextLine object's charArray.
     */
    public String toString() {
	String stringTemp = "";
	for(int i = 0; i < charArray.length; i++) {
	    stringTemp += charArray[i];
	}
	return stringTemp;
    }
    
    /**
     * This interface is later to be implemented in the editableTextLine class.
     * @author Dylan Diener
     *
     */
    public interface Editable {
	public void append(String fragment);
	public void insert(int index, String fragment) throws TextLineIndexOutOfBoundsException;
	public void replace(int start, int end, String fragment) throws TextLineIndexOutOfBoundsException;
    }
}
