class PhDStudent extends Person {
    private final String major;
    private final String researchTopic;

    public PhDStudent(String name, int age, String major, String researchTopic) {
        super(name, age);
        this.major = major;
        this.researchTopic = researchTopic;
    }

    public String getMajor()         { return major; }
    public String getResearchTopic() { return researchTopic; }

    @Override
    public boolean canAcceptPet(Animal pet) {
        return !(pet instanceof Dog); 
    }

    @Override
    public String getOccupation() {
        return "PhDStudent(major=" + major + ", research=" + researchTopic + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        PhDStudent p = (PhDStudent) o;
        return major.equals(p.major) && researchTopic.equals(p.researchTopic);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + major.hashCode() + researchTopic.hashCode();
    }
}