package edu.uga.cs1302.txtbuff;
import edu.uga.cs1302.txtbuff.TextLine.Editable;

/**
 * This class is a subclass of the Textline class that does everything that a TextLine
 * object can do, but this class has the ability to be edited, appended, replaced, etc..
 * @author Dylan Diener
 *
 */
public class EditableTextLine extends TextLine implements Editable {
    
    /**
     * This constructor creates an EditableTextLine object by calling its 
     * parent class's constructor.
     */
    public EditableTextLine() {
	super();
    }
    
    /**
     * This contructor creates an EditableTextLine object with the given string
     * located in the start of the object.
     * @param line This is the string that is to be placed at the beginning of the object.
     */
    public EditableTextLine(String line) {
	super(line);
    }
    
    /**
     * This method takes an Editable object's length and tacks on the string given in the parameter 
     * at the very end.
     * @param fragment This is the string that is going to be added onto the Editable object
     */
    public void append(String fragment) {
	while(capacity < length() + fragment.length())
	    capacity += DEFAULT_SIZE;
	
	char[] newCharArray = new char[capacity];
	
	for(int i = 0; i < this.length(); i++) {
	    newCharArray[i] = charArray[i];
	}
	
	int p = 0;
	for(int i = this.length(); i < this.length() + fragment.length(); i++) {
	    newCharArray[i] = fragment.charAt(p);
	    p++;
	}
	
	charArray = newCharArray;
    }
    
    /**
     * This method inserts and squeezes a given fragment within the Editable object
     * at the specified position.
     * @param index This parameter is the index in which the string is to be inserted.
     * @param fragment This is the string that is to be inserted within the object.
     */
    public void insert(int index, String fragment) throws TextLineIndexOutOfBoundsException {
	if(index > capacity || index < 0)
	    throw new TextLineIndexOutOfBoundsException(index);
	
	while(fragment.length() + length() > capacity) {
	    capacity += DEFAULT_SIZE;
	}
	
	char[] newCharArray = new char[capacity];
	
	for(int i = 0; i < index; i++) {
	    newCharArray[i] = charArray[i];
	}
	
	int p = 0;
	for(int i = index; i >= index && i < index + fragment.length(); i++) {
	    newCharArray[i] = fragment.charAt(p);
	    p++;
	}
	
	p = 0;
	int c = index;
	for(int i = index + fragment.length(); c < this.length(); i++) {
	    newCharArray[i] = charArray[c];
	    c++;
	}
	
	charArray = newCharArray;
    }
    
    /**
     * This method replaces the space denoted by the start and end parameters with the string given in the 
     * parameters as well.
     * @param start This integer is the start of the block to be replaced.
     * @param end This is the integer that dentotes the end of the block to be replaced.
     * @param fragment This is the string value that will fill in the block between start and finish.
     */
    public void replace(int start, int end, String fragment) throws TextLineIndexOutOfBoundsException {
	if(start > capacity || end > capacity || start < 0 || end < 0 
	   || start > end)
	    throw new TextLineIndexOutOfBoundsException();
	
	char[] newCharArray = new char[capacity];
	if(start != 0) {
	    for(int i = 0; i < start; i++) {
		newCharArray[i] = charArray[i];
	    }
	    
	    int p = 0;
	    for(int i = start; i >= start && i < end; i++) {
		newCharArray[i] = fragment.charAt(p);
		p++;
	    }
	    
	    for(int i = end + 1; i < this.length(); i++) {
		newCharArray[i] = charArray[i];
	    }
	    
	    charArray = newCharArray;
	}
	else {
	    for(int i = 0; i < end; i++) {
		newCharArray[i] = fragment.charAt(i);
	    }
	    
	    for(int i = end + 1; i < this.length(); i++) {
		newCharArray[i] = charArray[i];
	    }
	    
	    charArray = newCharArray;
	}
	
    }
}
