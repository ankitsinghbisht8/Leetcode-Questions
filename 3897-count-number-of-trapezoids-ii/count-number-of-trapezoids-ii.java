class Solution 
{
    private static final double inf = 1e9 + 7;
    
    public int countTrapezoids(int[][] points) 
    {
        int n = points.length;
        
        Map<Double, List<Double>> slopeToIntercept = new HashMap<Double, List<Double>>();
        Map<Integer, List<Double>> midToSlope = new HashMap<Integer, List<Double>>();
        int ans = 0;

        for (int i = 0; i < n; i++) 
        {
            int x1 = points[i][0];
            int y1 = points[i][1];
            
            for (int j = i + 1; j < n; j++) 
            {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dx = x1 - x2;
                int dy = y1 - y2;
                double k;
                double b;

                if (x2 == x1) 
                {
                    k = inf;
                    b = x1;
                } 
                else 
                {
                    k = (1.0 * (y2 - y1)) / (x2 - x1);
                    b = (1.0 * (y1 * dx - x1 * dy)) / dx;
                }
                if (k == -0.0) k = 0.0;
                if (b == -0.0) b = 0.0;
                int mid = (x1 + x2) * 10000 + (y1 + y2);
                slopeToIntercept.computeIfAbsent(k, key -> new ArrayList<Double>()).add(b);
                midToSlope.computeIfAbsent(mid, key -> new ArrayList<Double>()).add(k);
            }
        }

        for (List<Double> sti : slopeToIntercept.values()) 
        {
            if (sti.size() == 1) continue;
            Map<Double, Integer> cnt = new TreeMap<Double, Integer>();
            
            for (double b : sti) 
            {
                cnt.put(b, cnt.getOrDefault(b, 0) + 1);
            }
            
            int sum = 0;
            for (int count : cnt.values()) 
            {
                ans += sum * count;
                sum += count;
            }
        }

        for (List<Double> mts : midToSlope.values()) {
            if (mts.size() == 1) {
                continue;
            }
            Map<Double, Integer> cnt = new TreeMap<>();
            for (double k : mts) {
                cnt.put(k, cnt.getOrDefault(k, 0) + 1);
            }
            int sum = 0;
            for (int count : cnt.values()) 
            {
                ans -= sum * count;
                sum += count;
            }
        }

        return ans;
    }
}