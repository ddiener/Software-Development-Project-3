package edu.uga.cs1302.txtbuff;

/**
 * This class contains all of the exceptions and variation of exceptions that are 
 * required for the unique needs of the EditableTextLine class.
 * @author Dylan Diener
 *
 */
public class TextLineIndexOutOfBoundsException extends IndexOutOfBoundsException{

    /**
     * This constructor is for an exception that calls on its parent class whenever thrown.
     */
    public TextLineIndexOutOfBoundsException() {
	super();
    }
    
    /**
     * This constructor is for an exception that  calls on its parent class whenever thrown. 
     * @param errMsg This parameter is the error message that is displayed when this 
     * exception is thrown and dealt with.
     */
    public TextLineIndexOutOfBoundsException(String errMsg) {
	super(errMsg);
    }
    
    /**
     * This constructor occurs uniquely from within the EditableTExt class. Thrown whenever bounds do not
     * match an index.
     * @param index This essentially just becomes a part of the error message that is displayed when the exception
     * is thrown. It is just more specitic of the kind of error. 
     */
    public TextLineIndexOutOfBoundsException(int index) {
	this( (String) "TextLine index out of range: " + index);
    }
}
