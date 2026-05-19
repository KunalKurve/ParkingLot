package strategies;

public class PricingStrategyFactory {

    public static PricingStrategy getPricingStrategy(PricingStrategyType pricingStrategyType){

        if(pricingStrategyType.equals(PricingStrategyType.WEEKDAY)){
            return new WeekDayPricingStrategy();
        } else if (pricingStrategyType.equals(PricingStrategyType.WEEKEND)) {
            return new WeekendPricingStrategy();
        } else if (pricingStrategyType.equals(PricingStrategyType.FESTIVAL)) {
            return new FestivalPricingStrategy();
        }

        return null;
    }
}
