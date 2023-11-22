import java.util.*;
class miner {
    public int solution(int[] picks, String[] minerals) {
		int max = Math.min((picks[0]+picks[1]+picks[2])*5, minerals.length);
		
		int weight[] = new int[(int)Math.ceil((double)max/5)];
		
		int tmp=0;
		int count=0;
		for(int i=0; i<max; i++) {
			if(count==5) {
				tmp++;
				count=0;
			}
			switch(minerals[i]) {
			case "diamond":
				weight[tmp]+=10;
				break;
			case "iron":
				weight[tmp]+=2;
				break;
			case "stone":
				weight[tmp]+=1;
				break;
			}
			count++;
		}
		
		int t[] = weight.clone();
		List<Integer> c = new ArrayList<>();
		Arrays.sort(t);
		for(int i=0; i<weight.length; i++) {
			for(int j=0; j<weight.length; j++) {
				if(t[i]==weight[j]&&!c.contains(j)) {
					c.add(j);
					break;
				}
			}
		}
		
		
		Collections.reverse(c);
		
		
		String p[] = new String[c.size()];
		
		count=0;
		for(int i=0; i<picks[0]; i++) {
			if(count>=p.length) {
				break;
			}
			p[c.get(count)] = "d";
			count++;
		}
		for(int i=0; i<picks[1]; i++) {
			if(count>=p.length) {
				break;
			}
			p[c.get(count)] = "i";
			count++;
		}
		for(int i=0; i<picks[2]; i++) {
			if(count>=p.length) {
				break;
			}
			p[c.get(count)] = "s";
			count++;
		}
		
		
		
		
		int answer = 0;
		count=0;
		for(int i=0; i<max; i++) {
			switch(minerals[i]) {
			case "diamond":
				if(p[count].equals("d")) {
					answer+=1;
				}
				else if(p[count].equals("i")) {
					answer+=5;
				}
				else if(p[count].equals("s")) {
					answer+=25;
				}
				break;
			case "iron":
				if(p[count].equals("d")) {
					answer+=1;
				}
				else if(p[count].equals("i")) {
					answer+=1;
				}
				else if(p[count].equals("s")) {
					answer+=5;
				}
				break;
			case "stone":
				if(p[count].equals("d")) {
					answer+=1;
				}
				else if(p[count].equals("i")) {
					answer+=1;
				}
				else if(p[count].equals("s")) {
					answer+=1;
				}
				break;
			}
			
			if((i+1)%5==0) {
				count++;
			}
		}
        return answer;
    }
}