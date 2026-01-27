
public class Main
{
	public static void main(String[] args) 
	{
		BinNode<Integer> t15 = new BinNode<Integer>(16);
		BinNode<Integer> t14 = new BinNode<Integer>(14);
		BinNode<Integer> tree = new BinNode<Integer>(t15, 4, t14);
		BinNode<Integer> t8 = new BinNode<Integer>(8);
		tree.getLeft().setLeft(new BinNode<Integer>(t8, 6, new BinNode<Integer>(7)));
		tree.getLeft().setRight(new BinNode<Integer>(new BinNode<Integer>(34), 56, new BinNode<Integer>(12)));
		
		System.out.println(tree);
		printFit(tree);
		System.out.println("there are: "+countFit(tree)+" fitting in given tree.");
		System.out.println(isFit(tree));
		System.out.println(allFit(tree));
	}
	
	public static void printFit(BinNode<Integer> t)//f1
	{
	    if(t==null)
	        return;
	    if(isFitting(t))
	        System.out.println(t.getValue());
	    if(t.hasLeft()) printFit(t.getLeft());
	    if(t.hasRight()) printFit(t.getRight());
	}
	public static int countFit(BinNode<Integer> t)//f2
	{
	    if(t==null)
	        return 0;
	    if(isFitting(t))
	        return(countFit(t.getLeft()) + countFit(t.getRight()) )+1;
	    return(countFit(t.getLeft()) + countFit(t.getRight()) );
	}
	public static boolean isFit(BinNode<Integer> t)//f3
	{
	    return (countFit(t)>0);
	}
	public static boolean allFit(BinNode<Integer> t)//f4
	{
	    if(t==null)
	        return true;
	    if(isFitting(t))
	        return allFit(t.getLeft())&&allFit(t.getRight()) ;
	    return false;
	}
	
	
	public static boolean isFitting(BinNode<Integer> t)
	{
	    boolean r = false;
	    boolean l = false;
	    if((t.getValue()%2==0) )
	    {
	        if (t.getLeft() == null)
	        {
	            l = true;
	        }
	        else
	        {
	            if(t.getLeft().getValue()%2==0)
	                l = true;
	        }
	        
	        if (t.getRight() == null)
	        {
	            r = true;
	        }
	        else
	        {
	            if(t.getRight().getValue()%2==0)
	                r = true;
	        }
	    }
	    return r&&l;
	}
}
