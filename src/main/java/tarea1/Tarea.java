package tarea1;

public class Tarea {
    /**
     * Function to test primality.
     *
     * @param n the number to test.
     * @return true if n is prime
     */
    public static boolean isPrime(final long n) {

        // Can't process negative numbers
        if (n <= 0) {
            throw new IllegalArgumentException("Error in n: Can't process negative numbers");
        }

        // "One" isn't prime!
        if (n == 1) {
            return false;
        }

        // Testing primality from 2 to n-1
        // TODO: Change to n/2 the upper limit (??)
        for (long i = 2; i < n / 2; i++) {

            // If module == 0 -> not prime!
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }

    /**
     * The main.
     *
     * @param args to use.
     */
    public static void main(String[] args) {

        // Number to evaluate
        long number = 100000;

        //The counter of primes
        long contador = 0;

        // Two Threads
        Thread thread_1_for_2 = new Thread();
        Thread thread_2_for_2 = new Thread();

        // Conditions for 2 Threads
        thread_1_for_2.condition(1, number / 2);
        thread_2_for_2.condition(number / 2, number);


        // Three Threads
        Thread thread_1_for_3 = new Thread();
        Thread thread_2_for_3 = new Thread();
        Thread thread_3_for_3 = new Thread();

        // Conditions for 3 Threads
        thread_1_for_3.condition(1, number / 3);
        thread_2_for_3.condition(number / 3, 2 * (number / 3));
        thread_3_for_3.condition(2 * (number / 3), number);

        // Four Threads
        Thread thread_1_for_4 = new Thread();
        Thread thread_2_for_4 = new Thread();
        Thread thread_3_for_4 = new Thread();
        Thread thread_4_for_4 = new Thread();

        // Conditions for 4 Threads
        thread_1_for_4.condition(1, number / 4);
        thread_2_for_4.condition(number / 4, number / 2);
        thread_3_for_4.condition(number / 2, 3 * (number / 4));
        thread_4_for_4.condition(3 * (number / 4), number);

        // The time now
        long start = System.currentTimeMillis();

        /*
        // One Thread
        for(long i = 1; i < number; i++){
            if(isPrime(i)){
                // System.out.println(i + " is Prime");
                contador++;
            }
        }
        */

        /*
        // Two Threads
        thread_1_for_2.run();
        thread_2_for_2.run();

        // Total prime numbers of two threads
        contador += thread_1_for_2.num_Primes();
        contador += thread_2_for_2.num_Primes();
        */

        /*
        // Three Threads
        thread_1_for_3.run();
        thread_2_for_3.run();
        thread_3_for_3.run();

        // Total prime numbers of three threads
        contador += thread_1_for_3.num_Primes();
        contador += thread_2_for_3.num_Primes();
        contador += thread_3_for_3.num_Primes();
        */

        /*
        // Four Threads
        thread_1_for_4.run();
        thread_2_for_4.run();
        thread_3_for_4.run();
        thread_4_for_4.run();

        // Total prime numbers of three threads
        contador += thread_1_for_4.num_Primes();
        contador += thread_2_for_4.num_Primes();
        contador += thread_3_for_4.num_Primes();
        contador += thread_4_for_4.num_Primes();
        */

        long time = System.currentTimeMillis() - start;


        System.out.println("La cantidad de primos es " + contador);
        System.out.println("Tiempo de demora es milisegundos " + time);
    }
}
