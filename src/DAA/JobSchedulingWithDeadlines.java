package DAA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSchedulingWithDeadlines {
    public static List<Job> scheduleJobs(List<Job> jobs) {
        // Sort the jobs by profit in descending order
        Collections.sort(jobs, Comparator.comparingInt(job -> -job.profit));

        int maxDeadline = jobs.stream().mapToInt(job -> job.deadline).max().orElse(0);
        boolean[] slots = new boolean[maxDeadline + 1];
        List<Job> scheduledJobs = new ArrayList<>();

        for (Job job : jobs) {
            for (int i = job.deadline; i > 0; i--) {
                if (!slots[i]) {
                    slots[i] = true;
                    scheduledJobs.add(job);
                    break;
                }
            }
        }

        return scheduledJobs;
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, 2, 100));
        jobs.add(new Job(2, 1, 10));
        jobs.add(new Job(3, 2, 50));
        jobs.add(new Job(4, 1, 20));

        List<Job> scheduledJobs = scheduleJobs(jobs);

        System.out.println("Scheduled Jobs:");
        for (Job job : scheduledJobs) {
            System.out.println("Job " + job.id + " (Profit: " + job.profit + ")");
        }
    }
}
