package templatecallback;

public class PerformanceMonitor {

    public void analyze(Measurable task) {

        Long startedAt = System.currentTimeMillis();

        task.measure();

        Long endAt = System.currentTimeMillis();
        System.out.printf("소요 시간 : %s \n", endAt - startedAt);
    }
}
