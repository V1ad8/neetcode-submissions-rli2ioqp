class Solution {
    public void dfs(String node, HashMap<String, PriorityQueue<String>> map, List<String> res) {
        PriorityQueue<String> pq = map.get(node);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), map, res);
        }
        res.add(0, node);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap();

        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue()).add(ticket.get(1));
        }

        for (var e : map.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

        List<String> res = new ArrayList();
        dfs("JFK", map, res);

        return res;
    }
}
