import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        int opcion = 0;

        while (opcion != 8) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Construir arbol");
            System.out.println("2. Mostrar arbol");
            System.out.println("3. Recorrido Preorden");
            System.out.println("4. Recorrido Inorden");
            System.out.println("5. Recorrido Posorden");
            System.out.println("6. Mostrar factores de equilibrio");
            System.out.println("7. Balancear arbol (AVL)");
            System.out.println("8. Salir");
            System.out.println("==========================");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcion no valida.");
                continue;
            }

            if (opcion == 1) {
                tree = new BinaryTree();
                tree.buildTree(scanner);
            } else if (opcion == 2) {
                if (tree.root == null) System.out.println("El arbol esta vacio.");
                else tree.printTree();
            } else if (opcion == 3) {
                System.out.println(tree.preorder());
            } else if (opcion == 4) {
                System.out.println(tree.inorder());
            } else if (opcion == 5) {
                System.out.println(tree.postorder());
            } else if (opcion == 6) {
                if (tree.root == null) System.out.println("El arbol esta vacio.");
                else tree.printBalanceFactors();
            } else if (opcion == 7) {
                if (tree.root == null) {
                    System.out.println("El arbol esta vacio.");
                } else {
                    System.out.println("--- Arbol ANTES de balancear ---");
                    tree.printBalanceFactors();
                    tree.balance();
                    System.out.println("\n--- Arbol DESPUES de balancear ---");
                    tree.printBalanceFactors();
                }
            } else if (opcion == 8) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opcion incorrecta.");
            }
        }
        scanner.close();
    }
}