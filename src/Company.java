interface Advertisement {
    void display();
}

class FacebookAdvertisement implements Advertisement {
    @Override
    public void display() {
        System.out.println("This is a Facebook advertisement.");
    }
}

class EmailAdvertisement implements Advertisement {
    @Override
    public void display() {
        System.out.println("This is an Email advertisement.");
    }
}

class PrintAdvertisement implements Advertisement {
    @Override
    public void display() {
        System.out.println("This is a Print advertisement.");
    }
}

class AdvertisementFactory {
    public Advertisement createAdvertisement(String type) {
        if (type.equalsIgnoreCase("facebook")) {
            return new FacebookAdvertisement();
        } else if (type.equalsIgnoreCase("email")) {
            return new EmailAdvertisement();
        } else if (type.equalsIgnoreCase("print")) {
            return new PrintAdvertisement();
        } else {
            throw new IllegalArgumentException("Invalid advertisement type.");
        }
    }
}

public class Company {
    public static void main(String[] args) {
        AdvertisementFactory factory = new AdvertisementFactory();

        Advertisement facebookAd = factory.createAdvertisement("facebook");
        facebookAd.display();

        Advertisement emailAd = factory.createAdvertisement("email");
        emailAd.display();

        Advertisement printAd = factory.createAdvertisement("print");
        printAd.display();
    }
}

