package com.example.aggregator.controller;

import com.example.aggregator.model.Entry;
import com.example.aggregator.service.AggregatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AggregatorController {

    private static final Logger logger = LoggerFactory.getLogger(AggregatorController.class.getName());
    private AggregatorService service;

    public AggregatorController(AggregatorService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Entry> helloWorld() {
        List<Entry> entries = new ArrayList<>();
        entries.add(service.getDefinitionFor("hello"));
        entries.add(service.getDefinitionFor("world"));
        return entries;
    }

    @GetMapping("/getDefinitionFor/{word}")
    public Entry getDefinitionFor(@PathVariable String word) {

        StopWatch sw = new StopWatch();
        sw.start();
        Entry entry = service.getDefinitionFor(word);
        sw.stop();

        long nanoSeconds = sw.getLastTaskTimeNanos();
        String message = new StringBuilder().append("Retrieved entry for [")
                .append(word)
                .append("] in ")
                .append(nanoSeconds / 1000000.0)
                .append("ms")
                .toString();

        logger.info(message);

        return entry;
    }

    @GetMapping("/getWordsThatContainSuccessiveLettersAndStartsWith/{chars}")
    public List<Entry> getWordsThatContainSuccessiveLettersAndStartsWith(@PathVariable String chars) {

        StopWatch sw = new StopWatch();
        sw.start();
        List <Entry> entries = service.getWordsThatContainSuccessiveLettersAndStartsWith(chars);
        sw.stop();

        long nanoSeconds = sw.getLastTaskTimeNanos();
        String message = new StringBuilder().append("Retrieved entries for words that containing [")
                .append(" consecutive double letters and starts with [")
                .append(chars)
                .append("], containing ")
                .append(entries.size())
                .append(" entries in ")
                .append(nanoSeconds / 1000000.0)
                .append("ms")
                .toString();

        logger.info(message);

        return entries;
    }

    @GetMapping("/getAllPalindromes/")
    public List<Entry> getAllPalindromes() {

        StopWatch sw = new StopWatch();
        sw.start();
        List<Entry> entry = service.getAllPalindromes();
        sw.stop();

        long nanoSeconds = sw.getLastTaskTimeNanos();
        String message = new StringBuilder().append("Retrieved all palindromes, containing ")
                .append(entry.size())
                .append(" entries in ")
                .append(nanoSeconds / 1000000.0)
                .append("ms")
                .toString();

        logger.info(message);

        return entry;
    }
}
