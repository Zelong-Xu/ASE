interface MenuItem {
    void prepare();
    void serve();
    String getDescription();
}

interface Appetizer extends MenuItem {}
interface MainCourse extends MenuItem {}

class ItalianAppetizer implements Appetizer {
    @Override
    public void prepare() {
        System.out.println("Preparing Italian appetizer...");
    }

    @Override
    public void serve() {
        System.out.println("Serving Italian appetizer...");
    }

    @Override
    public String getDescription() {
        return "Italian Appetizer";
    }
}

class ItalianMainCourse implements MainCourse {
    @Override
    public void prepare() {
        System.out.println("Preparing Italian main course...");
    }

    @Override
    public void serve() {
        System.out.println("Serving Italian main course...");
    }

    @Override
    public String getDescription() {
        return "Italian Main Course";
    }
}

class ChineseAppetizer implements Appetizer {
    @Override
    public void prepare() {
        System.out.println("Preparing Chinese appetizer...");
    }

    @Override
    public void serve() {
        System.out.println("Serving Chinese appetizer...");
    }

    @Override
    public String getDescription() {
        return "Chinese Appetizer";
    }
}

class ChineseMainCourse implements MainCourse {
    @Override
    public void prepare() {
        System.out.println("Preparing Chinese main course...");
    }

    @Override
    public void serve() {
        System.out.println("Serving Chinese main course...");
    }

    @Override
    public String getDescription() {
        return "Chinese Main Course";
    }
}

interface CuisineFactory {
    Appetizer createAppetizer();
    MainCourse createMainCourse();
}

class ItalianCuisineFactory implements CuisineFactory {
    @Override
    public Appetizer createAppetizer() {
        return new ItalianAppetizer();
    }

    @Override
    public MainCourse createMainCourse() {
        return new ItalianMainCourse();
    }
}


class ChineseCuisineFactory implements CuisineFactory {
    @Override
    public Appetizer createAppetizer() {
        return new ChineseAppetizer();
    }

    @Override
    public MainCourse createMainCourse() {
        return new ChineseMainCourse();
    }
}

class Restaurant {
    private Appetizer appetizer;
    private MainCourse mainCourse;

    public Restaurant(CuisineFactory factory){
        appetizer = factory.createAppetizer();
        mainCourse = factory.createMainCourse();
    }

    public void serveMenu() {
        appetizer.prepare();
        appetizer.serve();
        mainCourse.prepare();
        mainCourse.serve();
    }

}

public void main(String[] args) {
    CuisineFactory italianFactory = new ItalianCuisineFactory();
    Restaurant italianRestaurant = new Restaurant(italianFactory);
    italianRestaurant.serveMenu();

    CuisineFactory chineseFactory = new ChineseCuisineFactory();
    Restaurant chineseRestaurant = new Restaurant(chineseFactory);
    chineseRestaurant.serveMenu();
}
