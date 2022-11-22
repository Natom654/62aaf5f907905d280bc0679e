package ithillel.lesson23.cocktailShakerSort;

public class ArraySort {

        public int[] cocktailShakerSort ( int[] arrayForSort){
            if (arrayForSort == null) {
                throw new RuntimeException("Array is null");
            }

            int start = 0;
            int end = arrayForSort.length - 1;
            do {
                for (int i = start; i < end; i++) {
                    if (arrayForSort[i] > arrayForSort[i + 1]) {
                        int temp = arrayForSort[i];
                        arrayForSort[i] = arrayForSort[i + 1];
                        arrayForSort[i + 1] = temp;
                    }
                }
                end--;
                for (int i = end; i > start; i--) {
                    if (arrayForSort[i] < arrayForSort[i - 1]) {
                        int temp = arrayForSort[i];
                        arrayForSort[i] = arrayForSort[i - 1];
                        arrayForSort[i - 1] = temp;
                    }
                }
                start++;
            } while (start < end);
            return arrayForSort;
        }

        public int[] arrayCopy ( int[] sourceArray, int[] targetArray){

            if (sourceArray == null || targetArray == null) {
                throw new RuntimeException("Source or target array is null");
            }

            int newArrayLength = sourceArray.length + targetArray.length;
            int[] newFinalArray = new int[newArrayLength];
            if (targetArray.length == 0) {
                System.arraycopy(sourceArray, 0, newFinalArray, 0, newArrayLength);
            } else {
                for (int i = 0; i < newArrayLength; i++) {
                    if (i < targetArray.length) {
                        newFinalArray[i] = targetArray[i];
                    } else {
                        newFinalArray[i] = sourceArray[i - targetArray.length];
                    }
                }
            }
            return newFinalArray;
        }
    }

