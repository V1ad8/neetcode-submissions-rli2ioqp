class Car {
    int position;
    double time;

    Car (int aPosition, int speed, int target) {
        position = aPosition;
        time = 1. * (target - position) / speed;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList();

        int n = position.length;
        for (int i = 0; i < n; i ++) {
            cars.add(new Car(position[i], speed[i], target));
        }

        Collections.sort(cars, (c1, c2) -> c2.position - c1.position);

        Stack<Car> stack = new Stack();
        for (int i = 0; i < n; i ++) {
            if (stack.isEmpty() || cars.get(i).time > stack.peek().time) {
                stack.push(cars.get(i));
            }
        }

        return stack.size();
    }
}
