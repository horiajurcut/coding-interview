package ctci.chapter_ten.rotated_array;

public class Question {

  static int search(int a[], int left, int right, int x) {
    int mid = (left + right) / 2;

    if (x == a[mid]) {
      return mid;
    }

    if (right < left) {
      return -1;
    }

    if (a[left] < a[mid]) {  // Left is normally ordered
      if (x >= a[left] && x < a[mid]) {
        return search(a, left, mid - 1, x);
      } else {
        return search(a, mid + 1, right, x);
      }
    } else if (a[mid] < a[left]) {  // Right is normally ordered
      if (x > a[mid] && x <= a[right]) {
        return search(a, mid +1, right, x);
      } else {
        return search(a, left, mid - 1, x);
      }
    } else if (a[left] == a[mid]) {  // Left or right half is all repeats
      if (a[mid] != a[right]) {
        return search(a, mid + 1, right, x);
      } else {  // We have to search both halves
        int result = search(a, left, mid - 1, x);
        if (result == - 1) {
          return search(a, mid + 1, right, x);
        } else {
          return result;
        }
      }
    }
    return -1;
  }
}
