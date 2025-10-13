#public class ShoppingList {
    public static void main(String[] args) {

        String[] shoppingList = {"milk", "juice", "water", "fruits", "chicken"};
        int count = shoppingList.length;

        System.out.println("Your shopping list:");
        for (int i = 0; i < count; i++) {
            System.out.print(shoppingList[i]);
            if (i < count - 1) System.out.print(", ");
        }

        System.out.println("\n\nYou entered " + count + " items.");

        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("\nSearch for an item: ");
        String searchItem = input.nextLine().trim();
        boolean found = false;

        for (String item : shoppingList) {
            if (item.equalsIgnoreCase(searchItem)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("✅ " + searchItem + " is in your shopping list!");
        } else {
            System.out.println("❌ " + searchItem + " is not in your shopping list.");
        }

        input.close();
    }
}
