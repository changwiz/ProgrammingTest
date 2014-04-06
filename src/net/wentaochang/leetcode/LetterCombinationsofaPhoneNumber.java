package net.wentaochang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
	//Use greedy dfs
	   private HashMap<Character,List<String>> table;
	    public ArrayList<String> letterCombinations(String digits) {
	    	initTable();
	        ArrayList<String> result = new ArrayList<String>();
	        if(digits==null||digits.length()==0){
	            result.add("");
	            return result;
	        }
	        try {
	            int num = Integer.parseInt(digits);
	        }catch(Exception e){
	            result.add("");
	            return result;
	        }
	        List<String> test = table.get(digits.charAt(0));
	        if(test == null || test.size()==0){
	            result.addAll(dfs(digits,1));
	        } else {
	            for(String s:test){
	            	if(dfs(digits,1).size() == 0){
	            		result.add(s);
	            	} else {
	                	for(String t:dfs(digits,1)){
	                		result.add(s+t);
	                	}
	            	}
	            }
	        }
	        return result;
	        
	    }
	    
	    public List<String> dfs(String digits, int index){
	    	List<String> result = new ArrayList<String>();
	        if(index >= digits.length()){
	            return new ArrayList<String>();
	        }
	        List<String> test = table.get(digits.charAt(index));
	        if(test == null || test.size()==0){
	            result.addAll(dfs(digits,index+1));
	        } else {
	            for(String s:test){
	            	if(dfs(digits,index+1).size() == 0){
	            		result.add(s);
	            	} else {
	                	for(String t:dfs(digits,index+1)){
	                		result.add(s+t);
	                	}
	            	}
	            }
	        }
	        return result;
	    }
	    
	    public void initTable(){
	        table = new HashMap<Character,List<String>>();
	        List<String> test = new ArrayList<String>();
	        test.add("a");
	        test.add("b");
	        test.add("c");
	        table.put('2',test);
	        test = new ArrayList<String>();
	        test.add("d");
	        test.add("e");
	        test.add("f");
	        table.put('3',test);
	        test = new ArrayList<String>();
	        test.add("g");
	        test.add("h");
	        test.add("i");
	        table.put('4',test);
	        test = new ArrayList<String>();
	        test.add("j");
	        test.add("k");
	        test.add("l");
	        table.put('5',test);
	        test = new ArrayList<String>();
	        test.add("m");
	        test.add("n");
	        test.add("o");
	        table.put('6',test);
	        test = new ArrayList<String>();
	        test.add("p");
	        test.add("q");
	        test.add("r");
	        test.add("s");
	        table.put('7',test);
	        test = new ArrayList<String>();
	        test.add("t");
	        test.add("u");
	        test.add("v");
	        table.put('8',test);
	        test = new ArrayList<String>();
	        test.add("w");
	        test.add("x");
	        test.add("y");
	        test.add("z");
	        table.put('9',test);
	    }
}
