import org.library.Author;
import org.library.Person;

public class Main {
    public static void main(String[] args) {


        Person person = new Person("Berk");
        person.whoAreYou();

        Person author = new Author("Yazar 1");
        author.whoAreYou();
    }
}