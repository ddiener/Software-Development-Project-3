package edu.uga.cs1302.test;
import edu.uga.cs1302.txtbuff.*;
import java.util.Scanner;

public class TextLineTester {

    public static void main(String[] args) {
	TextLine tLine = new TextLine("one line of text");
	System.out.println("Please enter a line of text: ");
	
	Scanner keyboard = new Scanner(System.in);
	
	EditableTextLine eLine = new EditableTextLine(keyboard.nextLine());
	
	System.out.println("Are these two objects the same?: ");
	
	if(tLine.equals(eLine))
	    System.out.println("Equal");
	else
	    System.out.println("Different");
	
	System.out.println();
	System.out.println("eLine: " + eLine.toString());
	System.out.println("Length: " + eLine.length());
	System.out.println("Capacity: " + eLine.capacity());
	
	System.out.println();
	System.out.println("Please enter a string of characters: ");
	String str = keyboard.next();
	
	System.out.println();
	
	int occurCount = 0;
	int indexTemp = 0;
	if(eLine.indexOf(str) == -1)
	    System.out.println("Number of occurances of str in eLine: none");
	else {
	    for(int i = 0; i < eLine.length(); i++) {
		if(eLine.indexOf(str, i) == 0) {
		    occurCount++;
		}
		if(indexTemp != eLine.indexOf(str, i) && eLine.indexOf(str, i) != -1) {
		    occurCount++;
		    indexTemp = eLine.indexOf(str, i);
		}
	    }
	    System.out.println("Number of occurances of str in eLine: " + occurCount);
	}
	
	eLine.append(str);
	System.out.println("Updated eLine: " + eLine.toString());
	eLine.insert(0, str);
	System.out.println("New eLine: " + eLine.toString());
	eLine.insert(str.length(), str);
	System.out.println("Newer eLine: " + eLine.toString());
	
	int indexCounter = 0;
	while(indexCounter != -1) {
	    if(eLine.indexOf(str, indexCounter) == -1)
		indexCounter = -1;
	    else {
		eLine.replace(eLine.indexOf(str, indexCounter), eLine.indexOf(str, indexCounter) + 3, "abc");
		indexCounter += str.length();
	    }
	}
	
	System.out.println("Replaced eLine: " + eLine.toString());
	
    }

}
