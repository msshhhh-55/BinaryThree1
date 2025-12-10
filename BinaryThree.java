public class BinaryThree {

    static class TreeItem {
        int data;
        TreeItem left;
        TreeItem right;

        TreeItem(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class MyTree {
        TreeItem top; // корень дерева

        MyTree(int firstValue) {
            top = new TreeItem(firstValue);
        }

        int howManyLeafs() {
            return leafCounter(top);
        }

        int leafCounter(TreeItem item) {
            if (item == null) {
                return 0;
            }
            if (item.left == null && item.right == null) {
                return 1;
            }
            return leafCounter(item.left) + leafCounter(item.right);
        }

        int maxDeep() {
            return deepFinder(top);
        }

        int deepFinder(TreeItem item) {
            if (item == null) {
                return 0;
            }

            int leftDeep = deepFinder(item.left);
            int rightDeep = deepFinder(item.right);

            if (leftDeep > rightDeep) {
                return leftDeep + 1;
            } else {
                return rightDeep + 1;
            }
        }

        boolean isGoodTree() {
            return checkTree(top, -1000000, 1000000);
        }

        boolean checkTree(TreeItem item, int min, int max) {
            if (item == null) {
                return true;
            }

            if (item.data < min) {
                return false;
            }
            if (item.data > max) {
                return false;
            }

            return checkTree(item.left, min, item.data - 1) &&
                    checkTree(item.right, item.data + 1, max);
        }

        void showFloorSums() {
            int floors = maxDeep();
            for (int floor = 1; floor <= floors; floor++) {
                int sum = floorSum(top, floor);
                System.out.println("Этаж " + floor + ": сумма чисел = " + sum);
            }
        }

        int floorSum(TreeItem item, int floor) {
            if (item == null) {
                return 0;
            }
            if (floor == 1) {
                return item.data;
            }
            return floorSum(item.left, floor - 1) + floorSum(item.right, floor - 1);
        }

        boolean isMirror() {
            if (top == null) {
                return true;
            }
            return mirrorCheck(top.left, top.right);
        }

        boolean mirrorCheck(TreeItem leftPart, TreeItem rightPart) {
            if (leftPart == null && rightPart == null) {
                return true;
            }
            if (leftPart == null || rightPart == null) {
                return false;
            }
            if (leftPart.data != rightPart.data) {
                return false;
            }
            return mirrorCheck(leftPart.left, rightPart.right) &&
                    mirrorCheck(leftPart.right, rightPart.left);
        }

        TreeItem findParent(int num1, int num2) {
            return findParentHelper(top, num1, num2);
        }

        TreeItem findParentHelper(TreeItem item, int num1, int num2) {
            if (item == null) {
                return null;
            }

            if (item.data == num1 || item.data == num2) {
                return item;
            }

            TreeItem leftResult = findParentHelper(item.left, num1, num2);
            TreeItem rightResult = findParentHelper(item.right, num1, num2);

            if (leftResult != null && rightResult != null) {
                return item;
            }

            if (leftResult != null) {
                return leftResult;
            } else {
                return rightResult;
            }
        }

        int countItems(TreeItem start) {
            if (start == null) {
                return 0;
            }
            return countItems(start.left) + countItems(start.right) + 1;
        }
    }
}
