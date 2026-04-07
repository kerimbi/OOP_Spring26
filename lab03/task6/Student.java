class Student extends Person {
    private final String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    public String getMajor() { return major; }

    @Override public String getOccupation() { return "Student(major=" + major + ")"; }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && major.equals(((Student) o).major);
    }

    @Override
    public int hashCode() { return 31 * super.hashCode() + major.hashCode(); }
}