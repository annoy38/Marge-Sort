package sort;
public class MainClass {
	public static void conquer(int arry[], int start, int mid, int end) {
		int[] tem_arry = new int[end-start+1];
		int idx1 = start;
		int idx2 = mid+1;
		int x = 0;
		while(idx1<=mid&&idx2<=end) {
			if(arry[idx1]<=arry[idx2]) {
				tem_arry[x] = arry[idx1];
				x++;
				idx1++;
			}
			else {
				tem_arry[x] = arry[idx2];
				x++;
				idx2++;
			}
		}
		while(idx1<=mid) {
			tem_arry[x] = arry[idx1];
			x++;
			idx1++;
		}
		while(idx2<=end) {
			tem_arry[x] = arry[idx2];
			x++;
			idx2++;
		}
		for(int i=0, j=start;i<tem_arry.length;i++, j++) {
			arry[j] = tem_arry[i];
		}
	}
	public static void divide(int arry[], int startidx, int endidx) {
		if(startidx>=endidx) {
			return;
		}
		int mid = startidx+(endidx-startidx)/2;
		divide(arry, startidx, mid);
		divide(arry, mid+1, endidx);
		conquer(arry, startidx, mid, endidx);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arry = {4,2,7,4,6,10,3};
		int n = arry.length;
		System.out.println("Before Marge Sorting ");
		for(int i=0;i<arry.length;i++) {
			System.out.print(arry[i]+" ");
		}
		divide(arry, 0, n-1);
		System.out.println();
		System.out.println("After Marge Sorting ");
		for(int i = 0; i<arry.length;i++) {
			System.out.print(arry[i]+" ");
		}
		//margeSort complexity O(nlogn)
		//divide part complexity O(logn)
		//conquer part complexity O(n)
		//when we need O(nlogn) time complexity space complexity doesn't matter that time we use this sort algorithm
	}

}
