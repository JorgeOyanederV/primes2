package tarea1;

public class Thread extends java.lang.Thread {

    // Start Number
    long num_start;

    // End Number
    long num_end;

    // Amount of Primes
    long nPrimes = 0;


    @Override
    public void run() {
        for (long i = num_start; i < num_end; i++) {
            if (Tarea.isPrime(i)) {
                // System.out.println(i + " is Prime");
                nPrimes += 1;
            }
        }
    }

    // Start Limit and End Limit
    public void condition(long num_start, long num_end) {
        this.num_start = num_start;
        this.num_end = num_end;
    }

    // Returns the number of primes
    public long num_Primes() {
        return nPrimes;
    }
}
