import java.io.*;

public class Basket {

    protected int[] prices;
    protected String[] products;
    protected int sumProducts;
    protected int[] countProducts = new int[3];


    Basket(int[] prices, String[] products) {
        this.prices = prices;
        this.products = products;
    }

    static Basket loadFromTxtFile(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] products = reader.readLine().split(" ");
            String sf = null;
            for (String product : products) {
                sf = product;
                System.out.print(sf + " ");

            }
            System.out.println();
            String[] countProducts = reader.readLine().split(" ");
            int g = 0;
            for (String s : countProducts) {
                g = Integer.parseInt(s);
                System.out.print(g + " ");
            }


            System.out.println();
        }

        return null;
    }

    void addToCart(int productNum, int amount) {

        int currentPrice = prices[productNum] * amount;
        sumProducts += currentPrice;
        countProducts[productNum] += amount;
    }

    void printCart() {
        System.out.println("Ваша корзина: ");

        for (int j = 0; j < countProducts.length; j++) {
            if (countProducts[j] != 0) {
                System.out.println(products[j] + " " + countProducts[j] + " " + "шт " + prices[j] + " " + "руб/шт "
                        + countProducts[j] * prices[j] + " руб в сумме");
            }
        }

        System.out.println("Итого " + sumProducts + " руб");
    }

    public void saveTxt(File file) throws IOException {
        try (PrintWriter out = new PrintWriter(file)) {

            for (String product : products) {
                out.print(product + " ");
            }
            out.println();
            for (int countProduct : countProducts) {
                out.print(countProduct + " ");
            }
        }
    }
}


