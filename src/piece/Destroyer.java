package piece;

public class Destroyer extends Ship {

    public Destroyer(){
        super(2);
    }

    @Override
    public String getName(){
        return "Destroyer";
    }
}
