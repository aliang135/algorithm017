public class LeaderBoard {
	Map<Integer, Integer> treemap = null;
    public LeaderBoard() {
        treemap = new TreeMap<>();
    }
    public void addScore(int playerId, int score) {
        treemap.put(playerId, treemap.getOrDefault(playerId, 0) + score);
    }
    public int top(int K) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(treemap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });
        int result = 0;
        for (Map.Entry<Integer, Integer> mapping : list) {
            if (K > 0) {
                result += mapping.getValue();
            }
            K--;
        }
        return result;
    }
    public void reset(int playerId) {
        treemap.put(playerId, 0);
    }

}