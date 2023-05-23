package ro.pao.service.impl;

import ro.pao.service.ThreadingService;
import ro.pao.threads.ProcessingFileWorker;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static ro.pao.application.utils.Constants.FILE_NAME;
import static ro.pao.application.utils.Constants.FULL_PATH_FILE_NAME_1;

public class ThreadingServiceImpl implements ThreadingService {

    // Define number of maximum threads that can be used
    private static final int MAX_THREADS = 10;

    @Override
    public List<List<String[]>> readResultFromFiles() {
        List<String> filePaths = List.of(FULL_PATH_FILE_NAME_1);
        List<String> fileNames = List.of(FILE_NAME);

        int fileCount = filePaths.size();

        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);

        // Thread-safe ArrayList to store results
        List<List<String[]>> results = new CopyOnWriteArrayList<>();

        for (int i = 0; i < fileCount; i++) {
            Path filePath = Path.of(filePaths.get(i));
            String fileName = fileNames.get(i);

            Runnable worker = new ProcessingFileWorker(fileName, filePath, results);
            executorService.execute(worker);
        }

        // Shut down the executor service
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }

        return results;
    }
}
