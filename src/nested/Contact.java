package nested;

public class Contact {
    private String name;

    // Campo para teléfono
    private ContactInfo phone;

    // Campos para emails (máximo 3)
    private ContactInfo[] emails = new ContactInfo[3];
    private int emailCount = 0;

    // Campos para redes sociales (máximo 5)
    private ContactInfo[] socials = new ContactInfo[5];
    private int socialCount = 0;

    // Constructor
    public Contact(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    // Método para renombrar
    public void rename(String newName) {
        if (newName != null && !newName.isEmpty()) {
            this.name = newName;
        }
    }

    // Clase anidada privada para el nombre
    private class NameContactInfo implements ContactInfo {
        @Override
        public String getTitle() {
            return "Name";
        }
        @Override
        public String getValue() {
            return name;
        }
    }

    // Método para añadir teléfono (clase anónima)
    public ContactInfo addPhoneNumber(int code, String number) {
        if (phone == null) {
            phone = new ContactInfo() {
                @Override
                public String getTitle() {
                    return "Tel";
                }
                @Override
                public String getValue() {
                    return "+" + code + " " + number;
                }
            };
            return phone;
        }
        return null;
    }

    // Método para añadir email (clase anidada estática)
    public ContactInfo addEmail(String localPart, String domain) {
        if (emailCount < 3) {
            Email email = new Email(localPart, domain);
            emails[emailCount++] = email;
            return email;
        }
        return null;
    }

    // Clase anidada estática para email
    public static class Email implements ContactInfo {
        private String localPart;
        private String domain;
        private String title = "Email";

        public Email(String localPart, String domain) {
            this.localPart = localPart;
            this.domain = domain;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return localPart + "@" + domain;
        }
    }

    // Métodos para añadir redes sociales
    public ContactInfo addTwitter(String twitterId) {
        if (socialCount < 5) {
            Social social = new Social("Twitter", twitterId);
            socials[socialCount++] = social;
            return social;
        }
        return null;
    }

    public ContactInfo addInstagram(String instagramId) {
        if (socialCount < 5) {
            Social social = new Social("Instagram", instagramId);
            socials[socialCount++] = social;
            return social;
        }
        return null;
    }

    public ContactInfo addSocial(String title, String id) {
        if (socialCount < 5) {
            Social social = new Social(title, id);
            socials[socialCount++] = social;
            return social;
        }
        return null;
    }

    // Clase anidada estática para redes sociales
    public static class Social implements ContactInfo {
        private String title;
        private String id;

        public Social(String title, String id) {
            this.title = title;
            this.id = id;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return id;
        }
    }

    // Método getInfo() que devuelve un arreglo con la información
    public ContactInfo[] getInfo() {
        int size = 1 + (phone != null ? 1 : 0) + emailCount + socialCount;
        ContactInfo[] result = new ContactInfo[size];
        int index = 0;

        result[index++] = new NameContactInfo();
        if (phone != null) result[index++] = phone;
        for (int i = 0; i < emailCount; i++) result[index++] = emails[i];
        for (int i = 0; i < socialCount; i++) result[index++] = socials[i];

        return result;
    }
}
