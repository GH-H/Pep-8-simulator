package model.instructionType;

import controller.Controller;
import model.instructionType.Instruction;

/**
 * This class was design to shift
 * the selected binary number first 1 to the left
 * WARNING: only UNSIGNED binary! 
 */

public class ArithmeticShiftLeft extends Instruction{
	
	/** The destination register number. */
	private String myRd;
   
	/** Temporary int holder. */
	public int holder;
	
	public  ArithmeticShiftLeft(String myInstructionSpecifier, String operandSpecifier, String myRd) {
		super(myInstructionSpecifier,operandSpecifier);
		this.myRd = myRd;
	}

	@Override
	public void execute(Controller theCon) {
		// TODO Auto-generated method stub
		holder = Integer.valueOf(myRd);
		holder = holder >>> 1;
		
		theCon.setMyIndexRegister(String.valueOf(holder));
	}
    
}
