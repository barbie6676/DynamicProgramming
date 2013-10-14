/*Rod cuts question, Introduction to Algorithm Chapter IV, Section 15.1
given an array of price: p[i] is the price for a rod length of i;
and a rod length of n,
return the maximum price you can get by cutting the rod into different parts.
*/


public int maxRodsPrice(int[] p, int n) {		
		
	int[] r = new int[n+1];
	
	r[0] = 0;
	
	for (int i = 1; i <=n; i ++) {
		int q= Integer.MIN_VALUE;
		int j =1;
		for (; j <= i; j ++) {
			q = Math.max(q,p[j-1]+maxRodsPrice(p,i-j));
		}
		r[i] = q;
	}
	
	return r[n];
}

public int memRodsPrice(int[] p, int n) {
	int[] r = new int[n+1];
	for (int i = 0; i < n+1 ; i ++) {
		r[i] = Integer.MIN_VALUE;
	}
	
	return memRodsPriceHelper(p,n,r);
}

public int memRodsPriceHelper(int[] p, int n, int[] r) {
	if (r[n] >= 0) return r[n];
	int q;
	if (n == 0) {
		q = 0;
	} else {
		 q = Integer.MIN_VALUE;
		for (int i = 1; i <= n ; i ++) {
			q = Math.max(q, p[i-1]+ memRodsPriceHelper(p,n-i,r));
		}
		
	}
	r[n] = q;
	return q;
}
