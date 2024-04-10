class SumTask implements Runnable {
    private int sequenceNumber;
    private int step;
    private long timeoutMillis;

    public SumTask(int sequenceNumber, int step, long timeoutMillis) {
        this.sequenceNumber = sequenceNumber;
        this.step = step;
        this.timeoutMillis = timeoutMillis;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        long sum = 0;
        int elements = 0;

        while (!Thread.currentThread().isInterrupted()) {
            sum += elements * step;
            elements++;
            try {
                Thread.sleep(step);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Thread " + sequenceNumber + " Sum: " + sum + ", Elements: " + elements + ", Elapsed Time: " + elapsedTime + "ms");
    }
}