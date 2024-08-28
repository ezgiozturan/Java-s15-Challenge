public enum Category {
    FICTION("Fiction"),
    NONFICTION("Non-Fiction"),
    MYSTERY("Mystery"),
    SCIENCE("Science"),
    HISTORY("History");

    private String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}