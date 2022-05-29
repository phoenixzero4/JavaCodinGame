package codinGame;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
  * 
  *  @author phoenix May 27, 2022
  *  
  *  Output a String output of a logic gates 2 inputs, represented by
  *  Strings of _(underscore) = false and -(minus) = true;
  *  
  *  numInputSignals input signals
  *  numOutputSignals number of output signals
  *  next numInputSignals lines = space separated Strings (name of input signal, signal form)
  *  next numOutputSignals lines = 4 space separated Strings (name of ouput, logicGateType of gate, first input, second input)
  *  
  *  
  */

public class LogicGates {

    /**
     * @param String:logicGateType - value of logic gate
     * @param String:inputSignalOne
     * @param String:inputSignalTwo
     * 
     * @returns String:output
     */
    private static String getOutput(String logicGateType, String inputSignalOne, String inputSignalTwo) {
        
        String output = "";
        
        if(logicGateType.equals("AND")) {
            for(int i = 0; i < inputSignalOne.length(); i++) {
                if(inputSignalOne.charAt(i) == '-' && inputSignalTwo.charAt(i) == inputSignalOne.charAt(i)) {
                    output+="-";
                }else {
                    output+="_";
                }
            }
        }else if(logicGateType.equals("OR")) {
            for (int i = 0; i < inputSignalOne.length(); i++) {
                if(inputSignalOne.charAt(i) == '-' || inputSignalTwo.charAt(i) == '-') {
                    output+="-";
                }else {
                    output+="_";
                }
            }
        }else if(logicGateType.equals("XOR")) {
            for (int i = 0; i < inputSignalOne.length(); i++) {
                if( (inputSignalOne.charAt(i) == '-' || inputSignalTwo.charAt(i) == '-') && inputSignalOne.charAt(i) != inputSignalTwo.charAt(i)) {
                    output+= "-";
                }else {
                    output += "_";
                }
            }
        }else if(logicGateType.equals("NOR")) {
            for (int i = 0; i < inputSignalOne.length(); i++) {
                if(inputSignalOne.charAt(i) == '_' && inputSignalTwo.charAt(i) == '_') {
                    output += "-";
                }else {
                    output += "_";
                }
            }
        }else if(logicGateType.equals("NAND")) {
            for (int i = 0; i < inputSignalOne.length(); i++) {
                if(inputSignalOne.charAt(i) == '-' && inputSignalTwo.charAt(i) == '-') {
                    output += "_";                    
                }else {
                    output += "-";
                }
            }
        }else if(logicGateType.equals("NXOR")) {
            for (int i = 0; i < inputSignalOne.length(); i++) {
                if( (inputSignalOne.charAt(i) == '-' || inputSignalTwo.charAt(i) == '-') && inputSignalOne.charAt(i) != inputSignalTwo.charAt(i)) {
                    output += "_";
                }else {
                    output += "-";
                }
            }
        }
        return output;
    }

    public static void main(String args[]) throws Exception {

        Scanner in = new Scanner(new File("logicGatesInput.txt"));
        
        int numInputSignals = Integer.parseInt(in.nextLine());
        int numOutputSignals = Integer.parseInt(in.nextLine());
        
        HashMap<String, String> inputMap = new HashMap<>();      
        
        for (int i = 0; i < numInputSignals; i++) {
            
            String inputName = in.next();
            String inputSignal = in.next();
            
            inputMap.put(inputName, inputSignal);
            
            in.nextLine();
        }
        
        for (int i = 0; i < numOutputSignals; i++) {
            
            String outputName = in.next();
            String logicGateType = in.next();
            String inputName1 = in.next();
            String inputName2 = in.next();
            
            String inputSignalOne = inputMap.get(inputName1);
            String inputSignalTwo = inputMap.get(inputName2);
            
            System.out.println(outputName + " " + getOutput(logicGateType, inputSignalOne, inputSignalTwo));
        }

    }
}
