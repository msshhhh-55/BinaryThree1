//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BinaryThree.MyTree tree = new BinaryThree.MyTree(1);

        tree.top.left = new BinaryThree.TreeItem(2);
        tree.top.right = new BinaryThree.TreeItem(3);

        tree.top.left.left = new BinaryThree.TreeItem(4);
        tree.top.left.right = new BinaryThree.TreeItem(5);

        tree.top.right.left = new BinaryThree.TreeItem(6);
        tree.top.right.right = new BinaryThree.TreeItem(7);

        System.out.println("Дерево создано успешно!");
        System.out.println();

        System.out.println("1. Подсчет всех листьев дерева:");
        int leafCount = tree.howManyLeafs();
        System.out.println("   Листьев в дереве: " + leafCount);
        System.out.println();

        System.out.println("2. Нахождение максимальной глубины:");
        int treeDepth = tree.maxDeep();
        System.out.println("   Глубина дерева равна: " + treeDepth);
        System.out.println();

        System.out.println("3. Проверка, является ли дерево BST:");
        boolean bstCheck = tree.isGoodTree();
        if (bstCheck) {
            System.out.println("   Да, это BST дерево");
        } else {
            System.out.println("   Нет, это не BST дерево");
        }

        System.out.println("4. Вывод сумм чисел на каждом уровне:");
        tree.showFloorSums();
        System.out.println();

        System.out.println("5. Проверка симметричности:");
        boolean symmetryResult = tree.isMirror();
        if (symmetryResult) {
            System.out.println("   Дерево СИММЕТРИЧНО");
        } else {
            System.out.println("   Дерево НЕ симметрично");
        }
        System.out.println();

        System.out.println("6. Поиск общего предка для узлов:");

        BinaryThree.TreeItem ancestor1 = tree.findParent(4, 5);
        if (ancestor1 != null) {
            System.out.println("   Общий предок для 4 и 5: узел " + ancestor1.data);
        } else {
            System.out.println("   Предок для 4 и 5 не найден");
        }

        System.out.println();
        System.out.println("   Размеры разных частей дерева:");

        int totalSize = tree.countItems(tree.top);
        System.out.println("   Весь размер дерева: " + totalSize);

        int leftPartSize = tree.countItems(tree.top.left);
        System.out.println("   Левая часть (узел 2): " + leftPartSize);

        int rightPartSize = tree.countItems(tree.top.right);
        System.out.println("   Правая часть (узел 3): " + rightPartSize);

        System.out.println();

        BinaryThree.TreeItem ancestor2 = tree.findParent(4, 7);
        if (ancestor2 != null) {
            System.out.println("   Общий предок для 4 и 7: узел " + ancestor2.data);
        } else {
            System.out.println("   Предок для 4 и 7 не найден");
        }

        BinaryThree.TreeItem ancestor3 = tree.findParent(6, 7);
        if (ancestor3 != null) {
            System.out.println("   Общий предок для 6 и 7: узел " + ancestor3.data);
        } else {
            System.out.println("   Предок для 6 и 7 не найден");
        }

        System.out.println();

        int subtreeSize = tree.countItems(tree.top.left.left);
        System.out.println("   Размер поддерева у узла 4: " + subtreeSize);

    }
    }