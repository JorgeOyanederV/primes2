package tarea1;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Primes Problem.
 */
public class Tarea {

    /**
     * The Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(Tarea.class);


    /**
     * The main.
     *
     * @param args to use.
     */
    public static void main(String[] args) {

        // The Chrono
        final StopWatch stopWatch = StopWatch.createStarted();

        log.debug("Stating the Main ...");

        /**
         * For One Thread
         *
         * Thread thread = new Thread(new PrimeTask(82731237L));
         *
         * // log.debug("Prime? {}.", PrimeTask.isPrime(82731237L));
         *
         * thread.run();
         */


        // Time:
        log.info("Done in {}.", stopWatch);
    }

    /**
     * Class to calculate the prime.
     */
    private static class PrimeTask implements Runnable {

        /**
         * The Number
         */
        private static long number;

        /**
         * The Counter.
         */
        private final AtomicInteger counter = new AtomicInteger(0);

        /**
         * The Constructor.
         *
         * @param number to test.
         */
        public PrimeTask(final long number){
            this.number = number;
        }

        /**
         * Run the code. (Parallel Mode)
         */
        @Override
        public void run() {
            if (isPrime(this.number)){
                log.debug("{} was a Prime !!!", this.number);
                counter.getAndIncrement();
            }
            else{
                log.debug("{} was not a Prime !!!", this.number);
            }
        }

        /**
         * Function to test primality.
         *
         * @param n the number to test.
         * @return true is n is prime
         */
        private static boolean isPrime(final long n) {

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

    }
}
