import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class FrequencySort {
	
	
	public static int[] FrequencySort(int arr[]) {
		
		
		/* create a Map that keeps track of the values in the array */
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>();
		mapEntryComparator comparator = new mapEntryComparator();
		
		/* go thru the array and put the values into the map and 
		 * increment the counts
		 */
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		
		Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
		
		/* put the values from the map into the list and now sort them */
		for (Map.Entry<Integer, Integer> m : entrySet) {
			list.add(m);
		}
		Collections.sort(list, comparator);
		
		/* to put the values back into the array */
		
		int times;
		int pos = 0;
		for (Map.Entry<Integer, Integer> m : list) {
			times = m.getValue();
			while (times > 0) {
				arr[pos] = m.getKey();
				times--;
				pos++;
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {2,2,3,3,5,7,7,7};
		int[] arr2 = {10,10,10};
		int[] arr3 = {-1,-1,-1,5};
		arr = FrequencySort.FrequencySort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		arr2 = FrequencySort.FrequencySort(arr2);
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		arr3 = FrequencySort.FrequencySort(arr3);
		for (int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		
		
	}
	
}

/* Comparator that is used to place the elements into the following order:
 * The higher value is placed before the lower value.
 * If the value is the same, then the key is placed 
 * in their natural order.
 * So, an ordering would be: { (5,3), (7,2), (14,2) }
 */
class mapEntryComparator implements Comparator<Map.Entry<Integer, Integer>> {

	@Override
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
		
		if (o1.getValue() > o2.getValue()) {
			return -1;
		} else if (o1.getValue() < o2.getValue()) {
			return 1;
		} else {
			if (o1.getKey() < o2.getKey()) {
				return -1;
			} else if (o1.getKey() > o2.getKey()) {
				return 1;
			} else {
				// this should not happen since there would be never be duplicate keys in the map
				return 0; 
			}
		}
		
		
	}

}