package baitap.week5;

// Bucket sort in Java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
  public void bucketSort(float[] arr, int n) {
    if (n <= 0) {
      System.out.println("Mang rong, khong co buoc sap xep.");
      return;
    }
    @SuppressWarnings("unchecked")
    ArrayList<Float>[] bucket = new ArrayList[n];

    System.out.println("Buoc 1: Tao " + n + " bucket rong.");
    for (int i = 0; i < n; i++) {
      bucket[i] = new ArrayList<Float>();
      System.out.println("  Bucket " + i + ": " + bucket[i]);
    }

    System.out.println("\nBuoc 2: Phan phoi cac phan tu vao bucket.");
    for (int i = 0; i < n; i++) {
      int bucketIndex = (int) (arr[i] * n);
      if (bucketIndex == n)
        bucketIndex = n - 1;
      bucket[bucketIndex].add(arr[i]);
      System.out.println("  " + arr[i] + " -> Bucket " + bucketIndex + ": " + bucket[bucketIndex]);
    }

    System.out.println("\nBuoc 3: Sap xep tung bucket.");
    for (int i = 0; i < n; i++) {
      System.out.println("  Bucket " + i + " truoc khi sap xep: " + bucket[i]);
      Collections.sort(bucket[i]);
      System.out.println("  Bucket " + i + " sau khi sap xep:   " + bucket[i]);
    }

    System.out.println("\nBuoc 4: Ghep cac bucket vao mang.");
    int index = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0, size = bucket[i].size(); j < size; j++) {
        arr[index++] = bucket[i].get(j);
        System.out.println("  Gan " + arr[index - 1] + " vao vi tri " + (index - 1)
            + ": " + Arrays.toString(arr));
      }
    }
  }

  // Driver code
  public static void main(String[] args) {
    BucketSort b = new BucketSort();
    float[] arr = { (float) 0.42, (float) 0.32, (float) 0.33, (float) 0.52, (float) 0.37, (float) 0.47,
        (float) 0.51 };
    System.out.println("Mang ban dau: " + Arrays.toString(arr) + "\n");
    b.bucketSort(arr, 7);
    System.out.println("\nMang sau khi sap xep: " + Arrays.toString(arr));
  }
}
