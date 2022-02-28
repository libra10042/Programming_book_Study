package DataFiltering;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;

public class SearchingTravel {
    public static final String COUNTRY_VIETNAM = "vietnam";
    public static final String COUNTRY_PHILLIPHINE = "philliphine";
    public static final String COUNTRY_TAILAND = "tailand";

    // 여행 상품 저장.
    private List<TravelInfoVO> travelInfoList = new ArrayList<>();

    public SearchingTravel(){
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


    // 국가 정보에 기반해서 여행 상품을 조회한다.
    public List<TravelInfoVO> searchTravelInfo(String country) {
        List<TravelInfoVO> returnValue = new ArrayList<>();

        for (TravelInfoVO travelInfo : travelInfoList) {
            if (travelInfo.equals(travelInfo.getCountry())) {
                returnValue.add(travelInfo);
            }
        }
        return returnValue;
    }


    public static void main(String[] args) {
        SearchingTravel travelSearch = new SearchingTravel();
        // 베트남 여행 상품 목록 조회
        List<TravelInfoVO> searchList = travelSearch.searchTravelInfo(SearchingTravel.COUNTRY_VIETNAM);


        for(TravelInfoVO searchTravel : searchList){
            System.out.println(searchTravel);
        }
    }


}
