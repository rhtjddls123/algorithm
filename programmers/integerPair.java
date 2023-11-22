class integerPair {
    public long solution(int r1, int r2) {
        long answer = 0;
        answer = r2-r1+1;
		long r2Square = (long) r2*r2;
		long r1Square = (long) r1*r1;
		
		for(int i=1; i<r2; i++) {
			
			long iSquare = (long) i*i;
			
			if(i<r1) {
				answer += (long)Math.floor(Math.sqrt(r2Square-iSquare)) - (long)Math.floor(Math.sqrt(r1Square-iSquare));
			}
			else {
				answer += (long)Math.floor(Math.sqrt(r2Square-iSquare));
			}


		}
		
		answer*=4;
        return answer;
    }
}