package common;



public class totalpage {


	// 根据菜品总个数确定总页数的函数
	
		public static int getTotalpage(int totalitem,int capacity){
			
			int totalpage;
			totalpage=(int)Math.ceil((double)totalitem/capacity);
			
			return totalpage;
		}
		
		
		
}
