package test;

public class ValidationTestPlayground {

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        // İnsan isminin yalnızca harflerden oluştuğunu kontrol eder
        if (!name.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Name must not contain numbers or special characters");
        }

        System.out.println("Name '" + name + "' is valid.");
    }

    public static void main(String[] args) {
        // Test senaryolarını burada çalıştırabilirsiniz
        testNameValidation();
    }

    public static void testNameValidation() {
        String[] testNames = {
                "John Doe",        // Geçerli
                "Alice",           // Geçerli
                "John123",         // Geçersiz
                "Jane@Doe",        // Geçersiz
                " ",               // Geçersiz
                null,              // Geçersiz
                "Mary Ann"         // Geçerli
        };

        for (String name : testNames) {
            try {
                validateName(name);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid name: " + name + " -> " + e.getMessage());
            }
        }
    }
}
