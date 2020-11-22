学习笔记
--BubbleSort
public class BubbleSort {
	public static void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j + 1]){
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
--QuickSort
public class TestQuickSort {
	public static void QuickSort(int[] arr,int start, int end){
		if(start < end){
			int low = start;
			int high = end;
			int standard = arr[low];
			while(low < high){
				while(low < high && standard < arr[high])high--;
				if(low < high) arr[low++] = arr[high];
				while(low < high && standard > arr[low])low++;
				if(low < high) arr[high--] = arr[low];
			}
			arr[low] = standard;
			QuickSort(arr, start, low - 1);
			QuickSort(arr, low + 1, end);
		}
	}
}
--InsertSort
import java.util.Arrays;

public class TestInsertSort {
	public static void insertSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < arr[i - 1]) {
				int temp = arr[i];
				int j;
				for(j = i - 1; j >= 0 && temp < arr[j]; j--) {
					arr[j + 1] = arr[j];
				}
				arr[j + 1] = temp;
			}
		}
		
	}
}
--SelectSort
public class TestSelectSort {
	public static void SelectSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int min = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[min] > arr[j]) {
 				    min = j;
				}
			}
			if(i != min) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
	}
}
--MergeSort
public class TestMergeSort {
	public static void mergeSort(int[] arr, int low, int high) {
		int middle = (high + low)/2;
		if(low < high) {
			mergeSort(arr, low, middle);
			mergeSort(arr, middle + 1, high);
			merge(arr, low, middle, high);
		}
	}
	public static void merge(int[] arr, int low, int middle, int high) {
		int i = low;
		int j = middle + 1;
		int index = 0;
		int[] temp = new int[high - low + 1];
		while(i <= middle && j <= high){
			if(arr[i] <= arr[j]) {
				temp[index] = arr[i];
				i++;
				index++;
			}
			else {
				temp[index] = arr[j];
				j++;
				index++;
			}
		}
		while(i <= middle) {
			temp[index] =arr[i];
			i++;
			index++;
		}
		while(j <= high) {
			temp[index] = arr[j];
			j++;
			index++;
		}
		for(int k = 0; k < temp.length; k++) {
			arr[k + low] = temp[k];
		}
	}
}