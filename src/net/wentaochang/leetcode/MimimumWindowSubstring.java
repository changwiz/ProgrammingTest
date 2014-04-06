package net.wentaochang.leetcode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.SortedMap;
import java.util.TreeMap;

public class MimimumWindowSubstring {
	// O(n) solution
	public String minWindow(String S, String T) {
		int minWindowBegin = -1;
		int minWindowEnd = -1;
		int sLen = S.length();
		int tLen = T.length();
		int[] needToFind = new int[256];

		for (int i = 0; i < tLen; i++) {
			needToFind[T.charAt(i)]++;
		}

		int[] hasFound = new int[256];
		int minWindowLen = Integer.MAX_VALUE;
		int count = 0;
		for (int begin = 0, end = 0; end < sLen; end++) {
			// skip characters not in T
			if (needToFind[S.charAt(end)] == 0)
				continue;
			hasFound[S.charAt(end)]++;
			if (hasFound[S.charAt(end)] <= needToFind[S.charAt(end)]) {
				count++;
			}

			// if window constraint is satisfied
			if (count == tLen) {
				// advance begin index as far right as possible,
				// stop when advancing breaks window constraint.
				while (needToFind[S.charAt(begin)] == 0 || hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]) {
					if (hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]) {
						hasFound[S.charAt(begin)]--;
					}
					begin++;
				}

				// update minWindow if a minimum length is met
				int windowLen = end - begin + 1;
				if (windowLen < minWindowLen) {
					minWindowBegin = begin;
					minWindowEnd = end;
					minWindowLen = windowLen;
				} // end if
			} // end if
		} // end for

		return (count == tLen) ? S.substring(minWindowBegin, minWindowEnd + 1) : "";
	}
	
	//O(nlgM)
	public String lessMinWindow(String S, String T) {
		  int N = S.length();
		  int M = T.length();
		  int minWindowBegin = -1;
		  int minWindowEnd = -1;
		  int minWindowLen = Integer.MAX_VALUE;
		   
		  // hash table init all to 0s
		  // used to check how many letters left in T to be filled
		  int []needToFill = new int[256];
		 
		  for (int i = 0; i < M; i++)
		    needToFill[T.charAt(i)]++;
		 
		  // array of queues, each corresponds to a unique char in T
		  Deque<Integer> []q = new Deque[256];
		  for(int i=0;i<256;++i){
			  q[i] = new ArrayDeque<Integer>();
		  }
		 
		  // maintains a sorted map (maps indices to char), 
		  // the first and last element tells us the 
		  // starting and ending position of the window
		  SortedMap<Integer,Character> m = new TreeMap<Integer,Character>();
		 
		  for (int i = 0; i < N; i++) {
		    // skips characters not in T
		    if (needToFill[T.charAt(i)] == 0) continue;
		    
		    // push character to queue
		    if (q[S.charAt(i)].size() < needToFill[S.charAt(i)]) {
		      q[S.charAt(i)].push(i);
		      m.put(i, S.charAt(i));
		    }
		    // replace the character in the queue 
		    // and updates the corresponding element in the map
		    else {
		      int idxToErase = q[S.charAt(i)].peek();
		      m.remove(idxToErase);
		      q[S.charAt(i)].pop();
		      q[S.charAt(i)].push(i);
		      m.put(i, S.charAt(i));
		    }
		 
		    // found a window, check for minimum
		    if (m.size() == M) {
		      int end = m.lastKey();
		      int begin = m.firstKey();
		      int windowLen = end - begin + 1;
		      if (windowLen < minWindowLen) {
		        minWindowLen = windowLen;
		        minWindowBegin = begin;
		        minWindowEnd = end;
		      }
		    } // end if
		  } // end for
		   
		  return (m.size() == M) ? S.substring(minWindowBegin, minWindowEnd+1) : "";
	}
}
