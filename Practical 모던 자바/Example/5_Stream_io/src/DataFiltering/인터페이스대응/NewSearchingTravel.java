package DataFiltering.인터페이스대응;

import DataFiltering.TravelInfoVO;

import java.util.ArrayList;
import java.util.List;

public class NewSearchingTravel {
    public static final String COUNTRY_VIETNAM = "vietnam";
    public static final String COUNTRY_PHILLIPHINE = "philliphine";
    public static final String COUNTRY_TAILAND = "tailand";

    private List<TravelInfoVO> travelInfoList = new ArrayList<>();

    public NewSearchingTravel() {
        iniializeProduct();
    }
    // 데이터를 초기화하며 외부에서 호출하지 못하도록 private 으로 선언.
    private void iniializeProduct(){
        TravelInfoVO cebu = new TravelInfoVO();
        cebu.setName("Cebu Travel");
        cebu.setCountry(COUNTRY_PHILLIPHINE);
        cebu.setCity("cebu");
        cebu.setDays(5);
        cebu.setNights(3);
        travelInfoList.add(cebu);

        TravelInfoVO hanoi = new TravelInfoVO();
        hanoi.setName("hanoi Travel");
        hanoi.setCountry(COUNTRY_VIETNAM);
        hanoi.setCity("hanoi");
        hanoi.setDays(5);
        hanoi.setNights(3);
        travelInfoList.add(hanoi);


        TravelInfoVO danang = new TravelInfoVO();
        danang.setName("danang Travel");
        danang.setCountry(COUNTRY_TAILAND);
        danang.setCity("danang");
        danang.setDays(5);
        danang.setNights(3);
        travelInfoList.add(danang);

    }

    // 외부에서 전달된 조건으로 검색.
    public List<TravelInfoVO> searchTravelInfo(TravelInfoFilter searchCondition){
        List<TravelInfoVO> returnValue = new ArrayList<>();
        for(TravelInfoVO travelInfo : travelInfoList){
            if(searchCondition.isMatched(travelInfo)){
                returnValue.add(travelInfo);
            }
        }
        return returnValue;
    }

    public static void main(String[] args) {
        NewSearchingTravel travelSearch = new NewSearchingTravel();

        // 조회 조건을 외부로 분리.
        List<TravelInfoVO> searchTravel = travelSearch.searchTravelInfo(new TravelInfoFilter(){
            public boolean isMatched(TravelInfoVO travelInfo){
                if(travelInfo.getCountry().equals("vietnam")){
                    return true;
                }
                else{
                    return false;
                }
            }
        });
        for(TravelInfoVO travelInfo : searchTravel){
            System.out.println(travelInfo);
        }

    }



}
