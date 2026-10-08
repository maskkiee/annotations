package lombokAnnotations;

import lombok.Singular;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        testProduct();
        testUserRank();
        testProgrammer();
        testUser();
    }

    public static void testProduct(){
        System.out.println("Product tests:");
        LombokDemo.Product product = LombokDemo.Product.create()
                .name("PC")
                .price(500)
                .description("Personal Computer")
                .label("electronics")
                .label("promo")
                .proceed();
        System.out.println("@Builder + @Singular = " + product);
        product.setPrice(600);
        LombokDemo.Product copy = product.toBuilder().description("something else").proceed();
        System.out.println("@ToString.Exclude + @EqualsAndHashCode.Exclude: equal despite description: " +
                product.equals(copy) + ", same hashCode: " + (product.hashCode() == copy.hashCode()));

        LombokDemo.Product empty = new LombokDemo.Product();
        LombokDemo.Product onlyName = new LombokDemo.Product("Coffee");
        LombokDemo.Product full = new LombokDemo.Product(
                "Coffee", 25.0, "coffee drink", List.of("drinks"));
        System.out.println("@NoArgsConstructor(force) = " + empty.getName());
        System.out.println("@RequiredArgsConstructor = " + onlyName.getName());
        System.out.println("@AllArgsConstructor = " + full.getName() + ", " + full.getPrice() + ", " + full.getLabels());
        System.out.println();
    }

    public static void testUserRank(){
        System.out.println("userRank tests:");
        LombokDemo.userRank rank = new LombokDemo.userRank("Advanced", 500);
        System.out.println("@Value = " + rank + ", getters: " + rank.getName() + ", " + rank.getPoints());
        System.out.println();
    }

    public static void testProgrammer(){
        System.out.println("Programmer tests:");
        LombokDemo.Programmer programmer = LombokDemo.Programmer.builder()
                .name("Ala")
                .lastName("Kowalska")
                .language("Java")
                .build();
        LombokDemo.Programmer programmer2 = LombokDemo.Programmer.builder()
                .name("Ala")
                .lastName("Kowalska")
                .language("Java")
                .build();
        System.out.println("@EqualsAndHashCode callSuper+of (identical instances) = " + programmer.equals(programmer2));
        programmer.setLastName("Nowak");
        System.out.println("after lastName, still equal (lastName excluded) = " + programmer.equals(programmer2));
        System.out.println("@SuperBuilder + @ToString(callSuper,of) + parent exclude = " + programmer);
        System.out.println();
    }

    public static void testUser(){
        System.out.println("user tests:");
        LombokDemo.user user = new LombokDemo.user("Ola", "a@x.pl");
        LombokDemo.user user2 = new LombokDemo.user("Ola", "b@x.pl");
        System.out.println("@Getter on field = " + user.getName());
        System.out.println("@EqualsAndHashCode onlyExplicitlyIncluded = " + user.equals(user2)
                + " (same @Include name, different email)");
        System.out.println("@ToString onlyExplicitlyIncluded = " + user);
        System.out.println();
    }
}
