package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class lambdaTest {

	private static List<String> list = Arrays.asList("my", "name", "is", "w", "k");

	public static void oldSort() {
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if (o1.charAt(1) <= o2.charAt(1)) {
					return 1;
				} else {
					return -1;
				}

			}

		});
	}

	public static void newSort() {
		Collections.sort(list, (a, b) -> a.charAt(1) < b.charAt(1) ? 1 : -1);
	}

	private static void heapSort(int[] arr) {
		// 将待排序的序列构建成一个大顶堆
		for (int i = arr.length / 2; i >= 0; i--) {
			heapAdjust(arr, i, arr.length);
		}

		// 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
		for (int i = arr.length - 1; i > 0; i--) {
			swap(arr, 0, i); // 将堆顶记录和当前未经排序子序列的最后一个记录交换
			heapAdjust(arr, 0, i); // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
		}
	}
	
    private static void heapAdjust(int[] arr, int i, int n) {  
        int child;  
        int father;   
        for (father = arr[i]; leftChild(i) < n; i = child) {  
            child = leftChild(i);  
              
            // 如果左子树小于右子树，则需要比较右子树和父节点  
            if (child != n - 1 && arr[child] < arr[child + 1]) {  
                child++; // 序号增1，指向右子树  
            }  
              
            // 如果父节点小于孩子结点，则需要交换  
            if (father < arr[child]) {  
                arr[i] = arr[child];  
            } else {  
                break; // 大顶堆结构未被破坏，不需要调整  
            }  
        }  
        arr[i] = father;  
    }  
	// 获取到左孩子结点  
    private static int leftChild(int i) {  
        return 2 * i + 1;  
    }  
      
    // 交换元素位置  
    private static void swap(int[] arr, int index1, int index2) {  
        int tmp = arr[index1];  
        arr[index1] = arr[index2];  
        arr[index2] = tmp;  
    } 

	public static void main(String[] args) {
		// oldSort();
		// newSort();

		long t0 = System.nanoTime();

		// 初始化一个范围100万整数流,求能被2整除的数字，toArray（）是终点方法

		int a[] = IntStream.range(0, 1_000_000).filter(p -> p % 2 == 0).toArray();

		long t1 = System.nanoTime();

		// 和上面功能一样，这里是用并行流来计算

		int b[] = IntStream.range(0, 1_000_000).parallel().filter(p -> p % 2 == 0).toArray();

		long t2 = System.nanoTime();

		// 我本机的结果是serial: 0.06s, parallel 0.02s，证明并行流确实比顺序流快

		System.out.printf("serial: %.2fs, parallel %.2fs%n", (t1 - t0) * 1e-9, (t2 - t1) * 1e-9);

		int[] arr = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };
		Arrays.stream(arr).forEach((i) -> System.out.print(i + " "));

		heapSort(arr);
		Arrays.stream(arr).forEach((i) -> System.out.print(i + " "));

		
		List<String> lst = new ArrayList<String>();
		lst = Arrays.asList(new String[] {"1","2","a","bbb"});
		
		Iterator it = lst.iterator();
	}
}
