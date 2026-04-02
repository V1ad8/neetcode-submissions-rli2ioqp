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

            idx = -1;
            num0 = 0;
            for (int i = 0; i < numCourses; i ++) {
                if (ingrade[i] == 0 && !removed[i]) {
                    num0 ++;
                    idx = idx == -1 ? i : idx;
                }
            }

            if (idx == -1) {
                break;
            }

            System.out.println(idx);

            removed[idx] = true;
            for (int i = 0; i < numCourses; i ++) {
                mat[idx][i] = 0;
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
