package info.ernestas.gildedrose.kata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GildedRose {

    private static final Logger LOGGER = LoggerFactory.getLogger(GildedRose.class);

    private static final Executor EXECUTOR = Executors.newFixedThreadPool(2);

    private RoseWorker roseWorker = new RoseWorker();

    public List<Item> updateQuality(Item[] items) {
        List<Item> results = new ArrayList<>();

        List<CompletableFuture> futures = Stream.of(items)
                .map(item -> calculateItems(results, roseWorker, item))
                .collect(Collectors.toList());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));

        try {
            allOf.get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error("Error calculating results: {}", e);
            throw new RuntimeException(e);
        }

        return results;
    }

    private CompletableFuture<Boolean> calculateItems(List<Item> results, RoseWorker roseWorker, Item item) {
        return CompletableFuture.supplyAsync(() -> roseWorker.getItem(item), EXECUTOR).thenApplyAsync(i -> results.add(i));
    }

}
