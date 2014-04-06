package net.wentaochang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	// Very hard problem, my solution timeout
	/*private static class Node {
		String val;
		Node parent;
		HashSet<String> visited = new HashSet<String>();;

		Node(String str) {
			this.val = str;
		}
	}

	// add a parent pointer to solution of WordLadder
	public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (start == null || end == null || start.length() != end.length() || dict == null || dict.size() == 0) {
			return res;
		}
		findLadder(start, end, dict, res);
		return res;
	}

	private static void findLadder(String start, String end, HashSet<String> dict, ArrayList<ArrayList<String>> res) {
		LinkedList<Node> wordQueue = new LinkedList<Node>();
		wordQueue.add(new Node(start));

		while (!wordQueue.isEmpty()) {
			Node currWord = wordQueue.pop();

			if (currWord.val.equals(end)) {
				ArrayList<String> temp = new ArrayList<String>();
				Node node = currWord;
				while (node != null) {
					temp.add(0, node.val);
					node = node.parent;
				}
				res.add(temp);
			}
			if (res.size() > 0) {
				continue;
			}

			for (int i = 0; i < currWord.val.length(); i++) {
				char[] currCharArr = currWord.val.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					currCharArr[i] = c;

					String newWord = new String(currCharArr);
					if (!currWord.visited.contains(newWord) && dict.contains(newWord)) {
						Node node = new Node(newWord);
						node.parent = currWord;
						node.visited.addAll(currWord.visited);
						node.visited.add(newWord);
						wordQueue.add(node);

					}
				}
			}
		}
	}
*/
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> res = findLadders("hot", "dog", new HashSet<String>(Arrays.asList("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot")));
		for (ArrayList<String> t : res) {
			for (String a : t) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}
	
	static class WordWithLevel {
		String word;
		int level;

		public WordWithLevel(String word, int level) {
			this.word = word;
			this.level = level;
		}
	}

	/*整个过程可以分成两个部分：先通过BFS从start找到end，在找的过程中需要记录前驱单词，再用DFS反向找回完整路径。

	但是用Java实现上述过程会遇到TLE。为了能让用时尽可能短，有如下几点需要注意的地方：

	1. 由于最后生成路径的时候，需要从end找到start构造ArrayList，即使用LinkList来协助构造，性能也不好。解决办法：不从start找end了，反过来从end找start，找到后，再从start往end构造路径，性能会有明显提升。

	2. 在BFS过程中，需要替换String的每一位字符，先转换成char数组再操作，性能也会有明显提升。

	3. 在BFS过程中，注意避免一些不必要的搜索，具体细节参考如下代码。*/
	private static String end;
	private static ArrayList<ArrayList<String>> result;
	private static Map<String, List<String>> nextMap;

	public static ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		result = new ArrayList<ArrayList<String>>();
		WordLadderII.end = end;

		// unvisited words set
		Set<String> unVisited = new HashSet<String>();
		unVisited.addAll(dict);
		unVisited.add(start);
		unVisited.remove(end);

		// used to record the map info of <word : the words of next level>
		nextMap = new HashMap<String, List<String>>();
		for (String e : unVisited) {
			nextMap.put(e, new ArrayList<String>());
		}

		// BFS to search from the end to start
		Queue<WordWithLevel> queue = new LinkedList<WordWithLevel>();
		queue.add(new WordWithLevel(end, 0));
		boolean found = false;
		int finalLevel = Integer.MAX_VALUE;
		int currentLevel = 0;
		int preLevel = 0;
		Set<String> visitedWordsInThisLevel = new HashSet<String>();
		while (!queue.isEmpty()) {
			WordWithLevel wordWithLevel = queue.poll();
			String word = wordWithLevel.word;
			currentLevel = wordWithLevel.level;
			if (found && currentLevel > finalLevel) {
				break;
			}
			if (currentLevel > preLevel) {
				unVisited.removeAll(visitedWordsInThisLevel);
			}
			preLevel = currentLevel;
			char[] wordCharArray = word.toCharArray();
			for (int i = 0; i < word.length(); ++i) {
				char originalChar = wordCharArray[i];
				boolean foundInThisCycle = false;
				for (char c = 'a'; c <= 'z'; ++c) {
					wordCharArray[i] = c;
					String newWord = new String(wordCharArray);
					if (c != originalChar && unVisited.contains(newWord)) {
						nextMap.get(newWord).add(word);
						if (newWord.equals(start)) {
							found = true;
							finalLevel = currentLevel;
							foundInThisCycle = true;
							break;
						}
						if (visitedWordsInThisLevel.add(newWord)) {
							queue.add(new WordWithLevel(newWord,
									currentLevel + 1));
						}
					}
				}
				if (foundInThisCycle) {
					break;
				}
				wordCharArray[i] = originalChar;
			}
		}

		if (found) {
			// dfs to get the paths
			ArrayList<String> list = new ArrayList<String>();
			list.add(start);
			getPaths(start, list, finalLevel + 1);
		}
		return result;
	}

	private static void getPaths(String currentWord, ArrayList<String> list, int level) {
		if (currentWord.equals(end)) {
			result.add(new ArrayList<String>(list));
		} else if (level > 0) {
			List<String> parentsSet = nextMap.get(currentWord);
			for (String parent : parentsSet) {
				list.add(parent);
				getPaths(parent, list, level - 1);
				list.remove(list.size() - 1);
			}
		}
	}
}
