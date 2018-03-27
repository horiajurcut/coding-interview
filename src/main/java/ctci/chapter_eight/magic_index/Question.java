package ctci.chapter_eight.magic_index;

public class Question {

  static int magic(int[] array) {
    return magic(array, 0, array.length - 1);
  }

  static int magic(int[] array, int start, int end) {
    if (end < start) {
      return -1;
    }
    int mid = start + (end - start) / 2;
    if (array[mid] == mid) {
      return mid;
    } else if (array[mid] > mid) {
      return magic(array, start, mid - 1);
    } else {
      return magic(array, mid + 1, end);
    }
  }

  static int magic2(int[] array, int start, int end) {
    if (end < start) {
      return -1;
    }

    int midIndex = start + (end - start) / 2;
    int midValue = array[midIndex];

    if (midValue == midIndex) {
      return midIndex;
    }

    int leftIndex = Math.min(midIndex - 1, midValue);
    int left = magic2(array, start, leftIndex);

    if (left > 0) {
      return left;
    }

    int rightIndex = Math.max(midIndex + 1, midValue);
    int right = magic2(array, rightIndex, end);

    return right;
  }
}
