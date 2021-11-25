package hackerrank.hashmaps;

import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> elementCountMap= new HashMap<>();
        int [] frequency = new int [queries.size()] ;

        
        queries.forEach((query) -> {
            int querytype = query[0];
            int element = query[1];
            Integer currentCount =null;
            if (querytype != 3) {
                currentCount = elementCountMap.get(element);
            }
            switch (querytype) {
            case 1:
            	if(currentCount == null || currentCount <0) {
            		currentCount = 0;
            	}
            	
            	Integer addCount = currentCount + 1;
            	
            	elementCountMap.put(element, currentCount + 1);
               	frequency[addCount] = frequency[addCount]+1;
               	frequency[currentCount] = frequency[currentCount] -1;
                break;
            case 2:
                if (currentCount == null ||  currentCount <=0 ) {
                    break;
                }
                Integer removeCount = currentCount - 1;
                
                elementCountMap.put(element, removeCount);
               	frequency[currentCount] = frequency[currentCount]-1;
                frequency[removeCount]= frequency[removeCount] + 1;
                
                break;
            case 3:
                ans.add(element<frequency.length && frequency[element]> 0 ? 1 : 0);
                break;
            default:
                break;
            }
            System.out.print("Input: ["+querytype+","+element+"]");
            System.out.print("\tCurrent Count: "+currentCount);
            System.out.print("\tFrequency: [");
            for(int i=1 ; i < frequency.length;i++) {
            	System.out.print(" "+i+":"+frequency[i]);            	
            }
            System.out.print(" ] ");
            System.out.print("\tElement Count: [");
            elementCountMap.forEach((el, count) -> {
                System.out.print(" "+el+":"+count);
            });
            System.out.print(" ]");
            System.out.print("\tOutput:"+ ans);
            System.out.println();

        });    
        
        return ans;
    }

	public static void main(String[] args) throws IOException {
//        console();
/*        test(
        		Arrays.asList(
        				new int[]{1,5},
        				new int[] {1,6},
        				new int[] {3,2},
        				new int[] {1,10},
        				new int[] {1,10},
        				new int[] {1,6},
        				new int[] {2,5},
        				new int[] {3,2}
        		));
        test(
        		Arrays.asList(
        				new int[] {3,4},
        				new int[] {2,1003},
        				new int[] {1,16},
        				new int[] {3,1}
        		));
        
        test(
        		Arrays.asList(
        				new int[] {1,3},
        				new int[] {2,3},
        				new int[] {3,2},
        				new int[] {1,4},
        				new int[] {1,5},
        				new int[] {1,5},
        				new int[] {1,4},
        				new int[] {3,2},
        				new int[] {2,4},
        				new int[] {3,2}
        		)); 
        test(
        		Arrays.asList(
        				new int[] {1,3},
        				new int[] {1,3},
        				new int[] {3,2},
        				new int[] {2,3},
        				new int[] {2,3},
        				new int[] {2,3},
        				new int[] {3,2}
        		)); 
        
  */    
        test(
        		Arrays.asList(new int[] {3, 5},
        				new int[] {3, 3},
        				new int[] {1, 10000004},
        				new int[] {1, 10000016},
        				new int[] {1, 10000011},
        				new int[] {3, 10},
        				new int[] {1, 10000006},
        				new int[] {3, 5},
        				new int[] {2, 4},
        				new int[] {2, 3},
        				new int[] {2, 6},
        				new int[] {1, 10000037},
        				new int[] {3, 10},
        				new int[] {3, 3},
        				new int[] {1, 10000013},
        				new int[] {1, 10000013},
        				new int[] {3, 10},
        				new int[] {3, 10},
        				new int[] {1, 10000025},
        				new int[] {1, 10000021},
        				new int[] {2, 7},
        				new int[] {1, 10000002},
        				new int[] {3, 7},
        				new int[] {3, 9},
        				new int[] {2, 9},
        				new int[] {2, 8},
        				new int[] {3, 4},
        				new int[] {3, 4},
        				new int[] {1, 10000025},
        				new int[] {3, 6},
        				new int[] {1, 10000037},
        				new int[] {2, 9},
        				new int[] {2, 8},
        				new int[] {1, 10000042},
        				new int[] {2, 7},
        				new int[] {2, 10},
        				new int[] {1, 10000002},
        				new int[] {2, 2},
        				new int[] {2, 4},
        				new int[] {2, 5},
        				new int[] {1, 10000005},
        				new int[] {1, 10000021},
        				new int[] {1, 10000031},
        				new int[] {3, 4},
        				new int[] {1, 10000013},
        				new int[] {1, 10000045},
        				new int[] {3, 8},
        				new int[] {3, 2},
        				new int[] {3, 4},
        				new int[] {1, 10000024},
        				new int[] {3, 5},
        				new int[] {2, 2},
                		new int[] {2, 5},
                        new int[] {3, 3}
        		)); 
    }

	private static void test(List<int[]> queries) {
	System.out.print("Input: [");
	queries.forEach((el)->{System.out.print(" {"+el[0]+","+el[1]+"}");});
	System.out.println(" ]");
	List<Integer> ans = freqQuery(queries);
	System.out.print("Result : [");
	ans.forEach(element -> {System.out.print(" "+element);});
	System.out.println(" ]");
	System.out.println("=====================================================");
	 
	}

	private static void console() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());
        List<int[]> queries = new ArrayList<>(q);
        Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
        for (int i = 0; i < q; i++) {
          int[] query = new int[2];
          Matcher m = p.matcher(bufferedReader.readLine());
          if (m.matches()) {
            query[0] = Integer.parseInt(m.group(1));
            query[1] = Integer.parseInt(m.group(2));
            queries.add(query);
          }
        }

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
	}
    static List<Integer> freqQueryTimingOut(List<int[]> queries) {
    	/**
		 create Map to maintain element and its count, elementCountMap
		 create Map to maintain count and set of elements, countElementSetMap
		 create List for result
		 
		 Loop over queries List
			if query type is not 3
				get current count for the element from elementCountMap,
		 for insert operation, 
		 	 if countElementSetMap contains this count
		 		remove the element from countElementSetMap.

		 	if count is 0 
		 		insert in elementCountMap with 1.
		 	else
		  		increment count and add to elementCountMap 

		  	if countElementSetMap does not contain this count
		  		create new Set with this element
		  		set new count to 1.

			add to element countElementSetMap for the new count,
		 
		 for delete operation, 
		 	if count is > 0
		 		remove the element from countElementSetMap.
		  		decrement count and add to elementCountMap
		  		if  countElementSetMap does not contain this count  
		  			create new Set with this element
		  			set new count to 1.
					add to element countElementSetMap for the new count,
		 
		 for query operation,
		 	check if countElementSetMap has the key and add 1 to the result.
*/

    	List<Integer> ans = new ArrayList<>();
    	Map<Integer,Long> elementCountMap= new HashMap<>();
    	Map<Long,Set<Integer>> countElementSetMap= new HashMap<>();
    	
    	
		queries.forEach((query) -> {
			int querytype = query[0];
			int element = query[1];
			Long currentCount = null;
			if (querytype != 3) {
				currentCount = elementCountMap.get(element);
			}
			switch (querytype) {
			case 1:
				Long newInsertCount = 1L;
				if (currentCount !=null) {
					Set<Integer> insertElements = countElementSetMap.get(currentCount);
					if (insertElements != null && !insertElements.isEmpty()) {
						insertElements.remove(element);
						countElementSetMap.put(currentCount, insertElements);
					}
					newInsertCount =  currentCount + 1;
				}
				elementCountMap.put(element, newInsertCount);

				Set<Integer> insertElementsNew = countElementSetMap.get(newInsertCount);
				if (insertElementsNew == null || insertElementsNew.isEmpty()) {
					insertElementsNew = new HashSet<>();
				}

				insertElementsNew.add(element);
				countElementSetMap.put(newInsertCount, insertElementsNew);

				break;
			case 2:

				if (currentCount == null) {
					break;
				}
				Set<Integer> removeElements = countElementSetMap.get(currentCount);
				if (removeElements != null && !removeElements.isEmpty()) {
					removeElements.remove(element);
					countElementSetMap.put(currentCount, removeElements);
				}
				Long newRemoveCount = currentCount - 1;

				if (newRemoveCount == 0L) {
					elementCountMap.remove(element);
					break;
				}
				elementCountMap.put(element, newRemoveCount);

				Set<Integer> removeElementsNew = countElementSetMap.get(newRemoveCount);
				if (removeElementsNew == null) {
					removeElementsNew = new HashSet<>();
				}
				removeElementsNew.add(element);
				countElementSetMap.put(newRemoveCount, removeElementsNew);
				break;
			case 3:
				Set<Integer> elements = countElementSetMap.get(Long.valueOf(element));
				ans.add(elements==null || elements.isEmpty() ? 0 : 1);
				break;
			default:
				break;
			}
			System.out.print(" Output:"+ ans);
			System.out.print("\tInput: ["+querytype+","+element+"]");
			System.out.print("\tCurrent Count: "+currentCount);
			System.out.print("\tCount Element Set:");
			countElementSetMap.forEach((count, elementSet) -> {
				System.out.print(" ["+count+":{");
				elementSet.forEach((el)->{System.out.print(" "+el);});
				System.out.print(" }]");
			});

			System.out.print(" Element Count: [");
			elementCountMap.forEach((el, count) -> {
				System.out.print(" "+el+":"+count);
			});
			System.out.println(" ]");

		});	
    	
    	return ans;
    }
    static List<Integer> freqQueryTiminOut3Fails(List<int[]> queries) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> elementCountMap= new HashMap<>();
        
        
        queries.forEach((query) -> {
            int querytype = query[0];
            int element = query[1];
            Integer currentCount = -1;
            if (querytype != 3) {
                currentCount = elementCountMap.get(element);
            }
            switch (querytype) {
            case 1:
                elementCountMap.put(element, currentCount ==null? 1 : currentCount + 1);
                break;
            case 2:
                if (currentCount == null) {
                    break;
                }
                if(currentCount == 1) {
                	elementCountMap.remove(element);
                	break;
                }
                elementCountMap.put(element, currentCount-1);
                break;
            case 3:
                ans.add(elementCountMap.containsValue(element)? 1 : 0);
                break;
            default:
                break;
            }
//            System.out.print(" Output:"+ ans);
//            System.out.print("\tInput: ["+querytype+","+element+"]");
//            System.out.print("\tCurrent Count: "+currentCount);
//
//            System.out.print(" Element Count: [");
//            elementCountMap.forEach((el, count) -> {
//                System.out.print(" "+el+":"+count);
//            });
//            System.out.println(" ]");

        });    
        
        return ans;
    }
  
}
