package piece;

public class Carrier extends Ship {

    public Carrier(){
        super(5);
    }

    @Override
    public String getName(){
        return "Carrier";
    }
}
