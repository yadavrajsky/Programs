class PrimeNumbers {
    public static void main(String[] args) {
        int a = 10, b = 20;
        int i;
        outer: for (int j = a; j <= b; j++) {
            for (i = 2; i <= j - 1; i++) {
                if (j % i == 0)
                    continue outer;
            }
            System.out.println(j + " is Prime Number");
        }
    }
}
