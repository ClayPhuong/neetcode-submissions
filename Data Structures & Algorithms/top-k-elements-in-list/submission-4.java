class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //cach 1: Sort | Time: O(nlogn) | Space: O(n)
        /*
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n,0)+1);
        }
        List<Integer> listKey = new ArrayList<>(map.keySet());
        listKey.sort((a,b) -> map.get(b) - map.get(a));
        int[] result = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = listKey.get(i);
        }
        return result;
        */

        //cach 2: Min-Heap (Dung PriorityQueue) | Time: O(nlogk) | Space: O(n)
        /*
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n,0)+1);
        }
        //tao ra 1 heap rong co thu tu tu nho den lon
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //them vao heap
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                //neu size cua heap lon hon k thi heap se xoa phan tu nho nhat
                heap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = heap.poll()[1];
        }
        return result;
        */

        //cach 3: Bucket sort | Time: O(n) | Space: O(n)
        /*
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n,0)+1);
        }
        //tao 1 mang list chua cac so thuong xuyen lap lai voi so lan giong nhau, vd cac so lap lai 1 lan se duoc group lai voi nhau
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i=0; i<freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        //add vaop list freq [frequency(map.value), number(map.key)]
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] result = new int[k];
        int index = 0;
        for(int i = freq.length-1; i>0 && index<k; i--) {
            for(int n : freq[i]) {
                result[index++] = n;
                if (index == k) {
                    return result;
                }
            }
        }
        return result;
        */

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if(heap.size()>k){
                heap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = heap.poll()[1];
        }
        return result;
    }
}
