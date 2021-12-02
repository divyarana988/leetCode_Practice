class WateringPlants {
    public int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;
        int count = 0;
        int rem = capacity;

        for (int i = 0; i < n; i++) {
            if (plants[i] <= rem) {
                rem -= plants[i];
            } else {
                count += i + i;
                rem = capacity - plants[i];
            }
            count++;
        }

        return count;
    }
}
