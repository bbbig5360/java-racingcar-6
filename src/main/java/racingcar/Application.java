package racingcar;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    static int carNameRange = 5;
    static int gameRepeatNum;
    static String[] carNameList;
    static ArrayList<Integer> carRacingCountList = new ArrayList<Integer>();

    public static void HyhpenPrint(int j){
        for(int k=0; k<carRacingCountList.get(j); k++){
                System.out.print('-');
            }
    }
    
    public static void RacingCountPrint(){
        for(int j=0; j<carNameList.length; j++){
            System.out.print(carNameList[j]);
            System.out.print(" : ");
            HyhpenPrint(j);
            System.out.println();
        }
        System.out.println();
    }

    public static void RacingStart(){
        for(int i=0; i<carNameList.length; i++){
            carRacingCountList.set(i, carRacingCountList.get(i) + Randoms.pickNumberInRange(0,9));
        }
    }

    public static void RacingGameStart(){
        System.out.println("실행 결과");
        
        for(int i=0; i<carNameList.length; i++){
            carRacingCountList.add(0);
        }

        for(int j=0; j<gameRepeatNum; j++){
            RacingStart();
            RacingCountPrint();
        }
   
    }

    public static void NameCheck(String carName){
        if (carName.length() > carNameRange)
            throw new IllegalArgumentException();
        if (carName.equals(""))
            throw new IllegalArgumentException();
    }

    public static int Input2Int(){
        String inputNumber = Console.readLine();
        int returnInt;
        try{
            returnInt = Integer.parseInt(inputNumber);
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
        return returnInt;
    }

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();
        carNameList = carNameInput.split("\\,");

        for(int i=0; i<carNameList.length; i++){
            NameCheck(carNameList[i]);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        gameRepeatNum = Input2Int();
        System.out.println();
        
        RacingGameStart();
    }
}
