public class Time implements Comparable<Time> {
    private int hours, minutes, seconds;

    public Time(int h, int m, int s) {
        hours = h; minutes = m; seconds = s;
    }
    public int toSeconds() { return hours*3600 + minutes*60 + seconds; }

    @Override
    public int compareTo(Time other) {
        return Integer.compare(this.toSeconds(), other.toSeconds());
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}