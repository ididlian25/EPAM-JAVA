package nested;

public class Main {
    public static void main(String[] args) {
        Contact contact = new Contact("Lily");
        contact.addPhoneNumber(52, "33-13-09-66-08");
        contact.addEmail("lily", "cecytejalisco.edu.mx");
        contact.addInstagram("lily_insta123");
        contact.addTwitter("lily_tw456");
        contact.addSocial("GitHub", "lilydev");

        for (ContactInfo info : contact.getInfo()) {
            System.out.println(info.getTitle() + ": " + info.getValue());
        }
    }
}
