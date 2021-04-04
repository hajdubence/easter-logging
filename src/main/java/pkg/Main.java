package pkg;

import org.apache.logging.log4j.*;

import java.util.Map;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    private static final Marker ERDŐ_MARKER = MarkerManager.getMarker("ERDŐ");
    private static final Marker TOJÁS_MARKER = MarkerManager.getMarker("TOJÁS");
    private static final Marker KÉRDÉS_MARKER = MarkerManager.getMarker("KÉRDÉS");

    public static void main(String[] args) throws InterruptedException {
        int iterations=1;
        if(args.length==1)
            iterations=Integer.parseInt(args[0]);
        for (int i = 0; i < iterations; i++) {
            ThreadContext.put("id", String.valueOf(i+1));
            logger.error(ERDŐ_MARKER, "Erdőn-mezőn nyitott szemmel,");
            logger.warn(ERDŐ_MARKER, "sok virágra lel az ember.");
            logger.info("Én most őket megöntözöm,");
            logger.debug(TOJÁS_MARKER, "a piros tojást megköszönöm!");
            logger.trace(KÉRDÉS_MARKER, "Szabad-e locsolni?");
            Thread.sleep(500);
            ThreadContext.clearAll();
        }

    }
}
