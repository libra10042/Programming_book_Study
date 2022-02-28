package DataFiltering.인터페이스대응;

import DataFiltering.TravelInfoVO;

public interface TravelInfoFilter {
    public boolean isMatched(TravelInfoVO travelInfoVO);
}
