class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] mat = new int[numCourses][numCourses];

        for (int i = 0; i < prerequisites.length; i ++) {
            mat[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }

        int[] ingrade = new int[numCourses];
        for (int i = 0; i < numCourses; i ++) {
            for (int j = 0; j < numCourses; j ++) {
                ingrade[j] += mat[i][j];
            }
        }
        boolean[] removed = new boolean[numCourses];

        int num0;
        do {
            num0 = 0;
            for (int i = 0; i < numCourses; i ++) {
                if (ingrade[i] == 0 && !removed[i]) {
                    removed[i] = true;
                    num0 ++;

                    for (int j = 0; j < numCourses; j ++) {
                        if (mat[i][j] == 1) {
                            mat[i][j] = 0;
                            ingrade[j] --;
                        }
                    }
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
