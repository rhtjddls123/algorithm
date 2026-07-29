import java.util.*;

class Solution {
    static class Info{
        public String genre;
        public int play;
        public int index;
        public Info(String genre, int play, int index) {
            this.genre = genre;
            this.play = play;
            this.index = index;
        }
        
        public String toString(){
            return "genre: %s, play: %d, index: %d".formatted(genre, play, index);
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<plays.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        Set<Map.Entry<String,Integer>> s = map.entrySet();
        String[] sortedGenres=s.stream().sorted((e1, e2)->e2.getValue().compareTo(e1.getValue())).map(Map.Entry::getKey).toArray(String[]::new);
        
        Info[] infos = new Info[plays.length];
        for(int i=0; i<infos.length; i++) {
            infos[i] = new Info(genres[i], plays[i], i);
        }
        
        Arrays.sort(infos, (o1, o2) -> {
            int order1 = Arrays.asList(sortedGenres).indexOf(o1.genre);
            int order2 = Arrays.asList(sortedGenres).indexOf(o2.genre);
            
            if(order1!=order2) {
                return Integer.compare(order1, order2);
            }
            
            if(o1.play != o2.play) {
                return Integer.compare(o2.play, o1.play);
            }
            
            return Integer.compare(o1.index, o2.index);
        });
        
        Map<String, List<Info>> infoMap = new HashMap<>();
        int cnt = 0;
        for(int i=0; i<plays.length; i++) {
            if(infoMap.containsKey(infos[i].genre)) {
                if(infoMap.get(infos[i].genre).size() == 2) continue;
            } else{
                infoMap.put(infos[i].genre, new ArrayList<>());
            }
            infoMap.get(infos[i].genre).add(infos[i]);
            cnt++;
        }
        
        int[] answer = new int[cnt];
        int idx = 0;
        for(int i=0; i<sortedGenres.length; i++) {
            List<Info> info = infoMap.get(sortedGenres[i]);
            for (Info inf: info) {
                answer[idx++] = inf.index;
            }
        }
        
        return answer;
    }
}