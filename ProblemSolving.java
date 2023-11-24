public class Learning {
  
    public static int binarySearch(int[] arr, int target) {
        //arr est supposé qu'il est trié
        int debut = 0;
        int fin = arr.length-1;
        int milieu;
        while(debut<=fin){
            milieu =debut+ (fin-debut)/2;
            if(target<arr[milieu]){
                fin = milieu-1;
            }
            else if(target>arr[milieu]){
                debut = milieu+1;
            }
            else if(target==arr[milieu])
                return milieu;
        }

        return -1;
    }


//Two Pointer Algorithm
public static boolean hasSum(int[] arr, int target) {
    //arr est supposé qu'il est trié
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        int currentSum = arr[left] + arr[right];
        if (currentSum == target) {
            return true; // La somme a été trouvée
        } else if (currentSum < target) {
            left++; // Augmenter le pointeur gauche pour augmenter la somme
        } else {
            right--; // Diminuer le pointeur droit pour réduire la somme
        }
    }
    
    return false; // La somme n'a pas été trouvée
}

// Une tentative d'utiliser l'algorithme Two Pointer pour résoudre le problème de Two Sum 
// consiste à stocker les valeurs du tableau ainsi que leurs indices dans une table de hachage (hashmap). 
// Ensuite, on trie le tableau et on essaie de trouver deux valeurs dont la somme est égale à la cible (target).

// Cependant, le problème réside dans le fait que si nous avons la somme de deux valeurs égales 
// avec des indices différents et que cette somme est égale à la cible, cet algorithme ne retourne pas ce résultat, 
// car la table de hachage ne peut  avoir deux clés égales
public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int indice = 0;
        for(int i = 0 ;i< nums.length;i++){
            hashMap.put(nums[i],i);
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1;

        while(left<right){
            if(nums[left]+nums[right]<target){
                left++;
            }
            else if(nums[left]+nums[right]>target){
                right--;
            }
            else {
                break;
            }
        }
        int[] arr= {hashMap.get(nums[left]),hashMap.get(nums[right])};
        return arr;
    }


//solution pour résoudre  :
public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> numIndexMap = new HashMap<>();

    // Parcourez le tableau une seule fois pour remplir le dictionnaire
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        
        // Vérifiez si le complément existe déjà dans le dictionnaire
        if (numIndexMap.containsKey(complement)) {
            // Si oui, retournez les indices des deux nombres
            return new int[]{numIndexMap.get(complement), i};
        }
        
        // Ajoutez l'élément actuel et son index au dictionnaire
        numIndexMap.put(nums[i], i);
    }
    
    // Aucune solution trouvée, retournez un tableau vide ou une valeur par défaut
    return new int[]{};
}


public List<List<Integer>> threeSum(int[] nums) {
       
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
            int target = -nums[i];
             int left = i + 1;
            int right = nums.length - 1;
            while(left<right){
                if(nums[left]+nums[right]==target) {
                        List list = Arrays.asList(nums[i],nums[left],nums[leght])
                        
                        result.add(list);

                         while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
 

                        left++;
                        right--;  
                    
                }

                else if(nums[left]+nums[right]<target) left++;
                else if(nums[left]+nums[right]>target) right--;;
            }
        }
        }
        return result;
        }
    



public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Triez le tableau pour faciliter la recherche.

        for (int i = 0; i < nums.length - 2; i++) {
            // Ignorez les éléments en double.
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                Set<Integer> seen = new HashSet<>();
                int target = -nums[i];

                for (int j = i + 1; j < nums.length; j++) {
                    int complement = target - nums[j];

                    // Si le complément est dans "seen", cela signifie que nous avons trouvé un triplet.
                    if (seen.contains(complement)) {
                        result.add(Arrays.asList(nums[i], nums[j], complement));

                        // Ignorez les éléments en double.
                        while (j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
                    }

                    seen.add(nums[j]);
                }
            }
        }

        return result;
    }


//problem  Palindrome Number
//ma première solution :
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        String s1 = String.valueOf(x);
       StringBuilder builder = new StringBuilder(s1);
       builder = builder.reverse();
       String s2 = builder.toString();
        if(s1.equals(s2)){
            return true;
        }
        return false;
    }


//ma deuxième solution
 public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        List<Integer> lisDigits = new ArrayList<>();
        List<Integer> lisDigits2 = new ArrayList<>();
        while (x >= 10) {
            lisDigits.add(x % 10);
            x = x / 10;
        }
        lisDigits.add(x);
        lisDigits2=List.copyOf(lisDigits);
        Collections.reverse(lisDigits);
        return lisDigits.equals(lisDigits2);
    }  

//solution de chatgpt
public static boolean isPalindrome(int x) {
    // Vérifiez les cas spéciaux où x est négatif ou se termine par zéro (sauf x=0)
    if (x < 0 || (x != 0 && x % 10 == 0)) {
        return false;
    }

    int reversedNumber = 0;
    int originalX = x;

    while (x > 0) {
        int digit = x % 10;
        reversedNumber = reversedNumber * 10 + digit;
        x /= 10;
    }

    // Si le nombre original est égal au nombre inversé, c'est un palindrome
    return originalX == reversedNumber;
}






//Roman to Integer
//ma solution :
 public int romanToInt(String s) {
        Map<String,Integer> mapRomanInt = new TreeMap();
       
        mapRomanInt.put("I",1);
        mapRomanInt.put("V",5);
        mapRomanInt.put("X",10);
        mapRomanInt.put("L",50);
        mapRomanInt.put("C",100);
        mapRomanInt.put("D",500);
        mapRomanInt.put("M",1000);
     int result = mapRomanInt.get(String.valueOf(s.charAt(s.length()-1)));

        for(int i = 0;i<s.length()-1;i++){
     
          if( mapRomanInt.get(String.valueOf(s.charAt(i))) < mapRomanInt.get(String.valueOf(s.charAt(i+1))))
                    result=result-mapRomanInt.get(String.valueOf(s.charAt(i)));
          else result=result+mapRomanInt.get(String.valueOf(s.charAt(i)));
            
        }
        return result;
    }




//lengthOfLongestSubstring
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Set<Character> uniqueChars = new HashSet<>();
        while (right < s.length()) {
            if (!uniqueChars.contains(s.charAt(right))) {
                uniqueChars.add(s.charAt(right));
                maxLength = Math.max(maxLength, uniqueChars.size());
                right++;
            } else {
                uniqueChars.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    
//autre solution
   public static int lengthOfLongestSubstring(String s) {
    int maxLength = 0;
    int[] charIndex = new int[256]; // Tableau pour suivre les index des caractères
    Arrays.fill(charIndex, -1); // Initialisation à -1, indiquant que le caractère n'a pas encore été rencontré

    int left = 0; // Pointeur gauche de la fenêtre

    for (int right = 0; right < s.length(); right++) {
        char currentChar = s.charAt(right);
        if (charIndex[currentChar] >= left) {
            left = charIndex[currentChar] + 1; // Met à jour le pointeur gauche pour exclure le caractère répété
        }
        charIndex[currentChar] = right; // Met à jour l'index du caractère

        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
}

//contains duplicate
public boolean containsDuplicate(int[] nums) {
        //Sorting the array
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            //Checking the adjacent element for equality
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
    
public boolean containsDuplicate(int[] nums) {
    
        HashSet<Integer> hashSet = new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            //If that element is present in the array before, we can return true, because searching in an hashset requires only O(1) time
            if(hashSet.contains(nums[i]))
                return true;
            //We add the number into our hashset
            else
                hashSet.add(nums[i]);
        }

        return false;
    }



//majority Element 
/* Program for finding out majority element in an array */
private static void findMajority(int[] arr) 
	{ 
	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); 
	int count=0; 
	for(int i = 0; i < arr.length; i++) 
		{ 
		if (map.containsKey(arr[i])) 
			{ 
			count = map.get(arr[i]) +1; 
			map.put(arr[i], count); 
			} 
		else
			{ 
			map.put(arr[i],1); 
			} 
		if(map.get(arr[i]) > arr.length /2) 
			{ 
			System.out.println("Majority found :- " + arr[i]); 
			return; 
			}
		} 
	System.out.println(" No Majority element"); 
	} 




//isHappy
public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        int slow = n;
        int fast = n;

        do {
            slow = calculateSumOfSquares(slow);
            fast = calculateSumOfSquares(fast);
            fast = calculateSumOfSquares(fast);

            if (slow == 1 || fast == 1) {
                return true;
            }
        } while (slow != fast);

        return false;
    }

    private int calculateSumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

//autre exemple 
// class Node {
//     int data;
//     Node next;

//     Node(int data) {
//         this.data = data;
//         this.next = null;
//     }
// }
public boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false; // Pas de cycle dans une liste vide ou d'un seul élément
        }

        Node slow = head;
        Node fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false; // Si fast atteint la fin de la liste, il n'y a pas de boucle
            }
            slow = slow.next; // Avance d'un pas
            fast = fast.next.next; // Avance de deux pas
        }

        return true; // Si les pointeurs se rencontrent, il y a une boucle
    }


// la somme de trois valeurs du tableau qui est proche à target
public int threeSumClosest(int[] nums, int target) {
      // Assurez-vous que le tableau a au moins 3 éléments.
        if (nums.length < 3) {
            return 0; // Valeur par défaut si le tableau est trop court.
        }

        // Triez le tableau pour faciliter la recherche.
        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }


//fourSum
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        if(nums.length<4){
            return new ArrayList();
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int a = target - nums[i];
                for (int p = i + 1; p < nums.length - 2; p++) {
                    if (p == i + 1 || nums[p] != nums[p - 1]) {
                        int left = p + 1;
                        int rigth = nums.length - 1;
                        while (left < rigth) {
                            if ((long)nums[p] + (long)nums[left] + (long)nums[rigth] == a) {
                                result.add(Arrays.asList(nums[i], nums[p], nums[left], nums[rigth]));
                                while (left < rigth && nums[left] == nums[left + 1]) left++;
                                while (left < rigth && nums[rigth] == nums[rigth - 1]) rigth--;
                                left++;
                                rigth--;
                            } else if (nums[p] + nums[left] + nums[rigth] < a) left++;
                            else rigth--;
                        }
                    }
                }

            }
        }

        return result;

    }

//problème rencontré dans un test technique chez axelor
 public static int[] filterDuplicated(int[] nums){
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.add(num)){
                list.add(num);
            }
        }
        int[] result = new int[list.size()];

        for(int i =0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;

    }

public static int[] filterDuplicated(int[] nums){
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        for(int  i =0;i<nums.length;i++){
            linkedHashSet.add(nums[i]);
        }
        int[] result = new int[linkedHashSet.size()];

        Iterator<Integer> iterator = linkedHashSet.iterator();
        int i = 0;
        while (iterator.hasNext()){
            result[i]=iterator.next();
            i++;
        }
        return result;
  }

//version amélioré : 
public static int[] filterDuplicated(int[] nums) {
    Set<Integer> uniqueSet = new HashSet<>();
    
    for (int num : nums) {
        uniqueSet.add(num);
    }
    
    int[] result = new int[uniqueSet.size()];
    int index = 0;
    
    for (int uniqueNum : uniqueSet) {
        result[index] = uniqueNum;
        index++;
    }
    
    return result;
}

//utilisation de streams est beaucoup mieux 
 public static int[] filterDuplicated(int[] nums){
        int[] array = Arrays.stream(nums).distinct().toArray();
        return array;
    }


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(-1);
    ListNode current = dummy;

    while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
            current.next = list1;
            list1 = list1.next;
        } else {
            current.next = list2;
            list2 = list2.next;
        }
        current = current.next;
    }

    if (list1 != null) {
        current.next = list1;
    } else {
        current.next = list2;
    }

    return dummy.next;
}


//la méthode boxed() de streams est très utile lorsque vous souhaiter passer des types primitifs aux objets enveloppes
 public int[] searchRange(int[] nums, int target) {
    List<Integer> list = Arrays.stream(nums)
                                   .boxed()
                                   .collect(Collectors.toList());
    int indexStart = list.indexOf(target);
    int indexEnd = list.lastIndexOf(target);
    return new int[]{indexStart,indexEnd};    
    
    }
//vous pouvez aussi utiliser mapToObj
//n'oubliez pas valueOf : c'est très utile
public int[] searchRange(int[] nums, int target) {
    //    Integer[] array = Arrays.stream(nums).mapToObj(Integer::valueOf).toArray(Integer[]::new); si vous voulez un array de integer à partir d'un array of int
    List<Integer> list =  Arrays.stream(nums)
                                    .mapToObj(Integer::valueOf)
                                    .collect(Collectors.toList());
    int indexStart = list.indexOf(target);
    int indexEnd = list.lastIndexOf(target);
    return new int[]{indexStart,indexEnd}; 

//si vous voulez transformer un tableau de int en tableau de Integer
    // Integer[] integerArray = Arrays.stream(nums)
    //                            .boxed()
    //                            .toArray(Integer[]::new);   
    }

    

//Kadane's Algorithm
public int maxSubArray(int[] nums) {
    int maxSum = nums[0]; // Initialise la somme maximale à la première valeur du tableau
    int currentSum = nums[0]; // Initialise la somme courante à la première valeur du tableau

    for (int i = 1; i < nums.length; i++) {
        // Compare la somme courante + élément actuel avec l'élément actuel seul
        currentSum = Math.max(nums[i], currentSum + nums[i]);
        
        // Met à jour la somme maximale si la somme courante est supérieure
        maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
}


// Given a sorted array of distinct integers and a target value, return the index 
// if the target is found. If not, return the index where it would be if it were inserted in order.
public int searchInsert(int[] nums, int target) {
    //  OptionalInt first = Arrays.stream(nums).filter(n -> n < 5).findFirst();
        if(target<nums[0]) return 0;
        List<Integer> result = Arrays.stream(nums).boxed().filter(n->n<=target).collect(Collectors.toList());
        int size = result.size();
        if(result.get(size-1)==target) return size-1;
        else return size; 
}
//autre solution
 public int searchInsert(int[] nums, int target) {
        if(target<nums[0]) return 0;
       long index = Arrays.stream(nums).boxed().filter(n->n<=target).count();
        if(nums[(int)index-1]==target) return (int)index-1;
        else return (int)index; 
}

//solution de chatgpt qui est beaucoup mieux
public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return left;
}



// Given a string s consisting of words and spaces, return the length of the last word in the string.
// A word is a maximal 
// substring
//  consisting of non-space characters only.
 public int lengthOfLastWord(String s) {
        String s1 = s.trim();
        int index = s1.lastIndexOf(" ");
        return s1.length()-index-1;

    }


// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
// A shift on s consists of moving the leftmost character of s to the rightmost position.
// For example, if s = "abcde", then it will be "bcdea" after one shift.
public boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder t = new StringBuilder(s);
        do{
            Character c = t.charAt(0);
            t=t.deleteCharAt(0).append(c);
            // t=t.delete(c).append(c);
            String temp = t.toString();
            if(temp.equals(goal)) return true;
        }while(!t.toString().equals(s));
            
            return false;
            
            
                 
    }
//solution de chatgpt : 
public boolean rotateString(String s, String goal) {
         if (s.length() != goal.length()) {
            return false;
        }

        // Concaténation de la chaîne d'origine avec elle-même
        String concatenated = s + s;

        // Vérification si la chaîne résultante contient la chaîne cible
        return concatenated.contains(goal);
                    
    }

// count_frequencies
// input : words = ["the","dog","got","the","bone"]
// output : [1, 1, 1, 2] bone : 1, dog : 1, got : 1, the : 2 (sorted words)
// ma solution
public static List<Integer> count_frequencies(List<String> words){
        Collections.sort(words);
        Stream<String> streamWords =  words.stream();
        List<String> array = streamWords.distinct().toList();
        List<Integer> result = new ArrayList<>();
        for(String word:array){
            long count = words.stream().filter(w->w.equals(word)).count();
            result.add((int)count);
        }
        System.out.println(result);
        return result;
    }

// Map<R,T> collect(Collectors.groupingBy(Function(T,R)))
// c est très important lorsque vous voulez faire des regroupements selon un critère
// par exemple : Groupement par longueur de chaîne
//  List<String> words = Arrays.asList("apple", "banana", "orange", "kiwi", "grape");

//         Map<Integer, List<String>> groupedByLength = words.stream()
//                 .collect(Collectors.groupingBy(String::length));
//         {4=[kiwi], 5=[apple, grape], 6=[banana, orange]}

// * Groupement par la première lettre
// List<String> words = Arrays.asList("apple", "banana", "orange", "kiwi", "grape");

//         Map<Character, List<String>> groupedByFirstLetter = words.stream()
//                 .collect(Collectors.groupingBy(s -> s.charAt(0)));
//         System.out.println(groupedByFirstLetter);
//         {a=[apple], b=[banana], g=[grape], k=[kiwi], o=[orange]}

// // Grouper les nombres par leur parité (pair ou impair)
//         Map<String, List<Integer>> groupedByParity = numbers.stream()
//                 .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));

//         System.out.println(groupedByParity);
//         {Even=[2, 4, 6, 8], Odd=[1, 3, 5, 7, 9]}


// autre solution 
public static List<Integer> countFrequencies2(List<String> words) {
    //Collectors.counting() est appliqué pour les valeurs de chaque clé
        Map<String, Long> map = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        TreeMap<String, Long> treeMap = new TreeMap<>(map);
        Collection<Long> values = treeMap.values();
        List<Integer> collect = values.stream().map(Long::intValue).collect(Collectors.toList());
        System.out.println(collect);
        return collect;
    }



// il existe plusieurs catégories de streams  : 
                             BaseStream<T, S>
                                   |
        ----------------------------------------------------------
        |                  |                 |                   |
     Stream<T>         IntStream         DoubleStream         LongStream 
        |                  |                 |                   |
Object[] toArray()   int[] toArray()   double[] toArray()    long[] toArray();      

// Juste pour vous rappeler de faire attention au type de stream sur lequel vous travaillez lorsque vous appelez une méthode comme toArray()
//boxed() transforme un IntStream en Stream<Integer> (meme chose pour LongStream et DoubleStream )
// Integer[] array = Arrays.stream(nums).boxed().toArray(Integer[]::new);
// La méthode mapToObj est une méthode de IntStream, DoubleStream, LongStream, et non pas de Stream<T>, ce qui est logique
// les méthodes mapToInt (qui trasnforme un Stream<T> ou DoubleStream ou LongStream en IntStream ), mapToDouble, mapToLong sont très utiles
//par exemple transfomer une collection de Long en un tableau de int : 
        // Collection<Long> collection;
        // ....
        // int[] array = collection.stream().mapToInt(Long::intValue).toArray();





































}
