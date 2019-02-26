//Search for an integer in an Bitonic array. Prints index of element.
//Prints -1 if search is unsuccessful.
//Time complexity ~ 3lg(n) as 3 times a binary search is conducted!(To find max ele, ascending and descending)

public class BitonicArraySearch {

    //Returns -1 if single largest element is not found!
    private static int findBitonicPoint(int[] a,int low,int high){
        int mid=low+(high-low)/2;

        //If there is one element, of if the edge elements are largest!
        if(low==high) return mid;

        //If there are only 2 elements
        if(a.length==2){
            if(a[low]>a[high]) return low;
            else if(a[low]<a[high]) return high;
            else return -1;
        }

        if(a[mid]>a[mid+1] && a[mid]>a[mid-1])
            return mid;
        if(a[mid]<a[mid+1] && a[mid]>a[mid-1])
            return(findBitonicPoint(a,mid+1,high));
        else if(a[mid]>a[mid+1] && a[mid]<a[mid-1])
            return(findBitonicPoint(a,low,mid-1));
        return -1;
    }
    private static int ascendingBinarySearch(int[]a,int key,int lo,int hi){
        int mid=lo+((hi-lo)/2);

        if(lo>hi) return -1;

        if(a[mid]==key) return mid;
        else if(key>a[mid]) return BitonicArraySearch.ascendingBinarySearch(a,key,mid+1,hi);
        else return BitonicArraySearch.ascendingBinarySearch(a,key,lo,mid-1);

    }

    private static int descendingBinarySearch(int[]a,int key,int lo, int hi){
        int mid=lo+((hi-lo)/2);

        if(lo>hi)return -1;
        if(key==a[mid]) return mid;
        else if(key>a[mid]) return BitonicArraySearch.descendingBinarySearch(a,key,lo,mid-1);
        else return BitonicArraySearch.descendingBinarySearch(a,key,mid+1,hi);

    }

    //Pass the key to be searched and the array
    public static int searchKeyInBitonicArray(int key, int[]a){

        int index=BitonicArraySearch.findBitonicPoint(a,0,a.length-1);
        if(key>a[index]) return -1;

        if(key==a[index])return index;

        int ascBinSearchVal=BitonicArraySearch.ascendingBinarySearch(a,key,0,index-1);
        if(ascBinSearchVal!=-1)
            return ascBinSearchVal;
        else return BitonicArraySearch.descendingBinarySearch(a,key,index+1,a.length-1);
    }


    public static void main(String[] args){

        int[] a={8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};

        int key= 80;

        System.out.println("Element found in position : "+BitonicArraySearch.searchKeyInBitonicArray(key,a));



    }


}
