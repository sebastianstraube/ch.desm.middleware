package ch.desm.middleware.app.core.component.petrinet;

public class Bucket {

    private final String name;
    private final Integer tokenCount;

    public Bucket(String name, Integer tokenCount) {
        this.name = name;
        this.tokenCount = tokenCount;
    }

    public String getName() { return name; }
    public Integer getTokenCount() { return tokenCount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bucket bucket = (Bucket) o;

        if (!getName().equals(bucket.getName())) return false;
        return getTokenCount().equals(bucket.getTokenCount());

    }

    @Override
    public String toString() {
        return "Bucket{" +
                "name='" + name + '\'' +
                ", tokenCount=" + tokenCount +
                '}';
    }
}
