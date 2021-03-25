package bll;



public class RepasManagerSingleton {

    private static RepasManager instance;

    public static IRepasManager getInstance() {
        if (instance == null) {
            instance = new RepasManager();
        }
        return instance;
    }
}




