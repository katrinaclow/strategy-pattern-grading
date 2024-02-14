import java.util.List;

/**
 * Helper class that provides methods to calculate the length, total, and average of a list of scores
 */
public class Helper {
    public Helper() {
    }

    /**
     * Get the length of the list of scores
     *
     * @param scores the list of scores
     * @return the length of the list of scores
     */
    public int getLength(List<Double> scores) {
        return scores.size();
    }

    /**
     * Get the total of the list of scores
     *
     * @param scores the list of scores
     * @return the total of the list of scores
     */
    public double getTotal(List<Double> scores) {
        double sum = 0;
        for (Double d : scores)
            sum += d;
        return sum;
    }

    /**
     * Get the average of the list of scores
     *
     * @param scores the list of scores
     * @return the average of the list of scores
     */
    public double getAverage(List<Double> scores) {
        return getTotal(scores) / getLength(scores);
    }
}