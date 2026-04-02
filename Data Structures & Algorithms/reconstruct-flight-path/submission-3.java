class Solution {
    public List<String> explore(String node, HashMap<String, List<String>> map, List<String> path, int length) {
        path.add(node);
        if (path.size() == length) {
            return new ArrayList<>(path);
        }

        if (!map.containsKey(node)) {
            path.remove(path.size() - 1);
            return null;
        }

        List<String> list = map.get(node);
        for (int i = 0; i < list.size(); i++) {
            String neigh = list.get(i);
            list.remove(i);

            List<String> res = explore(neigh, map, path, length);
            if (res != null) {
                return res;
            }

            list.add(i, neigh);
        }

        path.remove(path.size() - 1);

        return null;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> map = new HashMap();

        for (List<String> ticket : tickets) {
            map.compute(ticket.get(0), (k, v) -> {
                if (v == null) {
                    return new ArrayList(Arrays.asList(ticket.get(1)));
                } else {
                    v.add(ticket.get(1));
                    return v;
                }
            });
        }

        for (var e : map.entrySet()) {
            Collections.sort(e.getValue());
            System.out.println(e.getKey() + ": " + e.getValue());
        }

        return explore("JFK", map, new ArrayList(), tickets.size() + 1);
    }
}
