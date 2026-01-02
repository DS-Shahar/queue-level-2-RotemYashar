public class Main
{
	public static void main(String[] args) 
	{
	    
	    System.out.println("exc1: ");
	    char [] a = {'b','c','c','c','a','b','a','b','b','a'};
		Queue<Character> q = new Queue<Character>(); 
		q = arr2Q(a);
		System.out.println(lenRow(q).toString());
		
		System.out.println("exc5: ");
		int [] b = {1, 1, 3, 6, 8, 9, 10};
		Queue<Integer> q1 = new Queue<Integer>(); 
		q1 = arr2Q(b);
		int [] c = {1, 2, 5, 7, 9};
		Queue<Integer> q2 = new Queue<Integer>(); 
		q2 = arr2Q(c);
		System.out.println(combineSort(q1, q2));
		
		System.out.println("exc6: ");
		int [] d = {1, 2, 2, 3, 6, 8, 4, 9, 10};
		Queue<Integer> q3 = new Queue<Integer>(); 
		q3 = arr2Q(d);
		System.out.println(sumLongestEven(q3));
	}
	
    public static Queue<Integer> lenRow(Queue<Character> q) //f1 - lengh of every "same char in a row"
    {
        Queue<Character> copy = copyQueue(q);
        Queue<Integer> ints = new Queue<Integer>();
        int count = 1;
        char prev = copy.remove();
        while (!copy.isEmpty())
        {
            if (copy.head() == prev)
            {
                count ++;
            }
            else
            {
                ints.insert(count);
                count = 1;
            }
            prev = copy.remove();
        }
        if (count == 1)
            ints.insert(1);
        return ints;
    }	
	public static <T> Queue<Integer> combineSort(Queue<Integer> q1, Queue<Integer> q2) //f5 - combine pre sorted Queue into one sorted Queue
	{
	    Queue<Integer> c1 = copyQueue(q1);
	    Queue<Integer> c2 = copyQueue(q2);
	    Queue<Integer> n = new  Queue<Integer>();
	    int last;
	    if(c1.head() < c2.head())
	        last = c1.remove();
	    else    
	        last = c2.remove();

	    
	    while(!c1.isEmpty() && !c2.isEmpty())
	    {
	        if(c1.head() < c2.head())
	        {
	            if (last < c1.head())
	            {
	                n.insert(last);
	                last = c1.remove();
	            }
	            else
	                n.insert(c1.remove());
	        }
	        else    
	        {
	            if (last < c2.head())
	            {
	                n.insert(last);
	                last = c2.remove();
	            }
	            else
	                n.insert(c2.remove());
	        }

	    }
	    n.insert(last);
	    if(!c1.isEmpty())
	    {
	        while(!c1.isEmpty())
	            n.insert(c1.remove());
	    }
	    else
	    {
	        while(!c2.isEmpty())
	            n.insert(c2.remove());
	    }
	    
	    return n;
	}
	public static int sumLongestEven(Queue<Integer> q)//f6 - sum of the longest string of of even numbers in a queue
	{
	    Queue<Integer> copy = copyQueue(q);;
	    int sum = 0;
	    int max_sum = 0;//sum of max length
	    int len = 0;
	    int max_len = 0;
	    
	    while(!copy.isEmpty())
	    {
	        int val = copy.remove();
	        if(val%2==0)
	        {
	            sum += val;
	            len ++;
	        }
	        else
	        {
	            if(len>max_len)
	            {
	                max_len = len;
	                max_sum = sum;
	            }
	            len = 0;
	            sum = 0;
	        }
	    }
	    return max_sum;
	}
	
	
	public static <T> Queue<Integer> arr2Q(int [] a)
	{
	    Queue<Integer> q = new Queue<Integer>();
	    for (int i=0; i<a.length; i++)
	    {
	        q.insert(a[i]);
	    }
	    return q;
	} 
	public static <T> Queue<Character> arr2Q(char [] a)
	{
	    Queue<Character> q = new Queue<Character>();
	    for (int i=0; i<a.length; i++)
	    {
	        q.insert(a[i]);
	    }
	    return q;
	} 
	public static <T> Queue<T> copyQueue(Queue<T> q) 
    {
        Queue<T> copy = new Queue<>();
        Queue<T> temp = new Queue<>();
        while (!q.isEmpty()) {
            T val = q.remove(); 
            copy.insert(val);             
            temp.insert(val);
        }
        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
        return copy;
    }
}
