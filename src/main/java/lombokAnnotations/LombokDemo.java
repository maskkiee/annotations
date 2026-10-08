package lombokAnnotations;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


public class LombokDemo {

    @Data
    @NoArgsConstructor
    @RequiredArgsConstructor
    @AllArgsConstructor
    @Builder(toBuilder = true, builderMethodName = "create", buildMethodName = "proceed")
    public static class Product {

        @NonNull
        private String name;

        private double price;

        @ToString.Exclude
        @EqualsAndHashCode.Exclude
        private String description;

        @Singular("label")
        private List<String> labels;
    }

    @Value
    public static class userRank {
        String name;
        int points;
    }

    @SuperBuilder
    @Data
    public static class Worker {
        private String name;
        private String lastName;
    }

    @SuperBuilder
    @Getter
    @ToString(callSuper = true, of = "language")
    @EqualsAndHashCode(callSuper = true, of = "language")
    public static class Programmer extends Worker {
        private String language;
    }

    @ToString(onlyExplicitlyIncluded = true)
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public static class user {

        @Getter
        @ToString.Include
        @EqualsAndHashCode.Include
        private String name;

        private final String email;

        public user(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }
}
