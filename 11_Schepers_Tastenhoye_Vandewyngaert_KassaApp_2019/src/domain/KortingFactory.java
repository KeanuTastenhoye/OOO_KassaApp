package domain;

public class KortingFactory {


    public static KortingStrategy createTaal(String soortKorting){
        KortingEnum korting = KortingEnum.valueOf(soortKorting);
        String klasseNaam = korting.getKlasseNaam();
        KortingStrategy kortingStrategy = null;
        try{
            Class dbClass = Class.forName(klasseNaam);
            Object dbObject = dbClass.newInstance();
            kortingStrategy = (KortingStrategy) dbObject;
        }
        catch (Exception e){}
        return kortingStrategy;
    }
}