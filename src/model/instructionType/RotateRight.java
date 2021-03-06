package model.instructionType;

import controller.Controller;
import model.instructionType.Instruction;

/**
 * This class was design to Rotate
 * the selected binary number first 1 to the left
 */

public class RotateRight extends Instruction{

	/** The destination register number. */
	private String myRd;
   
	/** Temporary array holder. */
	public String holder;
	
	public  RotateRight (String myInstructionSpecifier, String operandSpecifier, String myRd) {
		super(myInstructionSpecifier,operandSpecifier);
		this.myRd = myRd;
	}
	
	@Override
	public void execute(Controller theCon) {
		holder = myRd.substring(myRd.length() - 1) + myRd.substring(0, myRd.length() - 1);
        
		theCon.setMyIndexRegister(holder);
	}

}