package hackerrank.hashmaps;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Stream;

public class CountingTriplets {
	

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	Map<Long,Long> leftMap = new HashMap<Long,Long> ();
    	Map<Long,Long> rightMap = new HashMap<Long,Long> (); 
    	int length = arr.size();
    	for ( int i=0; i < length;i++) {
    		Long element = arr.get(i);
   			rightMap.put(element, rightMap.containsKey(element)? rightMap.get(element)+1:1L);
    	}
    	Long result = 0L;
    	
    	for ( int i=0; i < length;i++) {
    		Long element = arr.get(i);
    		
    		Long leftCount = leftMap.get(element/r);
    		leftMap.put(element, leftMap.containsKey(element)? leftMap.get(element)+1:1L);  
    		
    		Long count = rightMap.get(element);
    		rightMap.put(element,count-1);;
    		
    		Long rightCount = rightMap.get(element*r);
    		if(element % r != 0 ||  leftCount ==null || rightCount==null) {
    			continue;
    		}
  
			result += leftCount*rightCount;
//			Long leftElement = element /r;
//			Long rightElement = element * r;
//			System.out.print("i: "+ i +" left:(" +leftElement +","+leftCount+ ") element: ("+element + ","+count+")"+" rightElement: ("+rightElement +","+rightCount+") Result: "+result);
//			System.out.println();

    	}		

    	return result;
    }

	
    static long countTripletsWorkingMyAnswer(List<Long> arr, long r) {
    	Map<Long,Long> countMap = new HashMap<Long,Long> ();
    	Map<Long,Long> middleElementTriplets = new HashMap<> (); 
    	int length = arr.size();

    	Long result = 0L;
    	countMap.put(arr.get(0), 1L );

    	for ( int i=1; i < length;i++) {
    		Long element = arr.get(i);
    		
    		if(r!=1) {
	    		Long leftElement = element % r == 0 ? element/r  : 0L ;
	    		if(middleElementTriplets.containsKey(element) && countMap.containsKey(leftElement)) {
	    			Long count = middleElementTriplets.get(element);
	    			middleElementTriplets.put(element, countMap.get(leftElement)+ count);
	    		}else if (countMap.containsKey(leftElement)){
	    			middleElementTriplets.put(element,countMap.get(leftElement));
	    		}
	   			
	   			if(middleElementTriplets.containsKey(leftElement) && countMap.containsKey(leftElement/r)){
	   				result +=middleElementTriplets.get(leftElement);
	   			}
    		}
   			countMap.put(element, countMap.containsKey(element)? countMap.get(element) + 1L: 1L);
    	}
    	if(r==1) {
    		result=0L;
    		for(Entry<Long,Long> entry :countMap.entrySet()){
    				long count = entry.getValue();
    				result+=count * (count-1)*(count-2)/(3*2);
    		}
    	}
    	return result;
    }

    public static void main(String[] args) throws IOException {
//    	consoleInput();
    	test(Arrays.asList(new Long[] {1L, 5L, 5L, 25L, 125L}), 5);
    	test(Arrays.asList(new Long[] {1L, 1L, 1L, 1L}), 1);
    	test(Arrays.asList(new Long[] {1L, 1L, 1L, 1L,1L}), 1);
    	test(Arrays.asList(new Long[] {1L, 1L, 5L, 5L,25L, 25L}), 5);
    	test(Arrays.asList(new Long[] { 5L, 5L, 5L, 5L , 5L, 5L,5L,5L,5L,5L }), 1);
    	test(Arrays.asList(new Long[] { 5L, 5L, 5L, 6L , 6L, 6L, 7L,7L,7L, 1L, 1L ,1L ,1L }), 1);
    	test(Arrays.asList(new Long[] { 5L, 5L, 5L, 6L , 6L, 6L, 7L,7L,7L, 1L}), 1);
    	test(Arrays.asList(new Long[] { 1L, 10L, 100L, 1L , 10L, 100L, 1L,10L,100L}), 10);
    	test(Arrays.asList(new Long[] { 1L, 100L, 10L, 10L, 100L,100L,100L}), 10);
     	test(Arrays.asList(new Long[] { 1L, 2L, 1L, 2L,4L}), 2);
    	test(Arrays.asList(new Long[] { 1L, 3L, 9L, 9L, 27L, 81L}),3);     	
     	List<Long> list = new ArrayList<>();
     	for(Long i=1L ; i<=100000L;i++) {
     		list.add(1237L);
     	}
     	test(list, 1);
    }
    private static void test(List<Long> arr, long r){
    	System.out.print("Input: "); arr.subList(0,arr.size()>20?20 : arr.size()).forEach(x -> {System.out.print(x + " ");});
    	System.out.println();
    	long ans = countTriplets(arr, r);
    	System.out.println("Result: "+ans);
    	System.out.println("================================================================");
    }

	private static void consoleInput() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
	}
    // Complete the countTriplets function below.
    static long countTripletsInitialAttempt(List<Long> arr, long r) {
    	Map<Long,Long> x = new TreeMap<>();
    	Map<Long,Long> xr = new TreeMap<>();
    	Map<Long,Long> xrr = new TreeMap<>();

    	arr.forEach(element -> {
			Long xcount = x.get(element);
			x.put(element, xcount == null ? 1 : ++xcount);
			if (element % r == 0 ) {
				Long factor1 = element/r;
				Long xrcount = xr.get(factor1);
				xr.put(factor1, xrcount == null ? 1 : ++xrcount);	
			}
			if (element % (r*r) == 0 ) {
				Long factor2 = element/(r*r);
				Long xrrcount = xrr.get(factor2);
				xrr.put(factor2, xrrcount == null ? 1 : ++xrrcount);	
			}

		});
		
		System.out.print("x   :");
		x.forEach((key,value) -> {System.out.print("\t"+key+":"+value);});
		System.out.println();
		System.out.print("xr  :");
		xr.forEach((key,value) -> {System.out.print("\t"+key+":"+value);});
		System.out.println();
		System.out.print("xrr :");
		xrr.forEach((key,value) -> {System.out.print("\t"+key+":"+value);});
		System.out.println();
		
		Long count = 0L;

		for(Entry<Long, Long> elementPair : x.entrySet() ) {
			Long element = elementPair.getKey();
			Long factor0count=elementPair.getValue();
			Long factor1count= xr.get(element);
			Long factor2count= xrr.get(element);
			Long intermCount =0L;
			if (r == 1) {
				intermCount += (factor0count) * (factor0count - 1) * (factor0count - 2) / (3 * 2);
			} else if (factor0count != null && factor1count != null && factor2count != null) {
				intermCount += factor0count * factor1count * factor2count;
			}

			count+=intermCount;
			System.out.print("For "+element+"\tfactor0count = "+ factor0count);
			System.out.print("\tfactor1count = "+ factor1count);
			System.out.print("\tfactor2count = "+ factor2count);
			System.out.print("\tInterm Count= "+ intermCount);
			System.out.print("\tTotal = "+ count);
			System.out.println();
		};
    	
    	return count;
    }

    // Complete the countTriplets function below.
    static long countTripletsTimingOut(List<Long> arr, long r) {
    	List<Map<Long,Long>> elementCountByIndex = new ArrayList<>();
    	int length = arr.size();
    	Map<Long,Long> initialMap = new HashMap<>();
    	initialMap.put(arr.get(0), 1L);
    	elementCountByIndex.add(initialMap);
    	for ( int i=1; i< length;i++) {
    		Long element = arr.get(i);
    		Map<Long,Long> countMap = new HashMap<>(elementCountByIndex.get(i-1));
    		Long elementCount = countMap.get(element);
    		if(elementCount==null) {
    			countMap.put(element, 1L);
    		}else {
    			countMap.put(element, ++elementCount);
    		}
    		elementCountByIndex.add(countMap);
    	}
    	
    	Long result = 0L;
    	Map<Long,Long> finalMap = elementCountByIndex.get(length-1);
    	
    	for ( int i=1; i< length;i++) {
    		Long element = arr.get(i);
    		if(element%r==0) {
    			long leftElement = element/r;
    			long rightElement = element*r;
	    		Long leftCountOfxbyr = elementCountByIndex.get(i-1).get(leftElement);
	    		Long leftCountOfxr = elementCountByIndex.get(i).get(rightElement);
	    		Long finalCountOfxr = finalMap.get(element*r);


	    		if(leftCountOfxbyr !=null && finalCountOfxr!=null && finalCountOfxr > 0 && leftCountOfxbyr > 0) {
	    			long count = leftCountOfxbyr * (finalCountOfxr- (leftCountOfxr==null ? 0 : leftCountOfxr));
	    			result+=count;
	    		}
    		}
    	}		
    	return result;
    }
    // Complete the countTriplets function below.
    static long countTripletsTimingOut2(List<Long> arr, long r) {
    	Map<Long,Long> countMap = new HashMap<Long,Long> ();
    	Map<Long,Long> leftCountAtIndexMap = new HashMap<Long,Long> (); 
    	int length = arr.size();

    	Long result = 0L;
    	
    	for ( int i=0; i < length;i++) {
    		Long element = arr.get(i);
    		Long leftElement = element % r == 0 ? element/r  : 0L ;
    		Long leftCount = countMap.get(leftElement);
    		Long elementCount = countMap.containsKey(element)? countMap.get(element): 0L;
    		countMap.put(element, elementCount + 1 );
    		
    		if(leftElement==0L) {
    			continue;
    		}
   			
   			if(leftCount==null) {
   				continue;
   			}
   			Long rightElement = element *r;
   			
//   			long rightCount = 1L;
 			long rightCount = count(arr.subList(i+1, length),rightElement);
 			
			result += leftCount*rightCount;
			System.out.print("i: "+ i +" leftElement: " +leftElement + " element: "+element + " rightElement: "+rightElement +" leftCount: "+ leftCount+" rightCount:"+rightCount +" Result: "+result);
			System.out.println();
    	}		
    	return result;
    }
    static long count(List<Long> arr, Long element){
    	return arr.stream().filter(x -> {return x.longValue()==element.longValue();}).count();
    }

}
