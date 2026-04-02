class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] mat = new int[numCourses][numCourses];

        for (int i = 0; i < prerequisites.length; i ++) {
            mat[prerequisites[i][0]][prerequisites[i][1]] = 1;
            // i before j
        }

        int[] ingrade;
        boolean[] removed = new boolean[numCourses];

        int num0 = 0;
        int idx;
        do {
            ingrade = new int[numCourses];
            for (int i = 0; i < numCourses; i ++) {
                for (int j = 0; j < numCourses; j ++) {
                    ingrade[j] += mat[i][j];
                }
            }

            num0 = 0;
            for (int i = 0; i < numCourses; i ++) {
                if (ingrade[i] == 0 && !removed[i]) {
                    System.out.println(i);

                    removed[i] = true;

                    for (int j = 0; j < numCourses; j ++) {
                        mat[i][j] = 0;
                    }
                    num0 ++;
                }
            }
        } while (num0 > 0);

        for (int i = 0; i < numCourses; i ++) {
            if (!removed[i]) {
                return false;
            }
        }

        return true;
    }
}
