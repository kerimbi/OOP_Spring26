class Employee extends Person {
    private final String jobTitle;

    public Employee(String name, int age, String jobTitle) {
        super(name, age);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() { return jobTitle; }

    @Override public String getOccupation() { return "Employee(" + jobTitle + ")"; }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && jobTitle.equals(((Employee) o).jobTitle);
    }

    @Override
    public int hashCode() { return 31 * super.hashCode() + jobTitle.hashCode(); }
}